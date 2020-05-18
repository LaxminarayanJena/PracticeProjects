# frozen_string_literal: true

require_relative "modules/setting_option_module"

class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end
  include SettingOptionModule

  def search_providers
    driver.find_element(:id, "MVPDEditText")
  end

  def search_show(string)
    search_show_icon.click
    wait_until(30) { search_show_text_input.displayed? }
    search_show_text_input.send_keys(string)
    wait_until(30) { search_result_icon.displayed? }
    search_result_icon.click
  end

  # Search Stuff
  def search_show_icon
    # driver.find_element(:id, 'action_search')
    driver.find_element(:accessibility_id, "Search")
  end

  def search_show_text_input
    driver.find_element(:id, "search_src_text")
  end

  def search_result_icon
    driver.find_element(:id, "img_show_thumbnail")
  end

  # Hamburger menu locators
  def hamburger_icon
    driver.find_element(:accessibility_id, "Navigate up")
  end

  def get_seeking_seconds(percentage, total_duration)
    percentage.to_f * total_duration.to_f / 100.0
  end

  def tap_by_coordinates(x_coordinate, y_coordinate)
    Appium::TouchAction.new.tap(x: x_coordinate, y: y_coordinate, count: 1).perform
  end

  def self.add_back_icon
    alias_method :back_icon, :hamburger_icon
  end
  add_back_icon

  def hamburger_watch_later_menu
    driver.find_element(:xpath, "//*[@text = 'Watch Later']")
  end

  def hamburger_shows_menu
    driver.find_element(:xpath, "//*[@text = 'Shows']")
  end

  def hamburger_favorite_show
    driver.find_element(:xpath, "//*[@text = 'Favorite Shows']")
  end

  def hamburger_app_settings
    driver.find_element(:xpath, "//*[@text = 'Settings']")
  end

  def hamburger_watch_live
    driver.find_element(:xpath, "//*[@text = 'Watch Live TV']")
  end

  def app_alert
    driver.find_element(:id, "com_appboy_inappmessage_slideup")
  end

  def on_last_night_header_desc
    driver.find_element(:xpath, "//*[@text = 'ON LAST NIGHT']")
  end

  def scroll_to_bottom
    size = $driver.driver.manage.window.size
    width = size.width / 2
    starty = size.height * 0.8
    # finishy = size.height * 0.2
    finishy = 1
    Appium::TouchAction.new.swipe(startx: width, starty: starty, end_x: width, end_y: finishy).perform
  end

  # we are using "edit_btn, edit_checkbox & show_empty_list" in watch later and favorite shows screens
  # we'll be able to reuse these locators in more than one place with common names
  def edit_btn
    driver.find_element(:id, "btn_edit")
  end

  def edit_checkbox
    driver.find_element(:id, "checkbox")
  end

  def show_empty_list
    driver.find_element(:id, "container_empty_videos")
  end

  def affiliate_img
    driver.find_element(:id, "img_affiliate")
  end

  def navigate_to_previous_screen
    driver.back
  end

  def sign_out_button
    driver.find_element(:xpath, "//*[@text = 'SIGN OUT']")
  end

  def hamburger_browse
    driver.find_element(:xpath, "//*[@text = 'Browse']")
  end

  def scroll_by_coordinates(x_start, y_start, x_end, y_end)
    Appium::TouchAction.new.swipe(start_x: x_start, start_y: y_start, end_x: x_end, end_y: y_end).perform
  end

  def hamburger_continue_watching
    driver.find_element(:xpath, "//*[@text = 'Continue Watching']")
  end

  def hamburger_home
    driver.find_element(:xpath, "//*[@text = 'Home']")
  end
end
