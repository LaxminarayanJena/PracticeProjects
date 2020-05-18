class OnlineClosedCaptioningScreen < BaseScreen
  # rubocop:disable Style/GlobalVars
  def screen_content
    $driver.scroll_to("To better assist us in addressing your question")
  end
  # rubocop:enable Style/GlobalVars
end
