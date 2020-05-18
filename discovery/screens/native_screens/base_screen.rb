require "rspec/expectations"

class BaseScreen
  include RSpec::Matchers
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end

  def tap_by_coordinates(x_coordinate, y_coordinate)
    Appium::TouchAction.new.tap(x: x_coordinate, y: y_coordinate, count: 1).perform
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

  def get_card_info(card_locator)
    card = {
      title: card_locator.find_element(:xpath, "//*[@content-desc = 'video-title' or @name = 'video-title' ]"),
      metadata: card_locator.find_element(:xpath, "//*[@content-desc = 'video-metadata' or @name= 'video-metadata']"),
      info_button: card_locator.find_element(:xpath, "//*[@content-desc='button-info' or @name='button-info']")
    }
    card
  end

  def affilate_logo
    driver.find_element(:xpath, "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")
  end

  def sign_in_button
    driver.find_element(:xpath, "//*[@text = 'SIGN IN' or @label = 'SIGN IN' or @text = 'Sign in']")
  end

  def signout_button
    driver.find_element(:xpath, "//*[@text = 'SIGN OUT']")
  end

  def home_settings_icon
    driver.find_element(:xpath, "//android.view.ViewGroup[@content-desc='main-nav__home']/../../android.view.ViewGroup[3]")
  end

  def device_width
    driver.window_size.width
  end

  def device_height
    driver.window_size.height
  end

  def scroll_to_info_button_by_coordinates
    x_start = device_width - 500
    y_start = device_height - 500
    x_end = x_start - 0
    y_end = y_start - 100
    scroll_by_coordinates(x_start, y_start, x_end, y_end)
  end

  def scroll_by_coordinates(x_start, y_start, x_end, y_end)
    Appium::TouchAction.new.swipe(start_x: x_start, start_y: y_start, end_x: x_end, end_y: y_end).perform
  end
end
