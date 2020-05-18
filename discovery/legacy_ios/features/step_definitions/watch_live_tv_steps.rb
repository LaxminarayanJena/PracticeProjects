# frozen_string_literal: true

Given(/^I go to main menu$/) do
  @screen = WatchLiveTvScreen.new
  @screen.hamburger_icon.click
end

And(/^I click on watch live tv$/) do
  @screen = WatchLiveTvScreen.new
  @screen.wait_until(30) { @screen.hamburger_watch_live.displayed? }
  @screen.hamburger_watch_live.click
end

Then(/^I should see sign in to unlock all shows$/) do
  @screen = WatchLiveTvScreen.new
  # Metrics/LineLength

  # Check if alert is shown and dismiss if so
  # Expect sign in page to be true
  begin
    # rubocop:disable Style/GlobalVars
    $driver.alert_dismiss
  # rubocop:enable Style/GlobalVars
  rescue Selenium::WebDriver::Error::NoSuchAlertError => e
    puts e
  end
  expect(@screen.sign_into_unlock.displayed?).to be true
end
