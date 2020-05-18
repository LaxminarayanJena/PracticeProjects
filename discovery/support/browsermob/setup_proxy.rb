require "browsermob/proxy"
require "byebug"
require "selenium-proxy"

class BrowserMobProxy
  attr_accessor :server, :proxy, :sel_proxy, :net_har, :proxy_listener

  def initialize
    bm_path = File.path(Support::Paths.cucumber_root + "/browsermob-proxy-2.1.4/bin/browsermob-proxy")
    @server = BrowserMob::Proxy::Server.new(bm_path, port: 9999, log: false, use_little_proxy: true)
    @server.start
    @proxy = @server.create_proxy
    @sel_proxy = @proxy.selenium_proxy
    Kernel.puts "Proxy Started at #{@sel_proxy.http}"
    @proxy.timeouts(read: 50_000, request: 50_000, dns_cache: 50_000)

    @net_har = @proxy.new_har("discovery", capture_binary_content: true, capture_headers: true, capture_content: true)
  end

  # #####################################################################
  # This method is basically a demo to show how a particular network call
  # can be captured. All we need to do is pass in the request url we're
  # targeting and it will wait for that request to fire. Currently all this
  # method does is save the content body as a json file.
  # @param [Object] target_url
  # #####################################################################
  def fetch_response_body(target_url, method_type, target_body_text)
    logs = nil
    Support::Eventually.eventually(timeout: 110, interval: 1) do
      # Initializing a new har in case the previous iteration ended before
      # the target network call was made.
      @net_har = @proxy.new_har("discovery", capture_binary_content: true, capture_headers: true, capture_content: true)
      @net_har.entries.each do |entry|
        begin
          break if @net_har.entries.index entry == @net_har.entries.count
          next unless entry.request.url.include?(target_url) && entry.request.method.eql?(method_type) &&
                      entry.response.content.text.include?(target_body_text)

          logs = JSON.parse(entry.response.content.text)
          break
        rescue TypeError
          fail("Response body for the network call came back empty")
        end
      end
      # if the target url is not reached in an iteration, it throws
      # a EOFError, and start the loop again creating another har
      # instance on line 33.
      raise EOFError if logs.nil?
    end
    logs
  end

  # #####################################################################
  # Method that fetches the request body text based on the arguments
  # provided, it filters the request based on request url, method type
  # and the target text within the request body. Unless it get's that,
  # it will keep looping for 110 seconds.
  # @param target_url
  # @param method_type
  # @param target_body_text
  # @return json object
  # #####################################################################
  def fetch_request_body(target_url, method_type, target_body_text)
    logs = nil
    Support::Eventually.eventually(timeout: 110, interval: 1) do
      @net_har = @proxy.new_har("discovery", capture_binary_content: true, capture_headers: true, capture_content: true)
      @net_har.entries.each do |entry|
        begin
          break if @net_har.entries.index entry == @net_har.entries.count
          next unless entry.request.url.include?(target_url) && entry.request.method.eql?(method_type) &&
                      entry.request.post_data.text.include?(target_body_text)

          logs = JSON.parse(entry.request.post_data.text)
          break
        rescue TypeError
          fail("Response body for the network call came back empty")
        end
      end
      raise EOFError if logs.nil?
    end
    logs
  end

  # #####################################################################
  # Method that fetches both the request and response bodies based on the
  # arguments provided to the method. It basically functions the same
  # way as fetch_request_body and fetch_response_body, the only difference
  # being that it captures both of those values in a single shot
  # @param target_url
  # @param method_type
  # @param target_body_text
  # @return Hash
  # #####################################################################
  def fetch_req_res_body(target_url, method_type, target_body_text, _screen)
    logs = {}
    Support::Eventually.eventually(timeout: 110, interval: 0.5) do
      @net_har = @proxy.new_har("discovery", capture_binary_content: true, capture_headers: true, capture_content: true)
      @net_har.entries.each do |entry|
        begin
          break if @net_har.entries.index entry == @net_har.entries.count
          next unless entry.request.url.include?(target_url) && entry.request.method.eql?(method_type) &&
                      entry.request.post_data.text.include?(target_body_text)

          logs = { "request" => JSON.parse(entry.request.post_data.text), "response" => JSON.parse(entry.response.content.text) }
          break
        rescue TypeError
          fail("Response body for the network call came back empty")
        end
      end
      $driver.window_size
      raise EOFError if logs.empty?
    end
    logs
  end

  # #####################################################################
  # Method that can be used to write the json file fetched to disk
  # @param [String] logs fetched from the network e.g. response body text
  # @param [String] saved_file_name arbitrary name of the file to save
  # #####################################################################
  def write_json_to_file(logs, saved_file_name)
    har_logs = File.join(Support::Paths.har_logs, "#{saved_file_name}_#{Time.now.strftime('%m%d%y_%H%M%S')}.json")
    File.open(har_logs, "w") do |json|
      json.write(logs)
    end
    logs
  end

  # #####################################################################
  # Stops the browsermob server
  # #####################################################################
  def stop_server
    Kernel.puts "Stopping Proxy Server"
    @server.stop
  end
end
