# frozen_string_literal: true

require "require_all"
require "set"
require "rubygems"
require "byebug"
require "cucumber"
require "cucumber/rake/task"
require "rubocop/rake_task"
require "report_builder"
require "google_drive"
require "json"
require "dotenv"
require "net/http"
require "uri"
require "json"
require "tty-prompt"
require_relative "../support/app_center"

namespace :tasks do
  task :get_affiliates do
    Dotenv.load
    config_file = File.read("config.json")
    data_hash = JSON.parse(config_file)
    data_hash["client_secret"] = ENV["GSECRET"]
    File.open("config.json", "w") do |f|
      f.write(data_hash.to_json)
    end
    session = GoogleDrive::Session.from_config("config.json")
    file = session.file_by_title("Affiliate Logins")
    file.export_as_file("affiliates_login.csv")
  end

  task :generate_report do
    Dotenv.load
    Kernel.puts "generating report"
    ReportBuilder.input_path = Support::Paths.logs_root
    Kernel.puts "input path set"
    Kernel.puts Dir.entries(Support::Paths.logs_root).count.to_s
    if Dir.entries(Support::Paths.logs_root).count > 2
      ReportBuilder.configure do |config|
        Kernel.puts "reports hash #{Support::Paths.output}"
        config.input_path = Support::Paths.reports_hash
        config.report_path = "reports/my_test_report"
        config.report_types = %i[retry html json]
        config.additional_info = { browser: "Chrome", environment: (ENV["APK"]).to_s }
      end
      Kernel.puts "configure"
      options = {
        report_title: "#{ENV['BUILD']} Results"
      }
      Kernel.puts "options"
      begin
        ReportBuilder.build_report options
      # rubocop:disable Lint/RescueException
      rescue Exception => e
        Kernel.puts "Failed to generate report"
        Kernel.puts options
        Kernel.puts e
      end
      # rubocop:enable Lint/RescueException
      at_exit { check_report }
    end
    at_exit { check_report }
  end

  task :get_app_center_build do
    desc "get most recent app from app center"
    Dotenv.load
    Support::AppCenter.download_apk
    # Support::AppCenter.downloaded_file_path
  end

  # For Jenkins Pr runs we need an html report to archive otherwise the build will fail.
  # In the case of no pr tests needing to be run this creates a blank test report so the stupid plugin is happy.
  def check_report
    Dotenv.load
    FileUtils.touch("#{Support::Paths.reports}/empty.html") unless Dir.entries(Support::Paths.reports).count > 2
  end

  task :clean_log_directories do
    # Clean up logs directory
    FileUtils.mkdir_p "output" unless File.directory? Support::Paths.output

    FileUtils.mkdir_p "reports" unless File.directory? Support::Paths.reports

    FileUtils.mkdir_p Support::Paths.logs_root unless File.directory? Support::Paths.logs_root

    Dir.foreach(Support::Paths.output) do |f|
      fn = File.join(Support::Paths.output, f)
      FileUtils.rm_rf(fn, secure: true) if f != "." && f != ".."
    end
    Dir.foreach(Support::Paths.logs_root) do |f|
      fn = File.join(Support::Paths.logs_root, f)
      FileUtils.rm_rf(fn, secure: true) if f != "." && f != ".."
    end
    # Clean up reports directory
    Dir.foreach(Support::Paths.reports) do |f|
      fn = File.join(Support::Paths.reports, f)
      FileUtils.rm_rf(fn, secure: true) if f != "." && f != ".."
    end
    FileUtils.mkdir_p "output"
    FileUtils.mkdir_p "reports"
    Support::Paths.logs_network_logs
    Support::Paths.logs_device_logs
  end

  task :clean_build_directory do
    desc "cleans app center build directory"
    Dir.foreach(Support::Paths.app_center_builds) do |f|
      fn = File.join(Support::Paths.output, f)
      FileUtils.rm_rf(fn, secure: true) if f != "." && f != ".."
    end
  end
end
