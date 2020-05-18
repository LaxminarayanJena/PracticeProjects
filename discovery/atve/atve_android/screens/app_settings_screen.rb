class SettingScreen < BaseScreen
  def about_option
    driver.find_element(:xpath, "//*[@text='About']")
  end

  def help_option
    driver.find_element(:xpath, "//*[@text='Help']")
  end

  def app_info_option
    driver.find_element(:xpath, "//*[@text='App Information']")
  end

  def terms_of_use_option
    driver.find_element(:xpath, "//*[@text='Terms of Use']")
  end

  def nielsen_measurement_option
    driver.find_element(:xpath, "//*[@text='Nielsen Measurement']")
  end

  def privacy_policy_option
    driver.find_element(:xpath, "//*[@text='Privacy Policy']")
  end

  def do_not_sell_option
    driver.find_element(:xpath, "//*[@text='California Do Not Sell My Info']")
  end

  def online_captioning_option
    driver.find_element(:xpath, "//*[@text='Online Closed Captioning']")
  end

  def captioning_header_text
    driver.find_element(:xpath, "//*[@text='Discovery, Inc.']")
  end

  def error_message
    driver.find_element(:id, "errorMessage")
  end

  def login_button
    driver.find_element(:xpath, "//*[@text='LOGIN']")
  end

  def logout_button
    driver.find_element(:xpath, "//*[@text='LOGOUT']")
  end

  def help_web_view
    driver.find_element(:xpath, "//*[@text='Discovery Communications Help Center home page']")
  end

  def my_list_option
    driver.find_element(:xpath, "//*[@text='My List']")
  end

  def push_notification_option
    driver.find_element(:xpath, "//*[@text='Push Notifications']")
  end
end
