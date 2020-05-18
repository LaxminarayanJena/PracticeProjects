class SearchScreen < BaseScreen
  def search_field
    driver.find_element(:xpath, "//XCUIElementTypeTextField")
  end

  def close_btn
    driver.find_element(:name, "close button")
  end

  def search_result(show_name)
    driver.find_elements(:xpath, "//*[contains(@name, '#{show_name}')]")
  end

  def search_close_button
    driver.find_element(:name, "search clear button")
  end

  def search_results
    driver.find_element(:xpath, "//XCUIElementTypeCollectionView")
  end

  def search_text
    driver.find_element(:xpath, "//XCUIElementTypeStaticText")
  end
end
