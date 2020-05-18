# frozen_string_literal: true

When(/^I view an unlocked episode$/) do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.unlocked_episode}")
end

When(/^I view an unlocked shortform episode$/) do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.shortform_unlocked_episode}")
end

When(/^I scroll unlocked episodes right and left$/) do
  @home_screen = HomeScreen.new
  @home_screen.wait_until { @home_screen.unlocked_episodes_show_card(1).displayed? }
  start_x = @home_screen.unlocked_episodes_show_card(1).location.x
  y = @home_screen.unlocked_episodes_show_card(1).location.y
  # start of the screen
  end_x = 1
  @home_screen.scroll_to_info_button_by_coordinates
  @home_screen.wait_until(30) { @home_screen.show_info_button.displayed? }
  Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  # rubocop:disable Style/GlobalVars
  expect($driver.exists { @home_screen.unlocked_episodes_show_card(0) }).to be_falsey
  # rubocop:enable Style/GlobalVars
  Appium::TouchAction.new.swipe(start_x: end_x.to_i + 70, start_y: end_x + 1500, end_x: start_x - 100, end_y: start_x + 530, duration: 200)
                     .perform.release
end

Then(/^I should see the video playing$/) do
  @video = VideoScreen.new
  @video.wait_until(30) { @video.up_next.displayed? }
  expect(@video.up_next.displayed?).to be_truthy
end

And(/^I play a live video$/) do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_live
  @home_screen.wait_until(30) { @home_screen.live_header_desc.displayed? }
  expect(@home_screen.live_header_desc.displayed?).to be_truthy
  @home_screen.live_video.click
end

Then(/^I should see the affiliate search screen$/) do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.affiliate_search_screen.displayed? }
  expect(@home_screen.affiliate_search_screen.displayed?).to be_truthy
end

Then("I should be able to view unlocked episodes info details") do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_info_button_by_coordinates
  @home_screen.wait_until(30) { @home_screen.get_card_info(@home_screen.unlocked_episode)[:info_button].displayed? }
  @home_screen.wait_until(30) { @home_screen.get_card_info(@home_screen.unlocked_episode)[:info_button].click }
  step "I should see information about the show"
end

And(/^I tap on any unlocked episode$/) do
  @home_screen = HomeScreen.new
  expect(@home_screen.unlocked_episodes_show_card(1).displayed?).to be_truthy
  @home_screen.unlocked_episodes_show_card(1).click
end
