When("I click on View Playlist button") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.btn_hero_action.displayed? }).to be true
  @home_screen.press_up
  @home_screen.press_select
end

And("I click on Start Show button") do
  @video_landing_screen = VideoLandingScreen.new
  @shows_screen = ShowScreen.new
  expect(@shows_screen.wait_until(30) { @shows_screen.start_show_button.displayed? }).to be true
  @shows_screen.press_select
end

Then("I see video playing on video player") do
  step "I see player controls, Metadata visible on video player screen"
end

Given("I am on the video playing screen") do
  @video_landing_screen = VideoLandingScreen.new
  step "I'm on the landing screen"
  step "I should see the details of hero content"
  step "I click on View Playlist button"
  step "I click on Start Show button"
  step "I see video playing on video player"
end

When("I see loader on player till playback starts") do
  @video_landing_screen = VideoLandingScreen.new
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_loader.displayed? }).to be true
end

Then("I see player controls, Metadata visible on video player screen") do
  @video_landing_screen = VideoLandingScreen.new
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_progress_bar.displayed? }).to be true
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_player_title.displayed? }).to be true
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_player_subtitle.displayed? }).to be true
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_cc.displayed? }).to be true
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_player_position.displayed? }).to be true
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_player_duration.displayed? }).to be true
end

When("I click on pause button on player") do
  @video_landing_screen = VideoLandingScreen.new
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_pause_button.displayed? }).to be true
  # rubocop:disable Custom/SleepCop.
  sleep(5) # playing video
  # rubocop:enable Custom/SleepCop.
  @video_landing_screen.press_up
  @video_landing_screen.press_media_play_pause
end

Then("I see playback stops and play button is displayed with metadata") do
  @video_landing_screen = VideoLandingScreen.new
  @pause_time = @video_landing_screen.video_player_position.text.to_f
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_play_button.displayed? }).to be true
  step "I see player controls, Metadata visible on video player screen"
end

And("I click on play button on player") do
  @video_landing_screen = VideoLandingScreen.new
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_play_button.displayed? }).to be true
  # rubocop:disable Custom/SleepCop.
  sleep(5) # pausing video
  # rubocop:enable Custom/SleepCop.
  @video_landing_screen.press_up
  @video_landing_screen.press_media_play_pause
end

Then("I see content playback resumed") do
  @video_landing_screen = VideoLandingScreen.new
  @play_time = @video_landing_screen.video_player_position.text.to_f
  expect(@pause_time = @play_time).to be_truthy
  @video_landing_screen.press_up
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_pause_button.displayed? }).to be true
end

Then("I see player controls fades out after few seconds") do
  @video_landing_screen = VideoLandingScreen.new
  # rubocop:disable Custom/SleepCop.
  sleep 10
  # rubocop:enable Custom/SleepCop.
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_inactive_screen.displayed? }).to be true
end

When("CC is in OFF state by default") do
  @video_landing_screen = VideoLandingScreen.new
  expect(@video_landing_screen.wait_until(30) { @video_landing_screen.video_cc.displayed? }).to be true
  expect(@video_landing_screen.video_cc_focus.eql?("false")).to be true
end

Then("I turn ON CC option") do
  @video_landing_screen = VideoLandingScreen.new
  step "I see player controls fades out after few seconds"
  2.times { @video_landing_screen.press_up }
  expect(@video_landing_screen.video_cc_focus.eql?("true")).to be true
end

When("I scrub {string} on the video") do |playback_option|
  @video_landing_screen = VideoLandingScreen.new
  case playback_option
  when "forward"
    step "Scrub forward the video"
  when "backward"
    step "Scrub forward the video"
    @forward_time = @video_landing_screen.video_playing_time
    @video_landing_screen.press_up
    @video_landing_screen.press_media_play_pause
    4.times { @video_landing_screen.press_rewind }
  end
end

And("Scrub forward the video") do
  @video_landing_screen.press_up
  # rubocop:disable Custom/SleepCop.
  step "Press left until scrubber reached to initial time 00.00"
  @initial_time = @video_landing_screen.video_playing_time
  sleep 7 # added it to overcome video buffering & rendering of videos
  @video_landing_screen.press_media_play_pause
  @video_landing_screen.press_up
  5.times { @video_landing_screen.press_fast_forward }
  sleep 3
  # rubocop:enable Custom/SleepCop.
end

And("Press left until scrubber reached to initial time 00.00") do
  loop do
    val = 0.0
    @video_landing_screen.press_rewind
    break if @video_landing_screen.video_playing_time == val
  end
end

Then("I see video playback time {string} correctly") do |playback_value|
  @video_landing_screen = VideoLandingScreen.new
  case playback_value
  when "increased"
    @forward_time = @video_landing_screen.video_playing_time
    expect(@forward_time >= @initial_time).to be_truthy
    expect(@video_landing_screen.video_play_button.displayed?).to be true
    @video_landing_screen.press_up
  when "decreased"
    @video_landing_screen.press_media_play_pause
    @video_landing_screen.press_up
    @backward_time = @video_landing_screen.video_playing_time
    expect(@backward_time <= @forward_time).to be_truthy
    expect(@video_landing_screen.video_play_button.displayed?).to be true
    @video_landing_screen.press_up
  end
end

When("I click on Remote Back button") do
  step "I see player controls, Metadata visible on video player screen"
  @video_landing_screen.press_back
end

Then("I see player is closed & user lands on screen from where playback was initiated") do
  step "I see the details of shows hero content"
end
