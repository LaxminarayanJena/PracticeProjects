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

When(/^I check shows home info option$/) do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_home_info.first.displayed?).to be_truthy
  @show_screen.show_home_info.first.click
end

Then(/^I view a on last night show video$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { expect(@show_screen.on_last_night_header_desc.displayed?).to be_truthy }
  @show_screen.wait_until(60) { expect(@show_screen.play_episode_button.displayed?).to be_truthy }
  @show_screen.play_episode_button.click
end
