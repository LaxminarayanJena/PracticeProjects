class AppSettingsScreen < BaseScreen
  def settings_container
    driver.find_element(:name, "SETTINGS")
  end

  def about_option
    driver.find_element(:name, "About")
  end

  def help_option
    driver.find_element(:name, "Help / FAQ")
  end

  def privacy_policy_option
    driver.find_element(:name, "Privacy Policy")
  end

  def terms_and_conditions_opt
    driver.find_element(:name, "Terms & Conditions")
  end

  def online_closed_captioning_option
    driver.find_element(:name, "Online Closed Captioning")
  end

  def contact_details_option
    driver.find_element(:name, "Contact Us / Send Feedback")
  end

  def agreement_details_option
    driver.find_element(:name, "About Nielsen Measurement")
  end

  def about_option_text
    driver.find_element(:xpath, "//*[@type = 'XCUIElementTypeStaticText']")
  end

  def help_option_text
    driver.find_element(:xpath, "//*[@type = 'XCUIElementTypeStaticText']")
  end

  def online_closed_captioning_option_text
    driver.find_element(:name, "Online Closed Captioning – Discovery, Inc.")
  end

  def privacy_policy_option_text
    driver.find_element(:name, "DISCOVERY COMMUNICATIONS PRIVACY POLICY – Discovery, Inc.")
  end

  def terms_and_conditions_opt_text
    driver.find_element(:name, "Visitor Agreement – Discovery, Inc.")
  end

  def contact_details_option_text
    driver.find_element(:xpath, "//*[@type = 'XCUIElementTypeStaticText']")
  end

  def agreement_details_option_text
    driver.find_element(:name, "About Nielsen Measurement")
  end
end
