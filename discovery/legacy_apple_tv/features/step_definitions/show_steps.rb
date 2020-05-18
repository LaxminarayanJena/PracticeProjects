Given("I am on a show screen in Apple TV") do
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }
  @show_screen.navigate_to_shows
end

When("I goto show info") do
  @show_screen = ShowScreen.new
  @show_title_list = @show_screen.show_title
  @show_screen.press_down
  @outer_show_get_title = @show_title_list[2].text
  @show_title_list[2].click
  @show_subtitle_list = @show_screen.show_inner_titles
  @inner_show_get_title = @show_subtitle_list[0].text
  expect(@outer_show_get_title == @inner_show_get_title).to be_truthy
end

Then("I should see information about the show") do
  @home_screen = HomeScreen.new
  @show_screen = ShowScreen.new
  @show_subtitle_list = @show_screen.show_inner_titles
  @show_subtitle_list[1].displayed?
  @home_screen.play_latest_button.displayed?
  @home_screen.play_more_seasons_button.displayed?
  @home_screen.play_favourites_button.displayed?
end

When("I goto Show tab") do
  @show_screen = ShowScreen.new
  @show_title_list = @show_screen.show_title
  @show_screen.press_down
  @show_screen.navigate_to_second_show
end

Then("I should scroll down & scroll up through videos") do
  @show_screen = ShowScreen.new
  6.times { @show_screen.press_down }
  @show_screen.press_right
  6.times { @show_screen.press_up }
  @show_screen.wait_until(30) { @show_screen.show_title[2].displayed? }
end

When("I select the show under Show tab") do
  @show_screen = ShowScreen.new
  @show_screen.navigate_to_shows
  @show_title_list = @show_screen.show_title
  @show_screen.press_down
  @show_title_list[2].click
end

And("I click on play button under Show tab") do
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.play_latest_button.displayed? }
  @home_screen.play_latest_button.click
end

Then("I should see video playing under show tab") do
  @home_screen = HomeScreen.new
  if @home_screen.check_start_from_beginning_button.positive?
    @home_screen.press_down
    @home_screen.start_from_beginning_button.click
  end
  @home_screen.press_media_play_pause
  @home_screen.press_up
  @home_screen.press_right
  expect(@home_screen.time_scrubbing_value.gsub(":", ".").to_f).to be > 0.0
end

When("I scrub forward the same video") do
  @show_screen = ShowScreen.new
  step "I click on play button under Show tab"
  step "check for resume option is displayed"
  # rubocop:disable Custom/SleepCop.
  sleep(10)
  @show_screen.press_select
  @show_screen.press_down
  @show_screen.wait_until(30) { @show_screen.show_played_info_tab.displayed? }
  @inner_show_get_title = @show_screen.show_played_inner_text
  @show_screen.press_up
  sleep(5)
  # rubocop:enable Custom/SleepCop.
  2.times { @show_screen.press_menu }
  @show_screen.show_played_outer_text.displayed?
  @outer_show_get_title = @show_screen.show_played_outer_text.text
  expect(@outer_show_get_title.include?(@inner_show_get_title)).to be true
end

When("I click and play the same show from Episodes") do
  @show_screen = ShowScreen.new
  @show_screen.show_played_outer_text.click
end

Then("I should see Resume Playing and Start from Beginning buttons") do
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @show_screen.wait_until(30) { @show_screen.show_resume_playing_button.displayed? }
  @home_screen.wait_until(30) { @home_screen.start_from_beginning_button.displayed? }
end

When("I click on More seasons and select an episode") do
  @home_screen = HomeScreen.new
  @home_screen.play_more_seasons_button.displayed?
  @home_screen.play_more_seasons_button.click
  @more_season_list = @show_screen.show_inner_titles
  @more_season_outer_title = @more_season_list[0].text
  @more_season_inner_title = @show_screen.more_season_inner_title.text
  expect(@more_season_outer_title.include?(@more_season_inner_title)).to be true
end

Then("I visit one of the season and check season details are same") do
  @home_screen = HomeScreen.new
  @show_screen = ShowScreen.new
  @show_screen.more_season_inner_title.displayed?
  @season_list = @show_screen.more_season_list
  @inner_season_number = @show_screen.more_season_list[0].text
  @show_screen.more_season_list.first.click
  @more_season_list = @show_screen.show_inner_titles
  @outer_season_number = @more_season_list[1].text
  expect(@outer_season_number.include?(@inner_season_number)).to be true
end
