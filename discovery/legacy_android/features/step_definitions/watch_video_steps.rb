# frozen_string_literal: true

When(/^I view a video$/) do
  @show_screen = ShowScreen.new
  @show_screen.play_episode_button.click
end

When(/^I watch a video$/) do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.show_search[:episode_1]}")
end

Then("I watch half of the show") do
  @video = VideoScreen.new
  # rubocop:disable Style/GlobalVars
  wdt = ($driver.window_size.width / 2)
  hgt = ($driver.window_size.height / 2)
  # rubocop:enable Style/GlobalVars
  retry_proc = proc do
    @video.tap_by_coordinates(wdt, hgt)
    @slider = @video.seek_bar
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @video.tap_by_coordinates(wdt, hgt)
    @slider = @video.seek_bar
    start_x = @slider.location.x
    y = @slider.location.y
    puts "====== initial x and y co-ordinates #{start_x} #{y} ================="
    width = @slider.size.width
    @video.tap_by_coordinates(wdt, hgt)
    # We are calculating the half point marker of the video in order to seek video to half time.
    # So as to place video into continue watching section
    seeking_size = (width / 2)
    if @video.ad_title.positive?
      rem_time = @video.ad_countdown.to_i
      while rem_time > 30
        puts "====== the  Remaining time is #{rem_time} =================="
        @video.tap_by_coordinates(wdt, hgt)
        # rubocop:disable Custom/SleepCop
        sleep 30
        @video.tap_by_coordinates(wdt, hgt)
        rem_time = @video.ad_countdown.to_i
      end
      @video.tap_by_coordinates(wdt, hgt)
      sleep rem_time
    end
    sleep 10 if @video.loading_icon.positive?
    @video.tap_by_coordinates(wdt, hgt)
    Appium::TouchAction.new.swipe(start_x: start_x, start_y: y, end_x: seeking_size, end_y: y, duration: 200).perform.release
    sleep 2
  end
  @video.tap_by_coordinates(wdt, hgt)
  @video.video_back_btn.click
end

Then("The show should be on continue watching page") do
  @landing_screen = LandingScreen.new
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://home")
  retry_proc = proc do
    @landing_screen.hamburger_icon.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @landing_screen.continue_watching_icon.displayed?
  end
  @landing_screen.continue_watching_icon.click
  @cont_watching_screen = ContinueWatchingScreen.new
  expect(@cont_watching_screen.layout_rows.count).to be >= 1
end

Then(/^I should see the video playing$/) do
  initial_time = 0
  elapsed_time = 0
  @video = VideoScreen.new
  if @video.ad_title.positive?
    # Tapping the screen until AD is playing
    while @video.ad_title.positive?
      @video.tap_by_coordinates(300, 150)
      sleep 10
    end
  end
  retry_proc = proc do
    @video.video_container.click
    Kernel.puts "---------retrying to click container------------"
  end
  @video.video_container.click
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    expect(@video.video_current_time.displayed?).to be_truthy
    initial_time = @video.video_current_time.text
    puts initial_time
  end
  sleep(5)
  retry_proc = proc do
    @video.video_container.click
    Kernel.puts "---------retrying to click container------------"
  end
  @video.video_container.click
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    expect(@video.video_current_time.displayed?).to be_truthy
    elapsed_time = @video.video_current_time.text
    puts elapsed_time
  end
  expect(initial_time).to be < elapsed_time
  # rubocop:enable Custom/SleepCop.
end

Then("I should see live video playing") do
  # Live tv doesn't have a time bar so we're checking for the live icon to be displayed
  @video = VideoScreen.new
  retry_proc = proc do
    @video.video_container.click
    Kernel.puts "---------retrying to click container------------"
  end
  @video.video_container.click
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    expect(@video.captions.displayed?).to be_truthy
  end
end

Given("I go to a show page") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.show_logo.displayed? }
  @landing_screen.search_show(NETWORK_DATA.show_search[:show_name])
end

Given("I go to a short form video") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.show_logo.displayed? }
  @landing_screen.search_show(NETWORK_DATA.video_playback[:shortform_video])
end

Then("I should be able to view unlocked episodes info details") do
  @video = VideoScreen.new
  @landing_screen = LandingScreen.new
  @landing_screen.scroll_to_unlocked_episode
  @landing_screen.wait_until(60) { @landing_screen.info_button.displayed? }
  # verifying info page details
  @current_video_title = @landing_screen.recent_video_title.text
  @current_video_episodeinfo = @landing_screen.video_episodeinfo.text
  @landing_screen.info_button.click
  @infopage_video_title = @landing_screen.recent_infopage_video_title.text
  @infopage_video_episodeinfo = @landing_screen.video_episodeinfo.text
  expect(@current_video_title == @infopage_video_title).to be true
  expect(@current_video_episodeinfo == @infopage_video_episodeinfo).to be true
end

And("I should be able to click on play button") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.recent_episodes_play_button.displayed?).to be_truthy
  @landing_screen.recent_episodes_play_button.click
end

Then("I should see the show tile on home page") do
  @cont_watching_screen = ContinueWatchingScreen.new
  @landing_screen = LandingScreen.new
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://home")
  expect(@landing_screen.continue_watching_header.displayed?).to be_truthy
  expect(@cont_watching_screen.video_thumbnail.count).to be >= 1
  expect(@landing_screen.hero_episode_play.displayed?).to be_truthy
end

Then("I see CC option on player UI") do
  @video = VideoScreen.new
  retry_proc = proc do
    @video.video_container.click
    Kernel.puts "---------retrying to click container------------"
  end
  @video.video_container.click
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    expect(@video.captions.displayed?).to be_truthy
    @video.captions.click
  end
end
