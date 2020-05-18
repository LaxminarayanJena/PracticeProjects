def parse_hash(data)
  data.values.join("_") unless data.empty?
end

def actual_seq(actual_seq)
  parse_hash(actual_seq)
end

def expected_seq(expected_seq)
  expected_seq.map { |elem| parse_hash(elem) }.join(" , ")
end

def result_seq(next_csv_row)
  parse_hash(next_csv_row)
end
