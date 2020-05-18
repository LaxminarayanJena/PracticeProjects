module Events
  module V2
    class BufferEvent
      # QTA-967 Buffer Logic for Automation
      include ActiveModel::Validations
      BufferEventCollection = Struct.new(:row_index, :type, :action)

      attr_accessor :row_index, :testcase, :buffer_start, :buffer_stop, :before_buffer_start, :next_buffer_stop, :next_resume_buffer_stop

      # before_buffer_start: event occured before the buffer start event
      # buffer_start: buffer start event.
      # buffer_stop: buffer stop event.
      # next_buffer_stop: event occured after the buffer stop event.
      # next_resume_buffer_stop: event occured after the buffer resume event.

      # Validations
      validate :validate_buffer_stop, :validate_next_buffer_stop, :validate_before_buffer_start

      def initialize(row, test_runner, row_index)
        @row_index = row_index
        # TODO: testcase name should be a Global variable
        @testcase = test_runner.testcase_name
        assign_values(row, test_runner)
      end

      def assign_values(row, test_runner)
        @buffer_start = BufferEventCollection.new(row_index, row["type"], row["payload_action"])
        @buffer_stop = set_buffer_struct(row_index + 1, test_runner.actual)
        @before_buffer_start = set_buffer_struct(row_index - 1, test_runner.actual)
        @next_buffer_stop = set_buffer_struct(row_index + 2, test_runner.actual)
        @next_resume_buffer_stop = set_buffer_struct(row_index + 3, test_runner.actual)
      end

      def set_buffer_struct(index, actual)
        # Incase buffer event occured last.
        if actual[index]
          BufferEventCollection.new(index, actual[index]["type"], actual[index]["payload_action"])
        else
          BufferEventCollection.new(index, "", "")
        end
      end

      private

      def validate_buffer_stop
        errors.add(:buffer_stop, "Event is not present") unless buffer_stop_event?
      end

      def validate_next_buffer_stop
        errors.add(:next_buffer_stop, "Event there is no playback or ad resume action") unless next_buffer_stop_check?
      end

      def validate_before_buffer_start
        errors.add(:before_buffer_start, "Event next Sequence is not match") if sequence_test[:result_seq].empty?
      end

      def buffer_stop_event?
        buffer_stop.type == "playback" && buffer_stop.action == "bufferStop"
      end

      def next_buffer_stop_check?
        %w[playback ad].include?(next_buffer_stop.type) && next_buffer_stop.action == "resume"
      end

      def sequence_test
        rules = TEST_CASES.detect { |rule| rule[:name] == testcase }[:rules]
        SequenceTest.new({ "type" => before_buffer_start.type, "payload_action" => before_buffer_start.action },
                         { "type" => next_resume_buffer_stop.type, "payload_action" => next_resume_buffer_stop.action },
                         0, rules).process
      end
    end
  end
end
