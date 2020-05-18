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

namespace :eurosports_black do
  desc "Parameterized eurosports_black android features on Android device"
  task :android_parameterized, [:device_name, :device_os_version] do |_t, args|
    Cuke::TaskRunner.new(
        files: ["eurosports_black/eurosports_black_android/features/"],
        parallel: true,
        parallel_opts: {
            count: 11,
            pattern: "--group-by scenarios"
        },
        with_rerun: true,
        minimal: false,
        profile: "require_eurosports_black_android",
        cucumber_opts: [
            "CUCUMBER_PROFILE=browser_stack",
            "platformName='Android'",
            "DEVICE_NAME='#{args[:device_name]}'",
            "OS_VERSION=#{args[:device_os_version]}"
        ]
    )
  end

  desc "Parameterized eurosports_black android features on Android device"
  task :android_parameterized_feature, [:device_name, :device_os_version, :feature_name] do |_t, args|
    Cuke::TaskRunner.new(
        files: ["eurosports_black/eurosports_black_android/features/'#{args[:feature_name]}'"],
        parallel: true,
        parallel_opts: {
            count: 11,
            pattern: "--group-by scenarios"
        },
        with_rerun: true,
        minimal: false,
        profile: "require_eurosports_black_android",
        cucumber_opts: [
            "CUCUMBER_PROFILE=browser_stack",
            "platformName='Android'",
            "DEVICE_NAME='#{args[:device_name]}'",
            "OS_VERSION=#{args[:device_os_version]}"
        ]
    )
  end

  desc "default eurosports_black android run for pr run decider"
  task :android do
    Cuke::TaskRunner.new(
        files: ["eurosports_black/eurosports_black_android/features/"],
        parallel: true,
        parallel_opts: {
            count: 7,
            pattern: "--group-by scenarios"
        },
        with_rerun: true,
        minimal: false,
        profile: "require_eurosports_black_android",
        cucumber_opts: [
            "CUCUMBER_PROFILE=browser_stack",
            "platformName='Android'",
            "DEVICE_NAME='Samsung Galaxy S9'",
            "OS_VERSION=8.0"
        ]
    )
  end

  desc "Run eurosports_black features on iOS device"
  task :ios_parameterized, [:device_name, :device_os_version] do |_t, args|
    Cuke::TaskRunner.new(
        files: ["eurosports_black/eurosports_black_ios/features/"],
        parallel: true,
        parallel_opts: {
            count: 11,
            pattern: "--group-by scenarios"
        },
        with_rerun: true,
        minimal: false,
        profile: "require_eurosports_black_ios",
        cucumber_opts: [
            "CUCUMBER_PROFILE=browser_stack",
            "platformName='iOS'",
            "OS_VERSION=#{args[:device_os_version]}",
            "DEVICE_NAME='#{args[:device_name]}'"
        ]
    )
  end

  desc "default eurosports_black ios run for pr run decider"
  task :ios do
    Cuke::TaskRunner.new(
        files: ["eurosports_black/eurosports_black_ios/features/"],
        parallel: true,
        parallel_opts: {
            count: 7,
            pattern: "--group-by scenarios"
        },
        with_rerun: true,
        minimal: false,
        profile: "require_eurosports_black_ios",
        cucumber_opts: [
            "CUCUMBER_PROFILE=browser_stack",
            "platformName='iOS'",
            "OS_VERSION=13",
            "DEVICE_NAME='iPhone XS'"
        ]
    )
  end

  task :print_network, [:network] do |_t, args|
    Kernel.puts args[:network]
  end
end