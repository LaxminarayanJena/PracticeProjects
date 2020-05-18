class LoginScreen < BaseScreen
  def email_field
    driver.find_element(:id, "email")
  end

  def password_field
    driver.find_element(:id, "password")
  end

  def sign_in_button
    driver.find_element(:xpath, "//*[@text = 'Sign In to Discovery Go']")
  end

  def cancel_button
    driver.find_element(:id, "closeButton")
  end

  def error_msg
    driver.find_element(:xpath, "//*[@text = 'You entered an incorrect email address or password, please try again.']")
  end

  def maybe_later
    driver.find_element(:id, "maybe_later")
  end
end
