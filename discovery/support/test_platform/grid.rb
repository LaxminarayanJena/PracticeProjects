module Support
  module TestPlatform
    # Browser that runs on a node on the in-house grid.
    class Grid < Base
      include RemoteHelpers

      def initialize(configs)
        @name = configs["name"]
        @dimensions = configs["dimensions"]
        grid_options = PROFILE.configs[:test_platform][:grid_options]
        @url = "http://#{grid_options[:ip]}:#{grid_options[:port]}/wd/hub"

        if ENV["platformName"] == "Android"
          Appium::Driver.new(android_caps, true)
        elsif ENV["platformName"] == "tvOS"
          Appium::Driver.new(appletv_caps, true)
        else
          Appium::Driver.new(ios_caps, true)
        end
      end

      def set_android_env
        if ENV["platformType"] == "legacy"
          # ENV["APK"] = ENV["LEGACY_FIRE_APK"]
          ENV["APP_PACKAGE"] = ENV["FIRETV_APP_PACKAGE"]
          ENV["APP_ACTIVITY"] = ENV["FIRETV_APP_ACTIVITY"]
          ENV["NETWORK_CODE"] = ENV["FIRETV_NETWORK_CODE"]
        else
          ENV["APK"] = ENV["NATIVE_ANDROID_APK"]
          ENV["APP_PACKAGE"] = ENV["NATIVE_FIRE_APP_PACKAGE"]
          ENV["APP_ACTIVITY"] = ENV["NATIVE_FIRE_APP_ACTIVITY"]
          ENV["NETWORK_CODE"] = ENV["NATIVE_FIRE_NETWORK_CODE"]
        end
      end

      def set_appletv_env
        ENV["BUNDLE_ID"] = ENV["APPLE_TV_BUNDLE_ID"]
        ENV["UDID"] = ENV["APPLE_TV_UDID"]
      end

      def android_caps
        set_android_env
        { caps: {
          deviceName: "Simulator",
          platformName: "Android",
          # app: File.join(Support::Paths.builds, ENV["APK"]),
          appPackage: (ENV["APP_PACKAGE"]).to_s,
          appActivity: (ENV["APP_ACTIVITY"]).to_s,
          automationName: "Appium"
          # browserName: "Chrome",
          # uiautomator2ServerInstallTimeout: "2400",
          # noReset: true,
          # newCommandtimeout: "3600"
        },
          appium_lib: {
            server_url: @url
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
          automationName: "Appium",
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
        },
          appium_lib: {
            server_url: @url
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

      def stop
        rescued_stop
      end
    end
  end
end
