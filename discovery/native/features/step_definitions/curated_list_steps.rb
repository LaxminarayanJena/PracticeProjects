When("I tap on any tile in curated playlist") do
  @home_screen = HomeScreen.new
  start_x_coordinate = @home_screen.device_width - 50
  start_y_coordinate = @home_screen.device_height - 500
  end_x_coordinate = start_x_coordinate
  end_y_coordinate = 200
  @home_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  @home_screen.wait_until(30) { expect(@home_screen.curated_tile.displayed?).to be_truthy }
  @home_screen.curated_tile.click
end

Then("I see episode art on each episode") do
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  max_swipping_round = 10
  first_index_screen = 1
  max_index_screen = 3
  start_x_coordinate = @home_screen.device_width - 50
  start_y_coordinate = @home_screen.device_height - 500
  end_x_coordinate = start_x_coordinate
  end_y_coordinate = start_y_coordinate - 400
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
  @show_screen.wait_until(30) { expect(@show_screen.epicode_art(first_index_screen).displayed?).to be_truthy }
  (1..max_swipping_round).each do |_i|
    @home_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
    @show_screen.wait_until(30) { expect(@show_screen.epicode_art(first_index_screen).displayed?).to be_truthy }
  end
  @show_screen.wait_until(30) { expect(@show_screen.epicode_art(max_index_screen - 1).displayed?).to be_truthy }
  @show_screen.wait_until(30) { expect(@show_screen.epicode_art(max_index_screen).displayed?).to be_truthy }
end

When("I tap on any tile in curated playlist for valid user") do
  @home_screen = HomeScreen.new
  start_x_coordinate = @home_screen.device_width - 50
  start_y_coordinate = @home_screen.device_height - 500
  end_x_coordinate = start_x_coordinate
  end_y_coordinate = 200
  @home_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  @home_screen.wait_until(30) { expect(@home_screen.curated_tile_authenticate.displayed?).to be_truthy }
  @home_screen.curated_tile_authenticate.click
end
