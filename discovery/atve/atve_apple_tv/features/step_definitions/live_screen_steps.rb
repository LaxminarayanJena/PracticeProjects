Given("I launch the app") do
  @live_screen = LiveScreen.new
  step "I am on splash screen"
end

When("I navigate to Live screen in Apple TV") do
  step "I am on a Live screen in Apple TV"
end

Then("I should see the live screen with Network List that has all the 18 networks,On Now section and Up Next section") do
  @live_screen = LiveScreen.new
  expect(@live_screen.wait_until(60) { @live_screen.live_screen_nw_list.size.positive? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_screen_nw_list.size }).to be == 7
  puts "On Now section and Up Next section not implemented yet, will add script once it gets implemented"
end

When("I see the network selectors list with default selected network ex.TLC network") do
  @live_screen = LiveScreen.new
  expect(@live_screen.wait_until(60) { @live_screen.live_screen_nw_list.size.positive? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_screen_nw_list.first.selected? }).to be_truthy
  @live_screen.wait_until(60) { @live_screen.live_screen_nw_list.first.attribute("visible") == "true" }
end

Then("I should see the network logo at the top of the screen as per the default selected network") do
  @live_screen = LiveScreen.new
  step "I see default network 'TLC' is selected"
end
