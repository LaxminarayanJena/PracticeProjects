# frozen_string_literal: true

Given(/^I'm on the landing screen$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.hamburger_icon.displayed? }
end

Then(/^I see on last night header description$/) do
  @landing_screen = BaseScreen.new
  @landing_screen.wait_until(60) { @landing_screen.on_last_night_header_desc.displayed? }
  expect(@landing_screen.on_last_night_header_desc.text.empty?).not_to be_truthy
  expect(@landing_screen.on_last_night_header_desc.text.downcase.include?("on last night")).to be true
end

Then(/^I add a show to watch later from on last night shows$/) do
  @show_screen = ShowScreen.new
  @show_screen.show_home_info.click
  @show_screen.watch_later_add_remove_option.click
  expect(@show_screen.watch_list_add_remove_desc.displayed?).to be true
  @show_screen.watch_list_popup.click
end

When(/^I check shows home info option$/) do
  @landing_screen = BaseScreen.new
  @landing_screen.on_last_night_header_desc.click
  @landing_screen.scroll_to_bottom
  @show_screen = ShowScreen.new
  @show_screen.show_home_info.displayed?
end

When(/^I view a on last night video$/) do
  step "I view a video"
end

When("I should not be able to play on last night episode without login") do
  @show_screen = ShowScreen.new
  expect(@show_screen.search_providers.displayed?).to be_truthy
end

And("I should be able to play the on last night episode after logging in") do
  step "Search provider and login with valid credential"
  step "I should see the video playing"
end
