Given("I am on the show with multiple season screen") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.show_with_seasons[:deeplink_id]}")
end

Given("I am on the show with one season screen") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.show_search[:deeplink_id]}")
end

When("I click on season picker option") do
  @show_screen = ShowScreen.new
  expect(@show_screen.season_picker.displayed?).to be_truthy
  @show_screen.season_picker.click
end

Then("I see seasons are in sorted order") do
  @show_screen = ShowScreen.new
  total_seasons = @show_screen.season_number.size
  seasons = @show_screen.season_number
  (0..total_seasons - 2).each do |i|
    @show_screen.wait_until(30) { seasons[i].displayed? }
    first_dropdown_season = seasons[i].text.split(" ")[1].to_i
    @show_screen.wait_until(30) { seasons[i + 1].displayed? }
    second_dropdown_season = seasons[i + 1].text.split(" ")[1].to_i
    expect(first_dropdown_season > second_dropdown_season).to be_truthy
  end
end

Then("I see there is only one season in show") do
  @show_list_screen = ShowListScreen.new
  season_dropdown_value = @show_list_screen.season_dropdown.text
  expect(season_dropdown_value.eql?("SEASON 1")).to be_truthy
end

When("I select season from season picker") do
  @show_screen = ShowScreen.new
  season_selection_index = 1
  seasons = @show_screen.season_number
  @selected_season = seasons[season_selection_index].text
  expect(seasons[season_selection_index].displayed?).to be_truthy
  seasons[season_selection_index].click
end

Then("I see opened season as per selected season") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.season_picker.displayed? }
  opened_season_no = @show_screen.season_picker.text.split(" ")[1].to_i
  selected_season_no = @selected_season.split(" ")[1].to_i
  expect(opened_season_no == selected_season_no).to be_truthy
end
