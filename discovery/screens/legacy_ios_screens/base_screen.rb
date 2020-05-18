class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end

  def hamburger_icon
    driver.find_element(:name, "ios hamburger menu icon")
  end

  # Hamburger menu locators
  def self.add_back_icon
    alias_method :back_icon, :hamburger_icon
  end
  add_back_icon

  def hamburger_home_icon
    driver.find_element(:name, "Home")
  end

  def hamburger_watch_later_menu
    driver.find_element(:name, "Watch Later")
  end

  def hamburger_watch_live
    driver.find_element(:name, "Watch Live")
  end

  def hamburger_shows_menu
    driver.find_element(:name, "Shows")
  end

  def search_show_icon
    driver.find_element(:name, "search icon")
  end

  def hamburger_sign_in_menu
    driver.find_element(:name, "SIGN IN")
  end

  def hamburger_settings_menu
    driver.find_element(:name, "Settings")
  end

  def tap_by_coordinates(x_coordinate, y_coordinate)
    Appium::TouchAction.new.tap(x: x_coordinate, y: y_coordinate, count: 1).perform
  end

  def hamburger_favorite_show_menu
    driver.find_element(:name, "Favorite Shows")
  end

  def top_back_button
    driver.find_element(:name, "back button")
  end

  def top_close_button
    driver.find_element(:name, "close button")
  end

  def search_show(string)
    search_show_icon.click
    wait_until(30) { search_input.displayed? }
    search_input.send_keys(string)
    wait_until(30) { search_result_icon.displayed? }
    search_result_icon.click
  end

  def search_input
    driver.find_element(:xpath, "//XCUIElementTypeTextField")
  end

  def search_result_icon
    driver.find_element(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
  end

  def on_last_night_header_desc
    driver.find_element(:name, "ON LAST NIGHT")
  end

  def hamburger_continue_watching_menu
    driver.find_element(:name, "Continue Watching")
  end

  def hamburger_home
    driver.find_element(:name, "Home")
  end

  def hamburger_app_settings
    driver.find_element(:name, "Settings")
  end

  def hamburger_browse
    driver.find_element(:name, "Browse")
  end

  def ad_learn_more_link
    driver.find_element(:name, "Learn More")
  end

  def find_sibling_element(filtered_parent_element, child_classname)
    filtered_parent_element.find_element(:xpath, "//#{child_classname}")
  end

  def switch_context_to_web
    wait_until(30) { driver.available_contexts.count >= 2 }
    available_contexts = driver.available_contexts
    app_package_without_com = ENV["APP_PACKAGE"].split(".", 2)[1]
    driver.set_context("WEBVIEW_com." + app_package_without_com) if available_contexts.include? "WEBVIEW_com." + app_package_without_com
  end

  def switch_to_web
    wait_until(30) { driver.available_contexts.count >= 2 }
    app_package_without_com = ENV["APP_PACKAGE"].split(".", 2)[1]
    expect(driver.available_contexts.include?("WEBVIEW_com." + app_package_without_com)).to be true
  end

  def switch_context_to_native
    driver.set_context("NATIVE_APP")
  end
end
