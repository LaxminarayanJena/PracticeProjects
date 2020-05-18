Given("I am on video landing screen") do
  @shows_screen = ShowScreen.new
  @video_screen = VideoScreen.new
  step "I am on show details screen"
  @shows_screen.wait_until(30) { @shows_screen.first_episode_description[3].displayed? }
  @shows_screen.first_episode_description[3].click
end

Then("video plays in portrait mode by default") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.size.positive?).to be_truthy }
  mode = driver.orientation
  expect(mode).to eq :portrait
end

Then("video metadata should be visible") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(20) { expect(@video_screen.video_title.displayed?).to be_truthy }
  @video_screen.wait_until(20) { expect(@video_screen.video_desc.displayed?).to be_truthy }
end

And("I change the video to landscape") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.size.positive?).to be_truthy }
  @video_screen.test_video_player.first.click
  @video_screen.wait_until(30) { expect(@video_screen.fullscreen_landscape_mode_btn.displayed?).to be_truthy }
  @video_screen.fullscreen_landscape_mode_btn.click
end

Then("the video plays in landscape mode") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.size.positive?).to be_truthy }
  mode = driver.orientation
  expect(mode).to eq :landscape
end

Then("I Validate metadata on landscape mode") do
  @video_screen = VideoScreen.new
  show_title = @video_screen.video_title.text
  step "I change the video to landscape"
  @video_screen.wait_until(30) { @video_screen.search_by_name(show_title).size.positive? }
end

Then("I close video player and validate") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { @video_screen.video_close_button.displayed? }
  @video_screen.video_close_button.click
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.size.positive?).to be_falsey }
end

Then("The video plays correctly") do
  # rubocop:disable Custom/SleepCop
  @video_screen = VideoScreen.new
  sleep(10)
  initial_time_from = @video_screen.video_playing_time_return_time
  sleep(10)
  elapsed_time_to = @video_screen.video_playing_time_return_time
  expect(initial_time_from).to be < elapsed_time_to
  # rubocop:enable Custom/SleepCop.
end

Then("I scrub forward on the video and check playback time increased correctly") do
  # rubocop:disable Custom/SleepCop
  @video_screen = VideoScreen.new
  sleep(10)
  initial_time_from = @video_screen.video_playing_time_return_time
  sleep(10)
  elapsed_time_to = @video_screen.video_playing_time_return_time
  expect(initial_time_from).to be < elapsed_time_to
  # rubocop:enable Custom/SleepCop.
end

Then("I scrub backward on the video and check playback time decreased correctly") do
  # rubocop:disable Custom/SleepCop
  @video_screen = VideoScreen.new
  sleep(10)
  initial_time_from = @video_screen.video_playing_time_return_time
  sleep(10)
  elapsed_time_to = @video_screen.video_playing_backward_time_return
  expect(initial_time_from).to be < elapsed_time_to
  # rubocop:enable Custom/SleepCop.
end
