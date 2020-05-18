module Events
  module V2
    class DataSequenceValidation
      include Events::V2::DataSequenceHelper
      attr_accessor :stream_timer, :content_position, :stream_position, :break_index, :chapter_index,
                    :ad_index, :playback_progress, :ad_progress, :row, :index

      ResultStruct = Struct.new(:row_index, :result, :expected, :actual)

      def initialize(row, index)
        @row = row
        @index = index
        @playback_progress = ResultStruct.new(index, true)
        @ad_progress = ResultStruct.new(index, true)
      end

      def process(test_runner)
        send(test_runner.testcase_config[:slug], test_runner)
      end

      def long_form_lean_back(test_runner)
        continuously_inc(test_runner)
      end

      def long_form_scrub_backward_outside_chapter(test_runner)
        seek_stop = seek_stop?(row)
        test_runner.testcase_config[:data_seq_cols].each do |column|
          if seek_stop && SEEK_BACK_DEC.include?(column)
            decreasing = decreasing?(test_runner, column)
            set_attr(column, ResultStruct.new(index, decreasing, "Should decrease continuously", decreasing))
          else
            cont_inc_cols(column, test_runner)
          end
        end
        timestamp_cols(test_runner)
      end

      def scrub_fwd_outside_seg(test_runner)
        continuously_inc(test_runner)
      end

      def ad_clicked_pause_or_play(test_runner)
        continuously_inc(test_runner)
      end

      def live_in_content_or_ad(test_runner)
        continuously_inc(test_runner)
      end

      def long_form_continue_watching_nth_segment(test_runner)
        continuously_inc(test_runner)
      end

      def long_form_scrub_backward_inside_segment(test_runner)
        continuously_inc(test_runner)
      end

      def long_form_scrub_forward_inside_segment(test_runner)
        continuously_inc(test_runner)
      end

      def playback_schema_validation(test_runner)
        continuously_inc(test_runner)
      end

      def all_passed?(test_runner)
        (test_runner.testcase_config[:data_seq_cols] + test_runner.testcase_config[:timestamp_cols]).all? do |column|
          send(column.split("payload_")[1]).result
        end
      end

      def continuously_inc(test_runner)
        test_runner.testcase_config[:data_seq_cols].each do |column|
          cont_inc_cols(column, test_runner)
        end
        timestamp_cols(test_runner)
      end

      private

      def cont_inc_cols(column, test_runner)
        if content_position_ad_type?(column)
          not_increasing = not_increasing?(test_runner, column)
          set_attr(column, ResultStruct.new(index, not_increasing, "Should not increase", not_increasing))
        else
          cont_inc = continuous_increasing?(test_runner, column)
          set_attr(column, ResultStruct.new(index, cont_inc, "Should increase continuously", cont_inc))
        end
      end

      def timestamp_cols(test_runner)
        if timestamp_playback_progress?(test_runner)
          @playback_progress = timestamp_seq(PLAYBACK_SEC, test_runner)
        elsif timestamp_ad_progress?(test_runner)
          @ad_progress = timestamp_seq(AD_SEC, test_runner)
        end
      end

      def timestamp_playback_progress?(test_runner)
        test_runner.testcase_config[:timestamp_cols].include?("payload_playback_progress") &&
          current_playback_progress? &&
          previous_playback_progress?(test_runner)
      end

      def timestamp_ad_progress?(test_runner)
        test_runner.testcase_config[:timestamp_cols].include?("payload_ad_progress") &&
          current_ad_progress? &&
          previous_ad_progress?(test_runner)
      end

      def timestamp_seq(val, test_runner)
        ResultStruct.new(index, timestamp_inc?(row, test_runner, val),
                         "Difference between #{val[:start_at]} and #{val[:end_at]} seconds,
                         #{DateTime.parse(previous_row(test_runner)['timestamp'])}",
                         DateTime.parse(row["timestamp"]))
      end
    end
  end
end
