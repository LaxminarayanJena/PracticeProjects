Given("I am on the Menu Bar") do
  @base_screen = BaseScreen.new
  step "I'm on the landing screen"
  @base_screen.press_left
end

And("I navigate to {string} screen") do |option_menu|
  @base_screen = BaseScreen.new
  @shows_screen = ShowScreen.new
  @search_screen = SearchScreen.new
  @settings_screen = SettingsScreen.new
  @signin_screen = SigninScreen.new
  @live_screen = LiveScreen.new
  @base_screen.menu_section(option_menu)
  if option_menu == "Home"
    step "I should be navigated to home screen"
  elsif option_menu == "Shows"
    expect(@shows_screen.wait_until(60) { @shows_screen.shows_header.displayed? }).to be_truthy
  elsif option_menu == "Search"
    expect(@search_screen.wait_until(60) { @search_screen.search_box.displayed? }).to be_truthy
  elsif option_menu == "Settings"
    expect(@settings_screen.wait_until(60) { @settings_screen.grid_menu_list.displayed? }).to be_truthy
  elsif option_menu == "Sign In"
    expect(@signin_screen.wait_until(60) { @signin_screen.tv_title.displayed? }).to be_truthy
  elsif option_menu == "Live"
    expect(@live_screen.wait_until(60) { @live_screen.live_network_logo_list.size.positive? }).to be_truthy
    expect(@live_screen.wait_until(60) { @live_screen.live_image.displayed? }).to be_truthy
  end
end

Then("I should scroll down & scroll up through Menu Bar options") do
  @search_screen = SearchScreen.new
  step "I navigate to 'Sign In' screen"
  @search_screen.press_left
  step "I navigate to 'Shows' screen"
  @search_screen.press_left
  step "I navigate to 'Home' screen"
  @search_screen.press_left
  step "I navigate to 'Search' screen"
  @search_screen.press_down
  @search_screen.press_left
  step "I navigate to 'Settings' screen"
end
