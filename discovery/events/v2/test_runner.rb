require "active_model"

module Events
  module V2
    class TestRunner
      include ActiveModel::Validations
      include Events::V2::TestRunnerHelper
      # actual: actual attr have CSV File object contains rows and columns of events
      # expected: expected attr used for sequence with Streaming API
      # testcase_name: testcase_name atrr name of the testcase.
      # vaildation_results: Array of ActiveModel Events objects for row based data validations
      # base_obj: composition of Events::V2::Base object
      # sequence_test_results: Array of Next sequence Test results.
      # verify_count: verify_count attr has hash of count bases testing
      # testcase_config : Next sequence Test rules
      # buffer_events: Array of buffer_events Failed objects
      attr_accessor :actual, :expected, :testcase_name, :vaildation_results, :base_obj, :sequence_test_results,
                    :verify_count, :testcase_config, :buffer_events, :data_sequence_validation, :dsv_collection

      validates :testcase_name, presence: true
      validate :valid_testcase_name, if: proc { |obj| obj.testcase_name }

      def initialize(testcase_name, request_path = nil, csv_obj = nil)
        puts "================Running Test cases for #{testcase_name}========================"
        # prefer composition over inheritance.
        # compose the Base object
        @testcase_name = testcase_name
        @actual = CSV.parse(csv_obj, headers: true) if csv_obj
        if request_path
          @base_obj = Base.new(request_path)
          if @base_obj.valid?
            @actual = @base_obj.actual_data
            @actual = @actual.select { |row| row["type"] == "playback" } if testcase_name == "Playback Schema"
          end
        end
        initial_assignment
      end

      def initial_assignment
        @vaildation_results = []
        @sequence_test_results = []
        @session_start_stop = 0
        @testcase_config = TEST_CASES.detect { |rule| rule[:name] == testcase_name }
        @verify_count = count_data_of_events if @testcase_config && execute_verify_count?
        @buffer_events = []
        @data_sequence_validation = []
      end

      def count_data_of_events
        { session_start: 0, session_stop: 0, ad_break_start: 0, ad_break_complete: 0, ad_start: 0, ad_complete: 0,
          ad_pauseStart: 0, ad_pauseStop: 0, sum_of_num_ads: 0, playback_start: 0, playback_stream_initiate: 0,
          playback_resume: 0, playback_seekStart: 0, playback_seekStop: 0, sum_adBreakcomplete_playbackseekStart: 0,
          chapter_start: 0, chapter_complete: 0, playback_pauseStart: 0, playback_pauseStop: 0, playback_stop: 0,
          playback_playbackRequest: 0, mod_chapter_complete: 0, sum_pausestop_seekstop_adbreak: 0, ad_buffer_start: 0,
          ad_buffer_stop: 0, playback_buffer_start: 0, playback_buffer_stop: 0 }
      end

      def process
        # Validate the params from the rake tasks
        if valid_params?
          run_all_tests
        else
          puts "================= Invalid Inputs ============================"
          puts error_messages
          exit(1)
        end
      end

      def run_all_tests
        # Run validation and sequence test curr_index = 0
        playback_req_index = []
        actual.each_with_index do |row, index|
          next unless TYPES_OF_SCHEMA.include?(row["type"])

          validation_test(row, index.succ)
          # this test required streaming Api response. will use the test in future.
          # once get integrate with UI testing
          # sequence_test(curr_index += 1) if can_run_sequence_test?(row, curr_index)

          sequence_and_buffer_testing(row, index)
          # TODOS for VerifyCount have to add a condition to avoid creating instance for all rows
          VerifyCount.new(row, self).process if execute_verify_count?

          playback_req_index << index - 1 if row["payload_action"] == "playbackRequest"
        end
        run_data_seq_validation(playback_req_index) if data_seq_validations?
      rescue StandardError => e
        puts "Exception Occurred: #{e.message}, #{e.backtrace}"
        exit(1)
      end

      def run_data_seq_validation(playback_req_index)
        data_seq_validation(playback_req_index)
        @dsv_collection = DataCollectionValidation.new.process(actual, self)
      end

      def data_seq_validation(playback_req_index)
        if playback_req_index.size > 1
          execute_tests(actual[0..playback_req_index[1]])
          data = begin
                   actual[playback_req_index[1] + 1..actual.length]
                 rescue StandardError
                   nil
                 end
          execute_tests_custom_index(playback_req_index, data) if data
        else
          execute_tests(actual)
        end
      end

      def execute_tests_custom_index(playback_req_index, data)
        index = playback_req_index[1] + 1
        data.each do |row|
          dsv = DataSequenceValidation.new(row, index)
          dsv.process(self)
          data_sequence_validation.push(dsv)
          index += 1
        end
      end

      def execute_tests(data)
        data.each_with_index do |row, index|
          dsv = DataSequenceValidation.new(row, index)
          dsv.process(self)
          data_sequence_validation.push(dsv)
        end
      end
    end
  end
end
