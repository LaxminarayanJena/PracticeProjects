require "yaml"

module ScreenHelpers
  class NetworkDataHelper
    attr_accessor :first_list_show, :unlocked_video, :ad_video, :locked_video, :show_search, :show_hero_by_letter_b, :show_with_seasons,
                  :about_title, :help_screen_title, :help_main_title, :contact_details_url, :contact_details_sub_title, :app_name,
                  :deeplink_prefix, :watch_live, :unlocked_episode, :unlocked_season, :shortform_unlocked_episode, :locked_episode,
                  :unlocked_show, :episode_name, :invalidShowName, :show_tab, :show_name_season_episode, :about, :help,
                  :locked_show, :search_string, :contact_details, :video_playback, :red_key_content

    def initialize
      data_file = File.join(Support::Paths.support, "network_data.yml")
      data = YAML.load(File.read(data_file))
      return if data[:"#{ENV["NETWORK_CODE"]}"].nil?

      assign_app_values(data[:"#{ENV["NETWORK_CODE"]}"])
      assign_app_settings_values(data[:"#{ENV["NETWORK_CODE"]}"])
    end

    def assign_app_values(data)
      self.app_name = data[:name]
      data.each do |key, value|
        send("#{key}=", value) unless key.to_s == "name"
      end
    end

    def assign_app_settings_values(data)
      self.about_title = data[:about][:title]
      self.help_screen_title = data[:help][:screen_title]
      self.help_main_title = data[:help][:main_title]
      self.contact_details_url = data[:contact_details][:url]
      self.contact_details_sub_title = data[:contact_details][:sub_title]
    end
  end
end
