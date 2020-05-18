class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def menu_home
    driver.find_elements(:xpath, "//XCUIElementTypeStaticText[@name='Home']")
  end

  def menu_shows
    driver.find_element(:name, "Shows")
  end

  def menu_live
    driver.find_element(:name, "Live")
  end

  def menu_search
    driver.find_element(:name, "Search")
  end

  def menu_account
    driver.find_element(:name, "Account")
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

  def menu_options_focus(option)
    driver.find_element(:xpath, "//*[@name='#{option}']/../../..")
  end

  def carousels(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/../following-sibling:: XCUIElementTypeCell[1]//XCUIElementTypeCell")
  end

  def carousels_showname_list(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/../following-sibling:: XCUIElementTypeCell[1]//XCUIElementTypeStaticText")
  end

  def carousels_showimage_list(caurosel)
    carousel_header = driver.find_element(:xpath, "//*[@name='#{caurosel}']/../following-sibling:: XCUIElementTypeCell[1]")
    carousel_header.find_elements(:xpath, "//XCUIElementTypeStaticText/../XCUIElementTypeOther/XCUIElementTypeImage")
  end

  def carousels_networklogo_list(caurosel)
    carousel_header = driver.find_element(:xpath, "//*[@name='#{caurosel}']/../following-sibling:: XCUIElementTypeCell[1]")
    carousel_header.find_elements(:xpath, "//XCUIElementTypeStaticText/../XCUIElementTypeImage")
  end

  def network_logo
    driver.find_element(:xpath, "//*[@name='tlc network logo']")
  end

  def driver
    $driver
  end
end
