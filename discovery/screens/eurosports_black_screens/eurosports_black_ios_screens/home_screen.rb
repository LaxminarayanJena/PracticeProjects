class EuroHomeScreen < BaseScreen
  def latest_option
    driver.find_element(:id, "Latest")
  end

  def home_screen_latest_option
    driver.find_element(:id, "Latest")
  end

  def home_screen_edit_option
    driver.find_element(:id, "Edit")
  end

  def watch_screen_option
    driver.find_element(:id, "Watch")
  end

  def result_screen_option
    driver.find_element(:id, "Result")
  end

  def sports_screen_option
    driver.find_element(:id, "Sports")
  end
end
