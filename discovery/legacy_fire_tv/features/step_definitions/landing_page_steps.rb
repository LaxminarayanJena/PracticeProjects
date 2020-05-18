# frozen_string_literal: true

Given(/^I'm on the landing screen$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.home_carousel_title_text.displayed? }
  4.times { @landing_screen.press_down }
  @landing_screen.wait_until(60) { @landing_screen.unlocked_episodes.first.displayed? }
  @landing_screen.unlocked_episodes.first.click
end

Then("I should see the video playing") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.play_btn.displayed? }
  expect(@landing_screen.play_btn.displayed?).to be_truthy
end
