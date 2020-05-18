module Events
  module V2
    class GenerateExpectedSequence
      attr_reader :test_case, :all_seqence, :base_obj

      def initialize(test_case_name, base_obj)
        @test_case = TEST_CASES.detect { |s| s[:name] == test_case_name }
        # prefer composition over inheritance.
        @all_seqence = base_obj.initial_seqence
        @base_obj = base_obj
      end

      # Dynamically call the slug method from TEST_CASES constant.
      def process
        send(test_case[:slug])
      end

      private

      # slug method for "Long Form: Scrub backward outside of chapter" case.
      def long_form_scrub_backward_outside_chapter
        long_form_lean_back

        seek_start_index = chapter_index(all_seqence, test_case[:seek_start_segment])
        seek_starting = all_seqence[0..seek_start_index]
        seek_end_index = chapter_index(all_seqence, test_case[:seek_start_end]) + 1
        starting_with_seek = seek_starting.concat(base_obj.seek_seqence)
        starting_with_seek.concat(all_seqence[seek_end_index..-1])
      end

      # slug method for "Long Form (lean back)" case.
      def long_form_lean_back
        counter = 0
        breaks.each do |sd|
          next if sd["ads"].empty?

          counter += 1
          ad_break = sd["ads"].inject([]) { |ad| ad.concat(base_obj.ad_seqence) }
          ad_break.unshift(type: "adBreak", action: "start", result: nil)
          ad_break.push(type: "adBreak", action: "complete", result: nil)
          all_seqence.concat(ad_break) if ad_break
          merge_seqence counter
        end
        @all_seqence
      end

      def ad_clicked_pause_or_play
        counter = 0
        breaks.each do |sd|
          next if sd["ads"].empty?

          counter += 1
          ad_break sd["ads"]
          ad_break.unshift(type: "adBreak", action: "start", result: nil)
          ad_break.push(type: "adBreak", action: "complete", result: nil)
          all_seqence.concat(ad_break) if ad_break
          merge_seqence counter
        end
        all_seqence
      end

      def ad_break(ads)
        ads.each_with_index.inject([]) do |ad, (_, i)|
          if test_case.dig(:ad_clicked, :adbreak) == counter && test_case[:ad_clicked][:ad] == i.succ
            ad.concat(base_obj.ad_pause_seqence)
          else
            ad.concat(base_obj.ad_seqence)
          end
        end
      end

      def merge_seqence(counter)
        if total_break_off_sets == counter
          merge_complete_seqence if base_obj.duration > last_time_off_set
        elsif total_break_off_sets == counter - 1
          base_obj.duration > last_time_off_set ? merge_resume_seqence : merge_complete_seqence
        else
          counter == test_case.dig(:video_cliecked, :segment) ? merge_pause_seqence : merge_resume_seqence
        end
      end

      def merge_complete_seqence
        all_seqence.concat(base_obj.complete_seqence)
      end

      def merge_resume_seqence
        all_seqence.concat(base_obj.resume_seqence)
      end

      def merge_pause_seqence
        all_seqence.concat(base_obj.palyback_pause_seqence)
      end

      def breaks
        @breaks ||= base_obj.streaming_resp["vendorAttributes"]["upLynk"]["preplay"]["ads"]["breaks"]
      end

      def break_off_sets
        @break_off_sets ||= base_obj.streaming_resp["vendorAttributes"]["upLynk"]["preplay"]["ads"]["breakOffsets"]
      end

      def total_break_off_sets
        @total_break_off_sets ||= break_off_sets.select { |i| i["timeOffset"].positive? }.count
      end

      def last_time_off_set
        @last_time_off_set ||= break_off_sets.last["timeOffset"]
      end

      def chapter_index(data, seek_chapter)
        count = 0
        chapter_index = 0
        data.each_with_index do |row, index|
          if row[:type] == "chapter" && row[:action] == "start"
            count += 1
            chapter_index = index if count == seek_chapter
          end
        end
        chapter_index
      end
    end
  end
end
