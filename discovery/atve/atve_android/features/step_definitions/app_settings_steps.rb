When("I go to account") do
  @account_screen = SettingScreen.new
  @account_screen.wait_until(30) { @account_screen.account_icon.displayed? }
  @account_screen.account_icon.click
end

And("I go to {string} screen") do |screen_name|
  @account_screen = SettingScreen.new
  case screen_name
  when "About"
    expect(@account_screen.about_option.displayed?).to be_truthy
    @account_screen.about_option.click
  when "Help"
    expect(@account_screen.help_option.displayed?).to be_truthy
    @account_screen.help_option.click
  when "App Information"
    expect(@account_screen.app_info_option.displayed?).to be_truthy
    @account_screen.app_info_option.click
  when "Terms of Use"
    expect(@account_screen.terms_of_use_option.displayed?).to be_truthy
    @account_screen.terms_of_use_option.click
  when "Nielsen Measurement"
    expect(@account_screen.nielsen_measurement_option.displayed?).to be_truthy
    @account_screen.nielsen_measurement_option.click
  when "Privacy Policy"
    expect(@account_screen.privacy_policy_option.displayed?).to be_truthy
    @account_screen.privacy_policy_option.click
  when "California Do Not Sell My Info"
    expect(@account_screen.do_not_sell_option.displayed?).to be_truthy
    @account_screen.do_not_sell_option.click
  when "Online Closed Captioning"
    expect(@account_screen.online_captioning_option.displayed?).to be_truthy
    @account_screen.online_captioning_option.click
  when "My List"
    expect(@account_screen.my_list_option.displayed?).to be_truthy
    @account_screen.my_list_option.click
  when "Push Notifications"
    expect(@account_screen.push_notification_option.displayed?).to be_truthy
    @account_screen.push_notification_option.click
  end
end

Then("I should be able to see app info") do
  @account_screen = SettingScreen.new
  expect(@account_screen.app_info_option.text.match(/App Information/)).to be_truthy
end

Then("online closed captioning details should be visible") do
  @account_screen = SettingScreen.new
  expect(@account_screen.captioning_header_text.displayed?).to be_truthy
end

Then("I should see error message") do
  @account_screen = SettingScreen.new
  expect(@account_screen.error_message.displayed?).to be_truthy
end

Then("I see web view of help page") do
  @account_screen = SettingScreen.new
  expect(@account_screen.help_web_view.displayed?).to be_truthy
end
