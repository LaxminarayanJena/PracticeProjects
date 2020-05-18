class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def menu_featured
    driver.find_element(:name, "Featured")
  end

  def menu_shows
    driver.find_element(:xpath, "//XCUIElementTypeButton[@name='Shows']")
  end

  def menu_browse
    driver.find_element(:name, "Browse")
  end

  def menu_search
    driver.find_element(:name, "Search")
  end

  def menu_search_box
    driver.find_element(:id, "search_editor")
  end

  def press_up
    driver.execute_script "mobile: pressButton", name: "up"
  end

  def press_down
    driver.execute_script "mobile: pressButton", name: "down"
  end

  def press_left
    driver.execute_script "mobile: pressButton", name: "left"
  end

  def press_right
    driver.execute_script "mobile: pressButton", name: "right"
  end

  def press_menu
    driver.execute_script "mobile: pressButton", name: "menu"
  end

  def press_media_play_pause
    driver.execute_script "mobile: pressButton", name: "playpause"
  end

  def press_select
    driver.execute_script "mobile: pressButton", name: "select"
  end

  def driver
    $driver
  end

  def menu_settings
    driver.find_element(:id, "Settings")
  end

  def menu_favorite_shows
    driver.find_element(:id, "Favorite Shows")
  end

  def verify_landing_screen
    wait_until(30) { menu_featured.displayed? }
  end
end
