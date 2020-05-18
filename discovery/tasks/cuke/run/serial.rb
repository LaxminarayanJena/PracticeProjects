require "cucumber/rake/task"

module Cuke
  module Run
    class Serial < Cuke::Run::Base
      def formatter
        %W[
          --strict
          --format Support::Formatters::TimestampedJSON --expand --out #{log('serial_run.json')}
          --tag 'not @wip'
          --format Cucumber::Formatter::Rerun --out #{@rerun_file}
        ]
      end

      def run
        create_log_directory
        command = executable_command(
          files: @files,
          opts: @cucumber_opts
        )
        puts "running executable: #{command}"
        # want to imitate the cucumber rake task exit
        exit unless system(command)
      end

      private

      def executable_command(files:, opts:)
        file_string = files.join(" ")
        opts_string = opts.join(" ")
        "cucumber #{file_string} #{opts_string}"
      end
    end
  end
end
