class AboutAgreementScreen < BaseScreen
  def screen_texts
    [screen_sub_title, screen_content]
  end

  def screen_sub_title
    driver.find_element(:xpath, "//*[@text = \"ABOUT NIELSEN MEASUREMENT\"]")
  end

  def screen_content
    driver.find_element(:xpath, "//*[contains(@text, 'Television and the way we watch it have come a long way since Nielsen')]")
  end
end
