# frozen_string_literal: true

When(/^I go to the search shows page$/) do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_search_icon.displayed? }
  @home_screen.home_search_icon.click
end

Then("I enter show name in search field") do
  @show_list = ShowListScreen.new
  @show_list.search_text_button.click
  @show_list.wait_until(30) { @show_list.search_text_field.displayed? }
  @show_list.search_text_field.send_keys(NETWORK_DATA.episode_name)
end

And(/^I select the show from results$/) do
  @show_list = ShowListScreen.new
  driver.hide_keyboard
  # This click is to remove focus from search field
  @show_list.search_list_first_show.click
  # Clicking the first show in search result
  @show_list.search_list_first_show.click
  @show_page = ShowScreen.new
  expect(@show_page.hero.displayed?).to be true
end

And(/^I search the show which is not present$/) do
  @show_list = ShowListScreen.new
  @show_list.search_text_button.click
  @show_list.search_text_field.send_keys("AAAAA")
end

Then(/^no shows are returned in the search$/) do
  @show_list = ShowListScreen.new
  driver.hide_keyboard
  expect(@show_list.no_results_text.displayed?).to be true
end

Then(/^I see all shows tab$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.all_shows_tab.displayed?).to be true
end

And(/^I see for you tab$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.for_you_tab.displayed?).to be true
end

And(/^I click for you tab$/) do
  @show_list = ShowListScreen.new
  @show_list.for_you_tab.click
end

And(/^For you tab displays show cards$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.for_you_tab_first_show.displayed?).to be true
end

Then("I see detail view of searched show") do
  @show_list = ShowListScreen.new
  @show_list.wait_until(30) { expect(@show_list.detail_view.displayed?).to be_truthy }
end

And("I tap on episode card to play the video from show episode list") do
  @show_list = ShowListScreen.new
  @show_list.wait_until(30) { expect(@show_list.episode_card.displayed?).to be_truthy }
  @show_list.episode_card.click
end
