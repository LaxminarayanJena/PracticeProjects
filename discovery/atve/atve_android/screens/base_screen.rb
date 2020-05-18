class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end

  def search_icon
    driver.find_element(:id, "Search")
  end

  def home_icon
    driver.find_element(:id, "Home")
  end

  def live_icon
    driver.find_element(:accessibility_id, "On Now")
  end

  def account_icon
    driver.find_element(:id, "Account")
  end

  def shows_icon
    driver.find_element(:id, "Shows")
  end

  def shows_screen_title
    driver.find_element(:xpath, "//*[@text = \"Shows\"]")
  end

  def live_screen_title
    driver.find_element(:xpath, "//*[@text = 'On Now']")
  end

  def settings_title
    driver.find_element(:id, "largeLabel")
  end

  def scroll_by_coordinates(x_start, y_start, x_end, y_end)
    Appium::TouchAction.new.swipe(start_x: x_start, start_y: y_start, end_x: x_end, end_y: y_end).perform
  end

  def scroll_to_bottom
    size = driver.manage.window.size
    width = size.width / 2
    start_y = size.height * 0.8
    finish_y = 1
    Appium::TouchAction.new.swipe(startx: width, starty: start_y, end_x: width, end_y: finish_y).perform
  end
end
