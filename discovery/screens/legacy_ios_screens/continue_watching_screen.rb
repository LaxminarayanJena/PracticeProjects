class ContinueWatchingScreen < BaseScreen
  def continue_watching_header
    driver.find_element(:name, "CONTINUE WATCHING")
  end

  def no_unfinished_videos
    driver.find_element(:xpath, "//*[contains(@name, 'Pick up where you left')]")
  end

  def unfinished_video
    driver.find_element(:xpath, "//XCUIElementTypeCell")
  end

  def play_unfinished_video(video_to_resume)
    video_to_resume.find_element(:name, "episode play button blue")
  end
end
