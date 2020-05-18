class AccountScreen < BaseScreen
  def mylist
    driver.find_element(:name, "MyList")
  end

  def app_information
    driver.find_element(:name, "App Information")
  end

  def help
    driver.find_element(:name, "Help")
  end

  def about
    driver.find_element(:name, "About")
  end

  def push_notifications
    driver.find_element(:name, "Push Notifications")
  end

  def debug_settings
    driver.find_element(:name, "Debug Settings")
  end
end
