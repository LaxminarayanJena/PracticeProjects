class HomeScreen < BaseScreen
  def home_hero
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def series_name
    driver.find_element(:xpath, "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1]")
  end

  def series_description
    driver.find_element(:xpath, "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[2]")
  end

  def live
    driver.find_element(:name, "Live")
  end

  def home_screen_carousels(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling:: XCUIElementTypeCell")
  end

  def watch_now_start_series_button
    driver.find_elements(:xpath, "//XCUIElementTypeOther/XCUIElementTypeButton")
  end

  def tlc_logo
    driver.find_element(:name, "tlc network logo")
  end

  def justadded_tiles
    driver.find_elements(:xpath, "//XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell")
  end

  def home_screen_carousel_elements(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText")
  end

  def homescreen_carousel_horizontal_forward_scroll(caurosel, scroll_steps)
    element = driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText")
    horizontal_forward_scroll(element[2], scroll_steps)
  end

  def homescreen_carousel_horizontal_backward_scroll(caurosel, scroll_steps)
    element = driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText")
    horizontal_backward_scroll(element[0], scroll_steps)
  end
end
