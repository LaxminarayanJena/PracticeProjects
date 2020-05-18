# frozen_string_literal: true

class LoginScreen < BaseScreen
  def navigate_to_signin
    press_up
    press_right while menu_signin.attribute("focused") == "false"
  end

  def visit_activate_url
    driver.find_element(:id, "visit_url_text")
  end

  def activate_code
    driver.find_element(:id, "code_text")
  end

  def provider_image
    driver.find_element(:id, "provider_image")
  end
end
