# frozen_string_literal: true

Given(/^I search a show$/) do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_show(NETWORK_DATA.show_search[:show_name])
  @search_screen.press_media_play_pause
end

When(/^I select the show's card$/) do
  @search_screen = SearchScreen.new
  @search_screen.results_view.first.click
end

Then(/^I should be on the show's show screen$/) do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_title.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  expect(@show_screen.info_btn.displayed?).to be true
  expect(@show_screen.favorite_btn.displayed?).to be true
end

Given(/^I search show with a invalid show$/) do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_show(NETWORK_DATA.show_search[:invalidShowName])
  @search_screen.press_media_play_pause
end

Then(/^I should be displayed with no results found message$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { expect(@show_screen.search_no_result.displayed?).to be_truthy }
end

Given(/^I search a show for seasons and episodes$/) do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_show(NETWORK_DATA.show_search[:show_name_season_episode])
  @search_screen.press_media_play_pause
end

Given("I search for a locked show") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_show(NETWORK_DATA.show_search[:locked_show])
end

And("I verify the details in shows show's screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(10) { @show_screen.info_btn.displayed? }
  expect(@show_screen.info_btn.displayed?).to be_truthy
  expect(@show_screen.favorite_btn.displayed?).to be_truthy
  expect(@show_screen.watch_later_btn.displayed?).to be_truthy
  expect(@show_screen.show_title.displayed?).to be_truthy
  expect(@show_screen.sesson_eposide_text.displayed?).to be_truthy
  expect(@show_screen.episode_description_text.displayed?).to be_truthy
  expect(@show_screen.duration_text.displayed?).to be_truthy
  expect(@show_screen.status_image_btn.displayed?).to be_truthy
  @end_time=@show_screen.duration_text.text.to_f
end

And("I click on the lock or play btn") do
  @show_screen = ShowScreen.new
  @show_screen.status_image_btn.click
end

Then("I should see the activation mesasge") do
  step "I see visit url & activate code"
end

Given("I search for a string") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_show(NETWORK_DATA.show_search[:search_string])
  @search_screen.press_media_play_pause
end

Then("I verify the search result") do
  @search_screen = SearchScreen.new
  @search_count = @search_screen.results_view.size
  if @search_count == 1
    @search_screen.press_down
    @search_screen.press_right
  elsif @search_count > 1
    @search_screen.press_right
    @search_screen.press_down
    @search_screen.press_left
  end
end

And("I select a show from result searched") do
  @search_screen = SearchScreen.new
  @search_screen.results_view.first.click
end

And("I click on back button") do
  @search = BaseScreen.new
  @search.press_back
end

Then("I verify the actual and expected search count") do
  @search_screen = SearchScreen.new
  @expected_search_count = @search_screen.results_view.size
  expect(@search_count = @expected_search_count).to be_truthy
end

When("I verify searched result") do
  @search_screen = SearchScreen.new
  @search_count = @search_screen.results_view.size
end

And("I navigate to my videos") do
  @search_screen = SearchScreen.new
  3.times { @search_screen.press_up }
  @search_screen.press_left
  @search_screen.navigate_to_search
end

Then("I should see search screen is refreshed") do
  @search_screen = SearchScreen.new
  @actual_search_count = @search_screen.results_view.size
  expect(@search_count == @actual_search_count).to be false
end

When("I navigate to search screen") do
  @screen = SearchScreen.new
  @screen.wait_until(30) { @screen.logo.displayed? }
  @screen.navigate_to_search
  @screen.press_up
end

Then("I should land on search tab") do
  @screen = BaseScreen.new
  expect(@screen.menu_search.displayed?).to be_truthy
end
