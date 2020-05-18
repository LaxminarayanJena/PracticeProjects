# frozen_string_literal: true

class WelcomeScreen < BaseScreen
  def maybe_later_button
    driver.find_element(:name, "Maybe Later")
  end

  def link_provider_button
    driver.find_element(:name, "Link TV Provider")
  end

  def link_tv_provider_msg
    driver.find_element(:name, "Link your TV Provider to unlock thousands of episodes from the networks of Discovery.")
  end

  def nw_availability_label
    driver.find_element(:name, "Network availability may vary with your TV package.")
  end

  def welcome_tlc_logo
    driver.find_elements(:xpath, "//*[@name='TVE']//..//following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage[1]")
  end

  def splash_logo
    driver.find_elements(:xpath, "//XCUIElementTypeImage[@name='tlc-splash-logo']")
  end

  def screen_loading_spinner
    driver.find_element(:name, "LunaUI-loadingSpinner")
  end

  def try_again_btn
    driver.find_element(:name, "Try Again")
  end

  def error_loading_text
    driver.find_element(:name, "//XCUIElementTypeStaticText[@name='Error loading, please try again.']")
  end
end
