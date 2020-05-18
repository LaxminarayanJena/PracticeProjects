Then("I see the episode description") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.hero_show_description.displayed? }
  expect(!@show_screen.hero_show_description.text.empty?).to be_truthy
end

Given("I am on an unlocked episode screen") do
  step "I'm on the home screen"
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.unlocked_episode}")
end

Given("I am on an unlocked show screen") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.unlocked_show}")
end

When("I select an unlocked episode to view") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.season_episode_card.displayed? }
  @show_screen.season_episode_card.click
end

Then("I should see the unlocked video playing") do
  step "I should see the video playing"
end

When("I tap on episode info") do
  @show_screen = ShowScreen.new
  @show_screen.scroll_to_info_button_by_coordinates
  @show_screen.wait_until(60) { @show_screen.episode_info.displayed? }
  @show_screen.episode_info.click
end

Then("I should see the episode screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.episode_description.displayed? }
  expect(@show_screen.show_description.displayed?).to be_truthy
end

Then("I select a up next video") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.episode_card.displayed? }
  @show_screen.episode_card.click
end

When("I tap on any show on shows list") do
  @show_screen = ShowScreen.new
  visible_start_x = @show_screen.device_width - 500
  visible_start_y = @show_screen.device_height - 500
  visible_end_x = visible_start_x - 0
  visible_end_y = visible_start_y - 400
  @show_screen.scroll_by_coordinates(visible_start_x, visible_start_y, visible_end_x, visible_end_y)
  start_x_coordinate = @show_screen.shows_list.location.x + 50
  start_y_coordinate = @show_screen.shows_list.location.y
  end_x_coordinate = @show_screen.shows_list.location.x + 50
  elelment_loc_check_wrt_height = @show_screen.device_height / 2
  end_y_coordinate = if start_y_coordinate > elelment_loc_check_wrt_height
                       start_y_coordinate + 0
                     else
                       start_y_coordinate + 150
                     end
  @show_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  @show_screen.wait_until(60) { @show_screen.shows_list }
  expect(@show_screen.shows_list.displayed?).to be_truthy
  @show_screen.shows_list.click
end

Then("I see hero show art on show details screen for selected show") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
end

Then("I see affiliate logo on top right corner on show screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { expect(@home_screen.affiliate_logo.displayed?).to be_truthy }
end

When("I tap on any show from shows list for valid user") do
  @show_screen = ShowScreen.new
  visible_start_x = @show_screen.device_width - 500
  visible_start_y = @show_screen.device_height - 500
  visible_end_x = visible_start_x - 0
  visible_end_y = visible_start_y - 400
  @show_screen.scroll_by_coordinates(visible_start_x, visible_start_y, visible_end_x, visible_end_y)
  start_x_coordinate = @show_screen.shows_list_authenticate.location.x + 50
  start_y_coordinate = @show_screen.shows_list_authenticate.location.y
  end_x_coordinate = start_x_coordinate + 50
  elelment_loc_check_wrt_height = @show_screen.device_height / 2
  end_y_coordinate = if elelment_loc_check_wrt_height > start_y_coordinate
                       start_y_coordinate + 0
                     else
                       start_y_coordinate - 200
                     end
  @show_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  @show_screen.wait_until(60) { @show_screen.shows_list_authenticate }
  expect(@show_screen.shows_list_authenticate.displayed?).to be_truthy
  @show_screen.shows_list_authenticate.click
end
