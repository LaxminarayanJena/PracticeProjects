Given(/^I search a show$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.search_show_icon.click

  @search_screen = SearchScreen.new
  @search_screen.search_field.send_keys(NETWORK_DATA.show_search[:show_name])
  @search_screen.search_result(NETWORK_DATA.show_search[:show_name]).first.click
end

Then(/^I get to the shows show page$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(20) { @show_screen.show_banner(NETWORK_DATA.show_search[:show_name]).enabled? }
  expect(@show_screen.show_banner(NETWORK_DATA.show_search[:show_name]).enabled?).to be_truthy
end

And(/^I click on search icon$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.search_show_icon.displayed? }
  @landing_screen.search_show_icon.click
end

And(/^I search an unlocked video$/) do
  step "I click on search icon"
  @search_screen = SearchScreen.new
  @search_screen.search_field.send_keys(NETWORK_DATA.unlocked_video)
  @search_screen.search_result(NETWORK_DATA.unlocked_video).first.click
end

And(/^I search an locked video$/) do
  step "I click on search icon"
  @search_screen = SearchScreen.new
  @search_screen.search_field.send_keys(NETWORK_DATA.locked_video)
  @search_screen.search_result(NETWORK_DATA.locked_video).first.click
end

Then(/^I exit search screen$/) do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.top_close_button.displayed? }
  @search_screen.top_close_button.click
end

When(/^I search a show that is not present$/) do
  step "I click on search icon"
  @search_screen = SearchScreen.new
  @search_screen.search_field.displayed?
  @search_screen.search_field.send_keys("AAAAA")
end

Then(/^no results are returned in the search$/) do
  @show_list = ShowListScreen.new
  driver.hide_keyboard
  expect(@show_list.no_results_text.displayed?).to be true
end

And(/^I tap on unlocked episode card to play the video from show episode list$/) do
  @show_list = ShowScreen.new
  @show_list.wait_until(30) { expect(@show_list.play_episode_button.displayed?).to be_truthy }
  @show_list.play_episode_button.click
end

And(/^I tap on locked episode card to play the video from show episode list$/) do
  @show_list = ShowScreen.new
  @show_list.wait_until(30) { expect(@show_list.lock_key_episode_button.displayed?).to be_truthy }
  @show_list.lock_key_episode_button.click
end

When("I type a show name on search bar") do
  @search_screen = SearchScreen.new
  @search_screen.search_show_icon.click
  @search_screen.search_field.send_keys(NETWORK_DATA.show_search[:show_name])
end

Then("I see total number of results found") do
  @search_screen = SearchScreen.new
  driver.hide_keyboard
  @search_screen.wait_until(30) { expect(@search_screen.search_results.displayed?).to be_truthy }
end

And("I tap on close icon in search bar") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_close_button.displayed? }
  @search_screen.search_close_button.click
end

And("I click on back button") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.top_back_button.displayed? }
  @search_screen.top_back_button.click
end

Then("I see text entered in the search bar is cleared") do
  @search_screen = SearchScreen.new
  expect(@search_screen.search_text.text.downcase.include?("search")).to be_truthy
end

Then("I type any letter on search bar") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_show_icon.displayed? }
  @search_screen.search_show_icon.click
  @search_screen.search_field.send_keys("E")
end
