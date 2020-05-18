module Support
  module Profiles
    class Cucumber < Base
      attr_reader :test_platform, :misc, :database, :configs

      def initialize(profile_name)
        @directory = "configs/cucumber_profiles"
        cucumber_configs = default_profile.deep_merge custom_profile(profile_name)
        @test_platform = cucumber_configs[:test_platform][:platform] # unused outside of BROWSER
        @misc = cucumber_configs[:misc]
        @configs = cucumber_configs
      end
    end
  end
end
