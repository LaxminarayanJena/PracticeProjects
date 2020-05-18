# frozen_string_literal: true

class SettingsScreen < BaseScreen
  def about_option
    driver.find_element(:xpath, "//*[@text = 'About' or @label = 'About']")
  end

  def help_option
    driver.find_element(:xpath, "//*[@text = 'Help / FAQ' or @label = 'Help / FAQ']")
  end

  def neilsen_option
    driver.find_element(:xpath, "//*[@text = 'Nielsen Measurements' or @label = 'Nielsen Measurements']")
  end

  def online_closed_captioning_option
    driver.find_element(:xpath, "//*[@text = 'Online Closed Captioning' or @label = 'Online Closed Captioning']")
  end

  def privacy_option
    driver.find_element(:xpath, "//*[@text = 'Privacy Policy' or @lable = 'Privacy Policy']")
  end

  def terms_option
    driver.find_element(:xpath, "//*[@text = 'Terms & Conditions' or @label = 'Terms & Conditions']")
  end

  def contact_option
    driver.find_element(:xpath, "//*[@text = 'Contact Us / Send Feedback' or @label = 'Contact Us / Send Feedback']")
  end

  def version_info_option
    driver.find_element(:xpath, "//*[contains(@text, 'Version') or contains(@label, 'Version')]")
  end

  def help_title_text
    driver.find_element(:xpath, "//*[@text = 'HELP / FAQ' or @label = 'HELP / FAQ']")
  end

  def nielsen_title_text
    driver.find_element(:xpath, "//*[@text = 'NIELSEN MEASUREMENTS' or @label = 'NIELSEN MEASUREMENTS']")
  end

  def online_title_text
    driver.find_element(:xpath, "//*[@text = 'ONLINE CLOSED CAPTIONING' or @label = 'ONLINE CLOSED CAPTIONING']")
  end

  def privacy_title_text
    driver.find_element(:xpath, "//*[@text = 'PRIVACY POLICY' or @label = 'PRIVACY POLICY']")
  end

  def terms_title_text
    driver.find_element(:xpath, "//*[@text = 'TERMS & CONDITIONS' or @label = 'TERMS & CONDITIONS']")
  end

  def contact_title_text
    driver.find_element(:xpath, "//*[@text = 'CONTACT US / SEND FEEDBACK' or @label = 'CONTACT US / SEND FEEDBACK']")
  end

  def version_info_title_text
    driver.find_element(:xpath, "//*[@text = 'Debug Settings' or @label = 'Debug Settings']")
  end

  def scroll_to_contact
    driver.scroll_to("Contact")
  end

  def scroll_to_version
    driver.scroll_to("Version")
  end

  def veriy_provider_text
    driver.find_element(:xpath, "//*[@text = 'Verify your TV provider to access even more videos']")
  end
end
