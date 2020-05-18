Then("privacy policy details should be visible") do
  @privacy_policy_screen = PrivacyPolicyScreen.new
  @privacy_policy_screen.wait_until(60) { @privacy_policy_screen.screen_title_text.displayed? }
  expect(@privacy_policy_screen.screen_title_bar.displayed?).to be_truthy
  expect(@privacy_policy_screen.screen_title_text.text.downcase.include?("privacy policy")).to be_truthy
  expect(@privacy_policy_screen.title.displayed?).to be_truthy
  expect(@privacy_policy_screen.title_text.text.match(/DISCOVERY COMMUNICATIONS PRIVACY POLICY/)).to be_truthy
  expect(@privacy_policy_screen.any_subtitle_text.text.match(/Information Collected/)).to be_truthy
end

Then("app details should be visible") do
  @about_screen = AboutScreen.new
  @about_screen.wait_until(60) { @about_screen.screen_title_text.displayed? }
  expect(@about_screen.screen_title_bar.displayed?).to be_truthy
  expect(@about_screen.screen_title_text.text == NETWORK_DATA.about_title).to be_truthy
  expect(@about_screen.screen_content[:name].match(/Discovery, Inc\. \(Nasdaq\: DISCA, DISCB, DISCK\) is a global leader/)).to be_truthy
end

Then("I should be able to read FAQS") do
  @help_screen = HelpScreen.new
  @help_screen.wait_until(60) { @help_screen.screen_title_text.displayed? }
  expect(@help_screen.screen_title_bar.displayed?).to be_truthy
  expect(@help_screen.screen_title_text.text == NETWORK_DATA.help_screen_title).to be_truthy
  expect(@help_screen.main_title.text == NETWORK_DATA.help_main_title).to be_truthy
  expect(@help_screen.screen_sub_titles[:name].match(/GENERAL QUESTIONS/)).to be_truthy
end

Then("terms and conditions should be visible") do
  @terms_and_conditions_screen = TermsAndCinditionsScreen.new
  @terms_and_conditions_screen.wait_until(60) { @terms_and_conditions_screen.visitor_agreement.displayed? }
  expect(@terms_and_conditions_screen.visitor_agreement.text.match(/Visitor Agreement – Discovery, Inc./)).to be_truthy
end

Then("online closed captioning details should be visible") do
  @online_closed_captioning_screen = OnlineClosedCaptioningScreen.new
  @online_closed_captioning_screen.wait_until(60) { @online_closed_captioning_screen.screen_title_text.displayed? }
  expect(@online_closed_captioning_screen.screen_title_bar.displayed?).to be_truthy
  expect(@online_closed_captioning_screen.screen_title_text.text.match(/Online Closed Captioning – Discovery, Inc\./)).to be_truthy
  expect(@online_closed_captioning_screen.screen_content[:name].match(/To better assist us in addressing your question/)).to be_truthy
end

Then("contact details should be visible") do
  @contact_details_screen = ContactUsScreen.new
  webview = driver.available_contexts.last
  driver.set_context(webview)
  expect(driver.current_url).to include "custhelp"
  # expect(@contact_details_screen.email_address_textarea.text.match(/Email Address/)).to be_truthy
end

Then("agreement details should be visible") do
  @about_agreement_screen = AboutAgreementScreen.new
  @about_agreement_screen.wait_until(60) { @about_agreement_screen.screen_title_text.displayed? }
  expect(@about_agreement_screen.screen_title_text.text.match(/About Nielsen Measurement/)).to be_truthy
  agreement_content = ["ABOUT NIELSEN MEASUREMENT", "Television and the way we watch it have come a long way since Nielsen"]
  agreement_screen_texts = ""
  @about_agreement_screen.screen_texts.each { |text_ele| agreement_screen_texts += text_ele[:name] }
  expect(agreement_screen_texts.include?(agreement_content.join(""))).to be_truthy
end

# rubocop:disable Style/GlobalVars
And("I go to the {string} screen") do |screen_name|
  @app_settings_screen = AppSettingsScreen.new
  if screen_name == "About"
    expect(@app_settings_screen.about_option.displayed?).to be_truthy
    @app_settings_screen.about_option.click
  elsif screen_name == "Help / FAQ"
    expect(@app_settings_screen.help_option.displayed?).to be_truthy
    @app_settings_screen.help_option.click
  elsif screen_name == "Privacy Policy"
    expect(@app_settings_screen.privacy_policy_option.displayed?).to be_truthy
    @app_settings_screen.privacy_policy_option.click
  elsif screen_name == "Terms and Conditions"
    expect(@app_settings_screen.terms_and_conditions_opt.displayed?).to be_truthy
    @app_settings_screen.terms_and_conditions_opt.click
  elsif screen_name == "Online Closed Captioning"
    @app_settings_screen.wait_until { @app_settings_screen.online_closed_captioning_option.displayed? }
    @app_settings_screen.online_closed_captioning_option.click
  elsif screen_name == "Contact US"
    expect(@app_settings_screen.contact_us.displayed?).to be_truthy
    @app_settings_screen.contact_us.click
  elsif screen_name == "About Nielsen Agreement"
    $driver.scroll_to("About Nielsen Measurement")
    expect(@app_settings_screen.neilsen_option.displayed?).to be_truthy
    @app_settings_screen.neilsen_option.click
  end
end

And("I go to settings") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(60) { @app_settings_screen.hamburger_icon.displayed? }
  @app_settings_screen.hamburger_icon.click
  @app_settings_screen.wait_until(60) { @app_settings_screen.hamburger_app_settings.displayed? }
  @app_settings_screen.hamburger_app_settings.click
  @app_settings_screen.wait_until(60) { @app_settings_screen.settings_container.displayed? }
  expect(@app_settings_screen.settings_container.displayed?).to be_truthy
end

Then("version details should be visible") do
  @app_settings_screen = AppSettingsScreen.new
  $driver.scroll_to("Version Name")
  expect(@app_settings_screen.version_details.text.match(/Version Name/)).to be_truthy
end
# rubocop:enable Style/GlobalVars

Then("I see sign in option on the setting screen") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { expect(@landing_screen.signin_button.displayed?).to be_truthy }
end

Then("I see sign out option on the setting screen") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(30) { expect(@app_settings_screen.sign_out_button.displayed?).to be_truthy }
end

Then("I click sign out option on the setting screen") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(30) { expect(@app_settings_screen.sign_out_button.displayed?).to be_truthy }
  @app_settings_screen.sign_out_button.click
end

Then("I see settings screen") do
  @app_settings_screen = AppSettingsScreen.new
  expect(@app_settings_screen.hamburger_app_settings.displayed?).to be_truthy
end

When("I sign out from valid provider from any screen") do
  step "I go to settings"
  step "I see sign out option on the setting screen"
  step "I click sign out option on the setting screen"
  @app_settings_screen.hamburger_icon.click
end
