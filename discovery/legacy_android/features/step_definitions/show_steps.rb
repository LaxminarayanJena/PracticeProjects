Given("I am on a show screen") do
  step "select a show from show list"
end

Given("I am on a locked show screen") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.show_with_seasons[:deeplink_id]}")
end

When("I check the show info") do
  @show_screen = ShowScreen.new
  @show_list_screen = ShowListScreen.new
  expect(@show_list_screen.hero_show_info.displayed?).to be_truthy
  @show_list_screen.hero_show_info.click
  expect(@show_screen.info_layout.displayed?).to be_truthy
end

Then("I should see information about the show") do
  @show_screen = ShowScreen.new
  expect(@show_screen.info_title.text == "About The Show").to be_truthy
  expect(!@show_screen.info_text.text.empty?).to be_truthy
end

When("I check the episode info") do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_home_info.displayed?).to be_truthy
  @episode_no = @show_screen.episode_count.size
  @show_screen.show_home_info.click
  expect(@show_screen.info_text.displayed?).to be_truthy
end

Then("I should see episode details") do
  @show_screen = ShowScreen.new
  expect(!@show_screen.show_hero.text.empty?).to be_truthy
  expect(!@show_screen.first_episode_title.text.empty?).to be_truthy
  expect(!@show_screen.info_text.text.empty?).to be_truthy
  expect(!@show_screen.first_episode_season_number.text.empty?).to be_truthy if @episode_no.positive?
  @show_screen.watch_list_popup.click
end

Then("I should not be able to play any episode") do
  @show_screen = ShowScreen.new
  @show_screen.show_home_info.click
  @show_screen.info_text.displayed?
  @show_screen.play_episode_btn.click
  expect(@show_screen.search_providers.displayed?).to be_truthy
  @show_screen.hamburger_icon.click
end

And("I should be able to play the episode after logging in") do
  step "I'm on the home screen"
  step "I log in with a valid provider"
  step "User has to be logged in"
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.show_with_seasons[:deeplink_id]}")
  @show_screen = ShowScreen.new
  @show_screen.show_home_info.click
  @show_screen.info_text.displayed?
  @show_screen.play_episode_btn.click
  step "I should see the video playing"
end

Given("I have selected a show that has multiple seasons") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://shows/#{NETWORK_DATA.show_with_seasons[:deeplink_id]}")
end

When("I change the season") do
  @show_screen = ShowScreen.new
  initial_season = @show_screen.show_season_selector.text
  @show_screen.change_season
  expect(initial_season).not_to eq(@show_screen.show_season_selector.text)
end

Then("I should see episodes for the new season") do
  @show_screen = ShowScreen.new
  expect(@show_screen.first_episode_season_number.text.downcase.include?(@show_screen.show_season_selector.text.downcase)).to be_truthy
end

Then("I see show title on show detail screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.show_hero.displayed?).to be_truthy }
end

Then("I see show key art on show details screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.show_key_art.displayed?).to be_truthy }
end

Then("I see affiliate logo on top right corner on show detail screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.affiliate_img.displayed?).to be_truthy }
end

Then("I see affiliate screen on playing locked show episode") do
  @show_screen = ShowScreen.new
  @show_screen.show_home_info.click
  @show_screen.info_text.displayed?
  @show_screen.play_episode_btn.click
  expect(@show_screen.search_providers.displayed?).to be_truthy
end

Then("I see Watch more shows like this option on episodes tile") do
  @show_screen = ShowScreen.new
  max_swipping_round = 5
  @show_screen.wait_until(30) { expect(@show_screen.show_hero.displayed?).to be_truthy }
  (1..max_swipping_round).each do |_i|
    @show_screen.scroll_to_last_episode_by_coordinates
  end
  @show_screen.wait_until(30) { expect(@show_screen.watch_more_shows_like_this_btn.displayed?).to be_truthy }
end

And("I tap on Watch more shows like this button") do
  step "I see Watch more shows like this option on episodes tile"
  @show_screen = ShowScreen.new
  @show_screen.watch_more_shows_like_this_btn.click
end

Then("I see list of Similar Shows opens in another screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.similar_shows.displayed?).to be_truthy }
end

Then("I go back to Show detail from similar shows") do
  step "I click on back button"
  @show_screen = ShowScreen.new
  max_swipping_round = 5
  start_x_coordinate = driver.window_size.width - 50
  start_y_coordinate = driver.window_size.height - 500
  end_x_coordinate = start_x_coordinate
  end_y_coordinate = start_y_coordinate + 400
  (1..max_swipping_round).each do |_i|
    @show_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end
  @show_screen.wait_until(30) { expect(@show_screen.show_hero.displayed?).to be_truthy }
end

Then("I see share icon on Show Art") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.share_icon.displayed?).to be_truthy }
end

Then("I see episode art on each episode") do
  @show_screen = ShowScreen.new
  max_swipping_round = 5
  (1..max_swipping_round).each do |_i|
    size = @show_screen.episode_art.size
    episode = @show_screen.episode_art
    (1..size - 1).each do |j|
      @show_screen.wait_until(30) { expect(episode[j].displayed?).to be_truthy }
    end
    @show_screen.scroll_to_last_episode_by_coordinates
  end
end

Then("I see play icon on each episode") do
  @show_screen = ShowScreen.new
  max_swipping_round = 5
  (1..max_swipping_round).each do |_i|
    size = @show_screen.play_icon.size
    icons = @show_screen.play_icon
    (1..size - 1).each do |j|
      @show_screen.wait_until(30) { expect(icons[j].displayed?).to be_truthy }
    end
    @show_screen.scroll_to_last_episode_by_coordinates
  end
end

Then("I see episode listed in order of newest to oldest") do
  @show_screen = ShowScreen.new
  episode_no_list = []
  episode_index = 0
  max_swipping_round = 2
  @show_screen.scroll_to_last_episode_by_coordinates
  (1..max_swipping_round).each do |_i|
    size = @show_screen.episode_count.size
    episodes = @show_screen.episode_count
    (0..size - 1).each do |j|
      first_episode_number = episodes[j].text.split(" ")[4].to_i
      episode_no_list[episode_index] = first_episode_number
      episode_index += 1
    end
    @show_screen.scroll_to_last_episode_by_coordinates
  end
  (1..episode_no_list.size - 2).each do |i|
    expect(episode_no_list[i] > episode_no_list[i + 1] || episode_no_list[i] == episode_no_list[i + 1]).to be_truthy
  end
end

Then("I see locked key for unathenticated content") do
  @show_screen = ShowScreen.new
  @show_list = ShowListScreen.new
  max_swipping_round = 5
  (1..max_swipping_round).each do |_i|
    size = @show_list.lock_icon.size
    icons = @show_list.lock_icon
    (1..size - 1).each do |j|
      @show_list.wait_until(30) { expect(icons[j].displayed?).to be_truthy }
    end
    @show_screen.scroll_to_last_episode_by_coordinates
  end
end

Then("I see all contents are watchable in selected season") do
  step "I see play icon on each episode"
  step "I play any episode"
  step "I should see the video playing"
end
