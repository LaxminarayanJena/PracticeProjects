Given("I am on the home screen") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.home_hero.first.displayed? }).to be true
end

When("I see the home hero") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_hero.first.displayed? }
end

When("I start the home hero series") do
  @home_screen = HomeScreen.new
  step "I see the home hero"
  @home_screen.home_hero.first.click
end

Then("I should see the series name and description") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.series_name.displayed? }
  @home_screen.wait_until(30) { @home_screen.series_description.displayed? }
end

When("I see the focus is on Hero Carousel") do
  @home_screen = HomeScreen.new
  expect(@home_screen.focus_hero.eql?("true")).to be false
end

Then("I see Hero Carousel auto-rotating") do
  @home_screen = HomeScreen.new
  # rubocop:disable Custom/SleepCop
  sleep 4 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @current_video_name = @home_screen.series_name.text
  # rubocop:disable Custom/SleepCop
  sleep 5 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @video_name_after_rotation = @home_screen.hero_after_rotation.text
  expect(@current_video_name.eql?(@video_name_after_rotation)).to be false
end

And("I go away from Hero carousel and refocus") do
  @home_screen = HomeScreen.new
  5.times { @home_screen.press_down }
  5.times { @home_screen.press_up }
  step "I see the focus is on Hero Carousel"
end

Then("I see Hero Carousel stops rotating") do
  @home_screen = HomeScreen.new
  # rubocop:disable Custom/SleepCop
  sleep 5 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @current_video_name = @home_screen.series_name.text
  puts @current_video_name
  # rubocop:disable Custom/SleepCop
  sleep 6 # sleep is used to load Hero Carousel rotating automatically in the loop 5 sec
  # rubocop:enable Custom/SleepCop
  @video_name_after_rotation = @home_screen.hero_after_rotation.text
  puts @video_name_after_rotation
  expect(@current_video_name.eql?(@video_name_after_rotation)).to be true
end

When("I see and navigate to {string} rail") do |carousel_name|
  @home_screen = HomeScreen.new
  step "I see Continue Watching rail then I press down"
  case carousel_name
  when "Most Popular Shows"
    @home_screen.press_down
    @home_screen.wait_until(30) { expect(@home_screen.carousels(carousel_name).size.positive?).to be_truthy }
  when "Just Added Shows"
    2.times { @home_screen.press_down }
    @home_screen.wait_until(30) { expect(@home_screen.carousels(carousel_name).size.positive?).to be_truthy }
  else
    "No Matching carousel found, please enter valid carousel name"
  end
end

Then("I do {string} scroll in {string} and verify functionality") do |direction, carousel_name|
  @home_screen = HomeScreen.new
  8.times { @home_screen.press_right } if direction.eql?("left")
  @before_scroll_carousel_text = @home_screen.carousels_showname_list(carousel_name).first.text
  puts @before_scroll_carousel_text
  if direction.eql?("right")
    4.times { @home_screen.press_right }
  else
    6.times { @home_screen.press_left }
  end
  @after_scroll_carousel_text = @home_screen.carousels_showname_list(carousel_name).first.text
  puts @after_scroll_carousel_text
  expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
end

When("I see Continue Watching rail then I press down") do
  @home_screen = HomeScreen.new
  @home_screen.press_down if @home_screen.carousels("Continue Watching").size.positive?
end

Then("I see Metadata on the {string} tile containing thumbnail image, title, network logo") do |carousel_name|
  @home_screen = HomeScreen.new
  expect(@home_screen.carousels(carousel_name).first.displayed?).to be_truthy
  expect(@home_screen.carousels(carousel_name).size == @home_screen.carousels_showimage_list(carousel_name).size).to be_truthy
  expect(@home_screen.carousels(carousel_name).size == @home_screen.carousels_networklogo_list(carousel_name).size).to be_truthy
  @show_name_list = @home_screen.carousels_showname_list(carousel_name)
  @show_name_list.each do |showname|
    puts showname.text
    expect(showname.text.empty?).not_to be_truthy
  end
end

Then("I see network logo on the top left") do
  @home_screen = HomeScreen.new
  expect(@home_screen.network_logo.visible.eql?("true")).to be true
end

And("I click on any tile in the {string} rail") do |carousel_name|
  @home_screen = HomeScreen.new
  case carousel_name
  when "Most Popular Shows"
    @home_screen.carousels(carousel_name)[0].click
  when "Just Added Shows"
    @home_screen.carousels(carousel_name)[0].click
  else
    "No Matching carousel found, please enter valid carousel name"
  end
  step "I see the season listed"
  step "I click on any episode"
end
