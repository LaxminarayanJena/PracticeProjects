Given("I view an episode") do
  @video_screen = VideoScreen.new
  @show_screen = ShowScreen.new
  step "I search a show"
  step "I select the show's card"
  @video_name = @show_screen.episode_title
end

When("I watch the video for some time") do
  @video_screen = VideoScreen.new
  step "I click on play button"
  step "I should see video playing"
  2.times { @video_screen.press_fast_forward }
  @video_screen.play_button.click
  @initial_time = @video_screen.video_current_time.to_f
  @video_screen.press_back
end

And("I search and play the same video") do
  @continue_option = ShowScreen.new
  step "I search and play the same show"
  expect(@continue_option.continue_btn.displayed?).to be_truthy
  @continue_option.continue_btn.click
end

And("I should play the video from the scrubed position") do
  @video_screen = VideoScreen.new
  step "I should see video playing"
  @video_screen.video_id.click
  2.times { @video_screen.press_down }
  @video_screen.play_button.click
  @current_time = @video_screen.video_current_time.to_f
  expect(@current_time = @initial_time).to be_truthy
  puts "Video is playing from the scrubed poistion"
  @video_screen.play_button.click
end

Then("I should play the video till next episode") do
  @video_screen = VideoScreen.new
  if @video_screen.ad_count.positive?
    # Tapping the screen until AD is playing
    puts "ad is Playing" while @video_screen.ad_count.positive?
  end
  @video_screen.watch_full_video(@video_name)
end

Then("Video should play till end and Autoplay the next episode") do
  @video_screen = VideoScreen.new
  step "I click on play button"
  step "I should see video playing"
  if @video_screen.ad_count.positive?
    # Tapping the screen until AD is playing
    puts "ad is Playing" while @video_screen.ad_count.positive?
  end
  @video_screen.watch_full_video(@video_name)
end

Given("I select show and scrub forward inside chapter") do
  @video_screen = VideoScreen.new
  @show_screen = ShowScreen.new
  step "I search a show"
  step "I select the show's card"
  @video_name = @show_screen.episode_title
  step "I click on play button"
  @show_screen.wait_until(90) { @show_screen.video_page.displayed? }
  expect(@show_screen.video_page.displayed?).to be_truthy
  2.times { @video_screen.press_fast_forward }
end
