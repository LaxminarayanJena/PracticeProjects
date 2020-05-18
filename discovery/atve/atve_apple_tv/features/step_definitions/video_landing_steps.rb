Given("I am on the video landing screen in Apple Tv") do
  @video_landing_screen = VideoLandingScreen.new
  step "I am on a Show screen in Apple TV"
  step "I click on any show tile of the selected network 'TLC' organised in content grids"
  step "I am taken to the selected network's 'TLC' Show Details page"
  step "I navigate to Show details page"
end

And("the video plays correctly") do
  @video_landing_screen = VideoLandingScreen.new
  # rubocop:disable Custom/SleepCop.
  sleep 10 # added it to overcome video buffering & rendering of videos
  @video_landing_screen.press_up
  @video_landing_screen.press_media_play_pause
  expect(@video_landing_screen.video_play.displayed?).to be true
end

When("I scrub {string} on the video") do |playback_option|
  @video_landing_screen = VideoLandingScreen.new
  case playback_option
  when "forward"
    step "Scrub forward the video"
  when "backward"
    step "Scrub forward the video"
    @forward_time = @video_landing_screen.scrubbed_marker_float
    @video_landing_screen.press_media_play_pause
    2.times { @video_landing_screen.press_left }
  else
    "No Matching option found, please enter valid option name"
  end
end

Then("the video playback time should be {string} correctly") do |playback_value|
  @video_landing_screen = VideoLandingScreen.new
  case playback_value
  when "increased"
    @forward_time = @video_landing_screen.scrubbed_marker_float
    expect(@forward_time >= @initial_time).to be_truthy
    expect(@video_landing_screen.video_play.displayed?).to be true
    @video_landing_screen.press_menu
  when "decreased"
    @video_landing_screen.press_media_play_pause
    @video_landing_screen.press_up
    @video_landing_screen.press_media_play_pause
    @backward_time = @video_landing_screen.scrubbed_marker_float
    expect(@backward_time <= @forward_time).to be_truthy
    expect(@video_landing_screen.video_play.displayed?).to be true
    @video_landing_screen.press_menu
  else
    "No Matching option found, please enter valid option name"
  end
end

And("Scrub forward the video") do
  @video_landing_screen.press_up
  step "Press left until scrubber reached to initial time 00.00"
  @initial_time = @video_landing_screen.time_scrubbing_value.gsub(":", ".").to_f
  @desired_percentage = @video_landing_screen.total_length_percentage(0.8)
  @video_landing_screen.press_right while @video_landing_screen.scrubbed_marker_float <= @desired_percentage
  @video_landing_screen.press_media_play_pause
  sleep 7 # added it to overcome video buffering & rendering of videos
  # rubocop:enable Custom/SleepCop.
  @video_landing_screen.press_up
end

And("Press left until scrubber reached to initial time 00.00") do
  loop do
    val = 0.0
    @video_landing_screen.press_left
    break if @video_landing_screen.scrubbed_marker_float == val
  end
end

Then("I do not see the navigation bar on the side navigation") do
  @video_landing_screen = VideoLandingScreen.new
  @menubar_screen = MenuBarScreen.new
  @video_landing_screen.press_select
  @video_landing_screen.press_media_play_pause
  @video_landing_screen.press_up
  @video_landing_screen.press_left
  expect(@menubar_screen.menu_home.size.positive?).to be false
  puts "On pressing left, there is no left navigation menu bar present"
  expect(@video_landing_screen.scrubber_needle.displayed?).to be true
  expect(@video_landing_screen.video_play.displayed?).to be true
end

Given("I watch the video") do
  step "I am on the video landing screen in Apple Tv"
  step "the video plays correctly"
  step "Start the video on clicking 'Resume'"
  step "the video plays correctly"
end

When("video starts playing for few seconds") do
  @video_landing_screen = VideoLandingScreen.new
  @video_landing_screen.press_select
  @video_landing_screen.press_media_play_pause
  @video_landing_screen.press_up
  expect(@video_landing_screen.video_play.displayed?).to be true
  loop do
    val = 0.15
    @video_landing_screen.press_media_play_pause
    break if @video_landing_screen.scrubbed_marker_float == val
  end
end

And("I tap on 15 sec backward") do
  @video_landing_screen = VideoLandingScreen.new
  @initial_15sec_time = @video_landing_screen.time_scrubbing_value.gsub(":", ".").to_f
  step "Press left until scrubber reached to initial time 00.00"
  @video_landing_screen.press_media_play_pause
end

Then("I see it should skip 15 sec back") do
  @video_landing_screen = VideoLandingScreen.new
  @backward_skip_time = @video_landing_screen.scrubbed_marker_float
  expect(@backward_skip_time <= @initial_15sec_time).to be_truthy
end

And("video plays continuously without any issue") do
  @video_landing_screen = VideoLandingScreen.new
  @video_landing_screen.press_media_play_pause
  @video_landing_screen.press_up
  expect(@video_landing_screen.video_play.displayed?).to be true
end

And("Start the video on clicking {string} button") do |button|
  @showdetail_screen = ShowDetailScreen.new
  if button == "Resume"
    @showdetail_screen.wait_until(30) { @showdetail_screen.shows_hero_button("Resume").displayed? }
    @showdetail_screen.shows_hero_button("Resume").click
  elsif button == "Start Series"
    @showdetail_screen.wait_until(30) { @showdetail_screen.shows_hero_button("Start Series").displayed? }
    @showdetail_screen.shows_hero_button("Start Series").click
  end
end
