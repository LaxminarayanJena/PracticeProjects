class AboutScreen < BaseScreen
  def screen_content
    driver.find_element(:xpath, "//*[contains(@text, 'Discovery, Inc. (Nasdaq: DISCA, DISCB, DISCK) is a global leader')]")
  end
end
