module Events
  module V2
    class DataCollectionValidation
      attr_accessor :uuid, :session_id, :payload_video_id, :payload_playback_is_paused,
                    :payload_stream_type, :payload_duration, :playback_type, :stream_provider_session_id

      attr_accessor :stream_types, :paused, :durations, :playback_types
      ResultStruct = Struct.new(:index, :result, :expected, :actual)

      def initialize
        @payload_duration = []
        @stream_types = []
        @paused = []
        @durations = []
        @playback_types = []
      end

      def process(actual, test_runner)
        direct_check_methods(actual, test_runner)
        process_check_and_methods(actual, test_runner)
        self
      end

      def direct_check_methods(actual, test_runner)
        uuid_check(actual)
        session_id_check(actual)
        video_id_check(actual, test_runner) unless scrub_scenarios?(test_runner)
        stream_provider_session_id_check(actual, test_runner)
      end

      def process_check_and_methods(actual, test_runner)
        preprocessing_data(actual)
        @payload_stream_type = verify_stream_type(@stream_types, test_runner)
        verify_payload_duration(@durations)
        @payload_playback_is_paused = verify_is_pasued(@paused)
        @playback_type = playback_type_check(@playback_types, test_runner) unless scrub_scenarios?(test_runner)
      end

      def preprocessing_data(actual)
        actual.each_with_index do |row, index|
          @stream_types << row["payload_stream_type"] if row["type"] == "playback"
          @paused << row["payload_playback_is_paused"] if row["type"] == "playback" || row["type"] == "ad"
          @durations << [index, row["payload_duration"]] if row["type"] == "chapter"
          @playback_types << row["payload_playback_type"] if row["type"] == "playback"
        end
      end

      def uuid_check(actual)
        uuid = actual.map { |row| row["uuid"] }.uniq.size
        @uuid = [ResultStruct.new(nil, actual.size == uuid, actual.size, uuid)]
      end

      def session_id_check(actual)
        session_ids = actual.map { |row| row["session_id"] }.uniq.size
        @session_id = [ResultStruct.new(nil, session_ids == 1, 1, session_ids)]
      end

      def video_id_check(actual, test_runner)
        video_ids = actual.map { |row| row["payload_video_id"] }.compact.uniq.size
        video_count = test_runner.testcase_config[:video_count]
        @payload_video_id = [ResultStruct.new(nil, video_ids == video_count, video_count, video_ids)]
      end

      def stream_provider_session_id_check(actual, test_runner)
        sps_ids = actual.map { |row| row["payload_stream_provider_session_id"] }.compact.uniq.size
        video_count = test_runner.testcase_config[:video_count]
        @stream_provider_session_id = [ResultStruct.new(nil, sps_ids == video_count, video_count, sps_ids)]
      end

      def verify_stream_type(stream_types, test_runner)
        stream_types = stream_types.compact.uniq
        expected_stream_type = test_runner.testcase_config[:stream_type]
        [ResultStruct.new(nil, (stream_types.size == 1 && stream_types[0] == expected_stream_type), expected_stream_type, stream_types)]
      end

      def verify_is_pasued(paused)
        paused = paused.compact.uniq
        [ResultStruct.new(nil, (paused.size == 1 && paused[0] == "false"), "false", paused[0])]
      end

      def verify_payload_duration(durations)
        durations.each_slice(2) do |i|
          @payload_duration << ResultStruct.new(i[1][0], (i[0][1] == i[1][1]), i[0][1], i[1][1]) if i[0] && i[1]
        end
      end

      def playback_type_check(playback_types, test_runner)
        playback_types = playback_types.compact.uniq
        playback_count = test_runner.testcase_config[:playback_type_count]
        [ResultStruct.new(nil, (playback_types.size == playback_count), PLAYBACK_TYPES, playback_types)]
      end

      def scrub_scenarios?(test_runner)
        SCRUB_SCENARIOS.include? test_runner.testcase_config[:slug]
      end

      def all_passed?(col)
        send(col).all? do |result_struct|
          result_struct.result
        end
      end
    end
  end
end
