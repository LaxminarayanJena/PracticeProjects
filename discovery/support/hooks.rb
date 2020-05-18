# frozen_string_literal: true

DEFAULT_WAIT = 45
# rubocop:disable Lint/Void
$video_file_name
# rubocop:enable Lint/Void

Before do |scenario|
  Kernel.puts caps
  # if ENV["CUCUMBER_PROFILE"] == "browser_stack"
  #   $driver.caps = $driver.caps.merge!(name: scenario.name)
  # end
  $driver.start_driver
  $driver.driver.manage.timeouts.implicit_wait = DEFAULT_WAIT
  $video_file_name = "#{scenario.name.tr(' ', '_')}_#{Time.now.strftime('%-l-%M-%S%p_on_%b-%-d-%Y')}"
  $driver.start_recording_screen if ENV["CUCUMBER_PROFILE"] == "grid"
  ENV["NETWORK_LOGS"] == false
end

AfterConfiguration do
  if ENV["CUCUMBER_PROFILE"] == "default"
    Kernel.puts "Starting Appium Server"
    pid = spawn "appium --allow-insecure chromedriver_autodownload --address 0.0.0.0 --port 4723 --log-level error"
    # rubocop:disable Custom/SleepCop
    sleep(20)
    # rubocop:enable Custom/SleepCop.
    Process.detach(pid)
  end
  begin
    FileUtils.cp(ENV["test_rail_config_path"], Support::Paths.logs_root)
  rescue StandardError => e
    puts e.message
  end
end

After do |scenario|
  time_stamp = Time.now.strftime("%-l:%M:%S %p on %b %-d, %Y")
  end_screen_recording if ENV["CUCUMBER_PROFILE"] == "grid"
  if scenario.passed?
    Kernel.puts(
      "[cucumber]\n"\
  "  Scenario Passed!: #{scenario.location}"
    )
    scenario_dir = "PASSED_#{scenario.name.tr(' ', '_').gsub(/[^0-9A-Za-z_]/, '')}_#{Time.parse(time_stamp).utc.iso8601}"
  else
    begin
      # Send a runtime "scenario failed" message to STDOUT
      scenario_backtrace = scenario.exception.backtrace.join("\n  ")
      Kernel.puts(
        "[cucumber]\n"\
  "  Scenario failure on #{scenario.location}\n"\
  "  at #{time_stamp}!\n"\
  "  Full backtrace:\n"\
  "  #{scenario_backtrace}"
      )
      if ENV["CUCUMBER_PROFILE"] == "browser_stack"
        # Take a screenshot, embed in the html report
        scenario_dir = "FAILED_#{scenario.name.tr(' ', '_').gsub(/[^0-9A-Za-z_]/, '')}_#{Time.parse(time_stamp).utc.iso8601}"
        scenario_path = File.join(Support::Paths.logs_screenshot, scenario_dir)
        FileUtils.mkdir_p scenario_path
        encoded_img = $driver.driver.screenshot_as(:base64)
        embed("data:image/png;base64,#{encoded_img}", "image/png")
      end
    rescue Selenium::WebDriver::Error::UnknownError, Selenium::WebDriver::Error::WebDriverError => e
      puts e
      Kernel.puts "Failed to take a screenshot or get device logs!"\
      " Continuing with the rest of the [After] hook"
    end
  end
  Support::Eventually.eventually { embed_video(scenario_dir) } if ENV["CUCUMBER_PROFILE"] == "browser_stack"
  Support::Eventually.eventually { embed_device_logs_url(scenario_dir) } if ENV["CUCUMBER_PROFILE"] == "browser_stack"
  Support::Eventually.eventually { embed_network_logs_url(scenario_dir) } if ENV["CUCUMBER_PROFILE"] == "browser_stack"

  $driver.driver_quit
end

def embed_video(scenario_dir)
  @session_id = $driver.driver.session_id
  Kernel.puts "Fetching Recorded Video URL, Device & Network Logs for the failed test from BrowserStack"
  video_url = nil
  Support::Eventually.eventually(timeout: 110, interval: 30) do
    video_url = Support::BrowserStack.fetch_video_url(@session_id)
    expect(video_url).not_to be(nil)
  end
  file_location = File.join(Support::Paths.logs_videos, "#{scenario_dir}_logs_videos.json")
  file = File.new(file_location, "w")
  file.write(video_url)
  html = "<embed width=\"350\" height=\"350\" src=#{video_url} video muted=\"muted\" /"
  embed(html, "text/plain")
end

##
# Writes url to get logs from browserstack to file in root, then embeds the final location
# to the html report.
#  Rake::save_device_logs runs after tests are completed and writes those logs to there final location.
#  This is because logs aren't available as soon as tests are completed
def embed_device_logs_url(scenario_dir)
  Kernel.puts "Fetching Device Logs from Browserstack"
  Support::Paths.logs_device_logs
  Support::Eventually.eventually(timeout: 110, interval: 30) do
    @device_logs_url = Support::BrowserStack.fetch_device_log_urls($driver.driver.session_id)[:url]
    expect(@device_logs_url).not_to be(nil)
    @device_logs_url
  end
  file_location = File.join(Support::Paths.device_logs, "#{scenario_dir}_device_logs.json")
  file = File.new(file_location, "w")
  file.write(Support::BrowserStack.fetch_device_log_urls($driver.driver.session_id)[:url])
  archived_location = File.join(Support::Paths.archived_device_logs, "#{scenario_dir}_device_logs.json")
  device_logs_html = "<a href=#{archived_location}> device logs </a>"
  embed(device_logs_html, "text/plain")
end

