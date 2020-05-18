class AppSettingsScreen < BaseScreen
  def settings_container
    driver.find_element(:id, "container_settings")
  end

  def about_option
    driver.find_element(:xpath, "//*[@text = \"About\"]")
  end

  def help_option
    driver.find_element(:xpath, "//*[@text = \"Help / FAQ\"]")
  end

  def privacy_policy_option
    driver.find_element(:xpath, "//*[@text = \"Privacy Policy\"]")
  end

  def terms_and_conditions_opt
    driver.find_element(:xpath, '//*[@text = "Terms & Conditions"]')
  end

  def online_closed_captioning_option
    driver.find_element(:xpath, '//*[@text = "Online Closed Captioning"]')
  end

  def contact_us
    driver.find_element(:xpath, '//*[@text = "Contact Us / Send Feedback"]')
  end

  def neilsen_option
    driver.find_element(:xpath, '//*[@text = "About Nielsen Measurement"]')
  end

  def version_details
    driver.find_element(:xpath, "//*[contains(@text, 'Version Name')]")
  end
end
