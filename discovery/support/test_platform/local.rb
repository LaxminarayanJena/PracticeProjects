require "httparty"
require "browserstack/local"

module Support
  module TestPlatform
    class Local < Base
      def initialize(_configs)
        if ENV["ANDROID_DEVICE_NAME"] == "FireTV"
          Appium::Driver.new(firetv_caps, true)
        elsif ENV["platformName"] == "Android"
          Appium::Driver.new(android_caps, true)
        elsif ENV["platformName"] == "tvOS"
          Appium::Driver.new(appletv_caps, true)
        else
          Appium::Driver.new(ios_caps, true)
        end
      end

      def set_android_env
        if ENV["platformType"] == "legacy"
          ENV["APK"] = ENV["LEGACY_ANDROID_APK"]
          ENV["APP_PACKAGE"] = ENV["LEGACY_ANDROID_APP_PACKAGE"]
          ENV["APP_ACTIVITY"] = ENV["LEGACY_ANDROID_APP_ACTIVITY"]
          ENV["NETWORK_CODE"] = ENV["LEGACY_ANDROID_NETWORK_CODE"]
        elsif ENV["platformType"] == "euro_black"
          ENV["APK"] = ENV["EURO_BLACK_ANDROID_APK"]
          ENV["APP_PACKAGE"] = ENV["EURO_BLACK_ANDROID_APP_PACKAGE"]
          ENV["APP_ACTIVITY"] = ENV["EURO_BLACK_ANDROID_APP_ACTIVITY"]
        else
          ENV["APK"] = ENV["ATVE_ANDROID_APK"]
          ENV["APP_PACKAGE"] = ENV["ATVE_ANDROID_APP_PACKAGE"]
          ENV["APP_ACTIVITY"] = ENV["ATVE_ANDROID_APP_ACTIVITY"]
          ENV["NETWORK_CODE"] = ENV["ATVE_ANDROID_NETWORK_CODE"]
        end
      end

      def set_ios_env
        if ENV["platformType"] == "legacy"
          ENV["BUNDLE_ID"] = ENV["LEGACY_IOS_BUNDLE_ID"]
          ENV["NETWORK_CODE"] = ENV["LEGACY_IOS_NETWORK_CODE"]
        elsif ENV["platformType"] == "euro_black"
          ENV["BUNDLE_ID"] = ENV["EURO_BLACK_IOS_BUNDLE_ID"]
        else
          ENV["BUNDLE_ID"] = ENV["ATVE_IOS_BUNDLE_ID"]
        end
      end

      def set_firetv_env
        ENV["APK"] = ENV["FIRETV_APK"]
        ENV["APP_PACKAGE"] = ENV["FIRETV_APP_PACKAGE"]
        ENV["APP_ACTIVITY"] = ENV["FIRETV_APP_ACTIVITY"]
        ENV["NETWORK_CODE"] = ENV["FIRETV_NETWORK_CODE"]
      end

      def set_appletv_env
        ENV["BUNDLE_ID"] = if ENV["platformType"] == "legacy"
                             ENV["APPLE_TV_BUNDLE_ID"]
                           else
                             ENV["ATVE_APPLE_TV_BUNDLE_ID"]
                           end
        ENV["UDID"] = ENV["APPLE_TV_UDID"]
      end

      def firetv_caps
        set_firetv_env
        { caps: {
          deviceName: "Simulator",
          platformName: "Android",
          # app: File.join(Support::Paths.builds, ENV["APK"]),
          appPackage: (ENV["APP_PACKAGE"]).to_s,
          appActivity: (ENV["APP_ACTIVITY"]).to_s,
          automationName: "Appium",
          uiautomator2ServerInstallTimeout: "5000",
          noReset: false,
          newCommandtimeout: "3600"
        } }
      end

      def android_caps
        set_android_env
        { caps: {
          deviceName: "Simulator",
          platformName: (ENV["platformName"]).to_s,
          # app: File.join(Support::Paths.builds, ENV["APK"]),
          appPackage: (ENV["APP_PACKAGE"]).to_s,
          appActivity: (ENV["APP_ACTIVITY"]).to_s,
          automationName: "Appium",
          uiautomator2ServerInstallTimeout: "5000",
          noReset: false,
          chromeOptions: { "w3c": false },
          newCommandtimeout: "3600"
        } }
      end

      def ios_caps
        set_ios_env
        { caps: {
          platformName: "ios",
          platformVersion: "12.1",
          deviceName: "iPhone",
          udid: (ENV["UDID"]).to_s,
          xcodeOrgId: (ENV["XCODEORGID"]).to_s,
          automationName: "XCUITest",
          usePrebuiltWDA: false,
          useNewWDA: false,
          bundleId: (ENV["BUNDLE_ID"]).to_s,
          wdaLaunchTimeout: 2_400_000,
          wdaConnectionTimeout: 2_400_000,
          shouldUseSingletonTestManager: false,
          waitForQuiescence: false,
          clearSystemFiles: true,
          wdaStartupRetryInterval: "1000",
          newCommandtimeout: "3600"
        } }
      end

      def appletv_caps
        set_appletv_env
        { caps: {
          platformName: "tvOS",
          platformVersion: "13.0",
          deviceName: "Apple TV 4G",
          udid: (ENV["UDID"]).to_s,
          xcodeOrgId: (ENV["XCODEORGID"]).to_s,
          automationName: "XCUITest",
          useNewWDA: true,
          bundleId: (ENV["BUNDLE_ID"]).to_s,
          waitForQuiescence: false
        } }
      end
    end
  end
end