##
# Writes url to get logs from browserstack to file in root, then embeds the final location
# to the html report.
#  Rake::save_network_logs runs after tests are completed and writes those logs to there final location.
#  This is because logs aren't available as soon as tests are completed
def embed_network_logs_url(scenario_dir)
  Kernel.puts "Fetching Network Logs from Browserstack"
  Support::Paths.logs_network_logs
  Support::Eventually.eventually(timeout: 110, interval: 30) do
    @network_logs_url = Support::BrowserStack.fetch_network_log_urls($driver.driver.session_id)[:url]
    expect(@network_logs_url).not_to be(nil)
    @network_logs_url
  end
  file_location = File.join(Support::Paths.network_logs, "#{scenario_dir}_network_logs.json")
  file = File.new(file_location, "w")
  file.write(Support::BrowserStack.fetch_network_log_urls($driver.driver.session_id)[:url])
  archived_location = File.join(Support::Paths.archived_network_logs, "#{scenario_dir}_network_logs.json")
  network_logs_html = "<a href=#{archived_location}> network logs </a>"
  embed(network_logs_html, "text/plain")
end

AfterStep do
  # $driver.driver.manage.timeouts.implicit_wait = 3
  # begin
  #   if appboy_alert.enabled?
  #     driver.find_element(:id, "com_appboy_inappmessage_modal_close_button").click
  #   elsif fullscreen_alert.enabled?
  #     driver.find_element(:id, "android:id/content").click
  #   elsif favorites_alert.enabled?
  #     dismiss_favorites_alert(favorites_alert)
  #   end
  # rescue Selenium::WebDriver::Error::NoSuchElementError => e
  #   puts e
  # ensure
  #   $driver.driver.manage.timeouts.implicit_wait = DEFAULT_WAIT
  # end
end

Before do
  #   dismiss_favorites_alert(favorites_alert) if favorites_alert.enabled?
  # rescue Selenium::WebDriver::Error::NoSuchElementError => e
  #   puts e
end

at_exit do
  BMP.stop_server if ENV["PROXY"]
  if ENV["CUCUMBER_PROFILE"] == "default"
    Kernel.puts "Stopping Appium Server"
    exec "/usr/bin/killall -KILL node"
  end
end

def fetch_screenshot_browserstack
  # Take a screenshot, embed in the html report
  scenario_dir = "FAILED_#{scenario.name.tr(' ', '_').gsub(/[^0-9A-Za-z_]/, '')}_#{Time.parse(time_stamp).utc.iso8601}"
  scenario_path = File.join(Support::Paths.logs_screenshot, scenario_dir)
  FileUtils.mkdir_p scenario_path
  encoded_img = $driver.driver.screenshot_as(:base64)
  embed("data:image/png;base64,#{encoded_img}", "image/png")

  # Method to get and save the device logs for the failed tests
  failed_device_logs(scenario, scenario_dir, time_stamp)

  # Method to get and save the network logs for the failed tests
  failed_network_logs(scenario, scenario_dir, time_stamp)
end

def fetch_video_browserstack
  @session_id = $driver.driver.session_id
  Kernel.puts "Fetching Recorded Video URL, Device & Network Logs for the failed test from BrowserStack"
  video_url = nil
  Support::Eventually.eventually(timeout: 110, interval: 30) do
    video_url = Support::BrowserStack.fetch_video_url(@session_id)
    expect(video_url).not_to be(nil)
  end
  html = "<embed width=\"350\" height=\"350\" src=#{video_url} video muted=\"muted\" /"
  embed(html, "text/plain")
  device_logs_url = Support::BrowserStack.fetch_device_log_urls(@session_id)
  device_logs_html = "<a href=#{device_logs_url}> device logs </a>"
  log_url(device_logs_html)
  network_logs_url = Support::BrowserStack.fetch_network_log_urls(@session_id)
  network_logs_html = "<a href=#{network_logs_url}> network logs </a>"
  log_url(network_logs_html)
end

def end_screen_recording
  video_encoding = $driver.stop_recording_screen
  # Write an mp4 file based on the Base64 encoded video
  unless video_encoding.nil?
    FileUtils.cd(Support::Paths.logs_videos)
    File.open("#{Support::Paths.logs_videos}/#{$video_file_name}.mp4", "wb") do |f|
      f.write(Base64.decode64(video_encoding))
    end
  end
  html = "<video width=\"720\" height=\"480\" controls muted>
            <source src=\"#{Support::Paths.jenkins_video_logs}/#{$video_file_name}.mp4\" type=\"video/mp4\">
          </video>"
  embed(html, "text/plain")
end

def favorites_alert
  element = driver.find_element(:id, "com_appboy_inappmessage_slideup")
  Support::Eventually.eventually(timeout: 1) { element }
  element
end

def fullscreen_alert
  element = driver.find_element(:id, "immersive_cling_title")
  Support::Eventually.eventually(timeout: 1) { element }
  element
end

def appboy_alert
  element = driver.find_element(:id, "com_appboy_inappmessage_modal_container")
  Support::Eventually.eventually(timeout: 1) { element }
  element
end

def device_size
  driver.manage.window.size
end

def calculate_dismiss_coords(element)
  width_divided_four = (device_size.width / 4)
  height = device_size.height
  startx = width_divided_four * 3.5
  endx = width_divided_four - 85
  y = if element.location.y.positive? && element.location.y < (device_size.height / 7)
        height / 12
      else
        height - 75
      end
  [startx, endx, y]
end

def dismiss_favorites_alert(element)
  startx, endx, y = calculate_dismiss_coords(element)
  Appium::TouchAction.new.press(x: startx, y: y).move_to(x: endx, y: y).release.perform
end
