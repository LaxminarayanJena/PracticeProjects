class ContactUsScreen < BaseScreen
  # rubocop:disable Style/GlobalVars
  def screen_content
    $driver.scroll_to("SIGN UP FOR THE DISCOVERY NEWSLETTER")
  end

  def feedback_form
    $driver.scroll_to("CLOSE")
  end
  # rubocop:enable Style/GlobalVars

  def email_address_textarea
    driver.find_element(:xpath, "//*[@text = \"Email Address\"]")
  end
end
