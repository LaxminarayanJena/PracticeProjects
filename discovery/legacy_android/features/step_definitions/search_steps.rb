# frozen_string_literal: true

Given(/^I search a show$/) do
  step "I go to a show page"
end

Then(/^I get to the shows show page$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.show_hero.displayed? }
  expect(@show_screen.show_hero.text.empty?).not_to be_truthy
  expect(@show_screen.show_hero.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
end

Then(/^I search a show that is not present$/) do
  @show_screen = BaseScreen.new
  @show_screen.wait_until(30) { @show_screen.search_show_icon.displayed? }
  @show_screen.search_show_icon.click
  @show_screen.search_show_text_input.send_keys("AAAAA")
end

Then(/^no results are returned in the search$/) do
  @show_list = ShowListScreen.new
  driver.hide_keyboard
  expect(@show_list.no_results_text.displayed?).to be true
end

And(/^I tap on episode card to play the video from show episode list$/) do
  @show_list = ShowScreen.new
  @show_list.wait_until(30) { expect(@show_list.play_episode_button.displayed?).to be_truthy }
  @show_list.play_episode_button.click
end

When("I type a show name on search bar") do
  @landing_screen = LandingScreen.new
  @landing_screen.search_show_icon.click
  @landing_screen.wait_until(30) { @landing_screen.search_show_text_input.displayed? }
  @landing_screen.search_show_text_input.send_keys(NETWORK_DATA.show_search[:show_name])
end

Then("I see total number of results found") do
  @landing_screen = LandingScreen.new
  driver.hide_keyboard
  expect(@landing_screen.search_results.displayed?).to be_truthy
  @landing_screen.scroll_to_bottom
  step "I click on device back button"
end

And("I tap on close icon in search bar") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.search_close_button.displayed? }
  @landing_screen.search_close_button.click
end

Then("I see text entered in the search bar is cleared") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.search_text.displayed?).to be_truthy
end

Then(/^I type any letter on search bar$/) do
  @show_screen = BaseScreen.new
  @show_screen.wait_until(30) { @show_screen.search_show_icon.displayed? }
  @show_screen.search_show_icon.click
  @show_screen.search_show_text_input.send_keys("E")
end

Then("I see video playing in landscape mode") do
  step "I tap on episode card to play the video from show episode list"
  mode = driver.orientation.to_s
  expect(mode).to eq "landscape"
end

Then("I see metadata of the show") do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_hero.displayed?).to be_truthy
  expect(@show_screen.search_result_icon.displayed?).to be_truthy
end
