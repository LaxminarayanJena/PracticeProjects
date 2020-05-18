require "net/http"
require "uri"
require "json"
require "httparty"
require "rest-client"

module Support
  module BrowserStack
    class << self
      BS_VIDEO_API = "https://api.browserstack.com/app-automate/".freeze
      BS_SESSION_API = "https://api.browserstack.com/app-automate/plan.json".freeze
      BS_UPLOAD = "https://api-cloud.browserstack.com/app-automate/upload".freeze

      def uploaded_apps
        uri = URI.parse("https://api-cloud.browserstack.com/app-automate/recent_group_apps")
        request = Net::HTTP::Get.new(uri)
        ENV["BROWSERSTACK_USERNAME"] = ENV["BROWSERSTACK_USERNAME"].gsub("-jenkins", "")
        request.basic_auth(ENV["BROWSERSTACK_USERNAME"], ENV["BROWSERSTACK_ACCESS_KEY"])

        req_options = {
          use_ssl: uri.scheme == "https"
        }

        response = Net::HTTP.start(uri.hostname, uri.port, req_options) do |http|
          http.request(request)
        end
        uploaded_apps = JSON.parse(response.body)
        uploaded_apps
      end

      def upload_app
        file = File.join(Support::Paths.app_center_builds, "#{Support::AppCenter.app_name}.apk")
        exec "curl -u '#{ENV['BROWSERSTACK_USERNAME']}:#{ENV['BR OWSERSTACK_ACCESS_KEY']}' -X POST 'https://api-cloud.browserstack.com/app-automate/upload' -F 'file=@#{file}' -F 'data={\"custom_id\": \"#{Support::AppCenter.app_custom_id}\"}'"
      end

      def under_bs_usage?
        res = bs_plan_info
        res.parsed_response["parallel_sessions_running"] <= res.parsed_response["team_parallel_sessions_max_allowed"]
      end

      def authenticate
        ENV["BROWSERSTACK_USERNAME"] = ENV["BROWSERSTACK_USERNAME"].gsub("-jenkins", "")
        auth = { username: ENV["BROWSERSTACK_USERNAME"], password: ENV["BROWSERSTACK_ACCESS_KEY"] }
        auth
      end

      def fetch_response_json(session_id)
        # authenticate
        HTTParty.get(BS_VIDEO_API + "sessions/#{session_id}.json", basic_auth: authenticate, format: :json)
      end

      def bs_plan_info
        HTTParty.get(BS_SESSION_API, basic_auth: authenticate, format: :json)
      end

      # Gets the Session info from BrowserStack API and get's the 'video_url' json
      # element from the json file and returns it
      def fetch_video_url(session_id)
        response = fetch_response_json(session_id)
        response["automation_session"]["video_url"]
      end

      # Gets the Session info from BrowserStack API and gets the "device_logs_url" json
      # element from the json file and returns it
      def fetch_device_log_urls(session_id)
        json_response = fetch_response_json(session_id)
        device_logs_url = json_response["automation_session"]["device_logs_url"]
        response = HTTParty.get(device_logs_url, basic_auth: authenticate, format: :json)
        device_logs = { response: response, url: device_logs_url }
        device_logs
      end

      # Gets the Session info from BrowserStack API and gets the "network_logs_url" json
      # element from the json file and returns it
      def fetch_network_log_urls(session_id)
        json_response = fetch_response_json(session_id)
        network_logs_url = json_response["automation_session"]["device_logs_url"].gsub("devicelogs", "networklogs")
        response = HTTParty.get(network_logs_url, basic_auth: authenticate, format: :json)
        network_logs = { response: response, url: network_logs_url }
        network_logs
      end
    end
  end
end
