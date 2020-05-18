Given("I am on the Settings screen") do
  step "I am on the Menu Bar"
  step "I navigate to 'Settings' screen"
end

Then("I see TV Provider, My List, About, Help, Nielsen Measurements") do
  @setting_screen = SettingsScreen.new
  expect(@setting_screen.tv_provider_subnav.displayed?).to be true
  expect(@setting_screen.my_list_subnav.displayed?).to be true
  expect(@setting_screen.about_subnav.displayed?).to be true
  expect(@setting_screen.help_subnav.displayed?).to be true
  expect(@setting_screen.nielsen_measurement_subnav.displayed?).to be true
end

And("I go to the {string} subnav") do |option|
  @setting_screen = SettingsScreen.new
  case option
  when "TV Provider"
    expect(@setting_screen.tv_provider_subnav.displayed?).to be_truthy
  when "My List"
    @setting_screen.press_right
    expect(@setting_screen.my_list_subnav.displayed?).to be_truthy
  when "About"
    2.times { @setting_screen.press_right }
    expect(@setting_screen.about_subnav.displayed?).to be_truthy
  when "Help"
    3.times { @setting_screen.press_right }
    expect(@setting_screen.help_subnav.displayed?).to be_truthy
  when "Nielsen Measurements"
    4.times { @setting_screen.press_right }
    expect(@setting_screen.nielsen_measurement_subnav.displayed?).to be_truthy
  end
end

Then("I see details of {string}") do |setting_option|
  @setting_screen = SettingsScreen.new
  case setting_option
  when "TV Provider"
    expect(@setting_screen.tv_provider_title.displayed?).to be_truthy
    expect(@setting_screen.tv_provider_subtitle.displayed?).to be_truthy
    expect(@setting_screen.link_tvprovider_btn.displayed?).to be_truthy
  when "My List"
    expect(@setting_screen.my_list_myshows_tab.displayed?).to be_truthy
    expect(@setting_screen.my_list_myepisode_tab.displayed?).to be_truthy
    expect(@setting_screen.my_list_showstext.displayed?).to be_truthy
    expect(@setting_screen.my_list_hinttext.displayed?).to be_truthy
    expect(@setting_screen.my_list_img.displayed?).to be_truthy
  when "About"
    expect(@setting_screen.about_details.displayed?).to be_truthy
  when "Help"
    expect(@setting_screen.help_details.displayed?).to be_truthy
    expect(@setting_screen.help_link.displayed?).to be_truthy
  when "Nielsen Measurement"
    expect(@setting_screen.nielsen_measurement_details.displayed?).to be_truthy
  end
end

Then("I see related info with URLs") do
  @setting_screen = SettingsScreen.new
  @setting_screen.press_down
  expect(@setting_screen.about_terms_url.displayed?).to be_truthy
  @setting_screen.press_down
  expect(@setting_screen.about_privacy_url.displayed?).to be_truthy
  @setting_screen.press_down
  expect(@setting_screen.about_online_url.displayed?).to be_truthy
  @setting_screen.press_down
  expect(@setting_screen.about_california_url.displayed?).to be_truthy
end
