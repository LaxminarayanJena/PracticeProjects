Given("I am on show with multiple season page") do
  @shows_screen = ShowScreen.new
  @search_screen = SearchScreen.new
  step "I go to the 'Search' screen"
  @search_screen.wait_until(30) { @search_screen.search_text_field.displayed? }
  @search_screen.search_text_field.send_keys(NETWORK_DATA.show_with_seasons[:show_name])
  @shows_screen.show_thumbnail.click
end

When("I see the season numbers listed") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.season_picker_rail.displayed?).to be_truthy }
end

Then("I see the latest season listed first and the other seasons listed in decreasing order") do
  @shows_screen = ShowScreen.new
  latest_season = @shows_screen.listed_seasons[0].text.split(" ")[1].to_i
  total_seasons = @shows_screen.listed_seasons.size
  (1..total_seasons - 1).each do |season|
    next_season = @shows_screen.listed_seasons[season].text.to_i
    expect(latest_season > next_season).to be_truthy
    latest_season = next_season
  end
end

When("I select any of the available seasons") do
  @shows_screen = ShowScreen.new
  available_seasons = @shows_screen.listed_seasons.size
  to_select_season = 0
  if available_seasons > 1
    @selected_season = @shows_screen.listed_seasons[to_select_season + 1].text.to_i
    @shows_screen.listed_seasons[to_select_season + 1].click
  else
    @selected_season = @shows_screen.listed_seasons[to_select_season].text.split(" ")[1].to_i
  end
end

When("I see episodes in order of newest episode to oldest episode for that season") do
  @shows_screen = ShowScreen.new
  max_swapping_round = 3
  (1..max_swapping_round).each do |_i|
    episode_numbers = @shows_screen.selected_season_episode_numbers(@selected_season).size
    (0..episode_numbers - 2).each do |episode_index|
      first_episode_number = @shows_screen.selected_season_episode_numbers(@selected_season)[episode_index].text.split("E")[1].to_i
      second_episode_number = @shows_screen.selected_season_episode_numbers(@selected_season)[episode_index + 1].text.split("E")[1].to_i
      expect(first_episode_number >= second_episode_number).to be_truthy
    end
    @shows_screen.scroll_to_traves_complete_episode_list
  end
end

When("I see corresponding season is in selected state") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.selected_state_season(@selected_season).displayed?).to be_truthy }
end

When("I see season listed first in the seasons list is selected by Default") do
  @shows_screen = ShowScreen.new
  selected_season = @shows_screen.listed_seasons[0].text
  expect(selected_season.include?("Season")).to be_truthy
end
