class EuroVideoScreen < BaseScreen
  def video_sport_label
    driver.find_element(:id, "sportLabel")
  end

  def video_title
    driver.find_element(:id, "titleLabel")
  end

  def video_art
    driver.find_elements(:id, "newsImage")
  end

  def video_description
    driver.find_element(:id, "descriptionLabel")
  end

  def video_time
    driver.find_element(:id, "timeLabel")
  end

  def play_icon
    driver.find_element(:id, "playButtonIcon")
  end

  def watch_button
    driver.find_element(:id, "playButtonLabel")
  end

  def video_list
    driver.find_element(:id, "seriesList")
  end
end
