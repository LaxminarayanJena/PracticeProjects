When("I click on any Show") do
  @showdetail_screen = ShowDetailScreen.new
  step "I see default network 'TLC' is selected"
  step "I click on any show tile of the selected network 'TLC' organised in content grids"
end

Then("I see Show details page") do
  @showdetail_screen = ShowDetailScreen.new
  step "I am taken to the selected network's 'TLC' Show Details page"
end

And("I see Network logo, 'Keep Watching' text and {string} or {string} button on the Show Hero screen") do |button, button1|
  @showdetail_screen = ShowDetailScreen.new
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.hero_show_carousel("1000-lb Sisters").displayed? }
  expect(@showdetail_screen.hero_network_logo.size.positive?).to be_truthy
  if button == "Resume"
    @showdetail_screen.wait_until(30) { @showdetail_screen.shows_hero_button("Resume").displayed? }
  elsif button1 == "Start Series"
    @showdetail_screen.wait_until(30) { @showdetail_screen.shows_hero_button("Start Series").displayed? }
    @showdetail_screen.wait_until(30) { @shows_screen.hero_show_carousel("NEW EPISODES").displayed? }
  end
end

And("I navigate to Show details page") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.hero_show_carousel("1000-lb Sisters").displayed? }
end

Then("I see Show Title over the Show Hero") do
  step "I see Show details page"
end

Then("I see Show specific hero on top") do
  step "I see Show details page"
end

And("I press on 'back' button on the remote") do
  @shows_screen = ShowScreen.new
  @after_show_title = @shows_screen.hero_show_carousel("1000-lb Sisters").text
  @shows_screen.press_right
  @shows_screen.press_down
  step "I see the season listed"
  @shows_screen.press_menu
end

Then("I see previous screen") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.tlc_all_shows.displayed?).to be_truthy }
  if @shows_screen.tlc_shows_list.size.positive?
    expect(@shows_screen.tlc_shows_list.first.displayed?).to be_truthy
    @before_show_title = @shows_screen.tlc_shows_name.first.text
    @after_show_title.eql?(@before_show_title)
  else
    puts "I do not see previous screen"
  end
end
