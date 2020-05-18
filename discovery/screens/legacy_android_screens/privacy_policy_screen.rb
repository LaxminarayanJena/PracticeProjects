class PrivacyPolicyScreen < BaseScreen
  def title
    driver.find_element(:xpath, "//*[@text = \"DISCOVERY COMMUNICATIONS PRIVACY POLICY\"]")
  end

  # rubocop:disable Style/GlobalVars
  def any_subtitle_text
    $driver.scroll_to("Information Collected")
  end

  def title_text
    $driver.scroll_to("DISCOVERY COMMUNICATIONS PRIVACY POLICY")
  end
  # rubocop:enable Style/GlobalVars
end
