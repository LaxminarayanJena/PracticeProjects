# frozen_string_literal: true

class SettingsScreen < BaseScreen
  def activate_settings
    driver.find_element(:id, "Activate")
  end

  def contact_us_settings
    driver.find_element(:id, "Contact")
  end

  def privacypolicy_settings
    driver.find_element(:id, "Privacy")
  end

  def terms_and_conditions_settings
    driver.find_element(:id, "Terms and Conditions")
  end

  def faq_settings
    driver.find_element(:id, "FAQ")
  end

  def about_settings
    driver.find_element(:id, "About")
  end

  def nielsenmeasurement_settings
    driver.find_element(:xpath, "//*[contains(@name, 'Nielsen Measurement')]")
  end

  def version_settings
    driver.find_element(:xpath, "//*[contains(@name, 'Version')]")
  end

  def contact_us_details
    driver.find_element(:xpath, "//*[contains(@name, 'Go to https://foodnetwork.custhelp.com')]")
  end

  def privacypolicy_details
    driver.find_element(:xpath, "//*[contains(@name, 'please visit https://corporate.discovery.com/privacy-policy/')]")
  end

  def terms_and_conditions_details
    driver.find_element(:xpath, "//*[contains(@name, 'please visit https://corporate.discovery.com/visitor-agreement/')]")
  end

  def faq_details
    driver.find_element(:xpath, "//*[contains(@name, 'https://foodnetwork.custhelp.com/app/go/home')]")
  end

  def nielsenmeasurement_details
    driver.find_element(:xpath, "//*[contains(@name, 'ABOUT NIELSEN MEASUREMENT')]")
  end

  def about_details
    driver.find_element(:xpath, "//*[contains(@name, 'global leader in real life entertainment')]")
  end

  def signout_settings
    driver.find_element(:id, "Sign Out")
  end

  def nielsenmeasurement_toggle(text)
    driver.find_element(:xpath, "//XCUIElementTypeCell[@name='Nielsen Measurement, #{text}']")
  end

  def nielsenmeasurement_disable_enable(text)
    driver.find_element(:xpath, "//XCUIElementTypeButton[@name='#{text} Nielsen Measurement']")
  end

  def navigate_to_settings
    press_up
    press_right while menu_settings.attribute("focused") == "false"
  end
end
