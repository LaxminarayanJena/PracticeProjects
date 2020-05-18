require "require_all"
require "byebug"
require_relative "../../support/paths"
require_relative "../../support/formatters/timestamped_json"
require_relative "run/base"
require_relative "run/serial"
require_relative "run/minimal"
require_rel "run"
require_rel "."

module Cuke
  class TaskRunner
    def initialize(**keywords)
      @keywords = {
        files: ["features/"],
        parallel: false,
        with_rerun: true,
        cucumber_opts: [],
        parallel_opts: {},
        minimal_run: false,
        profile: nil
      }.merge(keywords)
      @keywords.each { |key, val| instance_variable_set("@#{key}", val) }
      start
    end

    def instantiate_runs
      add_profile_to_opts

      @first_run = if @minimal_run
                     Cuke::Run::Minimal.new(@keywords)
                   elsif @parallel
                     Cuke::ParallelRuntimeLogs.new.copy_temp_to_actual
                     Cuke::Run::Parallel.new(@keywords)
                   else
                     Cuke::Run::Serial.new(@keywords)
                   end

      @keywords[:initial_run_directory] = @first_run.instance_variable_get("@log_directory") if @with_rerun
      @rerun = Cuke::Run::ParallelRerun.new(@keywords) if @with_rerun
    end

    def start
      instantiate_runs
      @cukes_successful = run_successfully?(@first_run)

      if !@cukes_successful && @with_rerun
        Kernel.puts "============First Run Failed ================"
        rerun_string = IO.read(@first_run.rerun_file)
        Kernel.puts "============Pre Filter================"
        Kernel.puts rerun_string
        rerun_string = filter_rerun(rerun_string)
        Kernel.puts "============Post Filter ================"
        Kernel.puts rerun_string
        @rerun.rerun_string = rerun_string
        Kernel.puts "============Rerun Log Directory ================"
        @rerun.log_directory
        puts "[rake] First run has a FAILURE! Rerunning the following tests: #{rerun_string}"
        fail "[rake] First run failed but no cukes to rerun!" if rerun_string.gsub(/\s+/, "").empty?

        @rerun_successful = run_successfully?(@rerun)
      end

      print_run_status
    end

    # Begin a Cucumber run and return true if it was successful or false if
    # there were any failures (Cucumber fails with a SystemExit exception if
    # any scenarios fail)
    def run_successfully?(run_instance)
      begin
        run_instance.run
      rescue SystemExit
        return false
      end
      true
    end

    def print_run_status
      if @cukes_successful
        puts "[rake] First run was a SUCCESS!"
        Cuke::ParallelRuntimeLogs.new.move_actual_to_temp if @parallel
      elsif @rerun_successful
        puts "[rake] Rerun was a SUCCESS!"
        move_rerun
      elsif !@cukes_successful && !@with_rerun
        fail "[rake] First run has a FAILURE and no rerun was desired! Marking build as FAILED."
      else
        move_rerun
        Kernel.puts Dir.entries(@rerun.log_directory)
        fail "[rake] Rerun has a FAILURE! Marking entire build as FAILED."
      end
    end

    def add_profile_to_opts
      fail "You requested Cucumber to run with profile #{@profile}"\
        " but the profile does not exist in cucumber.yml!" unless profile_exists?(@profile)
      profile_opt = %W[-p #{@profile}]
      @keywords[:cucumber_opts].unshift(*profile_opt) # so `-p profile` is first opt passed to cucumber exec
    end

    def profile_exists?(name)
      require "cucumber/cli/profile_loader"
      Cucumber::Cli::ProfileLoader.new.has_profile?(name)
    end

    def move_rerun
      final_rerun_dir = @rerun.log_directory + "_rerun"
      FileUtils.mv(@rerun.log_directory, final_rerun_dir)
      Kernel.puts "moving rerun directory"
      Kernel.puts @rerun.log_directory
      @rerun.log_directory = final_rerun_dir
    end

    ##
    # Filters rerun string for scenarios in incorrect format and puts them in correct format
    # EX "/features/Video.feature:3:62" becomes
    #  "/features/Video.feature3",
    #  "/features/Video.feature62",
    def filter_rerun(rerun)
      pre_filtered = []
      # split rerun file by newlines
      bd = rerun.split(/\n/)
      # find the runs prefix to filter by
      i = bd.first.index("/features") - 1
      prefix = bd.first[0..i]
      # split by feature file in line, because cucumbers weird and puts more than one for no good reason
      bd.each do |d|
        d.split(prefix).each do |x|
          Kernel.puts x
          pre_filtered << x
        end
      end
      # Remove Duplicates
      pre_filtered = pre_filtered.uniq
      # Remove empties
      pre_filtered.delete("")
      filtered = []
      # if a feature has more than one scenario to be rerun we need to find it
      # and put it in the correct format to be consumed by the rerunner
      pre_filtered.each do |feature|
        if /:\d+:\d+/.match?(feature)
          x = feature.split(":")
          # Find the index of the feature in array
          base_index = x.index { |s| s.include?("feature") }
          # set base string for scenarios to be rerun
          base_string = x.delete_at(base_index)
          x.each do |item|
            filtered << base_string + ":" + item
          end
        else
          filtered << feature
        end
      end
      # add prefix back before each line
      filtered = filtered.map { |line| prefix + line }
      # convert back to string
      filtered = filtered.join(" ")
      Kernel.puts "===========Filtered Scenarios============="
      Kernel.puts filtered
      filtered
    end
  end
end
