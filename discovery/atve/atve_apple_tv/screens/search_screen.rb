# frozen_string_literal: true

class SearchScreen < BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def navigate_to_search
    press_menu
    3.times { press_down }
    wait_until(30) { menu_search.displayed? }
  end

  def shows_label
    driver.find_element(:xpath, "(//XCUIElementTypeButton[@name='Shows'])[1]")
  end

  def search_box
    driver.find_element(:xpath, "//*[contains(@name, 'TVE')]//following:: XCUIElementTypeOther/XCUIElementTypeTextField")
  end

  def inside_search_box
    driver.find_element(:xpath, "//XCUIElementTypeTextView")
  end

  def search_button
    driver.find_element(:name, "done")
  end

  def search_mock_text
    driver.find_element(:xpath, "//XCUIElementTypeTextField")
  end

  def search_show_send_keys(string)
    inside_search_box.send_keys(string)
  end

  def search_results
    driver.find_elements(:xpath, " //*[contains(@name, 'Results')]//following::XCUIElementTypeCell")
  end

  def search_results_title
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText")
  end

  def search_no_results_msg
    driver.find_element(:name, "No results found")
  end
end
