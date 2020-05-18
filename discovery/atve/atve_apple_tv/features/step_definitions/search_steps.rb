Given("I search a valid show in Apple TV") do
  @search_screen = SearchScreen.new
  step "I am on a Search screen in Apple TV"
  step "I should see search box on Search screen"
  @search_screen.press_select
  @search_screen.search_show_send_keys(NETWORK_DATA.show_search[:show_name])
  3.times { @search_screen.press_down }
  @search_screen.search_button.click
end

Then("I should see no results found message") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_no_results_msg.displayed? }
  expect(@search_screen.search_no_results_msg.displayed?).to be true
end

Then("I see a mock text on the Search input field") do
  @search_screen = SearchScreen.new
  @expected_mock_text = "Search Shows, Episodes and more"
  @actual_mock_text = @search_screen.search_mock_text.text
  expect(@expected_mock_text.include?(@actual_mock_text)).to be true
end

When("I see and navigate to {string} rail on search page") do |carousel_name|
  @search_screen = SearchScreen.new
  case carousel_name
  when "Popular Shows this week"
    @search_screen.press_down
    @search_screen.wait_until(30) { expect(@search_screen.carousels(carousel_name).size.positive?).to be_truthy }
  when "Trending Now "
    2.times { @search_screen.press_down }
    @search_screen.wait_until(30) { expect(@search_screen.carousels(carousel_name).size.positive?).to be_truthy }
  else
    "No Matching carousel found, please enter valid carousel name"
  end
end

Given("I enter search string and click Next from keypad") do
  step "I search a valid show in Apple TV"
end

When("I navigate to any other page") do
  step "I should see search box on Search screen"
  step "I navigate and select 'Home' icon from search"
end

Then("I navigate back to Search screen") do
  step "I am on a Search screen in Apple TV"
end

And("I see search page is refreshed") do
  step "I should see search box on Search screen"
  puts "Search box should clear after screen refreshed, has not implemented yet"
  pending
end
