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

namespace :native do
  desc "Parameterized native android features against given network on Android device"
  task :android_parameterized, [:device_name, :device_os_version, :network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["native/features/"],
      parallel: true,
      parallel_opts: {
        count: 11,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_native",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "platformName='Android'",
        "DEVICE_NAME='#{args[:device_name]}'",
        "OS_VERSION=#{args[:device_os_version]}",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "Parameterized native android features against given network on Android device"
  task :android_parameterized_feature, [:device_name, :device_os_version, :network, :feature_name] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["native/features/'#{args[:feature_name]}'"],
      parallel: true,
      parallel_opts: {
        count: 11,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_native",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "platformName='Android'",
        "DEVICE_NAME='#{args[:device_name]}'",
        "OS_VERSION=#{args[:device_os_version]}",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "default native android run for pr run decider"
  task :android, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["native/features/"],
      parallel: true,
      parallel_opts: {
        count: 7,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_native",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "platformName='Android'",
        "DEVICE_NAME='Samsung Galaxy S9'",
        "OS_VERSION=8.0",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "Run native features against given networko iOS device"
  task :ios_parameterized, [:device_name, :device_os_version, :network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["native/features/"],
      parallel: true,
      parallel_opts: {
        count: 11,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_native",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "platformName='iOS'",
        "OS_VERSION=#{args[:device_os_version]}",
        "DEVICE_NAME='#{args[:device_name]}'",
        "SITE=#{args[:network]}"
      ]
    )
  end

  desc "default native ios run for pr run decider"
  task :ios, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["native/features/"],
      parallel: true,
      parallel_opts: {
        count: 7,
        pattern: "--group-by scenarios"
      },
      with_rerun: true,
      minimal: false,
      profile: "require_native",
      cucumber_opts: [
        "CUCUMBER_PROFILE=browser_stack",
        "platformName='iOS'",
        "OS_VERSION=11",
        "DEVICE_NAME='iPhone X'",
        "SITE=#{args[:network]}"
      ]
    )
  end

  task :print_network, [:network] do |_t, args|
    Kernel.puts args[:network]
  end
end
