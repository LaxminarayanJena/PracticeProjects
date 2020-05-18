module Events
  module V2
    class SequenceTest
      attr_accessor :csv_row, :next_csv_row, :index, :rules

      def initialize(csv_row, next_csv_row, index, rules)
        @csv_row = csv_row
        @next_csv_row = next_csv_row
        @index = index
        # TODOS avoid rules initialize everytime. Refactor
        @rules = rules
      end

      def process
        { expected_seq: current_row.nil? ? [] : current_row[:next_seq],
          action_not_present: current_row.nil?,
          actual_seq: actual_seq,
          result_seq: result_seq,
          next_csv_row: next_seq,
          index: index }
      end

      def current_row
        @current_row ||= rules.detect { |i| i[:type] == csv_row["type"] && i[:payload_action] == csv_row["payload_action"] }
      end

      def result_seq
        return [] if current_row.nil?

        @result_seq ||= current_row[:next_seq].select do |seq|
          seq[:type] == next_csv_row["type"] && seq[:payload_action] == next_csv_row["payload_action"]
        rescue StandardError
          []
        end
      end

      def actual_seq
        { type: csv_row["type"], payload_action: csv_row["payload_action"] }
      end

      def next_seq
        { type: next_csv_row["type"], payload_action: next_csv_row["payload_action"] }
      rescue StandardError
        []
      end

      class <<self
        def print_seq(sequence_test_results)
          puts "Total Events Tested: #{sequence_test_results.size}"
          puts "=======Failed Sequence======================"
          failed_seq sequence_test_results
          action_not_present sequence_test_results
        end

        def failed_seq(sequence_test_results)
          # here all the failed sequence will print.
          total_failed_seq = sequence_test_results.select { |i| i[:result_seq].empty? }
          puts "Failed Sequence: Total Events got Failed: #{total_failed_seq.count}"
          total_failed_seq.each_with_index do |seq, i|
            puts "#{i.succ}. Actual Sequence: #{seq[:actual_seq]}"
            puts " Expected Sequence: #{seq[:expected_seq]}"
            puts " Result Sequence: #{seq[:next_csv_row]}"
            puts " index: #{seq[:index] + 1}"
          end
        end

        def action_not_present(sequence_test_results)
          # Any event actions. that we are not covered in the sequence testing
          puts "=============Action not covered sequence==============="
          action_not_present = sequence_test_results.select { |i| i[:action_not_present] }.map { |seq| seq[:actual_seq] }
          puts "Total Events action not covered: #{action_not_present.uniq.count}"
          action_not_present.uniq.each do |seq|
            puts "Actual Sequence: #{seq}"
          end
        end
    end
    end
  end
end
