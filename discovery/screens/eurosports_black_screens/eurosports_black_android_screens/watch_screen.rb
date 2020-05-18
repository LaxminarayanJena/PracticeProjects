class EuroWatchScreen < BaseScreen # rubocop:disable Metrics/ClassLength
  def home_tab
    driver.find_element(:xpath, "//*[@text = 'Home']")
  end

  def schedule_tab
    driver.find_element(:accessibility_id, "Schedule")
  end

  def latest_videos_tab
    driver.find_element(:accessibility_id, "Latest Videos")
  end

  def premium_videos_tab
    driver.find_element(:accessibility_id, "Premium")
  end

  def sport_videos_tab
    driver.find_element(:accessibility_id, "By Sport")
  end

  def competition_videos_tab
    driver.find_element(:accessibility_id, "By Competition")
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

  def sport_video_category
    driver.find_element(:id, "sportsMultilevelListView")
  end

  def popular_sports_category
    driver.find_element(:xpath, "//*[@text = 'Most popular sports']")
  end

  def all_sports_category
    driver.find_element(:xpath, "//*[@text = 'All Sports']")
  end

  def first_popular_sport
    driver.find_elements(:id, "title")[1]
  end

  def self.competition
    alias_method :first_competition, :first_popular_sport
  end

  competition

  def sports_name
    driver.find_elements(:id, "title")
  end

  def self.sport_comepetition_name
    alias_method :competitions_name, :sports_name
  end

  sport_comepetition_name

  def scroll_to_last_sport_by_coordinates
    start_x_coordinate = driver.window_size.width - 50
    start_y_coordinate = driver.window_size.height - 500
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 1200
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def sport_page_title
    driver.find_element(:id, "toolbarTitle")
  end

  def self.page_title
    alias_method :competition_page_title, :sport_page_title
    alias_method :euro_original_series_page_title, :sport_page_title
  end

  page_title

  def competition_videos_sport_list
    driver.find_element(:id, "competitionsMultilevelListView")
  end

  def sport_competition_videos
    driver.find_element(:id, "title")
  end

  def back_icon
    driver.find_element(:accessibility_id, "Back")
  end

  def calender
    driver.find_element(:id, "calendar")
  end

  def today_label
    driver.find_element(:xpath, "//*[@text = 'TODAY']")
  end

  def regular_day_label
    driver.find_elements(:id, "regularDayBackground")
  end

  def regular_day
    driver.find_elements(:id, "regularDayBackground")[1]
  end

  def scroll_left_from_today_label
    start_x = wait_until(30) { today_label.location.x }
    y = wait_until(30) { today_label.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x.to_i + 500, end_y: y, duration: 400).perform.release
  end

  def scroll_right_from_today_label
    start_x = wait_until(30) { today_label.location.x }
    y = wait_until(30) { today_label.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 500, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end

  def show_earlier_today_button
    driver.find_element(:xpath, "//*[@text = 'SHOW EARLIER TODAY']")
  end

  def hide_earlier_today_button
    driver.find_element(:xpath, "//*[@text = 'HIDE EARLIER TODAY']")
  end

  def show_hide_earlier_today_button
    driver.find_elements(:id, "hidePastProgramsButton")
  end

  def program_list_view
    driver.find_elements(:id, "pastProgramsListView")
  end

  def previous_button
    driver.find_element(:id, "previousDateButton")
  end

  def next_button
    driver.find_element(:id, "nextDateButton")
  end

  def next_day
    driver.find_element(:xpath, "(//*[@text ='TODAY']//following::android.widget.TextView[4])")
  end

  def upcoming_program_list
    driver.find_elements(:id, "upcomingProgramsListView")
  end

  def card_on_program_list
    driver.find_elements(:id, "cardView")
  end

  def on_now_label
    driver.find_element(:xpath, "//*[@text = 'On Now']")
  end

  def most_popular_label
    driver.find_element(:xpath, "//*[@text = 'Most Popular']")
  end

  def latest_label
    driver.find_element(:xpath, "//*[@text = 'Latest']")
  end

  def tennis_label
    driver.find_element(:xpath, "//*[@text = 'Tennis']")
  end

  def cycling_label
    driver.find_element(:xpath, "//*[@text = 'Cycling']")
  end

  def football_label
    driver.find_element(:xpath, "//*[@text = 'Football']")
  end

  def whats_on_label
    driver.find_elements(:id, "titleTextView")[1]
  end

  def eurosports_original_label
    driver.find_element(:xpath, "//*[@text = 'Eurosport Originals']")
  end

  def latest_premium_label
    driver.find_element(:xpath, "//*[@text = 'Latest - Premium']")
  end

  def euro_originals_first_series_title
    driver.find_element(:xpath, "//*[@text = 'Eurosport Originals']//following::androidx.recyclerview.widget.RecyclerView[1]//
      android.widget.FrameLayout[1]//android.view.ViewGroup/android.widget.TextView[2]")
  end

  def eurosport_originals_series
    driver.find_element(:xpath, "//*[@text = 'Eurosport Originals']//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout[1]//android.view.ViewGroup/android.widget.ImageView")
  end

  def most_popular_video_title
    driver.find_elements(:id, "com.eurosport.black:id/titleLabel")
  end

  def scroll_to_most_popular
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 250
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_eurosport_originals
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 500
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_latest_premium
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 700
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_latest_corousel
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 1000
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_tennis
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 1250
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_cycling
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 1500
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def scroll_to_football
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 1750
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform.release
  end

  def latest_filter_label
    driver.find_element(:id, "latestFilterButton")
  end

  def most_popular_filter_label
    driver.find_element(:id, "popularFilterButton")
  end

  def most_popular_video_card
    driver.find_elements(:xpath, "//*[@text = 'Most Popular']//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout//android.view.ViewGroup/android.widget.ImageView")
  end

  def scroll_to_latest
    start_x = driver.window_size.width - 930
    start_y = driver.window_size.height - 400
    end_x = start_x
    end_y = start_y - 1490
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: start_y, end_x: end_x, end_y: end_y, duration: 200).perform
  end

  def self.scroll_to_second_carousel
    alias_method :scroll_to_most_popular, :scroll_to_latest
  end
  scroll_to_second_carousel

  def latest_video_card
    driver.find_elements(:xpath, "//*[@text = 'Latest']//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout//android.view.ViewGroup/android.widget.ImageView")
  end

  def scroll_horizontal_by_carousel
    start_x = driver.window_size.width * 0.90
    y = driver.window_size.height / 2
    end_x = driver.window_size.width / 2
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  end

  def scroll_down
    size = $driver.driver.manage.window.size
    width = size.width / 2
    starty = size.height * 0.8
    finishy = size.height * 0.20
    Appium::TouchAction.new.swipe(startx: width, starty: starty, end_x: width, end_y: finishy).perform
  end

  def collect_video_titles
    @uidata1 = []
    size = most_popular_video_title.size
    size.times do |j|
      before_scroll_video_text = most_popular_video_title[j].text
      @uidata1 << before_scroll_video_text
    end
    @uidata1
  end

  def whats_on_video_card
    driver.find_elements(:xpath, "//*[contains(@text, 'What')]//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout//android.view.ViewGroup/android.widget.ImageView")
  end

  def most_popular_home_video_card
    driver.find_elements(:xpath, "//*[contains(@text, 'Most Popular')]//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout//android.view.ViewGroup/android.widget.ImageView")
  end

  def latest_premium_video_card
    driver.find_elements(:xpath, "//*[contains(@text, 'Latest - Premium')]//following::androidx.recyclerview.widget.RecyclerView[1]//
    android.widget.FrameLayout//android.view.ViewGroup/android.widget.ImageView")
  end
end
