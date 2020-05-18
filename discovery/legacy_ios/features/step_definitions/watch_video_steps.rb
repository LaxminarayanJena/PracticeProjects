# frozen_string_literal: true

When(/^I view a video$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.play_episode_button.displayed? }
  @show_screen.play_episode_button.click
end

Then(/^I should see the video playing$/) do
  @video = VideoScreen.new
  # rubocop:disable Custom/SleepCop.
  # Checking whether AD is playing
  if @video.ad_title.positive?
    # Tapping the screen until AD is playing
    while @video.ad_title.positive?
      @video.tap_by_coordinates(300, 150)
      sleep 10
    end
  end
  @video.wait_until(60) { @video.video_buffer_element.empty? }
  @video.tap_by_coordinates(300, 150)
  initial_time = @video.video_current_time.text
  # sleep to allow time lapse so we know video is playing
  sleep(5)
  @video.tap_by_coordinates(300, 150)
  elapsed_time = @video.video_current_time.text
  puts initial_time
  puts elapsed_time
  expect(initial_time).to be < elapsed_time
  # rubocop:enable Custom/SleepCop.
end

Then("I should see live video playing") do
  # Live tv doesn't have a time bar so we're checking for the live icon to be displayed
  @video = VideoScreen.new
  # @video.video_container.click until @video.captions.displayed?
  # Wake screen by using tap through coordinates
  @video.tap_by_coordinates(300, 150)
  expect(@video.captions.displayed?).to be true
end

Given("I go to a show page") do
  @landing_screen = LandingScreen.new
  @landing_screen.search_show(NETWORK_DATA.show_search[:show_name])
end

And("A show with seasons is selected") do
  @landing_screen = LandingScreen.new
  @landing_screen.search_show(NETWORK_DATA.show_with_seasons[:show_name])
end

When(/^I view an unlocked video$/) do
  step "I search an unlocked video"
  step "I view a video"
end

Given("I'am watching an video with ad") do
  step "I search an video with ad"
  step "I view a video"
end

And(/^I search an video with ad$/) do
  step "I click on search icon"
  @search_screen = SearchScreen.new
  @search_screen.search_field.send_keys(NETWORK_DATA.ad_video)
  @search_screen.search_result(NETWORK_DATA.ad_video).first.click
end

When("Allow content to play through first ad break and click learn more link") do
  @video = VideoScreen.new
  until @video.ad_title.positive?
    Kernel.puts "tap video"
    @video.tap_by_coordinates(100, 100)
  end

  expect(@video.learn_more_link.displayed?).to be_truthy
  @video.learn_more_link.click

  if @video.appstore_ok_button.size.positive?
    @video.appstore_ok_button.first.click
    @video.navigate_to_app.first.click
  elsif @video.navigate_to_app.size.positive?
    @video.navigate_to_app.first.click
  end
end

Then("Webview Page displayed") do
  @video = VideoScreen.new
  @video.wait_until(30) { expect(@video.webview.displayed?).to be_truthy }
end
