When(/^I search a show that is not present$/) do
  @search_screen = SearchScreen.new
  @search_screen.search_icon.click
  @search_screen.search_field.displayed?
  @search_screen.search_field.send_keys("AAAAA")
end

Then(/^no results are returned in the search$/) do
  @search_screen = SearchScreen.new
  driver.hide_keyboard
  expect(@search_screen.no_results_text.displayed?).to be true
end

When("I type a show name on search bar") do
  @search_screen = SearchScreen.new
  @search_screen.search_field.displayed?
  @search_screen.search_field.send_keys("Deadly Devotion")
end

When("I tap on close icon in search bar") do
  @search_screen = SearchScreen.new
  @search_screen.clear_text.click
end

Then("I see text entered in the search bar is cleared") do
  @search_screen = SearchScreen.new
  expect(@search_screen.search_field.value == "Search Shows, Episodes and more").to be true
end

Then("I see {string} listname") do |carousel_name|
  @search_screen = SearchScreen.new
  @search_screen.wait_until(15) { expect(@search_screen.search_by_name(carousel_name).first.displayed?).to be_truthy }
end

Then("I see {string} carousel on searchpage") do |carousel_name|
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { expect(@search_screen.search_screen_carousels(carousel_name).size.positive?).to be_truthy }
end

Then("I see Metadata on the {string} tiles containing thumbnail image, title") do |carousel_name|
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { expect(@search_screen.search_screen_carousels(carousel_name).size.positive?).to be_truthy }
  @search_screen.wait_until(30) { expect(@search_screen.search_screen_carousels(carousel_name).first.displayed?).to be_truthy }
  expect(@search_screen.search_screen_carousel_elements(carousel_name).first.name.empty?).not_to be_truthy
end
