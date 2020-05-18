class ShowListScreen < BaseScreen
  def a_z_button
    driver.find_element(:name, "A-Z")
  end

  def most_recent_button
    driver.find_element(:name, "MOST RECENT")
  end

  def alphabet_selector(letter)
    driver.find_element(:name, letter)
  end

  def last_list_item
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeCell").last
  end

  def show_title_details_screen
    driver.find_element(:xpath, "//*//XCUIElementTypeImage//following-sibling::XCUIElementTypeStaticText")
  end

  def no_results_text
    driver.find_element(:name, "No Results Found")
  end
end
