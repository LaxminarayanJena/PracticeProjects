class EuroLandingScreen < BaseScreen
  def latest_option
    driver.find_element(:id, "Latest")
  end

  def account_option
    driver.find_element(:id, "action_account")
  end
end
