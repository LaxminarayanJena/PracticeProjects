class HelpScreen < BaseScreen
  # def screen_texts
  #   [main_title, screen_sub_titles]
  # end

  def screen_sub_titles
    driver.find_element(:xpath, "//*[@text = \"GENERAL QUESTIONS\"]")
  end

  def main_title
    driver.find_element(:xpath, "//*[@text = \"#{NETWORK_DATA.help_main_title}\"]")
  end
end
