require "net/http"
require "uri"
require "json"
require "httparty"
require "byebug"

module Support
  module AppCenter
    class << self
      def url
        "https://api.appcenter.ms/v0.1/public/sdk/apps/#{ENV['APP_CENTER_APP_ID']}/distribution_groups/#{ENV['APP_CENTER_GROUP_ID']}/releases/latest"
      end

      def latest_app_info
        HTTParty.get(url)
      end

      def latest_app_download
        latest_app_info.parsed_response["download_url"]
      end

      def app_name
        app_name = latest_app_info.parsed_response["app_name"]
        app_version = latest_app_info.parsed_response["short_version"]
        name = "#{app_name}_#{app_version}"
        Kernel.puts "#{app_name}_#{app_version}"
        name
      end

      def app_custom_id
        latest_app_info.parsed_response["app_name"]
      end

      def download_apk
        filename = "#{app_name}.apk"
        File.open(filename, "w") do |file|
          file.binmode
          HTTParty.get(latest_app_download, stream_body: true) do |fragment|
            file.write(fragment)
          end
        end
        Kernel.puts "#{filename} downloaded successfully!"
        FileUtils.mv(filename, Support::Paths.app_center_builds)
      end

      def downloaded_file_path
        File.join(Support::Paths.app_center_builds, "#{app_name}.apk")
      end
    end
  end
end
