class VideoLandingScreen < BaseScreen
  def video_loader
    driver.find_element(:id, "player_loading_view")
  end

  def video_play_button
    driver.find_element(:id, "player_play")
  end

  def video_pause_button
    driver.find_element(:id, "player_pause")
  end

  def video_progress_bar
    driver.find_element(:id, "player_progress_bar")
  end

  def video_player_position
    driver.find_element(:id, "player_position")
  end

  def video_player_duration
    driver.find_element(:id, "player_duration")
  end

  def video_cc
    driver.find_element(:id, "tvCCaption")
  end

  def video_cc_focus
    video_cc.attribute("focused")
  end

  def video_inactive_screen
    driver.find_element(:id, "exo_subtitles")
  end

  def video_player_title
    driver.find_element(:id, "player_title")
  end

  def video_player_subtitle
    driver.find_element(:id, "player_subtitle")
  end

  def video_playing_time
    video_progress_bar.text.gsub(":", ".").to_f
  end
end
