# frozen_string_literal: true

Given(/^I go to main menu$/) do
  @screen = WatchLiveTvScreen.new
  @screen.wait_until(60) { @screen.main_menu_hamburger.displayed? }
  @screen.main_menu_hamburger.click
  retry_proc = proc do
    @screen.hamburger_icon.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @screen.hamburger_watch_live.displayed?
  end
end

When(/^I click on watch live tv$/) do
  @screen = WatchLiveTvScreen.new
  @screen.wait_until { @screen.hamburger_watch_live.displayed? }
  @screen.hamburger_watch_live.click
end

Then(/^I should see sign in to unlock all shows$/) do
  @screen = WatchLiveTvScreen.new
  # Metrics/LineLength
  expect(@screen.sign_into_unlock.displayed?).to be true
end

Then("I see live icon on the screen") do
  @video = VideoScreen.new
  expect(@video.live_video_icon.displayed?).to be_truthy
end

When("I click on live tv back button") do
  @screen = WatchLiveTvScreen.new
  @video = VideoScreen.new
  retry_proc = proc do
    @video.video_container.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @screen.live_tv_back.displayed?
    @screen.live_tv_back.click
  end
end

Then("I should navigate to home screen") do
  @home_screen = HomeScreen.new
  expect(@home_screen.hero.displayed?).to be_truthy
end

Then("I see {string} on player") do |player_control|
  @screen = WatchLiveTvScreen.new
  @video = VideoScreen.new
  case player_control
  when "back_button"
    expect(@screen.live_tv_back.displayed?).to be_truthy
  when "volume button"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.volume.displayed?).to be_truthy
    end
  when "CC button"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.captions.displayed?).to be_truthy
    end
  when "Play button"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.play_button.displayed?).to be_truthy
    end
  when "Seek bar"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.seek_bar.displayed?).to be_truthy
    end
  when "Start time"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.video_current_time.displayed?).to be_truthy
    end
  when "End time"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.end_time.displayed?).to be_truthy
    end
  end
end

Then("I see {string} on ad player") do |ad_player_control|
  @video = VideoScreen.new
  case ad_player_control
  when "Ad continue time"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.ad_continue_time.displayed?).to be_truthy
    end
  when "Ad countdown"
    retry_proc = proc do
      @video.video_container.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
      expect(@video.ad_count.displayed?).to be_truthy
    end
  end
end
