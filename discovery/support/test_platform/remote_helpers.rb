module Support
  module TestPlatform
    # Mixin containing methods for webdrivers that run remotely (such as Grid and Docker)
    module RemoteHelpers
      def rescued_stop
        @instance.close
      rescue Selenium::WebDriver::Error::UnknownError, Selenium::WebDriver::Error::WebDriverError
        # Cannot communicate with the remote browser, so print to console and do nothing else:
        puts "[Support::Browser] Cannot communicate with browser"\
          " object: #{@instance}. Will just start a new one."
      end
    end
  end
end
