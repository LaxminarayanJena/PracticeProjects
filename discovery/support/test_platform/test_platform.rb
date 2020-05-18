module Support
  module TestPlatform
    class << self
      def new(configs)
        # platform = configs.delete(:platform)
        case configs
        when "docker"
          Docker.new(configs)
        when "grid"
          Grid.new(configs)
        when "local"
          Local.new(configs)
        when "browser_stack"
          BrowserStack.new(configs)
        else
          raise "Unknown platform: #{platform}"
        end
      end
    end
  end
end
