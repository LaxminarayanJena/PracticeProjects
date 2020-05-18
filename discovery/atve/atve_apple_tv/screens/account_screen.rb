# frozen_string_literal: true

class AccountScreen < BaseScreen
  def navigate_to_account
    press_menu
    4.times { press_down }
    wait_until(30) { menu_account.displayed? }
  end

  def california_do_not_sell_settings
    driver.find_element(:name, "California Do Not Sell My Info")
  end

  def app_information_settings
    driver.find_element(:name, "App Information")
  end

  def about_settings
    driver.find_element(:name, "About")
  end

  def help_settings
    driver.find_element(:name, "Help")
  end

  def terms_and_conditions_settings
    driver.find_element(:name, "Terms of Use")
  end

  def privacy_policy_settings
    driver.find_element(:name, "Privacy Policy")
  end

  def nielsen_measurement_settings
    driver.find_element(:name, "Nielsen Measurement")
  end

  def online_closed_caption_settings
    driver.find_element(:name, "Online Closed Captioning")
  end

  def version_number
    driver.find_element(:name, "Version Number")
  end

  def os_number
    driver.find_element(:name, "OS Version")
  end

  def device_model
    driver.find_element(:name, "Device Model")
  end

  def build_number
    driver.find_element(:name, "Build Number")
  end

  def my_list
    driver.find_element(:name, "My List")
  end
end
