class TermsAndCinditionsScreen < BaseScreen
  # rubocop:disable Style/GlobalVars
  def screen_content
    $driver.scroll_to("Welcome to Discovery.com, one of the family of informational, educational and")
  end

  def visitor_agreement
    driver.find_element(:xpath, '//*[@text = "Visitor Agreement – Discovery, Inc."]')
  end
  # rubocop:enable Style/GlobalVars
end
