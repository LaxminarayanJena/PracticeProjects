require "active_support/time"

def rfc3339?(str)
  DateTime.rfc3339(str)
  true
rescue StandardError => e
  puts e
  false
end

def valid_uuid?(str)
  uuid_regex = /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/
  uuid_regex.match?(str.to_s.downcase)
end

def buffer_events?(row, index, actual)
  current_row_has_bufferevent?(row) ||
    next_row_has_bufferevent?(actual[index + 1]) ||
    previous_row_has_bufferevent?(actual[index - 1])
end

def current_row_has_bufferevent?(row)
  buffer_event?(row)
end

def next_row_has_bufferevent?(row)
  buffer_event?(row)
end

def previous_row_has_bufferevent?(row)
  buffer_event?(row)
end

def buffer_event?(row)
  row && (%w[playback ad].include?(row["type"]) && %w[bufferStart bufferStop].include?(row["payload_action"]))
end

def buffer_start?(row)
  row && (%w[playback ad].include?(row["type"]) && row["payload_action"] == "bufferStart")
end

def timestamp_inc?(row, test_runner, val)
  # DateTime.parse(row["timestamp"]).to_i == (DateTime.parse(test_runner.actual[index - 1]["timestamp"]) + val.seconds).to_i
  diff = DateTime.parse(row["timestamp"]).to_i - DateTime.parse(test_runner.actual[index - 1]["timestamp"]).to_i
  diff.between?(val[:start_at], val[:end_at])
end

def playback_progress?(row)
  ["playback"].include?(row["type"]) && row["payload_action"] == "progress"
end

def ad_progress?(row)
  ["ad"].include?(row["type"]) && row["payload_action"] == "progress"
end

def seek_stop?(row)
  ["playback"].include?(row["type"]) && row["payload_action"] == "seekStop"
end

def previous_playback_progress?(test_runner)
  playback_progress?(previous_row(test_runner))
end

def previous_ad_progress?(test_runner)
  ad_progress?(previous_row(test_runner))
end

def current_playback_progress?
  playback_progress?(row)
end

def current_ad_progress?
  ad_progress?(row)
end

def not_nil_or_empty?(val)
  !val.to_s.empty?
end

def file_as_params?
  not_nil_or_empty?(ENV["FILE_PATH"]) && not_nil_or_empty?(ENV["TESTCASE_NAME"])
end

def sessionid_as_params?
  not_nil_or_empty?(ENV["EVENTS_SESSION_ID"]) &&
    not_nil_or_empty?(ENV["TESTCASE_NAME"]) &&
    not_nil_or_empty?(ENV["START_DATE"]) &&
    not_nil_or_empty?(ENV["END_DATE"])
end
