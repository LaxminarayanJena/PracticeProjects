Given("I go to shortform video get the episode title and play it") do
  step "I go to a short form video"
  step "I get episode title"
  step "I view a video"
end

Given("I go to a short form video") do
  @video_screen = BaseScreen.new
  @video_screen.search_show(NETWORK_DATA.video_playback[:shortform_video])
end

And("I tap on info icon") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.show_home_info.first.displayed? }
  @show_screen.show_home_info.first.click
end

When("I get episode title") do
  step "I tap on info icon"
  @video = EventsPlayBackScreen.new
  @show_list = ShowScreen.new
  @video_name = @show_list.show_episode_title[3].text
  @show_list.watch_list_popup.click
  Kernel.puts "initial video name is #{@video_name}"
end

Then("I should see the video playing till end and next video") do
  @video = VideoScreen.new
  @video_playback = EventsPlayBackScreen.new
  @video.wait_until { @video.video_container.displayed? }
  if @video.ad_title.positive?
    # Tapping the screen until AD is playing
    while @video.ad_title.positive?
      co = @video_playback.get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      # rubocop:disable Custom/SleepCop.
      sleep(10)
      # rubocop:enable Custom/SleepCop.
    end
  end
  @video_playback.watch_full_video(@video_name)
end

When(/^I watch live for 40 minutes$/) do
  step "I go to main menu"
  step "I click on watch live tv"
  step "I should see live video playing"
  @video_playback = EventsPlayBackScreen.new
  @video = VideoScreen.new
  co = @video_playback.get_coordinates(@video.video_container)
  # Each condition is to play video for 40mins
  120.times { @video_playback.tap_by_coordinates_eventplayback(co[0], co[1]) }
end

And("I perform operation on ad") do
  step "Allow content to play through first ad break and click learn more link"
  step "Webview Page displayed"
  step "I click on close button"
end

Then("I {string} main video and wait for some time") do |_string|
  @video_screen = VideoScreen.new
  @video_playback = EventsPlayBackScreen.new
  if @video.ad_title.positive?
    # Tapping the screen until AD is playing
    while @video.ad_title.positive?
      co = @video_playback.get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      # rubocop:disable Custom/SleepCop.
      sleep(10)
      # rubocop:enable Custom/SleepCop.
    end
  end
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  retry_proc = proc do
    co = @video_playback.get_coordinates(@video.video_container)
    @video.tap_by_coordinates(co[0], co[1])
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 3, on_retry: retry_proc) do
    co = @video_playback.get_coordinates(@video.video_container)
    @video.tap_by_coordinates(co[0], co[1])
    @video_screen.play_video_button.click
  end
  # rubocop:disable Custom/SleepCop.
  sleep 20
  # rubocop:enable Custom/SleepCop.
end

When("I play a video for 3 minutes and go back to landing screen") do
  @video_playback = EventsPlayBackScreen.new
  @video = VideoScreen.new
  co = @video_playback.get_coordinates(@video.video_container)
  9.times { @video_playback.tap_by_coordinates_eventplayback(co[0], co[1]) }
  step "I navigate back from video to landing screen"
end
