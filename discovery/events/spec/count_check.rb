RSpec.shared_examples "count_check" do |row, test_case, test_runner|
  if test_case.key?(:presence_check) && test_case[:presence_check].include?(row)
    it "with presence check - #{row[0]} count should equal to #{row[1]} count " do
      expect(test_runner.verify_count[row[0]].positive?).to eq(true)
      expect(test_runner.verify_count[row[1]].positive?).to eq(true)
      if test_runner.verify_count[row[0]].positive? && test_runner.verify_count[row[1]].positive?
        expect(test_runner.verify_count[row[0]]).to eq(test_runner.verify_count[row[1]])
      end
    end
  elsif test_case.key?(:specific_check) && test_case[:specific_check].include?(row)
    it " - #{row[0]} count should equal to #{row[1]} count besides both equals 2 " do
      expect(test_runner.verify_count[row[0]]).to eq(test_runner.verify_count[row[1]])
    end
    it "- #{row[0]} count should equal to 2" do
      expect(test_runner.verify_count[row[0]]).to eq 2
    end
    it "- #{row[1]} count should equal to 2" do
      expect(test_runner.verify_count[row[1]]).to eq 2
    end
  else
    it " - #{row[0]} count should equal to #{row[1]} count" do
      expect(test_runner.verify_count[row[0]]).to eq(test_runner.verify_count[row[1]])
    end
  end
end
