Given("I am on Shows screen") do
  @shows_screen = BaseScreen.new
  @shows_screen.wait_until(30) { @shows_screen.shows_icon.displayed? }
  @shows_screen.shows_icon.click
end

Then("A list of shows are displayed") do
  @shows_screen = ShowScreen.new
  expect(@shows_screen.list_of_shows.count).to be >= 1
end

When("I select a show") do
  @shows_screen = ShowScreen.new
  @shows_screen.list_of_shows.first.click
end

Given("I am on show details page") do
  @shows_screen = ShowScreen.new
  @search_screen = SearchScreen.new
  step "I go to the 'Search' screen"
  @search_screen.wait_until(30) { @search_screen.search_text_field.displayed? }
  @search_screen.search_text_field.send_keys(NETWORK_DATA.show_search[:show_name])
  @shows_screen.show_thumbnail.click
end

When("I click {string} option on first available episode description") do |option|
  @shows_screen = ShowScreen.new
  @shows_screen.more_less_option(option).click
end

Then("I see description option changed to {string} option") do |after_option|
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.more_less_option(after_option).displayed?).to be_truthy }
end

Then("I see episode description") do
  @shows_screen = ShowScreen.new
  episode_dec = @shows_screen.eposode_description
  @shows_screen.wait_until(30) { expect(episode_dec[1].displayed?).to be_truthy }
end

Then("I see episode metadata for episode art , title , number and duration") do
  @shows_screen = ShowScreen.new
  size = @shows_screen.episode_image.size
  max_swapping_round = 3
  (1..max_swapping_round).each do |_i|
    (1..size - 1).each do |j|
      @shows_screen.wait_until(30) { expect(@shows_screen.episode_image[j].displayed?).to be_truthy }
      @shows_screen.wait_until(30) { expect(@shows_screen.episode_number[j].displayed?).to be_truthy }
      @shows_screen.wait_until(30) { expect(@shows_screen.episode_name[j].displayed?).to be_truthy }
      @shows_screen.wait_until(30) { expect(@shows_screen.episode_duration[j].displayed?).to be_truthy }
    end
    @shows_screen.scroll_to_traves_complete_episode_list
  end
end

Then("I see episode list in the season") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_list.displayed?).to be_truthy }
end

Then("I see show hero on top") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.show_hero_image.displayed?).to be_truthy }
end

Then("I see Show Title over the Show Hero") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.show_hero_title.displayed?).to be_truthy }
end
