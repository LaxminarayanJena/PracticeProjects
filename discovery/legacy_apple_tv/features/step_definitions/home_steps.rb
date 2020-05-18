Given("I navigate to featured option") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }).to be true
end

Given("I'm on the home screen") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }).to be true
end

When("I view & click on one of the featured show") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.featured_show.displayed? }).to be true
  @home_screen.press_down
  @home_screen.featured_show.click
end

And("I should see show description") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.featured_show_season.displayed? }).to be true
end

When("I see {string} title") do |show_name|
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.featured_show.displayed? }).to be true
  case show_name
  when "Just Added"
    3.times { @home_screen.press_down }
    expect(@home_screen.wait_until(30) { @home_screen.just_added_title.displayed? }).to be true
  when "Popular Shows"
    4.times { @home_screen.press_down }
    expect(@home_screen.wait_until(30) { @home_screen.popular_shows_title.displayed? }).to be true
  when "Stream Free Episodes"
    5.times { @home_screen.press_down }
    expect(@home_screen.wait_until(30) { @home_screen.stream_free_title.displayed? }).to be true
  when "Classic Series for Free"
    6.times { @home_screen.press_down }
    expect(@home_screen.wait_until(30) { @home_screen.classic_series_title.displayed? }).to be true
  else
    "No Matching option found, please enter valid option name"
  end
end

And("I click on one of {string} Video") do |video_name|
  @home_screen = HomeScreen.new
  case video_name
  when "Just Added"
    @home_screen.press_left
    @home_screen.just_added_video.displayed?
    @home_screen.just_added_video.click
  when "Popular Shows"
    @home_screen.press_left
    @home_screen.popular_shows_video.displayed?
    @home_screen.popular_shows_video.click
  when "Stream Free Episodes"
    @home_screen.press_left
    @home_screen.stream_free_video.displayed?
    @home_screen.stream_free_video.click
  when "Classic Series for Free"
    @home_screen.classic_series_video.displayed?
    @home_screen.classic_series_video.click
  else
    "No Matching option found, please enter valid option name"
  end
end

Then("I should see {string} video playing") do |options|
  if options == "Popular Shows"
    @home_screen = HomeScreen.new
    expect(@home_screen.wait_until(30) { @home_screen.play_latest_button.displayed? }).to be true
    @home_screen.play_latest_button.click
  end
  step "check for resume option is displayed"
  step "check is video is playing"
end

Given("check for resume option is displayed") do
  if @home_screen.check_start_from_beginning_button.positive?
    @home_screen.press_down
    @home_screen.start_from_beginning_button.click
  end
end

Given("check is video is playing") do
  @home_screen.press_media_play_pause
  @home_screen.press_up
  @home_screen.press_right
  expect(@home_screen.time_scrubbing_value.gsub(":", ".").to_f).to be > 0.0
end

Then("I do {string} scroll in {string} and verify functionality") do |direction, carousel|
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.featured_show.displayed? }).to be true
  if carousel.eql?("Featured carousel")
    @home_screen.press_down
    expect(@home_screen.wait_until(30) { @home_screen.featured_show.displayed? }).to be true
  else
    step "I see '#{carousel}' title"
  end
  step "Verify '#{direction}' '#{carousel}' functionality"
end

Given("Verify {string} {string} functionality") do |direction, carousel_name|
  @home_screen = HomeScreen.new
  8.times { @home_screen.press_right } if direction.eql?("backward")
  @before_scroll_carousel_text = @home_screen.carousel_title(carousel_name).text
  if direction.eql?("forward")
    4.times { @home_screen.press_right }
  else
    6.times { @home_screen.press_left }
  end
  @after_scroll_carousel_text = @home_screen.carousel_title(carousel_name).text
  expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
end

When("The focus is on Featured header") do
  @home_screen = HomeScreen.new
  expect(@home_screen.focus_featured_header.eql?("true")).to be true
end

Then("I see Hero Carousel rotating automatically in the loop 5 sec") do
  @home_screen = HomeScreen.new
  # rubocop:disable Custom/SleepCop
  sleep 5 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @current_video_name = @home_screen.featured_show.text
  puts @current_video_name
  # rubocop:disable Custom/SleepCop
  sleep 6 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @video_name_after_rotation = @home_screen.featured_show_rotation.text
  puts @video_name_after_rotation
  expect(@video_name_after_rotation.eql?(@current_video_name)).to be false
end

When("The focus is on Hero Carousel") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.featured_show.displayed? }).to be true
  @home_screen.press_down
end

Then("I see Hero Carousel stops rotating") do
  @home_screen = HomeScreen.new
  # rubocop:disable Custom/SleepCop
  sleep 5 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @current_video_name = @home_screen.featured_show.text
  puts @current_video_name
  # rubocop:disable Custom/SleepCop
  sleep 6 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @video_name_after_rotation = @home_screen.featured_show_rotation.text
  puts @video_name_after_rotation
  expect(@video_name_after_rotation.eql?(@current_video_name)).to be true
end

Given("I am on Featured screen as {string} user.") do |user_type|
  @home_screen = HomeScreen.new
  @settings_screen = SettingsScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }).to be true
  step "I am on a settings screen"
  case user_type
  when "authorised"
    expect(@settings_screen.signout_settings.displayed?).to be true
    puts "I'm an authorised user."
  when "anonymous"
    expect(@settings_screen.activate_settings.displayed?).to be true
    puts "I'm an anonymous user."
  else
    puts "No Matching user type found, please enter valid user type"
  end
end

When("I navigate to any Episode list Ex: {string} as {string} user.") do |show_name, user_type|
  @home_screen = HomeScreen.new
  @home_screen.navigate_to_featured_menu
  case show_name
  when "Just Added"
    if user_type.eql?("authorised")
      3.times { @home_screen.press_down }
    else
      2.times { @home_screen.press_down }
    end
    @home_screen.press_left
    expect(@home_screen.wait_until(30) { @home_screen.just_added_video.displayed? }).to be true
  when "Stream Free Episodes"
    if user_type.eql?("anonymous")
      4.times { @home_screen.press_down }
    else
      5.times { @home_screen.press_down }
    end
    @home_screen.press_left
    expect(@home_screen.wait_until(30) { @home_screen.stream_free_video.displayed? }).to be true
  else
    puts "No Matching show name found, please enter valid show name"
  end
end

Then("I see Episode Thumbnail, Show Name, Season Number, Episode Number as a metadata for {string} list.") do |list_name|
  @home_screen = HomeScreen.new
  case list_name
  when "Just Added"
    @data = @home_screen.just_added_video.text
  when "Stream Free Episodes"
    @data = @home_screen.stream_free_video.text
  else
    "wrong list type"
  end
  @data_array = @data.split(", ")
  @data_array_2 = @data_array[0].split(" • ")
  expect(@data_array_2[0].include?("Season")).to be true
  expect(@data_array_2[1].include?("Episode")).to be true
  puts "Meta Data is as below : \n" + @data_array[1] + "\n" + @data_array_2[1] + "\n" + @data_array_2[0]
end
