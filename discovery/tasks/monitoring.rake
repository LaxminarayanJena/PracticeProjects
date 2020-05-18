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

namespace :monitoring do
  desc "Run features against given network"
  task :fire_tv_sanity, [:network] do |_t, args|
    Cuke::TaskRunner.new(
      files: ["legacy_fire_tv/features/WatchShow.feature"],
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
