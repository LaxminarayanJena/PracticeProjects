class LiveScreen < BaseScreen
  def row_content
    driver.find_elements(:id, "frameStandard").size
  end

  def live_onnow_rail
    driver.find_element(:xpath, "//*[@text = 'On Now']")
  end

  def live_upnext_rail
    driver.find_element(:xpath, "//*[contains(@text, 'Up Next on')]")
  end

  def live_network_logo_list
    driver.find_elements(:id, "lyt_channel_selector")
  end

  def live_btn_see_past_episodes
    driver.find_element(:id, "btnFocused")
  end

  def live_txt_notaired_yet
    driver.find_element(:id, "textFocused")
  end

  def live_show_title
    driver.find_element(:id, "textLiveTitle")
  end

  def live_season_number
    driver.find_element(:id, "textSeasonNumber")
  end

  def live_title_desc
    driver.find_element(:id, "textLiveDescription")
  end

  def live_age
    driver.find_element(:id, "textLiveAge")
  end

  def live_badge
    driver.find_element(:id, "badgeLive")
  end

  def live_show_progress_bar
    driver.find_element(:id, "progressLive")
  end

  def live_image
    driver.find_element(:id, "imageLive")
  end

  def live_time
    driver.find_element(:id, "textTime")
  end

  def live_msg_not_airedyet
    driver.find_element(:id, "textFocused").text
  end

  def live_btn_past_episodes
    driver.find_element(:id, "btnFocused")
  end
end
