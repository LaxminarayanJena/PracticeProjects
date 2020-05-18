class ContinueWatchingScreen < BaseScreen
  def navigate_right_to_featured
    press_left while menu_featured.attribute("focused") == "false"
  end

  def continue_watching_video_list
    driver.find_elements(:xpath, "//XCUIElementTypeStaticText[@name='Continue Watching']//following::XCUIElementTypeCell")
  end

  def continue_watching_video_first
    driver.find_element(:xpath, "//XCUIElementTypeStaticText[@name='Continue Watching']//following::XCUIElementTypeCell[1]")
  end

  def video_progress_bar
    driver.find_element(:id, "Media Controls")
  end

  def total_time
    driver.find_element(:xpath, "//*[@name='Media Controls']//XCUIElementTypeOther[@name='AXRemainingTime']").text
  end

  def scrubbed_marker
    driver.find_element(:id, "Elapsed Time Scrubbing Marker")
  end

  def get_seeking_seconds(percentage)
    time = total_time.to_f.abs * percentage.to_f / 100.0
    time + 0.30
  end

  def scrubbed_marker_float
    scrubbed_marker.text.gsub(":", ".").to_f
  end

  def total_1_percentage(percentage)
    total_time.to_f.abs * percentage.to_f / 100.0
  end

  def scrubbed
    scrubbed_marker.text.gsub(":", ".").to_f
  end

  def continue_watching_carousel
    driver.find_elements(:xpath, "//XCUIElementTypeStaticText[@name='Continue Watching']").size
  end
end
