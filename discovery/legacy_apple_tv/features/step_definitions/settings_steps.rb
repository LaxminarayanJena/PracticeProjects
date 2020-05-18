Given(/^I am on a settings screen$/) do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(60) { @settings_screen.menu_settings.displayed? }
  @settings_screen.navigate_to_settings
end

Then(/^I see all the settings screen options$/) do
  @settings_screen = SettingsScreen.new
  @settings_screen.press_down
  @settings_screen.wait_until(30) { @settings_screen.contact_us_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.privacypolicy_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.about_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.terms_and_conditions_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.faq_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_settings.displayed? }
  @settings_screen.wait_until(30) { @settings_screen.version_settings.displayed? }
end

When("I select {string} option") do |setting_option|
  @settings_screen = SettingsScreen.new
  case setting_option
  when "About"
    @settings_screen.about_settings.click
    @settings_screen.wait_until(30) { @settings_screen.about_settings.displayed? }
  when "Contact"
    @settings_screen.contact_us_settings.click
    @settings_screen.wait_until(30) { @settings_screen.contact_us_settings.displayed? }
  when "Privacy"
    @settings_screen.privacypolicy_settings.click
    @settings_screen.wait_until(30) { @settings_screen.privacypolicy_settings.displayed? }
  when "Terms and Conditions"
    @settings_screen.terms_and_conditions_settings.click
    @settings_screen.wait_until(30) { @settings_screen.terms_and_conditions_settings.displayed? }
  when "FAQ"
    @settings_screen.faq_settings.click
    @settings_screen.wait_until(30) { @settings_screen.faq_settings.displayed? }
  when "Nielsen Measurement"
    @settings_screen.nielsenmeasurement_settings.click
    @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_settings.displayed? }
  else
    "No Matching option found, please check the option entered"
  end
end

Then("I see details of {string} option") do |setting_option|
  @settings_screen = SettingsScreen.new
  case setting_option
  when "Contact"
    @settings_screen.wait_until(30) { @settings_screen.contact_us_details.displayed? }
  when "Privacy"
    @settings_screen.wait_until(30) { @settings_screen.privacypolicy_details.displayed? }
  when "About"
    @settings_screen.wait_until(30) { @settings_screen.about_details.displayed? }
  when "Terms and Conditions"
    @settings_screen.wait_until(30) { @settings_screen.terms_and_conditions_details.displayed? }
  when "FAQ"
    @settings_screen.wait_until(30) { @settings_screen.faq_details.displayed? }
  when "Nielsen Measurement"
    @settings_screen.wait_until(30) { @settings_screen.nielsenmeasurement_details.displayed? }
  else
    "No Matching option found, please check the option entered"
  end
end

When("I see Nielsen Measurement toggle as {string} option") do |nielsen_measurement_toggle|
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(10) { @settings_screen.nielsenmeasurement_toggle(nielsen_measurement_toggle).displayed? }
end

When("I click on Nielsen Measurement {string} button") do |nielsen_measurement_enable_disable|
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(10) { @settings_screen.nielsenmeasurement_disable_enable(nielsen_measurement_enable_disable).displayed? }
  @settings_screen.nielsenmeasurement_disable_enable(nielsen_measurement_enable_disable).click
  @settings_screen.press_menu
end
