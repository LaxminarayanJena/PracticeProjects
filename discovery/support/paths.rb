# frozen_string_literal: true

# rubocop:disable Metrics/ModuleLength

module Support
  module Paths
    # TODO: switch to class
    # TODO: reduce number of methods
    class << self
      def cucumber_root
        rel = File.join(File.dirname(__FILE__), "../")
        File.expand_path(rel)
      end

      def jenkins_video_logs
        # Original: /jenkins/workspace/FireTv-production-monitoring/logs/cucumber/videos
        # Modified: /view/native-tests/job/FireTv-production-monitoring/ws/logs/cucumber/videos
        path = logs_videos.split("/")
        path[1] = "view"
        path[2] = "native-tests"
        path.insert(3, "job")
        path.insert(5, "ws")
        path.join("/")
      end

      def eurosport_graphql_data
        File.join(cucumber_root, "support", "eurosports_black_graphql_testdata")
      end

      def discovery_root
        File.join(cucumber_root, "eurosports_black", "eurosports_black_android")
      end

      def temp_root
        File.join(cucumber_root, "temp")
      end

      def logs_root
        create_dir(cucumber_root, "logs", "cucumber")
      end

      def logs_screenshot
        create_dir(cucumber_root, "logs", "cucumber", "screenshots")
      end

      def logs_videos
        create_dir(cucumber_root, "logs", "cucumber", "videos")
      end

      def downloads
        create_dir(temp_root, "downloads")
      end

      def uploads
        create_dir(temp_root, "uploads")
      end

      def assets
        File.join(cucumber_root, "features", "assets")
      end

      def reports
        File.join(cucumber_root, "reports")
      end

      def output
        File.join(cucumber_root, "output")
      end

      def feature_support
        File.join(cucumber_root, "features", "support")
      end

      def support
        File.join(cucumber_root, "support")
      end

      def builds
        File.join(support, "builds")
      end

      def app_center_builds
        File.join(builds, "app_center")
      end

      def device_logs
        File.join(cucumber_root, "logs", "cucumber", "device_logs")
      end

      def network_logs
        File.join(cucumber_root, "logs", "cucumber", "network_logs")
      end

      ##
      # Build url is a jenkins env variable that links links to
      #   https://$jenkins_url/job/$job_name/$build_number/
      def archived_network_logs
        File.join(ENV["BUILD_URL"], "artifact", "logs", "cucumber", "network_logs")
      end

      ##
      # Build url is a jenkins env variable that links links to
      #   https://$jenkins_url/job/$job_name/$build_number/
      def archived_device_logs
        File.join(ENV["BUILD_URL"], "artifact", "logs", "cucumber", "device_logs")
      end

      def logs_device_logs
        create_dir(cucumber_root, "logs", "cucumber", "device_logs")
      end

      def logs_network_logs
        create_dir(cucumber_root, "logs", "cucumber", "network_logs")
      end

      def reports_hash
        directories = prepend_logs_to_dirs(run_dirs)
        # Remove empty directories
        directories = directories.reject { |x| Dir.empty?(x) }
        # Remove screenshot & Logs directories
        excluded_dirs = %w[FAILED videos]
        directories = directories.reject { |x| excluded_dirs.include? x }
        rename_rerun_directories(directories)
        report_builder_hash(directories)
      end

      def har_logs
        create_dir(temp_root, "har_logs")
      end

      private

      def run_dirs
        # Gets all directories in Support::paths.log_root
        Dir.entries(Support::Paths.logs_root).select do |f|
          File.directory?(File.join(Support::Paths.logs_root, f)) &&
            f != "." &&
            f != ".." &&
            !f.include?("screenshot") &&
            !f.include?("device_logs") &&
            !f.include?("videos") &&
            !f.include?("network_logs")
        end
      end

      def prepend_logs_to_dirs(directories)
        directories.map { |f| f.prepend("#{Support::Paths.logs_root}/") }
      end

      def rename_rerun_directories(directories)
        directories.each do |dir|
          # This is really for if task is run multiple times you dont get rerun_rerun_rerun in the dir name
          next if dir.include? "rerun"
          # rubocop:disable Lint/RequireParentheses
          next unless Dir.entries(dir).include? "rerun_fails.txt" && "cucumber_rerun.json"

          # rubocop:enable Lint/RequireParentheses

          FileUtils.mv dir, "#{dir}_rerun"
        end
      end

      def report_builder_hash(directories)
        #  Creates a hash of directories in Support::paths.log_root (logs/cucumber/$run_name)
        #  where run_name is key and the fullpath is the value
        #  This is sent to reports generator gem which groups runs by key value pair.
        #  So each directory in logs/cucumber is
        #  a different group in the test run.
        non_empty_dirs = []
        run_dirs.each do |dir|
          dir if directories.each { |x| non_empty_dirs << dir if x.include?(dir) }
          dir if directories.each { |x| non_empty_dirs << dir if x.include?("screenshot") }
        end
        Kernel.puts "non_empty_dirs #{non_empty_dirs}"
        # remove unix timestamp from non empty directories (which will be the key for the hash)
        non_empty_dirs.each { |x| x.gsub!(/\d+/, "") }
        # make sure they're in the same order before zipping
        non_empty_dirs.sort
        directories.sort
        Kernel.puts "final hash #{Hash[non_empty_dirs.zip directories]}"
        Hash[non_empty_dirs.zip directories]
      end

      # move this to an entry point process
      def create_dir(*path)
        File.join(path).tap do |dir|
          FileUtils.mkdir_p dir
        end
      end
    end
  end
end
# rubocop:enable Metrics/ModuleLength
