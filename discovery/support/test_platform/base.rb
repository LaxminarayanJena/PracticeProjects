module Support
  module TestPlatform
    # Base class for browsers platforms. Local, Grid, and Docker inherit off of this.
    class Base
      def instance
        return @instance if @instance

        fail "No instance created yet! Run #start first!"
      end
      #
      #   def start
      #     @instance = instantiate_watir_browser
      #     add_checkers
      #     resize_window
      #   end
      #
      #   def stop
      #     instance.close
      #   end
      #
      #   def restart
      #     stop
      #     start
      #   end
      #
      #   def cookies
      #     # workaround because @instance.cookies.to_a fails on remote chromedriver
      #     instance.execute_script("return document.cookie.split('\;')")
      #   end
      #
      #   def firefox?
      #     @name == "firefox"
      #   end
      #
      #   def console_log
      #     @instance.driver.manage.logs.get(:browser)
      #   end
      #
      #   def open?
      #     if attempt(:exists?)
      #       exists?
      #     else
      #       false
      #     end
      #   end
      #
      #   private
      #
      #   def attempt(meth)
      #     send(meth.to_sym)
      #     true
      #   rescue StandardError
      #     false
      #   end
      #
      #   def resize_window
      #     browser_window = @instance.driver.manage.window
      #
      #     browser_window.move_to(0, 0)
      #     browser_window.resize_to(@dimensions[:width], @dimensions[:height])
      #   end
      #

      #
      #   def check_for_alert
      #     @instance.url # Raises an exception if we can't get current page URL
      #   rescue Selenium::WebDriver::Error::UnhandledAlertError
      #     alert_text = @instance.alert.text
      #     @instance.alert.ok
      #     raise "Found & dismissed a JS alert with text: #{alert_text}"
      #   end
      #
      #   def check_apache
      #     return unless @instance.h1(text: "503 Service Unavailable").present?
      #
      #     # Normally, 503s only appear during deployments
      #
      #     # Kernel.puts "[Cucumber] Apache on #{DOMAINS[:oa]} seems to be having issues. "\
      #     # "Termininating Cucumber run!!!"
      #     # Cucumber.wants_to_quit = true
      #     fail "Cucumber is terminating due to web server issue: #{@instance.text}"
      #   end
      #
      #   def check_error
      #     return unless @instance.h1(text: /sorry, an error has occurred/).present?
      #
      #     error_body = @instance.div(id: "content").text
      #     fail "Error seen: #{error_body}"
      #   end
      #
      #   def check_application_error
      #     return unless @instance.h1(text: /Application Error/).present?
      #
      #     error_body = @instance.text
      #     fail "Application Error Seen! #{error_body}"
      #   end
      #
      #   def check_fatal_error
      #     return unless @instance.table(class: "xdebug-error").present?
      #
      #     error_body = @instance.body.text
      #     fail "Error Seen: #{error_body}"
      #   end
    end
  end
end
