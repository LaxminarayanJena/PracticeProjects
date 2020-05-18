# frozen_string_literal: true

class SearchScreen < BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def navigate_to_search
    while menu_search.attribute("focused") == "false"
      press_right
      # rubocop:disable Custom/SleepCop.
      sleep(2)
      # rubocop:enable Custom/SleepCop.
    end
    wait_until(2) { menu_search.displayed? }
  end

  def search_box
    driver.find_element(:xpath, "//XCUIElementTypeSearchField")
  end

  def search_show_send_keys(string)
    search_box.send_keys(string)
  end

  def search_results
    driver.find_elements(:xpath, " //*[contains(@name, 'Results')]//following::XCUIElementTypeCell")
  end

  def search_results_title
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText")
  end

  def search_no_results_msg
    driver.find_element(:xpath, "//XCUIElementTypeStaticText[@name='No results found.']")
  end
end
