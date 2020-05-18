Given(/^I am on a settings screen$/) do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(60) { @settings_screen.menu_settings.displayed? }
  @settings_screen.navigate_to_settings
end

Then(/^I see all the settings screen options$/) do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(30) { @settings_screen.signin_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.contact_us_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.privacypolicy_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.termsofservice_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.faq_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.version_settings.displayed? }
end

When("I select {string} option") do |setting_option|
  @settings_screen = SettingsScreen.new
  if setting_option == "Sign In"
    @settings_screen.press_down
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.signin_settings.displayed? }
  elsif setting_option == "Contact Us"
    2.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.contact_us_settings.displayed? }
  elsif setting_option == "Privacy Policy"
    3.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.privacypolicy_settings.displayed? }
  elsif setting_option == "California Do Not Sell My Info"
    4.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.californiadonotsellmyinfo_settings.displayed? }
  elsif setting_option == "Terms of Service"
    5.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.termsofservice_settings.displayed? }
  elsif setting_option == "Frequently Asked Questions"
    6.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.faq_settings.displayed? }
  elsif setting_option == "Nielsen Measurement"
    7.times { @settings_screen.press_down }
    @settings_screen.press_select
    @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_settings.displayed? }
  end
end

Then("I see details of {string} option") do |setting_option|
  @settings_screen = SettingsScreen.new
  if setting_option == "Contact Us"
    @settings_screen.wait_until(30) { @settings_screen.contact_us_details.displayed? }
  elsif setting_option == "Privacy Policy"
    @settings_screen.wait_until(30) { @settings_screen.privacypolicy_details.displayed? }
  elsif setting_option == "California Do Not Sell My Info"
    @settings_screen.wait_until(30) { @settings_screen.californiadonotsellmyinfo_details.displayed? }
  elsif setting_option == "Terms of Service"
    @settings_screen.wait_until(30) { @settings_screen.termsofservice_details.displayed? }
  elsif setting_option == "Frequently Asked Questions"
    @settings_screen.wait_until(30) { @settings_screen.faq_details.displayed? }
  elsif setting_option == "Nielsen Measurement"
    @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_details.displayed? }
  end
end

Then("I see Sign Out option and click on it") do
  step "I am on a settings screen"
  @settings_screen = SettingsScreen.new
  @settings_screen.press_down
  @settings_screen.wait_until(30) { @settings_screen.signout_settings.displayed? }
  @settings_screen.press_select
  @settings_screen.wait_until(30) { @settings_screen.signin_settings.displayed? }
end
