module Cuke
  module Run
    # Cucumber Run with no bells and whistles
    # Not parallel, no logging and no pretty formatters
    class Minimal < Cuke::Run::Serial
      RERUN_FILE = nil
      def formatter
        []
      end

      def log
        fail "This method should not be called!"
      end
    end
  end
end
