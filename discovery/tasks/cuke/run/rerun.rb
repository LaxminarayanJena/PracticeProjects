require "cucumber/rake/task"

module Cuke
  module Run
    class Rerun < Cuke::Run::Base
      attr_accessor :rerun_string
      # rubocop:disable Metrics/LineLength
      def formatter
        %W[
          --require features @#{rerun_string}
          --format Support::Formatters::TimestampedJSON --expand --out #{rerun_log(instance_variable_get('@log_directory'), 'cucumber_rerun.json')}
          --format ParallelTests::Cucumber::FailuresLogger --out #{rerun_log(instance_variable_get('@log_directory'), 'rerun.txt')}
          --format ParallelTests::Cucumber::FailuresLogger --out #{rerun_log(instance_variable_get('@log_directory'), 'rerun_fails.txt')}
        ]
      end

      # rubocop:enable Metrics/LineLength
      def run
        # TODO: check here vs how the parallel run is running to see why the rerun doesn't seem to actually be rerunning
        create_log_directory
        ENV["BUILD_ID"] = "RERUN-#{ENV['BUILD_ID']}"
        Cucumber::Rake::Task.new(:rerun) do |t|
          rerun_index = @cucumber_opts.find_index("@")
          @cucumber_opts[rerun_index] = "@#{rerun_string}"
          t.cucumber_opts = @cucumber_opts
        end
        Rake::Task["rerun"].invoke
      end
    end
  end
end
