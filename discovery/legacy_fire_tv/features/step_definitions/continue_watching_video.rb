Given("I watch half of the show") do
  @video_screen = VideoScreen.new
  step "I search a show"
  step "I select the show's card"
  step "I click on play button"
  step "I should see video playing"
  step "scrub forward"
  @video_screen.play_button.click
  @initial_time = @video_screen.video_current_time

  @initial_time = @video_screen.video_current_time.to_f
  @video_screen.press_back
end

When("I search for the same show and click on continue in continue page") do
  @continue_option = ShowScreen.new
  @video_screen = VideoScreen.new
  @show_season_episode_text = @show_screen.sesson_eposide_text.text
  @show_title_ = @show_screen.show_title.text
  step "I search and play the same show"
  expect(@continue_option.continue_btn.displayed?).to be_truthy
  expect(@video_screen.continue_show_name.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  expect(@show_season_episode_text == @video_screen.continue_description.text)
  expect(@show_title_ == @video_screen.continue_title.text)
  @continue_option.continue_btn.click
end

Then("I should see the video playing from the scrubed position") do
  @video_screen = VideoScreen.new
  step "I should see video playing"
  @video_screen.video_id.click
  @video_screen.press_down
  @video_screen.press_media_play_pause
  @current_time = @video_screen.video_current_time.to_f
  expect(@current_time = @initial_time).to be_truthy
  puts "Video is playing from the scrubed poistion"
end

When("I search for the same show and click on start over in continue page") do
  @startover_option = ShowScreen.new
  step "I search and play the same show"
  expect(@startover_option.start_over_btn.displayed?).to be_truthy
  @startover_option.start_over_btn.click
end

Then("I should see the video playing from the initial position") do
  @video_screen = VideoScreen.new
  step "I should see video playing"
  @video_screen.video_id.click
  @video_screen.press_down
  @video_screen.press_media_play_pause
  @current_time = @video_screen.video_current_time.to_f
  puts @current_time
  expect(@current_time < @initial_time).to be_truthy
  puts "Video is playing from the initial poistion"
end

Then("I should see continue watching in {string} screen") do |screen|
  @video_screen = VideoScreen.new
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @my_videos_screen = MyVideosScreen.new
  case screen
  when "Featured"
    @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
    6.times { @video_screen.press_up }
    7.times { @video_screen.press_left }
    @home_screen.wait_until(120) { @home_screen.featured_show.displayed? }
    @show_screen.wait_until(120) { @show_screen.continue_watching_title.displayed? }
    2.times { @show_screen.press_down }
    expect(@video_screen.continue_watching_txt.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
    expect(@show_screen.status_image_btn.displayed?).to be_truthy
    expect(@show_screen.progress_bar.displayed?).to be_truthy
    expect(@show_screen.subtitle_text.displayed?).to be_truthy
  when "MyVideos"
    @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
    6.times { @video_screen.press_up }
    @my_videos_screen.press_left
    @my_videos_screen.press_down
    expect(@video_screen.continue_watching_txt.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
    expect(@show_screen.status_image_btn.displayed?).to be_truthy
    expect(@show_screen.progress_bar.displayed?).to be_truthy
    expect(@show_screen.subtitle_text.displayed?).to be_truthy
  end
end

When("I check for the same show from myvideos screen and click on start over in continue page") do
  @video_screen = VideoScreen.new
  @startover_option = ShowScreen.new
  step "I should see continue watching in 'MyVideos' screen"
  @video_screen.press_select
  expect(@startover_option.start_over_btn.displayed?).to be_truthy
  @startover_option.start_over_btn.click
end

When("I check for the same show from myvideos screen and click on continue in continue page") do
  @video_screen = VideoScreen.new
  @continue_option = ShowScreen.new
  step "I should see continue watching in 'MyVideos' screen"
  @video_screen.press_select
  expect(@continue_option.continue_btn.displayed?).to be_truthy
  @continue_option.continue_btn.click
end

When("I watch the show for few seconds") do
  @video_screen = VideoScreen.new
  step "I search a show"
  step "I select the show's card"
  step "I click on play button"
  step "I should see video playing"
  @video_screen.press_fast_forward
  @video_screen.press_back
end

Then("I should not see continue watching in {string} screen") do |screen|
  @video_screen = VideoScreen.new
  @show_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @my_videos_screen = MyVideosScreen.new
  case screen
  when "Featured"
    @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
    6.times { @video_screen.press_up }
    7.times { @video_screen.press_left }
    @home_screen.wait_until(120) { @home_screen.featured_show.displayed? }

    2.times { @show_screen.press_down }
    expect(@video_screen.continue_watching_txt.text.include?(NETWORK_DATA.show_search[:show_name])).to be false
  when "MyVideos"
    @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
    6.times { @video_screen.press_up }
    @my_videos_screen.press_left
    @my_videos_screen.press_down
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  end
end

And("scrub forward") do
  @video_screen = VideoScreen.new
  if @video_screen.ad_title.positive?
    step "watch ad"
  else
    2.times { @video_screen.press_fast_forward }
  end
end
