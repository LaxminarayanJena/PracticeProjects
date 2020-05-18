# frozen_string_literal: true

Given(/^I navigate to live screen$/) do
  @screen = WatchLiveTvScreen.new
  @screen.wait_until(30) { @screen.logo.displayed? }
  @screen.navigate_to_live
end

When(/^I click on the key icon$/) do
  @screen = WatchLiveTvScreen.new
  @screen.activate_button.click
end

Then(/^I should see an activation screen$/) do
  @screen = WatchLiveTvScreen.new
  expect(@screen.activation_container.displayed?).to be true
end

And("I click on live tv play button") do
  @screen = LandingScreen.new
  @watchscreen = WatchLiveTvScreen.new
  @screen.wait_until(30) { @screen.play_btn.displayed? }
  expect(@screen.play_btn.displayed?).to be_truthy
  @show_name_text = @watchscreen.live_tv_current_show_name.text
  @show_title_text = @watchscreen.live_tv_current_title.text
  @show_description_text = @watchscreen.live_tv_current_description.text
  @upnext_show_name = @watchscreen.upnext_show_name.text
  @upnext_show_time = @watchscreen.upnext_show_time.text
  @screen.play_btn.click
end

Then("I should watch live tv") do
  @screen = WatchLiveTvScreen.new
  @page.wait_until(30) { @screen.live_tv_video_controls.displayed? }
  @screen.live_tv_video_controls.click
  @page.wait_until(30) { @screen.live_tv_show_name.displayed? }
end

Then("I should see the show details") do
  @screen = WatchLiveTvScreen.new
  @landingscreen = LandingScreen.new
  @basescreen = BaseScreen.new
  @screen.wait_until(30) { @landingscreen.play_btn.displayed? }
  expect(@landingscreen.play_btn.displayed?).to be_truthy
  expect(@screen.et_lable.displayed?).to be_truthy
  expect(@basescreen.menu_live.displayed?).to be_truthy
  expect(@screen.current_show_name.displayed?).to be_truthy
  expect(@screen.current_title.displayed?).to be_truthy
  expect(@screen.current_description.displayed?).to be_truthy
  expect(@screen.upnext_text.displayed?).to be_truthy
  expect(@screen.upnext_show_name.displayed?).to be_truthy
  expect(@screen.upnext_show_time.displayed?).to be_truthy
end

Then("I see player controls and content metadata") do
  @screen = WatchLiveTvScreen.new
  # step "I should see UpNext episode information"
  @page.wait_until(30) { @screen.live_tv_show_name.displayed? }
  expect(@screen.live_tv_player_captions_checkbox.displayed?).to be_truthy
  expect(@screen.live_tv_player_captions_text.displayed?).to be_truthy
  expect(@screen.live_tv_player_seek_bar.displayed?).to be_truthy
  expect(@show_name_text == @screen.live_tv_show_name.text).to be_truthy
  expect(@show_title_text == @screen.live_tv_title.text).to be_truthy
  expect(@show_description_text == @screen.live_tv_description.text).to be_truthy
  expect(@upnext_show_name == @screen.live_tv_next_show_name.text).to be_truthy
  expect(@upnext_show_time == @screen.live_tv_next_show_time.text).to be_truthy
  expect(@screen.live_tv_start_time.displayed?).to be_truthy
end

When("I click on live content from Live tab") do
  step"I navigate to live screen"
  step"I click on live tv play button"
end

And("I click on Remote Back button and play the same content again") do
  @screen = LandingScreen.new
  @screen = WatchLiveTvScreen.new
  step "I should watch live tv"
  @screen.press_back
  step "I click on live tv play button"
  step "I see player controls and content metadata"
end

Then("I should see confirmation message on app exit") do
  @screen = HomeScreen.new
  @screen.press_back
  expect(@screen.app_exit_option.displayed?).to be_truthy
  expect(@screen.app_cancel_option.displayed?).to be_truthy
  expect(@screen.app_exit_message.text.include?(NETWORK_DATA.show_search[:exit_app_message])).to be true
end

And("I click cancel option from exit app message") do
  @screen = HomeScreen.new
  @screen.press_back
  @screen.press_right
  expect(@screen.app_cancel_option.displayed?).to be_truthy
  @screen.app_cancel_option.click
end

Then("I should land on Live tv tab") do
  @screen = BaseScreen.new
  expect(@screen.menu_live.displayed?).to be_truthy
end

Then("I should see UpNext episode information") do
  @screen = WatchLiveTvScreen.new
  expect(@screen.upnext_text.displayed?).to be_truthy
  expect(@screen.upnext_show_name.displayed?).to be_truthy
  expect(@screen.upnext_show_time.displayed?).to be_truthy
end
