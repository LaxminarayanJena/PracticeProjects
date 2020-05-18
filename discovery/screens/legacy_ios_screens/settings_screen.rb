class SettingsScreen < BaseScreen
  def sign_out_button
    driver.find_element(:name, "SIGN OUT")
  end

  def close_button
    driver.find_element(:name, "close button")
  end

  def sign_in_button
    driver.find_element(:name, "SIGN IN")
  end
end
