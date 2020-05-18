# frozen_string_literal: true

class VideoLandingScreen < BaseScreen
  def home_hero
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def extra_clips_label
    driver.find_element(:name, "Extra Clips")
  end

  def media_control
    driver.find_element(:name, "Media Controls")
  end

  def video_play
    driver.find_element(:xpath, "//XCUIElementTypeApplication[@name='TVE']/XCUIElementTypeWindow/XCUIElementTypeOther")
  end

  def time_scrubbing
    driver.find_element(:xpath, "//*[@name='Media Controls']//XCUIElementTypeOther[@name='AXElapsedTime']")
  end

  def time_scrubbing_value
    time_scrubbing.text
  end

  def total_time
    driver.find_element(:xpath, "//*[@name='Media Controls']//XCUIElementTypeOther[@name='AXRemainingTime']").text
  end

  def scrubbed_marker
    driver.find_element(:id, "Elapsed Time Scrubbing Marker")
  end

  def lapsed_time
    driver.find_element(:name, "AXElapsedTime")
  end

  def remaining_time
    driver.find_element(:name, "AXRemainingTime")
  end

  def scrubber_needle
    driver.find_element(:name, "Scrub Needle")
  end

  def scrubbed_marker_float
    scrubbed_marker.text.gsub(":", ".").to_f
  end

  def total_length_percentage(percentage)
    total_time.to_f.abs * percentage.to_f / 100.0
  end
end
