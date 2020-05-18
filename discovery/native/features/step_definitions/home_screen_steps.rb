When("I play the hero episode") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.hero_play.displayed? }
  @home_screen.hero_play.click
end

When("I play a locked episode") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.locked_episode}")
  @video = VideoScreen.new
  @video.wait_until(60) { @video.video_container.displayed? }
end

When("I should be able to watch live tv") do
  # driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://livestreams/55c51d996b66d1dd7abfbc55")
  # driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://live/55c51d996b66d1dd7abfbc55")
  @home_screen = HomeScreen.new
  @video = VideoScreen.new
  @home_screen.scroll_to_idgolists
  expect(@video.live_icon.displayed?).to be_truthy
  @home_screen.live_video.click
end

When("I deeplink to watch live") do
  # This is currently broken because the path is set incorrectly as /livestream
  # This test should fail.
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://live/#{NETWORK_DATA.watch_live}")
end

Then("I can see live tv") do
  @video = VideoScreen.new
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 3, base_interval: 1) do
    @video.wait_until(30) { @video.video_container.displayed? }
    @video.wait_until { @video.live_icon.displayed? }
  end
end

When("I view the {string} carousel") do |carousel_name|
  @home_screen = HomeScreen.new
  if carousel_name == "RECOMMENDED FOR YOU"
    @home_screen.scroll_to_recommended
    expect(@home_screen.recommended_header_desc.displayed?).to be_truthy
  elsif carousel_name == "RECENT EPISODES"
    @home_screen.scroll_to_live
    @home_screen.scroll_to_recent
    expect(@home_screen.recent_episodes_header_desc.displayed?).to be_truthy
  end
end

And("I check the episode info") do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_info_button_by_coordinates
  expect(@home_screen.recent_episodes_info_option.displayed?).to be_truthy
  @home_screen.recent_episodes_info_option.click
end

And("I should see episode details") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.recent_episode_info_text.displayed?).to be_truthy }
end

And("I should be able to play the recent episode") do
  @home_screen = HomeScreen.new
  expect(@home_screen.recent_episodes_play_button.displayed?).to be_truthy
  @home_screen.recent_episodes_play_button.click
end

Then("I see live et badge on live stream module and click on epicode") do
  @home_screen = HomeScreen.new
  @video_screen = VideoScreen.new
  @home_screen.scroll_to_live_on_id
  @home_screen.wait_until(30) { expect(@video_screen.live_icon.displayed?).to be_truthy }
  @home_screen.live_video.click
end

And("I should be able to click on play button") do
  @home_screen = HomeScreen.new
  expect(@home_screen.recent_episode_info_text.displayed?).to be_truthy
  @home_screen.recent_episode_info_text.click
end

Then("I should see series title on episode tile") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.series_title.displayed?).to be_truthy }
end

And("I scroll down to see up next video") do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_up_next
  expect(@home_screen.scroll_to_up_next.displayed?).to be_truthy
end

And("I Tap on any episode") do
  @home_screen = HomeScreen.new
  expect(@home_screen.up_next_episodes_play_button.displayed?).to be_truthy
  @home_screen.up_next_episodes_play_button.click
end
