# frozen_string_literal: true

require "appium_lib"
require "dotenv"
require "byebug"
require "net/http"
require "cucumber"
# require "screen-object"
require "require_all"
require "retriable"
require_relative "../../../support/paths"
require_relative "../../../support/provider_affiliates"

require "active_support/core_ext/hash/deep_merge"
require "active_support/core_ext/hash/keys"
require "json"

Dotenv.load(File.join(Support::Paths.cucumber_root, ".env"))

# require_relative "../paths"
require_rel "../../../support/profiles"
require_rel "../../../support/test_platform/remote_helpers"
require_rel "../../../support/"

class AppiumWorld
end

ENV["platformName"] = "Android"
ENV["platformType"] = "legacy"
ENV["ANDROID_DEVICE_NAME"] = "FireTV"

PROFILE = Support::Profiles::Cucumber.new(ENV["CUCUMBER_PROFILE"])
TEST_PLATFORM = Support::TestPlatform.new(PROFILE.test_platform)

Appium.promote_appium_methods AppiumWorld

World do
  AppiumWorld.new
end

#  Need to require base screen first since other screens rely on it.
require_relative "../../../screens/legacy_fire_tv_screens/base_screen"
require_all File.join(File.dirname(__FILE__), "../../../screens/screen_helpers/")
require_all File.join(File.dirname(__FILE__), "../../../screens/legacy_fire_tv_screens")
require_relative "../../../support/hooks"

#  This loads data for each of our network based off the ENV["APP_PACKAGE"] value.
#  This lets tests use NETWORK_DATA.show or NETWORK_DATA.network_code etc.
NETWORK_DATA = ScreenHelpers::NetworkDataHelper.new
