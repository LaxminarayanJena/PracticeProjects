module Support
  module Profiles
    class Base
      private

      def default_profile
        file = File.join(Support::Paths.cucumber_root, @directory, "default.yml")
        preprocess_and_load(file)
      end

      def custom_profile(profile_name)
        return {} unless profile_name

        file = File.join(Support::Paths.cucumber_root, @directory, "#{profile_name}.yml")
        raise "couldn't find profile #{profile_name}!" unless File.exist? file

        preprocess_and_load(file)
      end

      def preprocess_and_load(file)
        processed_file = ERB.new(File.read(file)).result
        YAML.load(processed_file)
      end
    end
  end
end
