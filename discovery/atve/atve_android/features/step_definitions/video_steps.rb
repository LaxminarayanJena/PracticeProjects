Given("I am on video landing screen") do
  step "I go to the 'Search' screen"
  step "I enter a shown name in search text field"
  step "I click on searched episode"
end

Then("video plays in portrait mode by default") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.displayed?).to be_truthy }
  mode = driver.orientation
  expect(mode).to eq :portrait
end

Then("video metadata should be visible") do
  @video_screen = VideoScreen.new
  expect(@video_screen.video_title.displayed?).to be_truthy
  expect(@video_screen.video_desc.displayed?).to be_truthy
end

And("I change the video to landscape") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { @video_screen.full_screen_button.displayed? }
  @video_screen.full_screen_button.click
end

Then("the video plays in landscape mode") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.test_video_player.displayed?).to be_truthy }
  mode = driver.orientation
  expect(mode).to eq :landscape
end

Then("the video plays correctly") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.video_pause_button.displayed?).to be_truthy }
end

And("I scrub forward on the Video") do
  @video_screen = VideoScreen.new
  expect(@video_screen.forward_button.displayed?).to be_truthy
  @initial_time = @video_screen.video_current_time
  Kernel.puts "video displayed current #{@initial_time}"
  @video_screen.video_container.click
  @video_screen.forward_button.click
  @after_forwarding = @video_screen.video_current_time
  Kernel.puts "video displayed #{@after_forwarding}"
end

Then("the video playback time should be increased by 10 seconds") do
  @time_difference = @after_forwarding.split(":")[-1].to_i - @initial_time.split(":")[-1].to_i
  Kernel.puts "time differnece #{@time_difference}"
  expect(@time_difference).to be >= 10
end

And("I scrub backwards on the video") do
  @video_screen = VideoScreen.new
  expect(@video_screen.rewind_button.displayed?).to be_truthy
  @video_screen.forward_button.click
  @start_time = @video_screen.video_current_time
  Kernel.puts "video displayed current #{@start_time}"
  @video_screen.video_container.click
  @video_screen.rewind_button.click
  @after_rewind = @video_screen.video_current_time
  Kernel.puts "video displayed #{@after_rewind}"
end

Then("the video playback time should be decreased by 10 seconds") do
  @time_difference = @after_rewind.split(":")[-1].to_i - @start_time.split(":")[-1].to_i
  Kernel.puts "time differnece #{@time_difference}"
  expect(@time_difference).to be <= 10
end

When("I scroll till end of the screen") do
  @video_screen = VideoScreen.new
  @video_screen.scroll_to_bottom
end

Then("I see Extra Clips") do
  @video_screen = VideoScreen.new
  expect(@video_screen.extra_clips.displayed?).to be_truthy
end

Then("I see {string} on the player") do |player_control|
  @video_screen = VideoScreen.new
  case player_control
  when "pause"
    expect(@video_screen.video_pause_button.displayed?).to be_truthy

  when "play"
    @video_screen.video_pause_button.click
    expect(@video_screen.video_play_button.displayed?).to be_truthy

  when "forward"
    expect(@video_screen.forward_button.displayed?).to be_truthy

  when "backward"
    expect(@video_screen.rewind_button.displayed?).to be_truthy

  when "back"
    expect(@video_screen.player_back_button.displayed?).to be_truthy

  when "full screen"
    expect(@video_screen.full_screen_button.displayed?).to be_truthy

  when "cc"
    expect(@video_screen.cc_button.displayed?).to be_truthy
  end
end

And("I tap on {string} button") do |button|
  @video_screen = VideoScreen.new
  case button
  when "pause"
    step "I see 'pause' on the player"
    @video_screen.forward_button.click
    @video_screen.video_pause_button.click
    @time_when_paused = @video_screen.video_current_time
    puts "Time when paused:#{@time_when_paused}"

  when "play"
    step "I see 'play' on the player"
    @video_screen.video_play_button.click

  when "back"
    step "I see 'back' on the player"
    @video_screen.player_back_button.click

  end
end

Then("video should be paused") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { @video_screen.video_play_button.displayed? }
  time_after_wait = @video_screen.video_current_time
  expect(@time_when_paused).to be == time_after_wait
  puts "Time after wait: #{time_after_wait}"
end

Then("I see previous screen from where playback was initiated") do
  @video_screen = VideoScreen.new
  expect(@video_screen.network_logo.displayed?).to be_truthy
end

Then("I see metadata and validate") do
  @video_screen = VideoScreen.new
  portrait_show_title = @video_screen.video_title.text
  puts "Portrait title: #{portrait_show_title}"
  step "I change the video to landscape"
  landscape_show_title = @video_screen.landscape_video_title.text
  puts "Landscape title: #{landscape_show_title}"
  expect(portrait_show_title).to be == landscape_show_title
end
