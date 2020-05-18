Given("I am on the Account screen in Apple TV") do
  @account_screen = AccountScreen.new
  step "I am on the home screen"
  @account_screen.navigate_to_account
  @account_screen.press_select
  @account_screen.wait_until(30) { @account_screen.app_information_settings.displayed? }
  expect(@account_screen.app_information_settings.displayed?).to be true
end

When("I go to the {string} screen") do |option|
  @account_screen = AccountScreen.new
  case option
  when "California Do Not Sell My Info"
    expect(@account_screen.california_do_not_sell_settings.displayed?).to be_truthy
    @account_screen.press_select
  when "App Information"
    expect(@account_screen.app_information_settings.displayed?).to be_truthy
    1.times { @account_screen.press_down }
    @account_screen.press_select
  when "About"
    expect(@account_screen.about_settings.displayed?).to be_truthy
    2.times { @account_screen.press_down }
    @account_screen.press_select
  when "Help/FAQ"
    expect(@account_screen.help_settings.displayed?).to be_truthy
    3.times { @account_screen.press_down }
    @account_screen.press_select
  when "Terms and Conditions"
    expect(@account_screen.terms_and_conditions_settings.displayed?).to be_truthy
    4.times { @account_screen.press_down }
    @account_screen.press_select
  when "Privacy Policy"
    expect(@account_screen.privacy_policy_settings.displayed?).to be_truthy
    5.times { @account_screen.press_down }
    @account_screen.press_select
  when "Nielsen Measurement"
    expect(@account_screen.nielsen_measurement_settings.displayed?).to be_truthy
    6.times { @account_screen.press_down }
    @account_screen.press_select
  when "Online Closed Captioning"
    expect(@account_screen.online_closed_caption_settings.displayed?).to be_truthy
    7.times { @account_screen.press_down }
    @account_screen.press_select
  end
end

Then("I see details of {string} option") do |setting_option|
  @account_screen = AccountScreen.new
  case setting_option
  when "California Do Not Sell My Info"
    pending
  when "App Information"
    @account_screen.wait_until(60) { @account_screen.version_number.displayed? }
    @account_screen.wait_until(60) { @account_screen.os_number.displayed? }
    @account_screen.wait_until(60) { @account_screen.device_model.displayed? }
    @account_screen.wait_until(60) { @account_screen.build_number.displayed? }
  when "About"
    pending
  when "Help/FAQ"
    pending
  when "Terms and Conditions"
    pending
  when "Privacy Policy"
    pending
  when "Nielsen Measurement"
    pending
  when "Online Closed Captioning"
    pending
  else
    "No Matching option found, please enter valid option name"
  end
end

And("I tap on back") do
  @account_screen = AccountScreen.new
  @account_screen.press_menu
end

And("I see Account screen sub menu list") do
  @account_screen = AccountScreen.new
  @account_screen.wait_until(30) { @account_screen.app_information_settings.displayed? }
  expect(@account_screen.app_information_settings.displayed?).to be true
end
