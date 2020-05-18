# frozen_string_literal: true

#:nodoc: all
class WatchLiveTvScreen < BaseScreen
  def main_menu_hamburger
    driver.find_element(:accessibility_id, "Navigate up")
  end

  def sign_into_unlock
    driver.find_element(:name, "SIGN IN TO UNLOCK ALL SHOWS")
  end

  def logged_in_label
    driver.find_element(:name, "You are signed in with")
  end

  def tv_provider_alert
    driver.find_element(:name, "Tap Allow to watch full episodes. Included FREE with your TV subscription!")
  end

  def tv_provider_alert_allow
    driver.find_element(:xpath, "//*[@name = 'Don't Allow']//XCUIElementTypeButton")
  end
end
