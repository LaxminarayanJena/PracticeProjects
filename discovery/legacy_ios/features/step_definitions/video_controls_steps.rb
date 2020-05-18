Given("I'am watching an unlocked show") do
  step "I search an unlocked video"
  step "I view a video"
end

When("I pause the show") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  # rubocop:disable Custom/SleepCop.
  sleep(5)
  # rubocop:enable Custom/SleepCop.
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 5, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    # @video_screen.wait_until(60) { @video_screen.play_video_button.displayed? }
    @video_screen.play_video_button.click
    @time_when_paused = @video_screen.video_current_time.text
  end
end

Then("the video should pause") do
  # rubocop:disable Custom/SleepCop.
  sleep(5)
  # rubocop:enable Custom/SleepCop.
  @video_screen.tap_by_coordinates(100, 100)
  @video_screen.wait_until(60) { @video_screen.play_video_button.displayed? }
  time_after_wait = @video_screen.video_current_time.text
  expect(@time_when_paused).to be == time_after_wait
end

And("I should be able to resume watching the show") do
  # rubocop:disable Custom/SleepCop.
  sleep(5)
  # rubocop:enable Custom/SleepCop.
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 5, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(60) { @video_screen.play_video_button.displayed? }
    @video_screen.play_video_button.click
  end
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 5, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(60) { @video_screen.play_video_button.displayed? }
    current_time = @video_screen.video_current_time.text
    expect(current_time).to be > @time_when_paused
  end
end

When("I check the video information") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(60) { @video_screen.video_buffer_element.empty? }
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(5) { @video_screen.info_button.displayed? }
    @video_screen.info_button.click
    @video_screen.wait_until(5) { @video_screen.info_box.text.include? NETWORK_DATA.unlocked_video }
  end
end

Then("the video information should show up") do
  @video_screen.wait_until(5) { @video_screen.info_text.displayed? }
  show_info = @video_screen.info_text.text
  expect(show_info).to match(/Season/)
  expect(show_info).to match(/Episode/)
end

And("{string} should disappear on tapping anywhere on the screen") do |window_element|
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    if window_element.include? "info box"
      @video_screen.wait_until(3) { @video_screen.info_boxes.empty? }
      expect(@video_screen.info_boxes.length).to equal 0
    elsif window_element.include? "options to share"
      @video_screen.wait_until(3) { @video_screen.share_video_options.empty? }
      expect(@video_screen.share_video_options.length).to equal 0
    end
  end
end

When("I try to share the video") do
  @video_screen = VideoScreen.new
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(5) { @video_screen.share_video.displayed? }
    @video_screen.share_video.click
    @video_screen.wait_until(3) { @video_screen.cancel_upload_button.displayed? }
    expect(@video_screen.cancel_upload_button.displayed? == true).to be true
  end
end

Then("I should see options to share the video") do
  expect(@video_screen.share_video_window.displayed? == true).to be true
end

When("I disable closed captioning") do
  @video_screen = VideoScreen.new
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(5) { @video_screen.closed_captions.displayed? }
    @video_screen.closed_captions.click
    @video_screen.wait_until(6) { @video_screen.search_info_button.empty? }
  end
end

Then("closed captioning should get disabled") do
  retry_proc = proc do
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 5, base_interval: 1, on_retry: retry_proc) do
    @video_screen.tap_by_coordinates(100, 100)
    @video_screen.wait_until(5) { @video_screen.closed_captions.displayed? }
    expect(@video_screen.closed_captions.value.include?("1")).to be_truthy
  end
end
