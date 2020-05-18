# frozen_string_literal: true

class VideoScreen < BaseScreen
  #  Video Controls
  def video_container
    driver.find_element(:xpath, "//XCUIElementTypeWindow[1]")
  end

  def video_controls
    driver.find_element(:id, "video_controls")
  end

  def play_button
    driver.find_element(:accessibility_id, "video play unselected")
  end

  def video_current_time
    driver.find_element(:xpath, "//*[@type = 'XCUIElementTypeStaticText']")
  end

  def ad_title
    driver.find_elements(:name, "Learn More").size
  end

  def learn_more_link
    driver.find_element(:name, "Learn More")
  end

  def appstore_ok_button
    driver.find_elements(:id, "OK")
  end

  def navigate_to_app
    driver.find_elements(:id, "breadcrumb")
  end

  def webview
    driver.find_element(:xpath, "//XCUIElementTypeWebView")
  end

  def progress_timer
    driver.find_element(:xpath, "//*[@name='video play unselected']/following-sibling::XCUIElementTypeStaticText[1]")
  end

  def end_time
    driver.find_element(:id, "end_time")
  end

  def volume
    driver.find_element(:name, "volume unselected")
  end

  def captions
    driver.find_element(:name, "closed caption off unselected")
  end

  def live_video_icon
    driver.find_element(:id, "img_network_logo")
  end

  def back_btn
    driver.find_element(:name, "back button gray")
  end

  # Video Sharing and info
  def share_video
    driver.find_element(:id, "share unselected")
  end

  def video_info
    driver.find_element(:id, "info white")
  end

  def seek_bar
    driver.find_element(:xpath, "//*[@name='video play unselected']/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther")
  end

  def video_buffer_element
    driver.find_elements(:name, "In progress")
  end

  def info_button
    driver.find_element(:name, "info white")
  end

  def search_info_button
    driver.find_elements(:name, "//*[@name=\"info white\"]")
  end

  def slider
    driver.find_element(:xpath, '//XCUIElementTypeButton[@name="video play unselected"]/../XCUIElementTypeOther')
  end

  def play_video_button
    driver.find_element(:name, "video play unselected")
  end

  def info_box
    driver.find_element(:xpath, "//*[@name=\'#{NETWORK_DATA.unlocked_video}\']")
  end

  def info_boxes
    driver.find_elements(:xpath, "//*[@name=\'#{NETWORK_DATA.unlocked_video}\']")
  end

  def info_text
    driver.find_element(:xpath, "//*[@name=\'#{NETWORK_DATA.unlocked_video}\']/../XCUIElementTypeStaticText[2]")
  end

  def cancel_upload_button
    driver.find_element(:name, "Cancel")
  end

  def share_video_window
    driver.find_element(:name, "ActivityListView")
  end

  def share_video_options
    driver.find_elements(:name, "ActivityListView")
  end

  def closed_captions
    driver.find_element(:name, "closed caption off unselected")
  end
end
