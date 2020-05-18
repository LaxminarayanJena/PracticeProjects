Given("I navigate to featured option") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.logo.displayed? }
  @home_screen.navigate_to_featured
end

Given("I'm on the home screen") do
  @home_screen = LandingScreen.new
  @home_screen.wait_until(30) { @home_screen.home_carousel_title_text.displayed? }
end

When("I view & click on one of the featured show") do
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  @home_screen.wait_until(30) { @home_screen.featured_show.displayed? }
  @landing_screen.home_carousel_title_text.click
end

When("I should see show season episode") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.show_season_episode_text.displayed? }
end

And("I scroll down till the show") do
  @show_screen = ShowScreen.new
  2.times { @show_screen.press_down }
end

And("I view & click on last night carousel") do
  @home_screen = HomeScreen.new
  @home_screen.press_down
  @home_screen.wait_until(30) { @home_screen.onlastnight_carousel_title.displayed? }
  @home_screen.wait_until(30) { @home_screen.video_card_wrapper.displayed? }
  @home_screen.video_card_wrapper.click
end

When("I view & click the watch live") do
  @home_screen = HomeScreen.new
  @screen = LandingScreen.new
  @home_screen.press_down
  @home_screen.wait_until(30) { @home_screen.watch_tv_icon.displayed? }
  @home_screen.wait_until(30) { @home_screen.watch_tv_text.displayed? }
  @home_screen.wait_until(30) { @home_screen.watch_tv_video_image_icon.displayed? }
  2.times { @home_screen.watch_tv_video_image_icon.click }
end

And("I view & click the watch live tv program") do
  step "I view & click the watch live"
  @home_screen.press_down
  @screen.play_btn.click
end

When("I view & click the popular show") do
  @home_screen = HomeScreen.new
  3.times { @home_screen.press_down }
  @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
  @home_screen.wait_until(30) { @home_screen.popular_logo_image.displayed? }
  2.times { @home_screen.popular_logo_image.click }
end

When("I view & click an unlocked show") do
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  4.times { @home_screen.press_down }
  @home_screen.wait_until(30) { @home_screen.unlocked_episodes_desc.displayed? }
  @landing_screen.unlocked_episodes.first.click
end

When("I view & click the show from discovery go lists") do
  @home_screen = HomeScreen.new
  5.times { @home_screen.press_down }
  @home_screen.wait_until(30) { @home_screen.go_lists_desc.displayed? }
  2.times { @home_screen.go_lists_desc.click }
end

Then("I do forward scroll in {string} and verify functionality") do |carousel_option|
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  @home_screen.press_up
  case carousel_option
  when "Featured carousel"
    @home_screen.press_down
    @before_scroll_carousel_text = @landing_screen.home_carousel_title_text.text
    4.times { @home_screen.press_right }
    @after_scroll_carousel_text = @landing_screen.home_carousel_title_text.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "ON LAST NIGHT"
    2.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.onlastnight_carousel_title.displayed? }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text
    4.times { @home_screen.press_right }
    @after_scroll_carousel_text = @cards.first.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "Unlocked Episodes"
    5.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.unlocked_episodes_desc.displayed? }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text + @cards[1].text
    4.times { @home_screen.press_right }
    @after_scroll_carousel_text = @cards.first.text + @cards[1].text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "Discovery GO Lists"
    6.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.go_lists_desc.displayed? }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text
    4.times { @home_screen.press_right }
    @after_scroll_carousel_text = @cards.first.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  else
    "No Matching carousel found, please enter valid carousel name"
  end
end

Then("I do backward scroll in {string} and verify functionality") do |carousel_option|
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  @home_screen.press_up
  case carousel_option
  when "Featured carousel"
    @home_screen.press_down
    6.times { @home_screen.press_right }
    @before_scroll_carousel_text = @landing_screen.home_carousel_title_text.text
    3.times { @home_screen.press_left }
    @after_scroll_carousel_text = @landing_screen.home_carousel_title_text.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "ON LAST NIGHT"
    2.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.onlastnight_carousel_title.displayed? }
    6.times { @home_screen.press_right }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text
    3.times { @home_screen.press_left }
    @after_scroll_carousel_text = @cards.first.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "Unlocked Episodes"
    5.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.unlocked_episodes_desc.displayed? }
    6.times { @home_screen.press_right }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text + @cards[1].text
    3.times { @home_screen.press_left }
    @after_scroll_carousel_text = @cards.first.text + @cards[1].text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  when "Discovery GO Lists"
    6.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.go_lists_desc.displayed? }
    6.times { @home_screen.press_right }
    @cards = @home_screen.carousel(carousel_option)
    @before_scroll_carousel_text = @cards.first.text
    3.times { @home_screen.press_left }
    @after_scroll_carousel_text = @cards.first.text
    expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
  else
    "No Matching carousel found, please enter valid carousel name"
  end
end

And("I see and click on any show episode") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.video_card_wrapper.displayed? }
  @home_screen.video_card_wrapper.click
end

Then("I view the {string} scrubber") do |carousel_option|
  @home_screen = HomeScreen.new
  if carousel_option == "on last night carousel"
    @home_screen.press_down
    @home_screen.wait_until(30) { @home_screen.onlastnight_carousel_title.displayed? }
    step "I see the scrubber"
  elsif carousel_option == "unlocked episodes"
    4.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.unlocked_episodes_desc.displayed? }
    step "I see the scrubber"
  elsif carousel_option == "discovery go lists"
    5.times { @home_screen.press_down }
    @home_screen.wait_until(30) { @home_screen.go_lists_desc.displayed? }
    step "I see the scrubber"
  end
end

And("I see the scrubber") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.scrubber.displayed? }
end

Then("I see Hero carousel rotating automatically") do
  @landing_screen = LandingScreen.new
  (0..5).each do |_i|
    puts "Verifying the auto carousel functionality for every 5sec"
    @initial_title = @landing_screen.home_carousel_title_text.text
    puts "Initial title = " + @initial_title
    # rubocop:disable Custom/SleepCop.
    sleep(5) # To check carousel is automatically rotating for every 5 sec
    # rubocop:enable Custom/SleepCop.
    @current_title = @landing_screen.home_carousel_title_text.text
    puts "current title = " + @current_title
    expect(@initial_title != @current_title).to be_truthy
  end
end

When("I focus on Hero Carousel") do
  @landing_screen = LandingScreen.new
  @landing_screen.press_down
end

And("I click on hero content") do
  @landing_screen = LandingScreen.new
  @landing_screen.press_select
end

Then("I see title and discription of the show") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.home_carousel_title_text.displayed?).to be_truthy
  expect(@landing_screen.call_to_action_text.displayed?).to be_truthy
  expect(@landing_screen.description_text.displayed?).to be_truthy
end
