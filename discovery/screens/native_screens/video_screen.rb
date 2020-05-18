# frozen_string_literal: true

# Right now iOS locators are not available for video related methods

class VideoScreen < BaseScreen # rubocop:disable Metrics/ClassLength
  def video_current_time
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1) do
      driver.find_element(:xpath, "//*[@content-desc='player__time-current']/android.widget.TextView").text
    end
  end

  def end_time
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1) do
      driver.find_element(:xpath, "//*[@content-desc='player__time-total']/android.widget.TextView").text
    end
  end

  def check_video_playing
    driver.find_elements(:xpath, "//*[@content-desc='player__time-current']/android.widget.TextView").size
  end

  def scrubber_dot
    driver.find_element(:xpath, "//*[@content-desc='player__progress-bar']//android.view.ViewGroup[3]")
  end

  def up_next
    driver.find_element(:xpath, "//*[@text = 'UP NEXT' or @label = 'UP NEXT']")
  end

  def loading_icon
    driver.find_elements(:accessibility_id, "custom_progressbar").size
  end

  def play_button
    driver.find_element(:accessibility_id, "player__play")
  end

  def ad_title
    driver.find_elements(:xpath, "//*[@text = 'Advertisement']").size
  end

  def pause_button
    driver.find_element(:accessibility_id, "player__pause")
  end

  def rewind_button
    driver.find_element(:accessibility_id, "player__rewind")
  end

  def forward_button
    driver.find_element(:accessibility_id, "player__forward")
  end

  def video_container
    driver.find_element(:accessibility_id, "player")
  end

  def learn_more_link
    driver.find_element(:xpath, "//*[@text = 'Learn More']")
  end

  def video_text
    driver.find_element(:xpath, "//*[@class='android.widget.ScrollView']
      //following-sibling::android.view.ViewGroup/android.widget.TextView[1]")
  end

  def check_next_video_button
    driver.find_elements(:xpath, "//*[@content-desc='player-block-endcard-portrait__<no value>__cell-video']
      /../../android.view.ViewGroup").size
  end

  def get_coordinates(element)
    width = element.rect.width / 1.5
    height = element.rect.height / 1.5
    [width, height]
  end

  def captions
    driver.find_element(:accessibility_id, "player__close-caption-toggle--off")
  end

  def seek_bar
    driver.find_element(:accessibility_id, "player__progress-bar")
  end

  def video_segment_count
    video_container.click
    segments = driver.find_elements(:xpath, "//*[@content-desc='player__progress-bar']/android.view.ViewGroup/*")
    # subtracting 3 from segments.  One for start cap, one for end cap and one for player location indicator
    ad_attributes = {}
    Kernel.puts "segments.count #{segments.count}"
    seg_count = segments.count
    ad_attributes[:segments] = segments
    ad_attributes[:segment_count] = segments.count
    Kernel.puts "seg_count #{seg_count}"
    player_index = segments.find_index { |seg| seg.find_element(:xpath, "//android.view.ViewGroup") }
    Kernel.puts "player_index #{player_index}"
    ad_attributes[:player_index] = player_index
    current_segment = if player_index <= 3
                        1
                      else
                        player_index - 1
                      end
    ad_attributes[:current_segment] = current_segment
    Kernel.puts ad_attributes
    ad_attributes
  end

  def scrub_to_segment(segment)
    video_container.click
    seg_info = video_segment_count
    if seg_info[:current_segment] != segment
      segment_offset = 3 if (seg_info[:player_index]).zero?
      segment_offset = if seg_info[:current_segment] < segment
                         seg_info[:player_index] + 2
                       else
                         seg_info[:player_index] - 2
                       end
    end
    segment = segment_offset + segment
    video_container.click
    scrub_to = seg_info[:segments][segment].location.x
    scrub_backward(scrub_to)
    # byebug
  end

  def watch_video_till(start_time, end_time)
    co = get_coordinates(video_container)
    retry_proc = proc do
      Kernel.puts "============ retrying to tap the video ------------"
      tap_by_coordinates(co[0], co[1])
    end
    # rubocop:disable Custom/SleepCop.
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
      while start_time < end_time
        sleep 30
        tap_by_coordinates(co[0], co[1])
        start_time = video_current_time.to_f + 1
        end_time = end_time.to_f
        Kernel.puts "========================================= currrent time is #{video_current_time} ============"
      end
    end
  end

  def watch_full_video
    co = get_coordinates(video_container)
    retry_proc = proc do
      Kernel.puts "============ retrying to tap the video ------------"
      tap_by_coordinates(co[0], co[1])
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
      until check_next_video_button.positive?
        Kernel.puts "tapped video"
        # sleep 5
        co = get_coordinates(video_container)
        tap_by_coordinates(co[0], co[1])
      end
    end
  end

  def slider_attributes
    video_container.click
    @extra_time = 0
    @start_x = seek_bar.location.x
    @y = seek_bar.location.y
    video_container.click
    @width = seek_bar.size.width
  end

  def scrub_forward(length, start = true)
    slider_attributes
    video_container.click unless seek_bar.displayed?
    unless start
      @start_x = scrubber_dot.location.x
      @extra_time = 100
    end
    seeking_size = (@width / length) + @extra_time
    Appium::TouchAction.new.swipe(start_x: @start_x, start_y: @y, end_x: seeking_size, end_y: @y, duration: 200).perform.release
    # sleep is required since buffer time is needed after swiping
    sleep 2
    Kernel.puts "=============== After scrubbing video forward ============"
  end

  def scrub_backward(length)
    slider_attributes
    video_container.click
    seeked_point = scrubber_dot.location.x
    seek_upto = @start_x + length
    Appium::TouchAction.new.swipe(start_x: seeked_point, start_y: @y, end_x: seek_upto, end_y: @y, duration: 200).perform.release
    Kernel.puts "===============scrubbed video backword ============"
  end

  def scrub_forward_till_ad(length, watch = true)
    co = get_coordinates(video_container)
    tap_by_coordinates(co[0], co[1])
    scrub_forward(length)
    if ad_title.zero?
      scrub_forward(length, false)
    elsif watch # if Watch is true then watch full ad
      watch_ad(co)
    end
  end

  def watch_ad(coord)
    while ad_title.positive?
      Kernel.puts "============ tap the video in Ad ------------"
      tap_by_coordinates(coord[0], coord[1])
      sleep 30
    end
    tap_by_coordinates(coord[0], coord[1])
    sleep 10
  end

  def run_complete_ad(seek_size, ycord)
    co = get_coordinates(video_container)
    tap_by_coordinates(co[0], co[1])
    dot_point = scrubber_dot.location.x
    Appium::TouchAction.new.swipe(start_x: dot_point, start_y: ycord, end_x: seek_size + 100, end_y: ycord, duration: 200).perform.release
    sleep 2
    # rubocop:enable Custom/SleepCop.
    watch_ad(co)
  end

  def live_icon
    driver.find_element(:xpath, "//*[@text = 'LIVE ET' or @label = 'LIVE ET']")
  end

  def unlocked_up_next
    driver.find_element(:accessibility_id, "list-more-episodes__0__cell-video")
  end

  def full_screen_button
    driver.find_element(:xpath, "//*[@content-desc='player']/../../android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup")
  end

  def back_button
    driver.find_element(:xpath, "//*[@content-desc='button-back' or @name='button-back']")
  end
end
