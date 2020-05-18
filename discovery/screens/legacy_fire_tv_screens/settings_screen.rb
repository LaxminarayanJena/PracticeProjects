# frozen_string_literal: true

class SettingsScreen < BaseScreen
  def signin_settings
    driver.find_element(:xpath, "//*[@text = 'Sign In']")
  end

  def contact_us_settings
    driver.find_element(:xpath, "//*[@text = 'Contact Us']")
  end

  def privacypolicy_settings
    driver.find_element(:xpath, "//*[@text = 'Privacy Policy']")
  end

  def termsofservice_settings
    driver.find_element(:xpath, "//*[@text = 'Terms of Service']")
  end

  def faq_settings
    driver.find_element(:xpath, "//*[@text = 'Frequently Asked Questions']")
  end

  def nielsenmeasurement_settings
    driver.find_element(:xpath, "//*[@text = 'Nielsen Measurement']")
  end

  def version_settings
    driver.find_element(:xpath, "//*[contains(@text, 'Version')]")
  end

  def contact_us_details
    driver.find_element(:xpath, "//*[contains(@text, 'Go to Discovery.custhelp.com')]")
  end

  def privacypolicy_details
    driver.find_element(:xpath, "//*[contains(@text, 'please visit https://corporate.discovery.com/privacy-policy/')]")
  end

  def termsofservice_details
    driver.find_element(:xpath, "//*[contains(@text, 'please visit https://corporate.discovery.com/visitor-agreement/')]")
  end

  def faq_details
    driver.find_element(:xpath, "//*[contains(@text, 'https://discovery.custhelp.com/app/go/home')]")
  end

  def nielsenmeasurement_details
    driver.find_element(:xpath, "//*[contains(@text, 'ABOUT NIELSEN MEASUREMENT')]")
  end

  def signout_settings
    driver.find_element(:xpath, "//*[@text = 'Sign Out']")
  end

  def navigate_to_settings
    press_up
    press_right while menu_settings.attribute("focused") == "false"
  end

  def californiadonotsellmyinfo_settings
    driver.find_element(:xpath, "//*[@text = 'California Do Not Sell My Info']")
  end

  def californiadonotsellmyinfo_details
    driver.find_element(:xpath, "//*[contains(@text, 'https://corporate.discovery.com/california_dns/')]")
  end
end
