module Cuke
  module Run
    class Base
      attr_accessor :rerun_file, :log_directory

      def initialize(opts_hash)
        fail "Invalid cucumber_opts supplied!: #{opts_hash[:cucumber_opts].inspect}" unless opts_hash[:cucumber_opts]&.is_a?(Array)

        index = opts_hash[:cucumber_opts].index { |x| x.include? "SITE" }
        @site = opts_hash[:cucumber_opts][index].gsub("SITE=", "") if index
        @log_directory = set_log_directory
        Kernel.puts "=============Base Initialize Log Dir ================="
        Kernel.puts @log_directory
        Kernel.puts "=============Base Initialize Log Dir ================="
        create_log_directory unless File.exist?(@log_directory)
        @files = opts_hash[:files]
        @rerun_file = File.join(@log_directory, "rerun.txt")
        # Order is important here for rerun.txt to be placed in correct location for formatter.
        @cucumber_opts = opts_hash[:cucumber_opts] + formatter
        @cucumber_opts << "PRESERVE_WORKSPACE=true" # otherwise threads compete with each other
      end

      def log(filename)
        File.join(@log_directory, filename)
      end

      def rerun_log(directory, filename)
        File.join(directory, filename)
      end

      private

      # need to separate folders for tasks that have multiple unique runs. see ci:wsr for example.
      def set_log_directory
        stamp = Time.now.strftime("%s%6N")
        stamp = stamp.prepend(@site.to_s) if @site
        File.join(Support::Paths.logs_root, stamp)
      end

      def create_log_directory
        Kernel.puts "creating log directory in run::base"
        Dir.mkdir(@log_directory) unless File.exist?(@log_directory)
        Kernel.puts @log_directory
        create_rerun_txt
      end

      # Creates a rerun file for the given log directory if it does not exist.  Log directory is set by unix timestamp at runtime.
      def create_rerun_txt
        path = File.join(@log_directory, "rerun.txt")
        File.open(path, "w+").close unless File.exist?(path)
      end
    end
  end
end
