# frozen_string_literal: true

When(/^I view an unlocked episode$/) do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.unlocked_episode}")
end

When(/^I scroll unlocked episodes right and left$/) do
  @landing_screen = LandingScreen.new
  @home_screen = HomeScreen.new
  @show_screen = ShowScreen.new
  @landing_screen.scroll_to_unlocked_episode
  start_x = @home_screen.unlocked_episodes_show_card.location.x
  puts "====== start_x #{start_x} =================="
  y = @home_screen.unlocked_episodes_show_card.location.y
  puts "====== y is #{y} =================="
  # start of the screen
  end_x = 1
  @show_screen.wait_until(30) { @show_screen.show_info_button.displayed? }
  @current_video_title = @landing_screen.recent_video_title.text
  Kernel.puts "current video title: #{@current_video_title}"
  Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 200).perform.release
  @after_scrubed_video_title = @landing_screen.recent_video_title.text
  Kernel.puts "after scrubed video title: #{@after_scrubed_video_title}"
  expect(@current_video_title != @after_scrubed_video_title).to be true
  Appium::TouchAction.new.swipe(start_x: start_x + 300, start_y: y, end_x: start_x + 1000, end_y: y, duration: 200).perform.release
  @landing_screen.wait_until(30) { @landing_screen.recent_video_title.displayed? }
end
