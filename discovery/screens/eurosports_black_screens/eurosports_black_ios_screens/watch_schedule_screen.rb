class EuroWatchScheduleScreen < BaseScreen
  def calendar
    driver.find_element(:id, "schedule_background")
  end

  def today_label
    driver.find_element(:id, "TODAY")
  end

  def show_earlier_today
    driver.find_element(:id, "SHOW EARLIER TODAY")
  end

  def hide_earlier_today
    driver.find_element(:id, "HIDE EARLIER TODAY")
  end

  def scroll_left_from_today_label
    start_x = wait_until(30) { today_label.location.x }
    y = wait_until(30) { today_label.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x, end_y: y, duration: 200).perform.release
  end

  def scroll_right_from_today_label
    start_x = wait_until(30) { today_label.location.x }
    y = wait_until(30) { today_label.location.y }
    end_x = 1
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  end
end
