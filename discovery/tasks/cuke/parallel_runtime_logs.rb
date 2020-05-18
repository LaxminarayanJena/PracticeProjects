module Cuke
  # parallel-tests gem always reads parallel runtime info from `tmp/parallel_runtime_cucumber.log`
  # for use in sorting features by runtime. however, it overwrites this file after every run
  # regardless of whether or not it was successful. we only want to use runtimes from successful
  # runs, so we need to store runtime logs separately and update them with new data from
  # successful runs.
  #
  # Since most Jenkins jobs maps to at most one parallelized rake task, only one temp file is necessary.
  class ParallelRuntimeLogs
    ACTUAL_RUNTIME_FILE = File.join(Support::Paths.cucumber_root, "tmp", "parallel_runtime_cucumber.log")
    TEMP_RUNTIME_FILE = File.join(Support::Paths.cucumber_root, "tmp", "temp_runtimes.log")

    def move_actual_to_temp
      fail(
        "Runtime file does not exist! If the parallel-tests gem was recently "\
    "updated, then the file location may have changed"
      ) unless File.exist? ACTUAL_RUNTIME_FILE
      FileUtils.rm_f TEMP_RUNTIME_FILE
      FileUtils.mv ACTUAL_RUNTIME_FILE, TEMP_RUNTIME_FILE
    end

    def copy_temp_to_actual
      unless File.exist? TEMP_RUNTIME_FILE
        FileUtils.mkdir(File.join(Support::Paths.cucumber_root, "tmp"))
        FileUtils.touch TEMP_RUNTIME_FILE
        # puts "Temp runtime file does not exist! Has there been a green build "\
        # "since the last time the workspace was cleared?"
        # return
      end
      FileUtils.rm_f ACTUAL_RUNTIME_FILE
      FileUtils.cp TEMP_RUNTIME_FILE, ACTUAL_RUNTIME_FILE
    end
  end
end
