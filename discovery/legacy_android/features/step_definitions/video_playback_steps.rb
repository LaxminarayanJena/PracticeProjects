When(/^I get episode title$/) do
  step "I tap on info icon"
  @video_playback = VideoPalybackScreen.new
  @video_name = @video_playback.video_info_episode_name
  Kernel.puts "Current video name is #{@video_name}"
end

Then(/^I should see the video playing till end and next video$/) do
  @video = VideoScreen.new
  @video_playback = VideoPalybackScreen.new
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
  @video_playback = VideoPalybackScreen.new
  co = @video_playback.get_coordinates(@video.video_container)
  # Each condition is to play video for 40mins
  120.times { @video_playback.tap_by_coordinates_eventplayback(co[0], co[1]) }
end

When(/^Allow content to play through first ad break$/) do
  @watch_later_screen = WatchLaterScreen.new
  @video = VideoScreen.new
  @video_playback = VideoPalybackScreen.new
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
  @watch_later_screen.video_play_till_ad
end

And(/^I tap on learn more to see the info and resume ad$/) do
  @video = VideoScreen.new
  # Lean more is clickable only by co oridinates
  # @video.tap_by_coordinates(1959, 888)
  @video.learn_more.click
  # As per scenario- To hold the script in learn more screen
  # rubocop:disable Custom/SleepCop.
  sleep(10)
  # rubocop:enable Custom/SleepCop.
  @menu = BaseScreen.new
  @menu.navigate_to_previous_screen
  while @video.ad_title.positive?
    # skipping the ad
    # rubocop:disable Custom/SleepCop.
    sleep(10)
    # rubocop:enable Custom/SleepCop.
  end
end

Then(/^I pause video during subsequent chapter and resume after sometime$/) do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.tap_on_play_button
  # To capture the events after video is being paused
  # rubocop:disable Custom/SleepCop.
  sleep(20)
  # rubocop:enable Custom/SleepCop.
  @watch_later_screen.tap_on_play_button
  # To capture the events while video is being played
  # rubocop:disable Custom/SleepCop.
  sleep(30)
  # rubocop:enable Custom/SleepCop.
end

And(/^I exit the app after watching first ad pod$/) do
  step "Allow content to play through first ad break"
  @watch_later_screen = WatchLaterScreen.new
  @video = VideoScreen.new
  co = @video_playback.get_coordinates(@video.video_container)
  loop do
    @video.tap_by_coordinates(co[0], co[1])
    if @video.ad_title.positive? && @watch_later_screen.learn_more.positive?
      Kernel.puts "ad is playing"
      redo
    else
      puts "video is playing"
      @video.tap_by_coordinates(co[0], co[1])
      @current_time = @video.video_current_time.text
      @start_time_in_sec = ((@current_time.split(":")[0].to_f * 60) + @current_time.split(":")[-1].to_f)
      Kernel.puts "start time -- #{@start_time_in_sec}"
      break
    end
  end
  @video.tap_by_coordinates(co[0], co[1])
  @menu = BaseScreen.new
  @menu.navigate_to_previous_screen
  step "I click on device home button"
end

When(/^I observe user automatically pickup from where he left off$/) do
  @video_playback = VideoPalybackScreen.new
  @video = VideoScreen.new
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.tap_on_play_button
  co = @video_playback.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  Kernel.puts "Tapped"
  @present_time = @video.video_current_time.text
  @present_time_in_sec = ((@present_time.split(":")[0].to_f * 60) + @present_time.split(":")[-1].to_f) + 20
  Kernel.puts "Present time -- #{@present_time_in_sec}"
  Kernel.puts "start time -- #{@start_time_in_sec}"
  @watch_later_screen.tap_on_play_button
  step "I should see the video playing till end and next video" if @present_time_in_sec >= @start_time_in_sec
end
