Given(/^I am on Continue Watching screen$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.hamburger_icon.displayed? }
  @landing_screen.hamburger_icon.click
  @landing_screen.hamburger_continue_watching_menu.click
end

And(/^there are no unfinished videos on landing screen$/) do
  @landing_screen = LandingScreen.new
  titles = @landing_screen.carousel_headers
  expect((titles.include? "unlocked videos") || (titles.include? "stream for free")).to be false
end

And("there are no unfinished videos in continue watching screen") do
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_home_icon.click if @landing_screen.hamburger_home_icon.displayed?
  @landing_screen.wait_until(10) { @landing_screen.search_show_icon.displayed? }
  step "I am on Continue Watching screen"
  @continue_watching_screen = ContinueWatchingScreen.new
  @continue_watching_screen.wait_until(60) { @continue_watching_screen.continue_watching_header.displayed? }
  no_unfinished_videos_text = "Pick up where you left off.  Continue watching episodes you started but didn't finish."
  expect(@continue_watching_screen.no_unfinished_videos.text.include?(no_unfinished_videos_text)).to be true
  @continue_watching_screen.top_close_button.click
  @continue_watching_screen.wait_until(60) { @continue_watching_screen.hamburger_home.displayed? }
  @continue_watching_screen.hamburger_home.click
end

And(/^I watch an unlocked show for sometime$/) do
  step "I search an unlocked video"
  step "I view a video"
  step "I watch the show for sometime"
end

And(/^I watch the show for sometime$/) do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(3)
    # rubocop:enable Custom/SleepCop.
  end
  # rubocop:disable Custom/SleepCop.
  sleep(50)
  # rubocop:enable Custom/SleepCop.
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 5, on_retry: retry_proc) do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(60) { @video_screen.back_btn.displayed? }
    @video_screen.back_btn.click
    @show_screen = ShowScreen.new
    @show_screen.wait_until(15) { @show_screen.favorite_button.displayed? }
  end
  step "I exit show list screen"
  step "I exit search screen"
end

Then("the show should be on continue watching list on landing screen") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.unfinished_videos_list.displayed?).to be true
end

Then("I should be able to resume watching the video from continue watching carousel card") do
  @landing_screen = LandingScreen.new
  @landing_screen.play_video_button.click
  @video_screen = VideoScreen.new
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  # rubocop:disable Custom/SleepCop.
  sleep(5)
  # rubocop:enable Custom/SleepCop.
  @video_screen.tap_by_coordinates(100, 100)
  @video_screen.wait_until(60) { @video_screen.video_current_time.displayed? }
  @video_screen.info_button.click
  step "I should see the video playing"
end

Then("the show should be on continue watching screen") do
  step "I am on Continue Watching screen"
  @continue_watching_screen = ContinueWatchingScreen.new
  @continue_watching_screen.wait_until(60) { @continue_watching_screen.continue_watching_header.displayed? }
  expect(@continue_watching_screen.unfinished_video.displayed?).to be true
end

Then("I should be able to resume watching the video from continue watching screen") do
  @continue_watching_screen = ContinueWatchingScreen.new
  @continue_watching_screen.wait_until(60) { @continue_watching_screen.continue_watching_header.displayed? }
  video_to_watch = @continue_watching_screen.unfinished_video
  @continue_watching_screen.play_unfinished_video(video_to_watch).click
  step "I should see the video playing"
end

Then("watch {int} percent of unfinished videos") do |_int|
  @landing_screen.wait_until(60) { @landing_screen.hamburger_home.displayed? }
  @landing_screen.hamburger_home.click
  titles = @landing_screen.carousel_headers
  puts "unfinished videos present" if titles.include? "unlocked videos" == true
  step "I am on Continue Watching screen"
end
