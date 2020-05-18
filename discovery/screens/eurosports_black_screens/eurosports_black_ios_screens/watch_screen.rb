class EuroWatchScreen < BaseScreen
  def schedule_tab
    driver.find_element(:id, "Schedule")
  end

  def latest_news_tab
    driver.find_element(:id, "Latest Videos")
  end

  def premium_videos_tab
    driver.find_element(:id, "Premium")
  end

  def latest_premium
    driver.find_element(:id, "LATEST - PREMIUM")
  end

  def sport_videos_tab
    driver.find_element(:id, "By Sport")
  end

  def competition_videos_tab
    driver.find_element(:id, "By Competition")
  end

  def navigate_to_sports_tab
    start_x = wait_until(30) { schedule_tab.location.x }
    y = wait_until(30) { schedule_tab.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  end

  def navigate_to_competition_tab
    start_x = wait_until(30) { premium_videos_tab.location.x }
    y = wait_until(30) { premium_videos_tab.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  end

  def expandable_arrow_opened
    driver.find_element(:id, "expandable arrow opened")
  end

  def whats_on_carousel
    driver.find_element(:id, "RailTitle")
  end

  def on_next_carousel
    driver.find_element(:id, "ON NEXT")
  end

  def eurosport_originals_carousel
    driver.find_element(:id, "EUROSPORT ORIGINALS")
  end

  def sport_name
    driver.find_element(:id, "SportName")
  end

  def back_button
    driver.find_element(:id, "Back")
  end

  def watch_button
    driver.find_element(:name, "WATCH")
  end

  def on_now_option
    driver.find_element(:name, "ON NOW")
  end

  def live_option
    driver.find_element(:name, "LIVE")
  end

  def play_button
    driver.find_element(:name, "play_button")
  end

  def replay_button
    driver.find_element(:name, "REPLAY")
  end

  def most_popular_carousel
    driver.find_element(:id, "MOST POPULAR")
  end

  def latest_free_carousel
    driver.find_element(:id, "LATEST")
  end

  def sport_title
    driver.find_element(:xpath, "//*[@name='SportTitle']")
  end

  def sport_description
    driver.find_element(:id, "SportDescription")
  end

  def scroll_most_popular_video_horizontally
    start_x = video_title.location.x
    y = video_title.location.y
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  end
end
