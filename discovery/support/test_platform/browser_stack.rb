require "httparty"
require "browserstack/local"

module Support
  module TestPlatform
    class BrowserStack < Base
      include RemoteHelpers
      BS_VIDEO_API = "https://api.browserstack.com/app-automate/".freeze
      BS_SESSION_API = "https://api.browserstack.com/app-automate/plan.json".freeze

      def initialize(_configs)
        if ENV["platformName"] == "Android"
          Appium::Driver.new(android_caps, true)
        elsif ENV["platformName"] == "iOS"
          Appium::Driver.new(ios_caps, true)
        end
      end

      def set_android_env
        ENV["DEVICE_NAME"] = ENV["ANDROID_DEVICE_NAME"]
        ENV["OS_VERSION"] = ENV["ANDROID_OS_VERSION"]
        if ENV["platformType"] == "legacy"
          ENV["BROWSERSTACK_APP_ID"] = ENV["LEGACY_ANDROID_APP_ID"]
          ENV["NETWORK_CODE"] = ENV["LEGACY_ANDROID_NETWORK_CODE"]
          ENV["APP_PACKAGE"] = ENV["LEGACY_ANDROID_APP_PACKAGE"]
        elsif ENV["platformType"] == "euro_black"
          ENV["BROWSERSTACK_APP_ID"] = ENV["EURO_BLACK_ANDROID_APP_ID"]
          ENV["APP_PACKAGE"] = ENV["EURO_BLACK_ANDROID_APP_PACKAGE"]
        else
          ENV["BROWSERSTACK_APP_ID"] = ENV["ATVE_ANDROID_APP_ID"]
          ENV["APP_PACKAGE"] = ENV["ATVE_ANDROID_APP_PACKAGE"]
          ENV["NETWORK_CODE"] = ENV["ATVE_ANDROID_NETWORK_CODE"]
        end
      end

      def set_ios_env
        ENV["DEVICE_NAME"] = ENV["IOS_DEVICE_NAME"]
        ENV["OS_VERSION"] = ENV["IOS_OS_VERSION"]
        if ENV["platformType"] == "legacy"
          ENV["BROWSERSTACK_APP_ID"] = ENV["LEGACY_IOS_APP_ID"]
          ENV["NETWORK_CODE"] = ENV["LEGACY_IOS_NETWORK_CODE"]
        elsif ENV["platformType"] == "euro_black"
          ENV["BROWSERSTACK_APP_ID"] = ENV["EURO_BLACK_IOS_APP_ID"]
        else
          ENV["BROWSERSTACK_APP_ID"] = ENV["ATVE_IOS_APP_ID"]
        end
      end

      def android_caps
        set_android_env
        {
          caps: {
            deviceName: (ENV["DEVICE_NAME"]).to_s,
            os_version: (ENV["OS_VERSION"]).to_s,
            platformName: (ENV["platformName"]).to_s,
            automationName: "Appium",
            locale: "en_GB",
            app: (ENV["BROWSERSTACK_APP_ID"]).to_s,
            build: "#{ENV['BUILD_ID']} #{ENV['DEVICE_NAME']} #{ENV['OS_VERSION']} #{Time.now.strftime '%Y-%m-%d %H:%M'}",
            project: (ENV["BS_PROJECT"]).to_s,
            chromeOptions: { "w3c": false },
            "browserstack.debug" => "true",
            "browserstack.geoLocation" => "GB",
            "browserstack.appium_version" => "1.12.1",
            "browserstack.networkLogs" => "true",
            "browserstack.appProfiling" => "true",
            "browserstack.resignApp" => "false",
            "autoAcceptAlerts" => "true",
            "browserstack.console" => "verbose",
            "browserstack.local" => true

          },
          appium_lib: {
            server_url: "http://#{ENV['BROWSERSTACK_USERNAME']}:#{ENV['BROWSERSTACK_ACCESS_KEY']}@hub-cloud.browserstack.com/wd/hub"
          }
        }
      end

      def ios_caps
        set_ios_env

        {
          caps: {
            deviceName: (ENV["DEVICE_NAME"]).to_s,
            os_version: "#{ENV['OS_VERSION']} ",
            platformName: "iOS",
            automationName: "XCUITest",
            app: (ENV["BROWSERSTACK_APP_ID"]).to_s,
            build: "#{ENV['BUILD_ID']} #{ENV['DEVICE_NAME']} #{ENV['OS_VERSION']} #{Time.now.strftime '%Y-%m-%d %H:%M'}",
            project: (ENV["BS_PROJECT"]).to_s,
            "browserstack.debug" => "true",
            "browserstack.geoLocation" => "US",
            "browserstack.appium_version" => "1.12.1",
            "browserstack.console" => "verbose",
            "browserstack.appProfiling" => "true",
            "browserstack.resignApp" => "true",
            "autoDismissAlerts" => "true",
            "browserstack.networkLogs" => "true",
            "browserstack.local" => true
          },
          appium_lib: {
            server_url: "http://#{ENV['BROWSERSTACK_USERNAME']}:#{ENV['BROWSERSTACK_ACCESS_KEY']}@hub-cloud.browserstack.com/wd/hub"
          }
        }
      end
    end
  end
end
