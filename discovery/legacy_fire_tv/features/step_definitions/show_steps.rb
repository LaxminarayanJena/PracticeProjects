When("I check the show info") do
  @show_screen = ShowScreen.new
  @show_screen.info_btn.click
end

Then("I should see information about the show") do
  @show_info = ShowInfoScreen.new
  expect(@show_info.title.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  expect(@show_info.description.text.include?(NETWORK_DATA.show_search[:show_desc])).to be true
end

Given("I select the show") do
  step "I search a show"
  step "I select the show's card"
end

When("I click on play button") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.play_video.first.displayed? }
  @show_screen.play_video.first.click
end

Then("I should see video playing") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.video_page.displayed? }
  expect(@show_screen.video_page.displayed?).to be_truthy
end

Given("I select show and scrub forward") do
  @video_screen = VideoScreen.new
  step "I search a show"
  step "I select the show's card"
  step "I click on play button"
  step "I should see video playing"
  @video_screen.press_fast_forward
  @video_screen.press_back
end

When("I search and play the same show") do
  @show_info = ShowScreen.new
  expect(@show_info.show_title.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  step "I click on play button"
end

Then("I should see continue and start over options") do
  @continue_watching = ShowScreen.new
  expect(@continue_watching.continue_show_title.text.include?(NETWORK_DATA.show_search[:show_name])).to be true
  expect(@continue_watching.continue_btn.displayed?).to be_truthy
  expect(@continue_watching.start_over_btn.displayed?).to be_truthy
end

Given("I am on shows screen") do
  @show_info = ShowScreen.new
  @show_info.wait_until(60) { @show_info.logo.displayed? }
  @show_info.navigate_to_shows
end

And("do forward scroll") do
  @show_info.press_down
  @show_info.press_select
  @show_info.wait_until(30) { @show_info.show_title.displayed? }
  @before_carousel_text = @show_info.show_title.text
  @show_info.press_back
  @show_info.wait_until(10) { @show_info.logo.displayed? }
  @show_info.press_down
  3.times { @show_info.press_right }
  @show_info.press_select
  @after_carousel_text = @show_info.show_title.text
end

And("do backward scroll") do
  @before_carousel_text = @after_carousel_text
  @show_info.press_back
  @show_info.wait_until(10) { @show_info.logo.displayed? }
  @show_info.press_down
  3.times { @show_info.press_left }
  @show_info.press_select
  @after_carousel_text = @show_info.show_title.text
end

When("I do {string} on seasons") do |scroll|
  @show_info = ShowScreen.new
  case scroll
  when "forward scroll"
    step "do forward scroll"
  when "backward scroll"
    step "do forward scroll"
    step "do backward scroll"
  end
end

Then("I verify {string} carousel functionality") do |assert_carousel|
  @show_info = ShowScreen.new
  case assert_carousel
  when "forward"
    expect(@before_carousel_text == @after_carousel_text).to be false
  when "backward"
    expect(@before_carousel_text == @after_carousel_text).to be false
  end
end
And("do forward scroll on seasonlist") do
  @show_info = ShowScreen.new
  # for i in @show_info.season_list_size
  @splitvalue = @show_info.season_episode_text.text.split(" ")
  @season_count = @splitvalue[1].to_i
  @episode_count = @splitvalue[4].to_i
  puts @episode_count
  puts @season_count
  @show_info.press_up
  if @season_count > 1
    (0..@season_count).each do |_i|
      @show_info.wait_until(30) { @show_info.season_episode_text.displayed? }
      expect(@show_info.season_episode_text.displayed?).to be_truthy
      @show_info.press_right
    end
  else
    puts "Not enough seasons to scroll"
  end
end

And("do backward scroll on seasonlist") do
  @show_info = ShowScreen.new
  if @season_count > 1
    (0..@season_count).each do |_i|
      @show_info.wait_until(30) { @show_info.season_episode_text.displayed? }
      expect(@show_info.season_episode_text.displayed?).to be_truthy
      @show_info.press_left
    end
  else
    puts "Not enough seasons to scroll"
  end
end

Then("I verify {string} on seasonslist carousel functionality") do |scroll|
  @show_info = ShowScreen.new
  case scroll
  when "forward scroll"
    step "do forward scroll on seasonlist"
  when "backward scroll"
    step "do forward scroll on seasonlist"
    step "do backward scroll on seasonlist"
  end
end

And("do forward scroll on episodelist") do
  @show_info = ShowScreen.new
  @splitvalue = @show_info.season_episode_text.text.split(" ")
  @episode_count = @splitvalue[4].to_i
  if @episode_count > 1
    (0..@episode_count).each do |_i|
      @show_info.wait_until(30) { @show_info.season_episode_text.displayed? }
      expect(@show_info.season_episode_text.displayed?).to be_truthy
      @show_info.press_right
    end
  else
    puts "Not enough episodes to scroll"
  end
end

And("do backward scroll on episodelist") do
  @show_info = ShowScreen.new
  if @episode_count > 1
    (0..@episode_count).each do |_i|
      @show_info.wait_until(30) { @show_info.season_episode_text.displayed? }
      expect(@show_info.season_episode_text.displayed?).to be_truthy
      @show_info.press_left
    end
  else
    puts "Not enough episodes to scroll"
  end
end

Then("I verify {string} on episodelist carousel functionality") do |scroll|
  @show_info = ShowScreen.new
  case scroll
  when "forward scroll"
    step "do forward scroll on episodelist"
  when "backward scroll"
    step "do forward scroll on episodelist"
    step "do backward scroll on episodelist"
  end
end

Given("I select the show with seasons and episode") do
  step "I search a show for seasons and episodes"
  step "I select the show's card"
end

Given("I select show and play video") do
  step "I search a show"
  step "I select the show's card"
  step "I click on play button"
end

When("I click on pause button") do
  step "I should see video playing"
  @show_screen = ShowScreen.new
  @show_screen.play_button.click
end

Then("I see playback is paused and player controls are active on video screen") do
  @video_screen = VideoScreen.new
  @video_screen.press_fast_forward
  @video_screen.press_rewind
end
