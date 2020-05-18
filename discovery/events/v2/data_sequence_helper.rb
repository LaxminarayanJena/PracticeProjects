module Events
  module V2
    module DataSequenceHelper
      def set_attr(column, result_struct)
        instance_variable_set("@" + column.split("payload_")[1], result_struct)
      end

      def content_position_ad_type?(column)
        column == "payload_content_position" && %w[adBreak ad].include?(row["type"])
      end

      def continuous_increasing?(test_runner, column)
        format_value?(row[column]) >= format_value?(previous_row(test_runner)[column])
      end

      def not_increasing?(test_runner, column)
        format_value?(row[column]) == format_value?(previous_row(test_runner)[column])
      end

      def decreasing?(test_runner, column)
        format_value?(row[column]) <= format_value?(previous_row(test_runner)[column])
      end

      def format_value?(val)
        val ? val.to_i : 0
      end

      def previous_row(test_runner)
        @previous_row ||= test_runner.actual[index - 1]
      end
    end
  end
end
