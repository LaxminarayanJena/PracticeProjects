module Events
  module V2
    module TestRunnerHelper
      def sequence_and_buffer_testing(row, index)
        if buffer_events?(row, index, actual)
          buffer_events.push(BufferEvent.new(row, self, index)) if buffer_start?(row)
        elsif execute_data_seq_validation?
          # TODOS avoid rules as passing params
          sequence_test_results.push(SequenceTest.new(row, actual[index + 1], index + 1, testcase_config[:rules]).process)
        end
      end

      def data_seq_validations?
        testcase_config[:covered_testcases].include?("DataSequenceValidation")
      end

      def execute_data_seq_validation?
        testcase_config[:covered_testcases].include?("NextSequence")
      end

      def execute_verify_count?
        testcase_config[:covered_testcases].include?("VerifyCount")
      end

      # Tests Executions
      def sequence_test(curr_index)
        expected[curr_index][:result] = "passed"
      end

      def validation_test(row, curr_index)
        # Dynamically call the Event model based on the type
        obj = Object.const_get("Events::V2::Model::#{row['type'].capitalize}").new(row, curr_index)
        vaildation_results.push(obj)
      end

      def valid_params?
        valid? && (@actual || base_obj.valid?)
      end

      def error_messages
        errors.full_messages + base_obj.errors.full_messages
      end

      def valid_testcase_name
        errors.add(:testcase_name, "Invalid Testcase Name") unless TEST_CASES.map { |s| s[:name] }.include? testcase_name
      end

      def can_run_sequence_test?(row, curr_index)
        row["type"] == expected[curr_index][:type] && row["payload_action"] == expected[curr_index][:action]
      end
    end
  end
end
