When("I go to settings") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(30) { @app_settings_screen.hamburger_icon.displayed? }
  @app_settings_screen.hamburger_icon.click
  @app_settings_screen.wait_until(30) { @app_settings_screen.hamburger_app_settings.displayed? }
  @app_settings_screen.hamburger_app_settings.click
  expect(@app_settings_screen.settings_container.displayed?).to be_truthy
end

And("I go to the {string} setting screen") do |screen_name|
  @app_settings_screen = AppSettingsScreen.new
  if screen_name == "About"
    @app_settings_screen.about_option.click
  elsif screen_name == "Help / FAQ"
    @app_settings_screen.help_option.click
  elsif screen_name == "Privacy Policy"
    @app_settings_screen.privacy_policy_option.click
  elsif screen_name == "Terms and Conditions"
    @app_settings_screen.terms_and_conditions_opt.click
  elsif screen_name == "Online Closed Captioning"
    @app_settings_screen.online_closed_captioning_option.click
  elsif screen_name == "Contact US"
    @app_settings_screen.contact_details_option.click
  elsif screen_name == "About Nielsen Agreement"
    @app_settings_screen.agreement_details_option.click
  end
end

Then("app details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.about_option_text.displayed?
  expect(@app_settings_screen.about_option_text.text.empty?).not_to be_truthy
end

Then("I should be able to read FAQS") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.help_option_text.displayed?
  expect(@app_settings_screen.help_option_text.text.empty?).not_to be_truthy
end

Then("online closed captioning details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.online_closed_captioning_option_text.displayed?
  expect(@app_settings_screen.online_closed_captioning_option_text.text.empty?).not_to be_truthy
end

Then("privacy policy details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.privacy_policy_option_text.displayed?
  expect(@app_settings_screen.privacy_policy_option_text.text.empty?).not_to be_truthy
end

Then("terms and conditions should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.terms_and_conditions_opt_text.displayed?
  expect(@app_settings_screen.terms_and_conditions_opt_text.text.empty?).not_to be_truthy
end

Then("contact details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.contact_details_option_text.displayed?
  expect(@app_settings_screen.contact_details_option_text.text.empty?).not_to be_truthy
end

Then("agreement details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.agreement_details_option_text.displayed?
  expect(@app_settings_screen.agreement_details_option_text.text.empty?).not_to be_truthy
end

Then("I see sign in option on the setting screen") do
  @landing_screen = SettingsScreen.new
  @landing_screen.wait_until(60) { expect(@landing_screen.sign_in_button.displayed?).to be_truthy }
end

Then("I see sign out option on the setting screen") do
  @app_settings_screen = SettingsScreen.new
  @app_settings_screen.wait_until(30) { @app_settings_screen.hamburger_app_settings.displayed? }
  @app_settings_screen.hamburger_app_settings.click
  @app_settings_screen.wait_until(30) { expect(@app_settings_screen.sign_out_button.displayed?).to be_truthy }
end

Then("I click sign out option on the setting screen") do
  step "I see sign out option on the setting screen"
  @app_settings_screen.sign_out_button.click
end

And("I tap on X button") do
  @app_settings_screen = BaseScreen.new
  @app_settings_screen.wait_until(30) { @app_settings_screen.top_close_button.displayed? }
  @app_settings_screen.top_close_button.click
end

Then("I see global navigation menu overlay") do
  @app_settings_screen = BaseScreen.new
  @app_settings_screen.wait_until(30) { @app_settings_screen.hamburger_home_icon.displayed? }
end

Then("I see affiliate picker screen") do
  @show_screen = LandingScreen.new
  expect(@show_screen.search_providers.displayed?).to be_truthy
end

Then("I login from Settings screen") do
  step "I go to settings"
  step "I see and click on sign in"
  step "I search provider and login with valid credential"
  step "I should see 'Settings' page"
  step "I tap on X button"
end
