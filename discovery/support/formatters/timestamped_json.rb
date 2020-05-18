require "cucumber/formatter/json"
require_relative "../../support/paths"

module Support
  module Formatters
    class TimestampedJSON < Cucumber::Formatter::Json
      def on_finished_testing(*args)
        timestamp = Time.now.strftime("%s")
        @feature_hashes.each do |feature_hash|
          feature_hash[:name] += " #{timestamp}"
        end
        super(*args)
      end
    end
  end
end
