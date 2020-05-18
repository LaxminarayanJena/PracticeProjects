Given("I watch some contents for more than {string}% in Apple TV {string} than 1 min") do |percentage_value, time_measure|
  @continue_screen = ContinueWatchingScreen.new
  @home_screen = HomeScreen.new
  step "I search a valid show in Apple TV"
  step "I select the show card"
  step "I should be on the Show screen"
  step "Click on Start from Beginning button"
  # rubocop:disable Custom/SleepCop.
  sleep 9 # added it to overcome video buffering & rendering of videos
  @continue_screen.press_up
  @continue_screen.press_media_play_pause
  @continue_screen.press_up
  step "Press left until scrubber reached to initial time 00.00"
  if percentage_value == "0.5" && time_measure == "less"
    @desired_percentage = @continue_screen.total_1_percentage(0.5)
    @continue_screen.press_right while @continue_screen.scrubbed_marker_float <= @desired_percentage
    @continue_screen.press_media_play_pause
    sleep 5 # added it to overcome video buffering & rendering of videos
    @continue_screen.press_up
    @continue_screen.press_left
    @continue_screen.press_select
  elsif percentage_value == "2" && time_measure == "greater"
    @desired_percentage = @continue_screen.get_seeking_seconds(2)
    @continue_screen.press_right while @continue_screen.scrubbed_marker_float <= @desired_percentage
    @continue_screen.press_media_play_pause
    sleep 5 # added it to overcome video buffering & rendering of videos
    # rubocop:enable Custom/SleepCop.
    @continue_screen.press_select
    @continue_screen.press_right
    @initial_time = @home_screen.time_scrubbing_value.gsub(":", ".").to_f
    @continue_screen.press_select
  end
  step "Go to Featured screen"
end

And("Go to Featured screen") do
  @continue_screen.press_menu
  @home_screen.wait_until(30) { @home_screen.play_latest_button.displayed? }
  @continue_screen.press_menu
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  @continue_screen.press_menu
  @continue_screen.wait_until(30) { @continue_screen.menu_search.displayed? }
  expect(@continue_screen.menu_search.displayed?).to be true
  @continue_screen.navigate_right_to_featured
end

And("Press left until scrubber reached to initial time 00.00") do
  loop do
    val = 0.0
    @continue_screen.press_left
    break if @continue_screen.scrubbed_marker_float == val
  end
end

And("Click on Start from Beginning button") do
  @home_screen = HomeScreen.new
  if @home_screen.check_start_from_beginning_button.positive?
    @home_screen.press_down
    @home_screen.start_from_beginning_button.click
  end
end

And("I click on Resume Playing button") do
  @show_screen = ShowScreen.new
  @continue_screen = ContinueWatchingScreen.new
  @current_time = @continue_screen.scrubbed_marker_float
  @show_screen.show_resume_playing_button.click if @show_screen.show_resume_playing_button.displayed?
end

When("I go to Continue Watching list") do
  @continue_screen = ContinueWatchingScreen.new
  @home_screen = HomeScreen.new
  step "I should see show description"
  2.times { @continue_screen.press_down }
  2.times { @continue_screen.press_left }
  @continue_screen.wait_until(30) { @continue_screen.continue_watching_video_list.first.displayed? }
  expect(@continue_screen.continue_watching_video_list[0].text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  @continue_screen.continue_watching_video_first.click
  expect(@home_screen.start_from_beginning_button.displayed?).to be true
end

Then("I should see that video playing from the last watched timestamp") do
  @continue_screen = ContinueWatchingScreen.new
  expect(@current_time >= @initial_time).to be_truthy
  step "check is video is playing"
  puts "Video is playing from the last watched timestamp"
end

Then("I should see that video is playing from the beginning") do
  @continue_screen = ContinueWatchingScreen.new
  @continue_screen.press_media_play_pause
  @current_time = @continue_screen.scrubbed_marker_float
  expect(@current_time <= @initial_time).to be_truthy
  step "check is video is playing"
  puts "Video is playing from the beginning"
end

Then("I should see that Continue Watching tray is NOT listed under Featured section") do
  @continue_screen = ContinueWatchingScreen.new
  step "I should see show description"
  2.times { @continue_screen.press_down }
  if @continue_screen.continue_watching_carousel.positive?
    expect(@continue_screen.continue_watching_video_list.first.text.include?(NETWORK_DATA.show_search[:show_name])).to be false
    puts "Video is not present in Continue Watching tray"
  else
    puts "No Continue Watching Carousel present, as no video present in Continue Watching tray"
  end
end
