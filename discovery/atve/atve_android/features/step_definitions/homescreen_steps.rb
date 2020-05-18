Given("I am on home screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_icon.displayed? }
end

When("I see home hero") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_hero.displayed? }
end

When("I start home hero series") do
  step "I see home hero"
  @home_screen.home_hero.click
end

Then("I should see the series name and description") do
  # pending
end

Then("I should see blank screen") do
  # pending
end

When("I see {string} carousel on homepage") do |carousel_name|
  @home_screen = HomeScreen.new
  if carousel_name == "Shows"
    @home_screen.scroll_to_most_popular_episodes_this_month
    @home_screen.scroll_to_shows
    expect(@home_screen.shows_header_desc.displayed?).to be_truthy
  elsif carousel_name == "Just Added Shows"
    @home_screen.scroll_to_most_popular_episodes_this_month
    @home_screen.scroll_to_just_added_shows
    expect(@home_screen.just_added_header_desc.displayed?).to be_truthy
  elsif carousel_name == "Most Popular Shows"
    @home_screen.scroll_to_most_popular_shows
    expect(@home_screen.most_popular_shows_header_desc.displayed?).to be_truthy
  elsif carousel_name == "Most popular Episodes this month"
    @home_screen.scroll_to_most_popular_episodes_this_month
    expect(@home_screen.most_popular_episodes_this_month_header_desc.displayed?).to be_truthy
  elsif carousel_name == "Continue Watching"
    step "I am on video landing screen"
    step "I scrub forward on the Video"
    driver.press_keycode(4)
    @home_screen.home_icon.click
    @home_screen.scroll_to_continue_watching
    expect(@home_screen.continue_watching_header_desc.displayed?).to be_truthy
  end
end

Then("I see Just Added Shows rail with tiles") do
  @home_screen = HomeScreen.new
  max_swapping_round = 3
  start_tile_index = 1
  @home_screen.scroll_to_just_added_shows
  start_x = @home_screen.just_added_header_desc.location.x + 600
  start_y = @home_screen.just_added_header_desc.location.y + 250
  end_x = start_x - 400
  end_y = start_y
  (1..max_swapping_round).each do |_i|
    expect(@home_screen.just_added_tiles(start_tile_index).displayed?).to be_truthy
    expect(@home_screen.just_added_tiles(start_tile_index + 1).displayed?).to be_truthy
    @home_screen.scroll_by_coordinates(start_x, start_y, end_x, end_y)
  end
end

Then("I scroll horizontally {string} for {string} rail tiles and verify") do |direction, carousel|
  @home_screen = HomeScreen.new
  start_x = @home_screen.rail_header_name(carousel).location.x + 600
  start_y = @home_screen.rail_header_name(carousel).location.y + 250
  end_x = start_x - 400
  end_y = start_y
  case direction
  when "left"
    tile_before_scroll = @home_screen.carousel_tile_name(carousel).text
    @home_screen.scroll_by_coordinates(start_x, start_y, end_x, end_y)
    tile_after_scroll = @home_screen.carousel_tile_name(carousel).text
  when "right"
    tile_before_scroll = @home_screen.carousel_tile_name(carousel).text
    @home_screen.scroll_by_coordinates(end_x, start_y, start_x, end_y)
    tile_after_scroll = @home_screen.carousel_tile_name(carousel).text
  end
  @home_screen.wait_until(30) { expect(tile_before_scroll != tile_after_scroll).to be_truthy }
end
