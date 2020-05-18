# frozen_string_literal: true

Then(/^I check the show info option$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { expect(@show_screen.show_info.displayed?).to be_truthy }
end

Given("I login with valid provider and go to Shows screen from hamburger menu") do
  step "I'm on the home screen"
  step "I log in with a valid provider"
  step "I navigate to Shows from hamburger menu"
  step "I'm taken to Shows List Page"
end

Given("I'm anonymous user and go to Shows screen from hamburger menu") do
  step "I'm on the home screen"
  step "I navigate to Shows from hamburger menu"
  step "I'm taken to Shows List Page"
end

Then(/^I should be able to play the episode$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.show_home_info.first.displayed? }
  expect(@show_screen.show_home_info.first.displayed?).to be_truthy
  @show_screen.wait_until(60) { @show_screen.play_episode_button.displayed? }
  expect(@show_screen.play_episode_button.displayed?).to be_truthy
  @show_screen.play_episode_button.click
end

Given("I have selected a show that has multiple seasons") do
  @show_screen = ShowScreen.new
  @show_screen.search_show(NETWORK_DATA.show_with_seasons[:show_name])
end

Then("I change the season") do
  @show_screen = ShowScreen.new
  season = @show_screen.season_dropdown_menu.text
  @show_screen.season_dropdown_menu.click
  drop_season = @show_screen.select_season.text
  @show_screen.select_season.click
  expect(season != drop_season).to be_truthy
end

Then("I check the episode info") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.episode_tile.first.displayed? }
  @show_screen.wait_until(30) { @show_screen.show_home_info.first.displayed? }
  expect(@show_screen.show_home_info.first.displayed?).to be_truthy
  @show_screen.show_home_info.first.click
  @show_screen.wait_until(30) { @show_screen.play_episode.displayed? }
  expect(@show_screen.play_episode.displayed?).to be_truthy
  @show_screen.wait_until(30) { @show_screen.watch_later_add_remove_option.displayed? }
  expect(@show_screen.watch_later_add_remove_option.displayed?).to be_truthy
end

Then("I click on video back button") do
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(3)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 5, on_retry: retry_proc) do
    @video_screen = VideoScreen.new
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(60) { @video_screen.back_btn.displayed? }
    @video_screen.back_btn.click
  end
end

Then("I scroll down") do
  @lists_screen = LandingScreen.new
  @lists_screen.scroll_to_down
end

Then("I click on close button") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.close_btn.displayed? }
  @show_screen.close_btn.click
end

Then("I click on X close button") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.close_x_mark.displayed? }
  @show_screen.close_x_mark.click
end

Given("I select any show from show list") do
  @show_list_screen = ShowListScreen.new
  @show_list_screen.wait_until(30) { @show_list_screen.last_list_item.displayed? }
  @show_list_screen.last_list_item.click
end

Then("I see show title on show detail screen") do
  @show_list_screen = ShowListScreen.new
  @show_list_screen.wait_until(60) { expect(@show_list_screen.show_title_details_screen.text.empty?).to be_falsey }
  @show_title = @show_list_screen.show_title_details_screen.text
end

Then("I see affiliate logo on top right corner on show detail screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.affiliate_logo_img_on_shows.displayed?).to be_truthy }
end

Then("I click on episode key button and validate functionality") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.episode_key_button.first.displayed? }
  @show_screen.episode_key_button.first.click
  @show_screen.wait_until(30) { expect(@show_screen.signin_to_unlock_title.displayed?).to be_truthy }
end

Then("I exit from show list screen and search screen") do
  step "I exit show list screen"
  step "I exit search screen"
end

Then("I navigate back from video to landing screen") do
  step "I click on video back button"
  step "I exit show list screen"
  step "I click on close button"
end

Then("I navigate back from show details screen to landing screen") do
  step "I exit show list screen"
  step "I click on close button"
end

Then("I navigate back from episode details screen to landing screen") do
  step "I click on X close button"
  step "I exit show list screen"
  step "I click on close button"
end

Then("I navigate back from affiliate screen to landing screen") do
  step "I click on close button"
  step "I exit show list screen"
  step "I click on close button"
end

Then("I copy show title name") do
  @show_title_before = @show_title
end

Then("I compare show title name") do
  @show_screen = ShowScreen.new
  @show_title_after = @show_title
  @show_screen.wait_until(30) { expect(@show_title_before == @show_title_after).to be_falsey }
end

Then("I copy show title, go back to show list, scroll down and select show and compare titles") do
  step "I see show title on show detail screen"
  step "I copy show title name"
  step "I exit show list screen"
  step "I scroll down"
  step "I select any show from show list"
  step "I see show title on show detail screen"
  step "I compare show title name"
end
