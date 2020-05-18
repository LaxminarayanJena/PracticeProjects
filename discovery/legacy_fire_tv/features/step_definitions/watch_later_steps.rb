# frozen_string_literal: true

When("I add the show to Watch Later") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(10) { @show_screen.watch_later_btn.displayed? }
  @show_screen.watch_later_btn.click
  @title_expect = @show_screen.show_title.text
end

Then("My videos screen should display the show added from {string} as my videos") do |screen_option_add|
  @my_videos_screen = MyVideosScreen.new
  @home_screen = HomeScreen.new
  @show_screen = ShowScreen.new
  case screen_option_add
  when "Search Screen"
    6.times { @my_videos_screen.press_up }
    @my_videos_screen.press_left
    @my_videos_screen.press_down
    step "I check the expected and actual title of the show"
  when "Browse Screen"
    3.times { @my_videos_screen.press_up }
    2.times { @my_videos_screen.press_right }
    step "Check the expected show title with actual show title"
  when "Shows Screen"
    3.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    @my_videos_screen.press_right
    step "Check the expected show title with actual show title"
  when "Featured Screen"
    3.times { @my_videos_screen.press_up }
    @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
    4.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    step "I check the expected and actual title of the show"
  end
end

Given("I have a show added to watch later from {string}") do |screen_option|
  case screen_option
  when "Featured Screen"
    step "I navigate to featured option"
    step "I view & click the popular show"
    step "I add the show to Watch Later"
    step "My videos screen should display the show added from 'Featured Screen' as my videos"
  when "Shows Screen"
    step "I am on shows screen"
    step "I click on show season"
    step "I add the show to Watch Later"
    step "My videos screen should display the show added from 'Shows Screen' as my videos"
  when "Browse Screen"
    step "I navigate to browse screen"
    step "I select the show from browse screen"
    step "I click on show season"
    step "I add the show to Watch Later"
    step "My videos screen should display the show added from 'Browse Screen' as my videos"
  when "Search Screen"
    step "I am on the shows screen"
    step "I add the show to Watch Later"
    step "My videos screen should display the show added from 'Search Screen' as my videos"
  end
end

And("I remove the show from my videos") do
  @show_screen = ShowScreen.new
  @show_screen.watch_later_btn.click
end

Then("My videos screen should not display the show removed from {string} as my videos") do |screen_option_remove|
  @my_videos_screen = MyVideosScreen.new
  @home_screen = HomeScreen.new
  case screen_option_remove
  when "Search Screen"
    6.times { @my_videos_screen.press_up }
    @my_videos_screen.press_left
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Browse Screen"
    3.times { @my_videos_screen.press_up }
    2.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Shows Screen"
    3.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Featured Screen"
    3.times { @my_videos_screen.press_up }
    @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
    4.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  end
end

And("I check the expected and actual title of the show") do
  @my_videos_screen.my_videos.first.click
  @title_actual = @show_screen.show_title.text
  expect(@title_expect == @title_actual).to be_truthy
end

Given("I search a show on Search screen") do
  step "I search a show"
  step "I select the show's card"
end

When("I add few episodes to Watch Later") do
  @my_videos_screen = MyVideosScreen.new
  @browse_screen = BrowseScreen.new
  @show_info = ShowScreen.new

  @splitvalue = @show_info.season_episode_text.text.split(" ")
  @episode_count = @splitvalue[4].to_i
  if @episode_count > 1
    (0..@episode_count).each do |_i|
      @show_info.wait_until(30) { @show_info.season_episode_text.displayed? }
      expect(@show_info.season_episode_text.displayed?).to be_truthy
      step "I add the show to Watch Later"
      @title_actual = @show_info.show_title.text
      @show_info.press_right
    end
  else
    puts "Not enough episodes to scroll"
  end
end

And("I navigate to My Videos screen from search") do
  @my_videos_screen = MyVideosScreen.new
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
  6.times { @my_videos_screen.press_up }
  @my_videos_screen.press_left
  @my_videos_screen.press_down
end

And("I navigate to My Videos screen") do
  @my_videos_screen = MyVideosScreen.new
  3.times { @my_videos_screen.press_up }
  4.times { @my_videos_screen.press_right }
  @my_videos_screen.press_right
end

Then("I see Episodes are sorted as recently added first and follows") do
  step "I check the expected and actual title of the show"
end

Then("I see episode playing from my videos list") do
  step "I click on play button"
  step "I should see video playing"
end

And("I login with affiliate which has few episodes under My Videos") do
  @my_videos_screen = MyVideosScreen.new
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.info_btn.displayed? }
  6.times { @my_videos_screen.press_up }
  @my_videos_screen.press_right
  step "I login with valid provider"
end

Then("I see videos added by anon & auth user") do
  @home_screen = HomeScreen.new
  @video_screen = MyVideosScreen.new
  @home_screen.wait_until(60) { @home_screen.logo.displayed? }
  @home_screen.wait_until(60) { @home_screen.featured_show.displayed? }
  @video_screen.navigate_to_myvideos
  2.times { @home_screen.press_down }
  expect(@video_screen.auth_video.displayed?).to be_truthy
  3.times { @home_screen.press_right }
end

Then("I see the show details in my video page") do
  @video_screen = MyVideosScreen.new
  @video_screen.press_down
  expect(@video_screen.my_videos.displayed?).to be_truthy
  expect(@video_screen.episode_show_name.displayed?).to be_truthy
  expect(@video_screen.season_episode_num.displayed?).to be_truthy
  expect(@video_screen.my_videos_image.displayed?).to be_truthy
end

Then("I see episode organised horizontally") do
  @home_screen = HomeScreen.new
  @home_screen.press_right
  @title_expect = @show_screen.show_title.text
  expect(@title_expect == @title_actual).to be_truthy
end
