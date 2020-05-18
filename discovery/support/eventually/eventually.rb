module Support
  module Eventually
    class << self
      def eventually(options = {})
        timeout = options[:timeout] || 30
        interval = options[:interval] || 0.1
        time_limit = Time.now + timeout
        loop do
          begin
            yield # will be what's in the block, eg. eventually(timeout: 60) { expect(thing1).to eq thing2 }
            # rubocop:disable Lint/HandleExceptions
          rescue RSpec::Expectations::ExpectationNotMetError,
                 # rubocop:enable Lint/HandleExceptions
                 Selenium::WebDriver::Error::NoSuchElementError,
                 Selenium::WebDriver::Error::StaleElementReferenceError,
                 JSON::ParserError,
                 EOFError => e
            # puts error
          end
          return if e.nil?
          raise e if Time.now >= time_limit

          # rubocop:disable Custom/SleepCop.
          sleep interval
          # rubocop:enable Custom/SleepCop.
        end
      end
    end
  end
end
