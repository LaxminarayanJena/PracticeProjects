When(/^I enter a shown name in search text field$/) do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_text_field.displayed? }
  @search_screen.search_text_field.send_keys(NETWORK_DATA.show_search[:search_string])
end

Then("I click on searched episode") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.searched_episode.displayed? }
  @search_screen.searched_episode.click
end

When("I tap on search bar") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_text_field.displayed? }
  @search_screen.search_text_field.click
end

Then("I see keypad is enabled") do
  @search_screen = SearchScreen.new
  expect(@search_screen.driver.is_keyboard_shown).to be_truthy
  @search_screen.driver.hide_keyboard
end

When("I type {string} in search text field") do |text|
  @search_screen = SearchScreen.new
  @search_screen.search_text_field.clear
  @search_screen.search_text_field.send_keys(text)
end

Then("I see No results found page") do
  @search_screen = SearchScreen.new
  expect(@search_screen.no_result_found.displayed?).to be_truthy
end

And("I see shows results for searched text") do
  @search_screen = SearchScreen.new
  expect(@search_screen.searched_episode.displayed?).to be_truthy
  expect(@search_screen.shows_screen_title.displayed?).to be_truthy
end

Then("keypad should be hidden") do
  @search_screen = SearchScreen.new
  @search_screen.driver.hide_keyboard
  expect(@search_screen.driver.is_keyboard_shown).to be_falsy
end

And("I tap on 'x' button in search text field") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.clear_text.displayed? }
  @search_screen.clear_text.click
end

Then("I see text entered in the search bar is cleared") do
  @search_screen = SearchScreen.new
  expect(@search_screen.search_icon.displayed?).to be_truthy
end

Then("I see 'Search for shows, episodes and more' Help text in the search bar") do
  @search_screen = SearchScreen.new
  expect(@search_screen.search_help_text.displayed?).to be_truthy
end

And("I tap on any show in the result") do
  @search_screen = VideoScreen.new
  expect(@search_screen.test_video_thumbnail.displayed?).to be_truthy
  @search_screen.test_video_thumbnail.click
end

Then("I see shows detail page") do
  @search_screen = SearchScreen.new
  expect(@search_screen.search_show_details_title.displayed?).to be_truthy
  expect(@search_screen.search_show_details_desc.displayed?).to be_truthy
end

Then("I see 'Popular Shows this week' and 'Trending Now' rails") do
  @search_screen = SearchScreen.new
  expect(@search_screen.popular_shows.displayed?).to be_truthy
  expect(@search_screen.trending_now.displayed?).to be_truthy
end
