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

namespace :legacy do
  desc "Run legacy Android features against given network"
  task :android, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["legacy_android/features/"],
      parallel: true,
      parallel_opts: {
        count: 11,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_android",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "DEVICE_NAME='Samsung Galaxy S9'",
        "OS_VERSION=8.0",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "Run legacy iOS features against given network"
  task :ios, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["legacy_ios/features/"],
      parallel: true,
      parallel_opts: {
        count: 11,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_legacy_ios",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "OS_VERSION=13",
        "DEVICE_NAME='iPhone XS'",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "Run features against given network"
  task :fire_tv, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["legacy_fire_tv/features/"],
      parallel: false,
      with_rerun: true,
      minimal: false,
      profile: "require_legacy_fire_tv",
      cucumber_opts: [
        "CUCUMBER_PROFILE=grid",
        "SITE=#{args[:network]}"
      ]
    )
  end
end
