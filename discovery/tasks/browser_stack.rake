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

namespace :browser_stack do
  task :check_bs_builds do
    Dotenv.load
    uploaded_apps = Support::BrowserStack.uploaded_apps
    puts "======================================"
    puts "*** Available Browser Stack Builds ***"
    puts "======================================"
    uploaded_apps.each do |app|
      pp app
    end

    puts "", "======================================"
    puts "*** BUILDS YOUR CURRENTLY ON ***"
    puts "======================================", ""

    puts "", "================ATVE ANDROID======================"
    puts "You are currently on build #{ENV['ATVE_ANDROID_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["ATVE_ANDROID_APP_ID"]) }
    pp current_app_info
    puts "================ATVE ANDROID======================", ""

    puts "", "================EUROSPORT BLACK ANDROID======================"
    puts "You are currently on build #{ENV['EURO_BLACK_ANDROID_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["EURO_BLACK_ANDROID_APP_ID"]) }
    pp current_app_info
    puts "================EUROSPORT BLACK ANDROID======================", ""

    puts "", "================LEGACY ANDROID======================"
    puts "You are currently on build #{ENV['LEGACY_ANDROID_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["LEGACY_ANDROID_APP_ID"]) }
    pp current_app_info
    puts "Your network code is: #{ENV['LEGACY_ANDROID_NETWORK_CODE']}"
    puts "================LEGACY ANDROID======================", ""

    puts "================NATIVE ANDROID======================"
    puts "You are currently on build #{ENV['NATIVE_ANDROID_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["NATIVE_ANDROID_APP_ID"]) }
    pp current_app_info
    puts "Your network code is: #{ENV['NATIVE_ANDROID_NETWORK_CODE']}"
    puts "================NATIVE ANDROID======================", ""

    puts "", "================ATVE IOS======================"
    puts "You are currently on build #{ENV['ATVE_IOS_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["ATVE_IOS_APP_ID"]) }
    pp current_app_info
    puts "================ATVE IOS======================", ""

    puts "", "================EUROSPORT BLACK IOS======================"
    puts "You are currently on build #{ENV['EURO_BLACK_IOS_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["EURO_BLACK_IOS_APP_ID"]) }
    pp current_app_info
    puts "================EUROSPORT BLACK IOS======================", ""

    puts "================LEGACY IOS======================"
    puts "You are currently on build #{ENV['LEGACY_IOS_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["LEGACY_IOS_APP_ID"]) }
    pp current_app_info
    puts "Your network code is: #{ENV['LEGACY_IOS_NETWORK_CODE']}"
    puts "================LEGACY IOS======================", ""

    puts "================NATIVE IOS======================"
    puts "You are currently on build #{ENV['NATIVE_IOS_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["NATIVE_IOS_APP_ID"]) }
    pp current_app_info
    puts "Your network code is: #{ENV['NATIVE_IOS_NETWORK_CODE']}"
    puts "================NATIVE IOS======================", ""

    puts "You can change the app your testing against by replacing your .env *_APP_ID with one of the above listed app ids"
    puts "If your network codes do not match your builds will fail."
  end

  task :set_bs_build do
    Dotenv.load

    uploaded_apps = Support::BrowserStack.uploaded_apps
    Kernel.puts "You are currently on build #{ENV['BROWSERSTACK_APP_ID']}"
    current_app_info = uploaded_apps.find { |hash| hash.value?(ENV["BROWSERSTACK_APP_ID"]) }
    pp current_app_info
    app_names = []
    uploaded_apps.each do |app|
      app_names << app["app_name"]
    end

    prompt = TTY::Prompt.new
    build_id = prompt.select("Select your build") do |menu|
      uploaded_apps.each do |app|
        menu.choice (app["app_name"]).to_s, (app["app_id"]).to_s
      end
    end
    if current_app_info.nil? || current_app_info["app_id"] != build_id
      env_hash = Dotenv.parse(".env")
      env_hash["BROWSERSTACK_APP_ID"] = build_id
      app_name = uploaded_apps.select { |app| app["app_id"] == build_id }[0]["app_name"]
      env_hash["NETWORK_CODE"] = format_network_code(app_name)
      # Create a copy of .env file as backup unless a backup exists already
      FileUtils.mv ".env", ".env_backup" unless File.file? ".env_backup"
      File.open(".env", "w") do |file|
        env_hash.each { |k, v| file.write("#{k} = \"#{v}\" \n") }
      end

      Kernel.puts "Environment currently set as:"
      pp env_hash
      Kernel.puts "Build id changed to #{build_id}"
      Kernel.puts "your old .env file has been backed up to .env_backup"
    else
      Kernel.puts "no changes made"
    end
  end

  task :upload_build do
    Dotenv.load
    Support::BrowserStack.upload_app
  end

  task :wait_for_browserstack_sessions do
    #  This is a lame queueing method that has signifigant drawlbacks that
    # we can use until we impliment an actual queue when we have more jobs running.
    Dotenv.load
    Timeout.timeout(600) do
      unless Support::BrowserStack.under_bs_usage?
        running_sessions = Support::BrowserStack.bs_plan_info["parallel_sessions_running"]
        sessions_allowed = Support::BrowserStack.bs_plan_info["team_parallel_sessions_max_allowed"]
        Kernel.puts "Waiting......"
        Kernel.puts "Currently #{running_sessions} and #{sessions_allowed}"
      end
    end
  end

  task :save_device_logs do
    Dotenv.load
    files = Dir.entries(Support::Paths.device_logs).reject { |f| File.directory? f }
    Kernel.puts files
    files.each do |f|
      next unless f.include? ".json"

      file = File.open(File.join(Support::Paths.device_logs, f))
      res = HTTParty.get(file.read, basic_auth: Support::BrowserStack.authenticate)
      File.open(file, "w") { |s| s.write(res.body) }
    end
  end

  task :save_network_logs do
    Dotenv.load
    files = Dir.entries(Support::Paths.network_logs).reject { |f| File.directory? f }
    Kernel.puts files
    files.each do |f|
      next unless f.include? ".json"

      file = File.open(File.join(Support::Paths.network_logs, f))
      res = HTTParty.get(file.read, basic_auth: Support::BrowserStack.authenticate)
      File.open(file, "w") { |s| s.write(res.body) }
    end
  end

  task :save_video_logs do
    Dotenv.load
    files = Dir.entries(Support::Paths.logs_videos).reject { |f| File.directory? f }
    Kernel.puts files
    files.each do |f|
      next unless f.include? ".json"

      file = File.open(File.join(Support::Paths.logs_videos, f))
      res = HTTParty.get(file.read, basic_auth: Support::BrowserStack.authenticate)
      File.open(file, "w") { |s| s.write(res.body) }
    end
  end

  task :test_dev do
    Dotenv.load
    Support::BrowserStack.fetch_network_log_urls("0366e41bd209973f2c702668f1efc10ad3f812f3")
  end

  def format_network_code(app_name)
    # check if app is Android or iOS
    platform = app_name.split(".").last
    # parse the app name and upcase it
    platform == "apk" ? app_name.split("-")[1].upcase : app_name.split("_")[0].upcase
  end
end
