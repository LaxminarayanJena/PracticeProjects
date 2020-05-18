class SigninScreen < BaseScreen
  def tv_title
    driver.find_element(:id, "tv_title")
  end

  def tv_sub_title
    driver.find_element(:id, "tv_sub_title")
  end

  def tv_url
    driver.find_element(:id, "tv_url")
  end

  def tv_activation_code
    driver.find_element(:id, "tv_activation_code")
  end

  def layout_activation_code
    driver.find_element(:id, "layout_activation_code")
  end
end
