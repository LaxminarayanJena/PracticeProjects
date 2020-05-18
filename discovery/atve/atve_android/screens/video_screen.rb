class VideoScreen < HomeScreen
  def test_video_thumbnail
    driver.find_element(:id, "image")
  end

  def test_video_player
    driver.find_element(:id, "lunaVideoContainer")
  end

  def video_title
    driver.find_element(:id, "videoTitle")
  end

  def video_desc
    driver.find_element(:id, "expandable_tv")
  end

  def just_added_desc
    driver.find_element(:id, "description")
  end

  def video_pause_button
    driver.find_element(:id, "player_pause")
  end

  def forward_button
    driver.find_element(:id, "player_ffwd")
  end

  def video_current_time
    driver.find_element(:id, "player_position").text
  end

  def video_container
    driver.find_element(:id, "exo_subtitles")
  end

  def rewind_button
    driver.find_element(:id, "player_rwd")
  end

  def extra_clips
    driver.find_element(:xpath, "//*[@text = 'Extra Clips']")
  end

  def video_play_button
    driver.find_element(:id, "player_play")
  end

  def full_screen_button
    driver.find_element(:id, "fullscreen_toggle")
  end

  def player_back_button
    driver.find_element(:id, "player_back_button")
  end

  def cc_button
    driver.find_element(:id, "audio_settings")
  end

  def landscape_video_title
    driver.find_element(:id, "player_title")
  end
end
