# TODO: move to spec_helper.rb file
require "rspec"
require_relative "../v2/test_runner_helper"
require_relative "../v2/data_sequence_helper"
require_relative "../v2/base"
require_relative "../v2/test_runner"
require_relative "../v2/config"
require_relative "../v2/model/event"
require_relative "../v2/model/ad"
require_relative "../v2/model/ad_break"
require_relative "../v2/model/chapter"
require_relative "../v2/model/client_attributes"
require_relative "../v2/model/general_schema"
require_relative "../v2/model/playback"
require_relative "../v2/model/product_attributes"
require_relative "../v2/model/session"
require_relative "../v2/buffer_event"
require_relative "../v2/data_sequence_validation"
require_relative "../v2/helper"
require_relative "../v2/sequence_test"
require_relative "../v2/verify_count"
require_relative "../v2/athena_client"
require_relative "./count_check"
require_relative "../v2/data_collection_validation"
require_relative "./report_content"

# Build File Path and Testcase Array
testcases = []

def get_csv_obj(sessionid, start_date, end_date)
  client = Events::V2::AthenaClient.new
  client.query = client.events_query(sessionid, start_date, end_date)
  client.batch_query
  client.csv_obj
end

if file_as_params? && Events::V2::Base.new(ENV["FILE_PATH"], nil, nil).valid?
  testcases.push(name: ENV["TESTCASE_NAME"], path: ENV["FILE_PATH"])
elsif sessionid_as_params?
  puts "-----------------------------------Test Running Get Session as Parameter-------------------------------------"
  testcases.push(name: ENV["TESTCASE_NAME"], path: nil,
                 csv_obj: get_csv_obj(ENV["EVENTS_SESSION_ID"], ENV["START_DATE"], ENV["END_DATE"]))
else
  puts "--------------------------------Test Running Get Session from Query----------------------------------------"
  client = Events::V2::AthenaClient.new
  client.query = client.sessionids_query
  client.batch_query
  if client.results.result_set.rows.count <= 1
    puts "-----Unable to get the results from AWS Athena In Get Sessionid Query------------"
    exit(1)
  end
  results = [].tap do |res|
    client.results.result_set.rows.each do |row|
      res << row.data.inject([]) { |acc, r| acc << r.var_char_value }
    end
  end
  TEST_CASES.reject { |row| row[:slug] == "generic_case" }.each_with_index do |row, i|
    next unless results[i.succ]

    s_date = DateTime.parse(results[i.succ][1]).strftime("%Y/%m/%d")
    e_date = DateTime.parse(results[i.succ][1]).next_day(1).strftime("%Y/%m/%d")
    testcases.push(name: row[:name], path: nil,
                   csv_obj: get_csv_obj(results[i.succ][0], s_date, e_date))
  end
end

p "----------------------Running testcases--------------------------"
testcases.each { |testcase| p testcase[:name] }

testcases.each do |testcase|
  test_runner = Events::V2::TestRunner.new(testcase[:name], testcase[:path], testcase[:csv_obj])
  test_runner.process
  describe "#{testcase[:name]} - Next Sequence Testing" do
    test_runner.sequence_test_results.each do |seq|
      it "Index: #{seq[:index] + 1}, Previous Event Seq: #{actual_seq(seq[:actual_seq])},
          Expected Events Seq: #{expected_seq(seq[:expected_seq])}, Result/Current Event Seq: #{result_seq(seq[:next_csv_row])}" do
        expect(seq[:expected_seq]).to include(seq[:next_csv_row])
      end
    end
  end

  RSpec.describe "#{testcase[:name]} - Verify Count Testing" do
    before { skip "pending for #{testcase[:name]} testcase" unless test_runner.execute_verify_count? }
    TEST_CASES.select do |test_case|
      next unless test_case[:name] == test_runner.testcase_name && test_runner.execute_verify_count?

      test_case[:verify_count].each do |row|
        include_examples "count_check", row, test_case, test_runner
      end
    end
  end

  describe "#{testcase[:name]} - Row based data validation testing" do
    test_runner.vaildation_results.each do |obj|
      # TODO: remove hard code valure index
      it "CSV Index: #{obj.event_id + 1}: row based data validation" do
        expect(obj.valid?).to eq(true), "Failure Message, #{obj.push_errors}"
      end
    end
  end

  describe "#{testcase[:name]} - Buffer Logic Testing" do
    test_runner.buffer_events.each do |buffer_event|
      it "CSV Index: #{buffer_event.row_index}: Buffer Event" do
        expect(buffer_event.valid?).to be_true, "Failure Message: #{buffer_event.errors.full_messages}"
      end
    end
  end

  describe "#{testcase[:name]} - Data Sequence Validation Testing" do
    before { skip "pending for #{testcase[:name]} testcase" unless test_runner.data_seq_validations? }
    test_runner.data_sequence_validation.each do |dsv|
      it "CSV Index: #{dsv.index + 2}: Data Sequence Validation" do
        expect(dsv.all_passed?(test_runner)).to eq(true), "DSV Failure Message: #{print_error(dsv, test_runner)}"
      end
    end

    # Check the testcase config d't have data seq collections columns
    test_runner.testcase_config[:data_seq_collection_cols]&.each do |col|
      it "Data Collection Sequence Validation for #{col}" do
        expect(test_runner.dsv_collection.all_passed?(col)).to eq(true),
                                                               "DCV Failure Message: #{error_dcv(test_runner.dsv_collection, col)}"
      end
    end
  end
end

def print_error(dsv, test_runner)
  (test_runner.testcase_config[:data_seq_cols] + test_runner.testcase_config[:timestamp_cols])
    .each_with_object([]) do |column, testcases|
    obj = dsv.send(column.split("payload_")[1])
    testcases << "#{column} Expected: #{obj.expected}, Actual: #{obj.actual}" unless obj.result
  end
end

def error_dcv(obj, col)
  result_structs = obj.send(col)
  result_structs.each_with_object([]) do |result_struct, testcases|
    testcases << "#{col} Expected: #{result_struct.expected}, Actual: #{result_struct.actual}" unless result_struct.result
  end
end
