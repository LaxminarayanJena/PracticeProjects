module Events
  module V2
    class VerifyCount
      # QTA-956 Verify the count for pair actions
      attr_accessor :event, :test_runner

      def initialize(event, test_runner)
        @event = event
        @test_runner = test_runner
      end

      def process
        session_count_increment if event["type"] == "session"
        ad_break_count_increment if event["type"] == "adBreak"
        ad_count_increment if event["type"] == "ad"
        playback_count_increment if event["type"] == "playback"
        chapter_count_increment if event["type"] == "chapter"
        buffer_events_increment
        calculations_post_count
      end

      private

      def session_count_increment
        test_runner.verify_count[:session_start] += 1 if event["payload_action"] == "start"
        test_runner.verify_count[:session_stop] += 1 if event["payload_action"] == "stop"
      end

      def ad_count_increment
        test_runner.verify_count[:ad_start] += 1 if event["payload_action"] == "start"
        test_runner.verify_count[:ad_complete] += 1 if event["payload_action"] == "complete"
        test_runner.verify_count[:ad_pauseStart] += 1 if event["payload_action"] == "pauseStart"
        test_runner.verify_count[:ad_pauseStop] += 1 if event["payload_action"] == "pauseStop"
      end

      def ad_break_count_increment
        if event["payload_action"] == "start"
          test_runner.verify_count[:ad_break_start] += 1
          test_runner.verify_count[:sum_of_num_ads] += event["payload_num_ads"].to_i
        end
        test_runner.verify_count[:ad_break_complete] += 1 if event["payload_action"] == "complete"
      end

      def playback_count_increment
        test_runner.verify_count[:playback_start] += 1 if event["payload_action"] == "start"
        test_runner.verify_count[:playback_stop] += 1 if event["payload_action"] == "stop"
        test_runner.verify_count[:playback_resume] += 1 if event["payload_action"] == "resume"
        playback_count_increment_seek
        playback_count_increment_seek_inside
      end

      def playback_count_increment_seek
        test_runner.verify_count[:playback_stream_initiate] += 1 if event["payload_action"] == "streamInitiate"
        test_runner.verify_count[:playback_seekStart] += 1 if event["payload_action"] == "seekStart"
        test_runner.verify_count[:playback_seekStop] += 1 if event["payload_action"] == "seekStop"
      end

      def playback_count_increment_seek_inside
        test_runner.verify_count[:playback_playbackRequest] += 1 if event["payload_action"] == "playbackRequest"
        test_runner.verify_count[:playback_pauseStart] += 1 if event["payload_action"] == "pauseStart"
        test_runner.verify_count[:playback_pauseStop] += 1 if event["payload_action"] == "pauseStop"
      end

      def chapter_count_increment
        test_runner.verify_count[:chapter_start] += 1 if event["payload_action"] == "start"
        test_runner.verify_count[:chapter_complete] += 1 if event["payload_action"] == "complete"
      end

      def ad_buffer_events_increment
        test_runner.verify_count[:ad_buffer_start] += 1 if event["payload_action"] == "bufferStart"
        test_runner.verify_count[:ad_buffer_stop] += 1 if event["payload_action"] == "bufferStop"
      end

      def playback_buffer_events_increment
        test_runner.verify_count[:playback_buffer_start] += 1 if event["payload_action"] == "bufferStart"
        test_runner.verify_count[:playback_buffer_stop] += 1 if event["payload_action"] == "bufferStop"
      end

      def buffer_events_increment
        ad_buffer_events_increment if event["type"] == "ad"
        playback_buffer_events_increment if event["type"] == "playback"
      end

      # Todo refactor : remove this and sum calculation should be at run time
      # use slug value to call dynamically the required calculation methods
      def calculations_post_count
        test_runner.verify_count[:sum_adBreakcomplete_playbackseekStart] = (
        test_runner.verify_count[:playback_seekStart] + test_runner.verify_count[:ad_break_complete])
        calc_continue_watch_nth_seg if test_runner.testcase_name == "Long Form: Continue watching nth segment"
        calc_scrub_inside_seg if test_runner.testcase_config[:inside_segment]
      end

      def calc_continue_watch_nth_seg
        test_runner.verify_count[:mod_chapter_complete] = test_runner.verify_count[:chapter_complete] + 2
      end

      def calc_scrub_inside_seg
        test_runner.verify_count[:sum_pausestop_seekstop_adbreak] = (
        test_runner.verify_count[:playback_pauseStop] + test_runner.verify_count[:playback_seekStop] +
        test_runner.verify_count[:ad_break_complete])
      end
    end
  end
end
