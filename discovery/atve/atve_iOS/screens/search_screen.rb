class SearchScreen < BaseScreen
  def search_field
    driver.find_element(:xpath, "//XCUIElementTypeTextField")
  end

  def no_results_text
    driver.find_element(:name, "No results found")
  end

  def clear_text
    driver.find_element(:name, "Clear text")
  end

  def popularshowlist
    driver.find_elements(:xpath, "//XCUIElementTypeCell//XCUIElementTypeOther//XCUIElementTypeImage")
  end

  def trending_now_rail
    driver.find_element(:name, "Trending Now ")
  end

  def search_screen_carousels(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling:: XCUIElementTypeCell")
  end

  def search_screen_carousel_elements(caurosel)
    driver.find_elements(:xpath, "//*[@name='#{caurosel}']/..//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText")
  end
end
