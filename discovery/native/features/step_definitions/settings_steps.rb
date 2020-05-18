When("I go to the {string} screen") do |screen_name|
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_settings_icon.displayed? }
  @home_screen.home_settings_icon.click
  @settings_screen = SettingsScreen.new
  if screen_name == "About"
    @settings_screen.wait_until(30) { @settings_screen.about_option.displayed? }
    @settings_screen.about_option.click
  elsif screen_name == "Help / FAQ"
    @settings_screen.wait_until(30) { @settings_screen.help_option.displayed? }
    @settings_screen.help_option.click
  elsif screen_name == "Nielsen Measurements"
    @settings_screen.wait_until(30) { @settings_screen.neilsen_option.displayed? }
    @settings_screen.neilsen_option.click
  elsif screen_name == "Online Closed Captioning"
    @settings_screen.wait_until(30) { @settings_screen.online_closed_captioning_option.displayed? }
    @settings_screen.online_closed_captioning_option.click
  elsif screen_name == "Privacy Policy"
    @settings_screen.wait_until(30) { @settings_screen.privacy_option.displayed? }
    @settings_screen.privacy_option.click
  elsif screen_name == "Terms & Conditions"
    @settings_screen.wait_until(30) { @settings_screen.terms_option.displayed? }
    @settings_screen.terms_option.click
  elsif screen_name == "Contact Us / Send Feedback"
    @settings_screen.wait_until(30) { @settings_screen.about_option.displayed? }
    @settings_screen.scroll_to_contact
    @settings_screen.contact_option.click
  elsif screen_name == "Version Info"
    @settings_screen.wait_until(30) { @settings_screen.about_option.displayed? }
    @settings_screen.scroll_to_version
    @settings_screen.version_info_option.click
  end
end

Then("app details should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("Discovery")
  # @settings_screen.wait_until(30) { expect(@settings_screen.about_title_text.displayed?).to be_truthy }
end

Then("I should be able to read FAQS") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("faq")
  # @settings_screen.wait_until(30) { expect(@settings_screen.help_title_text.displayed?).to be_truthy }
end

Then("agreement details should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("neilsen")
  # @settings_screen.wait_until(30) { expect(@settings_screen.nielsen_title_text.displayed?).to be_truthy }
end

Then("online closed captioning details should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("closed caption")
  # @settings_screen.wait_until(30) { expect(@settings_screen.online_title_text.displayed?).to be_truthy }
end

Then("privacy policy details should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("privacy policy")
  # @settings_screen.wait_until(30) { expect(@settings_screen.privacy_title_text.displayed?).to be_truthy }
end

Then("terms and conditions should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("agreement")
  # @settings_screen.wait_until(30) { expect(@settings_screen.terms_title_text.displayed?).to be_truthy }
end

Then("contact details should be visible") do
  @settings_screen = SettingsScreen.new
  @settings_screen.switch_context_to_web
  driver.page_source.include?("custhelp.com")
  # @settings_screen.wait_until(30) { expect(@settings_screen.contact_title_text.displayed?).to be_truthy }
end

Then("version details should be visible") do
  @settings_screen = SettingsScreen.new
  expect(@settings_screen.version_info_option.displayed?).to be_truthy
end

Then("I see Affiliate icon") do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(60) { expect(@settings_screen.affilate_logo.displayed?).to be_truthy }
end

And("I see Sign out button on the settings screen") do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(50) { expect(@settings_screen.signout_button.displayed?).to be_truthy }
end

Then("I see Sign in button on the settings screen") do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(30) { expect(@settings_screen.sign_in_button.displayed?).to be_truthy }
end

And("I am on the settings screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { @home_screen.home_settings_icon.click }
end

Then("I see text Verify your TV provider to access even more videos") do
  @settings_screen = SettingsScreen.new
  @settings_screen.wait_until(50) { expect(@settings_screen.veriy_provider_text.displayed?).to be_truthy }
end
