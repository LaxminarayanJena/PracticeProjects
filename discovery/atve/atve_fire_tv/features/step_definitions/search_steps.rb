Given("I search an invalid show") do
  @search_screen = SearchScreen.new
  @home_screen = HomeScreen.new
  step "I am on the Menu Bar"
  step "I navigate to 'Search' screen"
  @search_screen.wait_until(60) { expect(@search_screen.search_box.displayed?).to be true }
  @search_screen.search_box.send_keys("AAAAAAA")
  @search_screen.press_media_play_pause
end

When("I type {string} in search text field") do |text|
  @search_screen.search_box.send_keys(text)
end

Then("I should see no results found message and curated recommendations") do
  @search_screen.wait_until(60) { expect(@search_screen.search_no_results_msg.displayed?).to be_truthy }
  step "I see a manually curated 'Popular Shows' rail of content Recommendations"
  step "I see a manually curated 'Trending Now' rail of content Recommendations"
end

Given("I search a show") do
  step "I am on the Menu Bar"
  step "I navigate to 'Search' screen"
  @search_screen.wait_until(60) { @search_screen.search_box.displayed? }
  @search_screen.search_box.send_keys("Alaska")
  @search_screen.press_media_play_pause
end

When("I select the show's card in search screen") do
  @search_screen.wait_until(60) { expect(@search_screen.search_header.displayed?).to be true }
  @search_screen.wait_until(60) { expect(@search_screen.search_showtitle.displayed?).to be true }
  expect(@search_screen.wait_until(60) { @search_screen.search_showslist.size.positive? }).to be_truthy
  @shows_screen.press_select
end

Then("I see keypad is enabled") do
  expect(@search_screen.driver.is_keyboard_shown).to be_truthy
  @search_screen.driver.hide_keyboard
end

When("I click on search bar") do
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  @search_screen.press_right
  @search_screen.search_box.click
end

Then("I see a mock text on the Search input field") do
  @mock_text = @search_screen.search_box.text
  expect(@mock_text == "Search for Shows, Episodes and More").to be_truthy
end

Then("I see a manually curated {string} rail of content Recommendations") do |recm_rail|
  case recm_rail
  when "Trending Now"
    @home_screen.search_rail_by_name(recm_rail)
    expect(@search_screen.wait_until(30) { @search_screen.search_rails(recm_rail).displayed? }).to be_truthy
    @search_screen.wait_until(30) { expect(@search_screen.search_trendingnowshowlist.size.positive?).to be_truthy }
  when "Popular Shows this week"
    @home_screen.search_rail_by_name(recm_rail)
    expect(@search_screen.wait_until(30) { @search_screen.search_rails(recm_rail).displayed? }).to be_truthy
    @search_screen.wait_until(30) { expect(@search_screen.search_popularshowlist.size.positive?).to be_truthy }
  end
end

Then("I see entered string is displayed on the search bar") do
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  expect(@search_screen.search_box.text == "Alaska").to be true
end

When("I navigate to any other screen and back to Search screen") do
  @search_screen.press_down
  @search_screen.press_left
  step "I navigate to 'Shows' screen"
  @search_screen.press_left
  step "I navigate to 'Search' screen"
end

And("do forward scroll on shows in {string}") do |rail|
  @search_screen.wait_until(30) { @search_screen.search_show_title(rail).displayed? }
  @before_carousel_text = @search_screen.search_show_title(rail).text
  @forward_scroll_count = @search_screen.search_show_list(rail).size
  @forward_scroll_count.times { @search_screen.press_right }
  @after_carousel_text = @search_screen.search_show_title(rail).text
end

And("do backward scroll on shows in {string}") do |rail|
  @before_carousel_text = @after_carousel_text
  @forward_scroll_count.times { @search_screen.press_left }
  @after_carousel_text = @search_screen.search_show_title(rail).text
end

And("I scroll show list horizontally forward and backward in {string} rail") do |scroll_rail|
  case scroll_rail
  when "Trending Now"
    @home_screen.search_rail_by_name(scroll_rail)
    @search_screen.press_down
    expect(@search_screen.wait_until(30) { @search_screen.search_rails(scroll_rail).displayed? }).to be_truthy
    @search_screen.wait_until(30) { expect(@search_screen.search_show_list(scroll_rail).size.positive?).to be_truthy }
    step "do forward scroll on shows"
    expect(@before_carousel_text == @after_carousel_text).to be false
    step "do backward scroll on shows"
  when "Popular Shows this week"
    @home_screen.search_rail_by_name(scroll_rail)
    expect(@search_screen.wait_until(60) { @search_screen.search_rails(scroll_rail).displayed? }).to be_truthy
    @search_screen.wait_until(60) { expect(@search_screen.search_show_list(scroll_rail).size.positive?).to be_truthy }
    step "do forward scroll on shows in 'Popular Shows this week'"
    expect(@before_carousel_text == @after_carousel_text).to be false
    step "do backward scroll on shows in 'Popular Shows this week'"
  when "Shows"
    @home_screen.search_rail_by_name(scroll_rail)
    expect(@search_screen.wait_until(60) { @search_screen.search_rails(scroll_rail).displayed? }).to be_truthy
    puts @search_screen.search_show_list(scroll_rail).size
    @search_screen.wait_until(60) { expect(@search_screen.search_show_list(scroll_rail).size.positive?).to be_truthy }
    step "do forward scroll on shows in 'Shows'"
    expect(@before_carousel_text == @after_carousel_text).to be false
    step "do backward scroll on shows in 'Shows'"
  when "Episodes"
    @home_screen.search_rail_by_name(scroll_rail)
    expect(@search_screen.wait_until(60) { @search_screen.search_rails(scroll_rail).displayed? }).to be_truthy
    @search_screen.wait_until(60) { expect(@search_screen.search_show_list(scroll_rail).size.positive?).to be_truthy }
    step "do forward scroll on shows in 'Episodes'"
    expect(@before_carousel_text == @after_carousel_text).to be false
    step "do backward scroll on shows in 'Episodes'"
  end
end

Then("I verify horizantal carousel functionality") do
  expect(@before_carousel_text == @after_carousel_text).to be false
end
