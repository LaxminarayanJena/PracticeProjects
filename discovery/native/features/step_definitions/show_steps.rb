When("I check unlocked show info from the home screen") do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_info_button_by_coordinates
  @home_screen.wait_until(30) { @home_screen.show_info_button.displayed? }
  @home_screen.wait_until(30) { @home_screen.show_info_button.click }
end

Then("I should see information about the show") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.episode_description.displayed? }
  expect(@show_screen.episode_description.displayed?).to be_truthy
end
