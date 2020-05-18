Given("I'm on the landing screen") do
  step "I am in splash screen"
  step "I navigate to welcome page"
  step "I click on maybe later button"
  step "I should be navigated to home screen"
end

Then("I should see the details of hero content") do
  @home_screen = HomeScreen.new
  expect(@home_screen.wait_until(30) { @home_screen.hero_title.displayed? }).to be true
  expect(@home_screen.wait_until(30) { @home_screen.hero_detail.displayed? }).to be true
  expect(@home_screen.wait_until(30) { @home_screen.hero_description.displayed? }).to be true
  expect(@home_screen.wait_until(30) { @home_screen.btn_hero_action.displayed? }).to be true
end

Then("I see Hero Carousel auto-rotating") do
  @home_screen = HomeScreen.new
  @hero_shows_count = @home_screen.hero_shows_count.size - 1
  @initial_title = @home_screen.hero_title.text
  (1..@hero_shows_count).each do |_i|
    # rubocop:disable Custom/SleepCop
    sleep 5 # sleep is used to check Hero Carousel rotational functionality for every 5 sec
    # rubocop:enable Custom/SleepCop
    @current_title = @home_screen.hero_title.text
    expect(@initial_title != @current_title).to be true
  end
end

Then("I see {string} carousel on homepage") do |rail_name|
  @home_screen = HomeScreen.new
  if rail_name == "Most Popular Shows"
    @home_screen.search_rail_by_name(rail_name)
    expect(@home_screen.wait_until(30) { @home_screen.most_popular_shows_rail.displayed? }).to be_truthy
  elsif rail_name == "Just Added Shows"
    step "I should be navigated to home screen"
    @home_screen.search_rail_by_name(rail_name)
    expect(@home_screen.wait_until(30) { @home_screen.just_added_rail.displayed? }).to be_truthy
  elsif rail_name == "Most popular Episodes this month"
    step "I should be navigated to home screen"
    @home_screen.search_rail_by_name(rail_name)
    expect(@home_screen.wait_until(30) { @home_screen.most_popular_episodes_rail.displayed? }).to be_truthy
  end
end

Then("I do {string} scroll on {string} and verify functionality") do |direction, carousel_name|
  @home_screen = HomeScreen.new
  @shows_screen = ShowScreen.new
  @show_card_count = @home_screen.rail_row_content(carousel_name).size - 1
  step "I do forward scroll" if direction.eql?("backword")
  if direction.eql?("forward")
    step "I do forward scroll"
  else
    step "I do backword scroll"
  end
end

And("I do forward scroll") do
  @show_screen = ShowScreen.new
  expect(@show_screen.wait_until(30) { @show_screen.show_title.displayed? }).to be true
  @before_scroll_title = @show_screen.show_title.text
  @show_card_count.times { @show_screen.press_right }
  @after_scroll_title = @show_screen.show_title.text
  expect(@before_scroll_title == @after_scroll_title).to be false
end

And("I do backword scroll") do
  @show_screen = ShowScreen.new
  expect(@show_screen.wait_until(30) { @show_screen.show_title.displayed? }).to be true
  @show_card_count.times { @show_screen.press_left }
  @initial_show_title = @show_screen.show_title.text
  expect(@initial_show_title == @before_scroll_title).to be true
end
