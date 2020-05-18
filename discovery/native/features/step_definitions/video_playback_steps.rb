# frozen_string_literal: true

Then("I should be able to scrub forward") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed"
  @video.video_container.click
  initial_time = @video.video_current_time
  @video.scrub_forward(3)
  after_seeking = @video.video_current_time
  expect(after_seeking).to be > initial_time
  Kernel.puts "============Before Seeking: #{initial_time} After Seeking: #{after_seeking} ------------"
end

Then("I should be able to scrub backward") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed"
  @video.wait_until { @video.seek_bar.displayed? }
  @video.scrub_forward(3)
  initial_time = @video.video_current_time
  @video.scrub_backward(3)
  after_seeking = @video.video_current_time
  expect(after_seeking).to be < initial_time
  Kernel.puts "============Before Seeking: #{initial_time} After Seeking: #{after_seeking} ------------"
end

Then(/^I should see the video playing till end$/) do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  co = @video.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  @start_time = @video.video_current_time.to_f + 1
  Kernel.puts "start time #{@start_time}"
  @end_time = @video.end_time.to_f
  Kernel.puts "end time #{@end_time}"
  @video.wait_until { @video.video_text.displayed? }
  # capturing the video title for verfiying up_next video title
  @current_video_text = @video.video_text.text
  Kernel.puts "video title #{@current_video_text}"
  @video.watch_video_till(@start_time, @end_time)
  Kernel.puts "video ended"
end

Then(/^Video should playing till end$/) do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  # capturing the video title for verfiying up_next video title
  @current_video_text = @video.video_text.text
  Kernel.puts "video title #{@current_video_text}"
  @video.watch_full_video
end

Then("Autoplay the next episode") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  @video.video_container.click
  Kernel.puts " =====out of loop========="
  # sleep 30   # sleep required for load next video
  @video.wait_until { @video.video_text.displayed? }
  @upnext_video_text = @video.video_text.text
  Kernel.puts "video title #{@upnext_video_text}"
  expect(@currentvideo_text != @upnext_video_text).to be true
end

Then("I should {string} the AD") do |string|
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed #{string}"
  @video.scrub_to_segment(2)
  Kernel.puts "scrubed till segement"
  @video.video_container.click
  expect(@video.ad_title.positive?).to be true
  Kernel.puts "ad title present"
  @video.video_container.click if string == "Play"
  co = @video.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  @ad_initial_time = @video.video_current_time.split(":")[1].to_i
  Kernel.puts "ad initial time: #{@ad_initial_time}"
  # rubocop:disable Custom/SleepCop.
  # sleep is used to check the video current time changes or not
  sleep 10
  @video.tap_by_coordinates(co[0], co[1])
  @after_sleep_time = @video.video_current_time.split(":")[1].to_i
  Kernel.puts "ad sleep time: #{@after_sleep_time}"
  if string == "Pause"
    expect(@after_sleep_time).to equal(@ad_initial_time)
  else
    expect(@after_sleep_time).to be > @ad_initial_time
  end
end

Then("Allow content to play through first ad break and Scrub forward") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed"
  @video.video_container.click
  @video.scrub_forward_till_ad(2)
  @current_video_text = @video.video_text.text
  Kernel.puts "video title #{@current_video_text}"
  @video.watch_full_video
end

Then("Allow content to play through first ad break and Scrub backwards") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed"
  @video.video_container.click
  @video.scrub_forward_till_ad(2)
  @video.scrub_backward(3)
  @current_video_text = @video.video_text.text
  Kernel.puts "video title #{@current_video_text}"
  @video.watch_full_video
end

Then("Allow content to play through first ad break and click learn more link") do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  Kernel.puts "video displayed"
  @video.video_container.click
  @video.scrub_forward(2)
  @video.learn_more_link.click
  @video.switch_to_web
  puts "switched to web view"
  # required to load the web page
  sleep 20
  driver.press_keycode(4)
  @video.switch_context_to_native
  puts "switched to native view"
  Kernel.puts "back to ad page"
  co = @video.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  expect(@video.pause_button.displayed?).to be true
  # required to play after 10sec as per requirement
  sleep 10
  @video.video_container.click
  @video.watch_ad(co)
  co = @video.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  @video.video_container.click
  Kernel.puts "video paused"
  # pause video for 10sec
  sleep 20
  co = @video.get_coordinates(@video.video_container)
  @video.tap_by_coordinates(co[0], co[1])
  @video.video_container.click
  Kernel.puts "video played"
  # Play video for 10sec
  sleep 30
  # rubocop:enable Custom/SleepCop.
end

And("I change device orientation to landscape") do
  @video = VideoScreen.new
  @video.wait_until { @video.full_screen_button.displayed? }
  @video.full_screen_button.click
end

Then("I should be able to play the episode") do
  @home_screen = HomeScreen.new
  expect(@home_screen.unlocked_episode.displayed?).to be_truthy
  @home_screen.unlocked_episode.click
end

And("I see video is playing") do
  @video = VideoScreen.new
  expect(@video.play_button.displayed?).to be_truthy
end

And("I see episode playing on portrait mode") do
  @video = VideoScreen.new
  @video.wait_until(30) { @video.video_container.displayed? }
  mode = driver.orientation.to_s
  expect(mode).to eq "portrait"
end

And("I see episode playing on landscape mode") do
  @video = VideoScreen.new
  @video.wait_until(30) { @video.video_container.displayed? }
  mode = driver.orientation.to_s
  expect(mode).to eq "landscape"
end

When("I change phone orientation to landscape mode") do
  driver.rotation = :landscape
  mode = driver.orientation.to_s
  expect(mode).to eq "landscape"
end

When("I change phone orientation to portrait mode") do
  driver.rotation = :portrait
  mode = driver.orientation.to_s
  expect(mode).to eq "portrait"
end

Then("I see Play and Pause option on Player UI") do
  @video = VideoScreen.new
  @video.wait_until { @video.play_button.displayed? }
  expect(@video.play_button.displayed?).to be_truthy
  @video.video_container.click
  @video.wait_until { @video.pause_button.displayed? }
  expect(@video.pause_button.displayed?).to be_truthy
end

Then("I see CC option on player UI") do
  @video = VideoScreen.new
  @video.wait_until { @video.captions.displayed? }
  expect(@video.captions.displayed?).to be_truthy
  @video.captions.click
end

And("I tap on forward button") do
  @video = VideoScreen.new
  expect(@video.forward_button.displayed?).to be_truthy
  @initial_time = @video.video_current_time
  Kernel.puts "video displayed current #{@initial_time}"
  @video.video_container.click
  @video.forward_button.click
  @after_forwarding = @video.video_current_time
  Kernel.puts "video displayed #{@after_forwarding}"
end

Then("I see video advances ten seconds") do
  @time_difference = @after_forwarding.split(":")[-1].to_i - @initial_time.split(":")[-1].to_i
  Kernel.puts "time differnece #{@time_difference}"
  expect(@time_difference).to be >= 10
end

And("I tap on rewind button") do
  @video = VideoScreen.new
  expect(@video.rewind_button.displayed?).to be_truthy
  @video.forward_button.click
  @start_time = @video.video_current_time
  Kernel.puts "video displayed current #{@start_time}"
  @video.video_container.click
  @video.rewind_button.click
  @after_rewind = @video.video_current_time
  Kernel.puts "video displayed #{@after_rewind}"
end

Then("I see video rewinds ten seconds") do
  @time_difference = @after_rewind.split(":")[-1].to_i - @start_time.split(":")[-1].to_i
  Kernel.puts "time differnece #{@time_difference}"
  expect(@time_difference).to be <= 10
end
