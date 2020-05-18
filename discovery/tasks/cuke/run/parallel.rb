# require "parallel_tests/tasks"

module Cuke
  module Run
    class Parallel < Cuke::Run::Base
      def initialize(opts_hash)
        @parallel_opts = opts_hash[:parallel_opts]
        super
      end

      def formatter
        # TODO: add --order random
        %W[
          --strict
          --format Support::Formatters::TimestampedJSON --expand
          --tags 'not @wip'
          --out #{log('cucumber\$TEST_ENV_NUMBER.json')}
          --format ParallelTests::Cucumber::FailuresLogger --out #{rerun_file}
        ]
      end

      def run
        create_log_directory
        # Needs to be turned into a String, joined with spaces, for the parallel_tests gem to work
        # Standard Cucumber::Rake::Task accepts :cucumber_opts as an Array or Stringc
        opts_string = @cucumber_opts.join(" ")
        files_string = @files.join(" ")
        command = executable_command(
          files: files_string,
          count: @parallel_opts[:count] || 4, # number of browsers run in parallel
          # assignment of tests to threads - runtime vs. filesize, etc.
          pattern: @parallel_opts[:pattern] || nil,
          opts: opts_string || "" # formatters and profiles
        )
        puts "running executable: #{command}"
        # want to imitate the cucumber rake task exit
        exit unless system(command)
      end

      private

      def executable_command(files:, count:, pattern:, opts:)
        count_arg = count ? " -n #{count}" : ""
        pattern_arg = pattern ? " -p #{pattern}" : ""
        opts_arg = opts ? " -o \"#{opts}\"" : ""
        "parallel_cucumber " + files + count_arg + pattern_arg + opts_arg
      end
    end
  end
end
