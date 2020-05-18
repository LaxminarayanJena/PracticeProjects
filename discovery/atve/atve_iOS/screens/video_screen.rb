class VideoScreen < BaseScreen
  def test_video_player
    driver.find_elements(:xpath, "//XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
  end

  def video_title
    driver.find_element(:xpath, "//XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
  end

  def video_desc
    driver.find_element(:xpath, "//XCUIElementTypeOther[2]/XCUIElementTypeStaticText[3]")
  end

  def fullscreen_landscape_mode_btn
    driver.find_element(:name, "icon fullscreen")
  end

  def video_running_time
    driver.find_element(:xpath, "//*[@name='skipForwardButton']/../following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[1]")
  end

  def video_end_time; end

  def video_skip_forward_button
    driver.find_element(:name, "skipForwardButton")
  end

  def video_skip_backword_button
    driver.find_element(:name, "skipBackwardButton")
  end

  def video_close_button
    driver.find_element(:name, "Stop")
  end

  def video_playing_time_return_time
    time_final = ""
    retry_proc = proc do
      tap_by_coordinates(300, 150)
      video_skip_forward_button.click
      time_final = video_running_time.text
    end
    Retriable.retriable(on: [Selenium::WebDriver::Error::NoSuchElementError, Selenium::WebDriver::Error::TimeoutError],
                        tries: 5, base_interval: 1, on_retry: retry_proc) do
      tap_by_coordinates(300, 150)
      video_skip_forward_button.click
      initial_time = video_running_time.text
      time_final = initial_time
      while time_final == ""
        tap_by_coordinates(300, 150)
        video_skip_forward_button.click
        time_final = video_running_time.text
      end
    end
    time_final
  end

  def video_playing_backward_time_return
    time_final = ""
    retry_proc = proc do
      tap_by_coordinates(300, 150)
      video_skip_backword_button.click
      time_final = video_running_time.text
    end
    Retriable.retriable(on: [Selenium::WebDriver::Error::NoSuchElementError, Selenium::WebDriver::Error::TimeoutError],
                        tries: 5, base_interval: 1, on_retry: retry_proc) do
      tap_by_coordinates(300, 150)
      video_skip_backword_button.click
      initial_time = video_running_time.text
      time_final = initial_time
      while time_final == ""
        tap_by_coordinates(300, 150)
        video_skip_backword_button.click
        time_final = video_running_time.text
      end
    end
    time_final
  end
end
