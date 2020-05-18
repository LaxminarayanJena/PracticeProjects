When("I navigate to Menu Bar left panel") do
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
end

Then("I should scroll down & scroll up through Menu Bar options") do
  @menubar_screen = MenuBarScreen.new
  4.times { @menubar_screen.press_down }
  expect(@menubar_screen.wait_until(30) { @menubar_screen.menu_account.displayed? }).to be true
  4.times { @menubar_screen.press_up }
  expect(@menubar_screen.wait_until(30) { @menubar_screen.menu_home.first.displayed? }).to be true
end

And("I should see {string} title on Home screen") do |option_title|
  @menubar_screen = MenuBarScreen.new
  @search_screen = SearchScreen.new
  step "I see Continue Watching rail then I press down"
  case option_title
  when "Shows"
    pending
  when "Just Added"
    2.times { @menubar_screen.press_down }
    expect(@menubar_screen.wait_until(30) { @menubar_screen.just_added_label.displayed? }).to be true
  when "Go Original Series"
    pending
  when "Popular Episodes"
    @menubar_screen.press_down
    expect(@menubar_screen.wait_until(30) { @menubar_screen.popular_epi_label.displayed? }).to be true
  else
    "No Matching option found, please enter valid option name"
  end
end

Given("I am on a Show screen in Apple TV") do
  @menubar_screen = MenuBarScreen.new
  step "I am on the home screen"
  @menubar_screen.navigate_to_shows
  @menubar_screen.press_select
end

Then("I should see shows label on Shows screen") do
  step "I see default network 'TLC' is selected"
end

Given("I am on a Live screen in Apple TV") do
  @menubar_screen = MenuBarScreen.new
  step "I am on the home screen"
  @menubar_screen.navigate_to_live
  @menubar_screen.press_select
end

Given("I am on a Search screen in Apple TV") do
  @search_screen = SearchScreen.new
  step "I am on the home screen"
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
end

Then("I should see search box on Search screen") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  expect(@search_screen.search_box.displayed?).to be true
end

Then("I see the navigation bar in {string} state with all the menu options") do |option|
  @menubar_screen = MenuBarScreen.new
  case option
  when "collapsed"
    expect(@menubar_screen.menu_home.first.visible.eql?("true")).to be false
    expect(@menubar_screen.menu_shows.visible.eql?("true")).to be false
    expect(@menubar_screen.menu_live.visible.eql?("true")).to be false
    expect(@menubar_screen.menu_search.visible.eql?("true")).to be false
    expect(@menubar_screen.menu_account.visible.eql?("true")).to be false
  when "expanded"
    expect(@menubar_screen.menu_home.first.visible.eql?("true")).to be true
    expect(@menubar_screen.menu_shows.visible.eql?("true")).to be true
    expect(@menubar_screen.menu_live.visible.eql?("true")).to be true
    expect(@menubar_screen.menu_search.visible.eql?("true")).to be true
    expect(@menubar_screen.menu_account.visible.eql?("true")).to be true
  end
end

Then("I see the {string} menu option is in the selected state") do |option|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case option
  when "Home"
    expect(@menubar_screen.menu_options_focus(option).focused.eql?("true")).to be true
  when "Shows"
    expect(@menubar_screen.menu_options_focus(option).focused.eql?("true")).to be true
  when "Live"
    expect(@menubar_screen.menu_options_focus(option).focused.eql?("true")).to be true
  when "Search"
    expect(@menubar_screen.menu_options_focus(option).focused.eql?("true")).to be true
  when "Account"
    expect(@menubar_screen.menu_options_focus(option).focused.eql?("true")).to be true
  end
end

When("I navigate and select {string} icon from search") do |icon|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case icon
  when "Home"
    3.times { @menubar_screen.press_up }
  when "Shows"
    2.times { @menubar_screen.press_up }
  when "Live"
    @menubar_screen.press_up
  when "Account"
    @menubar_screen.press_down
  end
  @menubar_screen.wait_until(30) { @menubar_screen.menu_shows.displayed? }
  @menubar_screen.press_select
end

When("I navigate and select {string} icon from home") do |icon|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case icon
  when "Shows"
    @menubar_screen.press_down
  when "Live"
    2.times { @menubar_screen.press_down }
  when "Search"
    3.times { @menubar_screen.press_down }
  when "Account"
    4.times { @menubar_screen.press_down }
  end
  @menubar_screen.wait_until(30) { @menubar_screen.menu_shows.displayed? }
  @menubar_screen.press_select
end

When("I navigate and select {string} icon from Shows") do |icon|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case icon
  when "Home"
    @menubar_screen.press_up
  when "Live"
    @menubar_screen.press_down
  when "Search"
    2.times { @menubar_screen.press_down }
  when "Account"
    3.times { @menubar_screen.press_down }
  end
  @menubar_screen.wait_until(30) { @menubar_screen.menu_shows.displayed? }
  @menubar_screen.press_select
end

When("I navigate and select {string} icon from Live") do |icon|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case icon
  when "Home"
    2.times { @menubar_screen.press_up }
  when "Shows"
    @menubar_screen.press_up
  when "Search"
    @menubar_screen.press_down
  when "Account"
    2.times { @menubar_screen.press_down }
  end
  @menubar_screen.wait_until(30) { @menubar_screen.menu_shows.displayed? }
  @menubar_screen.press_select
end

When("I navigate and select {string} icon from Account") do |icon|
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.navigate_to_menubar
  case icon
  when "Home"
    4.times { @menubar_screen.press_up }
  when "Shows"
    3.times { @menubar_screen.press_up }
  when "Live"
    2.times { @menubar_screen.press_up }
  when "Search"
    @menubar_screen.press_up
  end
  @menubar_screen.wait_until(30) { @menubar_screen.menu_shows.displayed? }
  @menubar_screen.press_select
end

And("all the other menu items are in unselected state except {string}") do |menu|
  @menubar_screen = MenuBarScreen.new
  case menu
  when "Home"
    expect(@menubar_screen.menu_shows.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_live.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_search.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_account.focused.eql?("true")).to be false
  when "Shows"
    expect(@menubar_screen.menu_home.first.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_live.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_search.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_account.focused.eql?("true")).to be false
  when "Live"
    expect(@menubar_screen.menu_home.first.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_shows.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_search.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_account.focused.eql?("true")).to be false
  when "Search"
    expect(@menubar_screen.menu_home.first.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_shows.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_live.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_account.focused.eql?("true")).to be false
  when "Account"
    expect(@menubar_screen.menu_home.first.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_shows.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_live.focused.eql?("true")).to be false
    expect(@menubar_screen.menu_search.focused.eql?("true")).to be false
  end
end

When("I scroll down on the {string} screen") do |option|
  @menubar_screen = MenuBarScreen.new
  case option
  when "Home"
    step "I see the home hero"
    4.times { @menubar_screen.press_down }
  when "Shows"
    step "I should see shows label on Shows screen"
    @menubar_screen.press_right
    3.times { @menubar_screen.press_down }
  when "Search"
    step "I should see search box on Search screen"
    2.times { @menubar_screen.press_down }
  when "Account"
    4.times { @menubar_screen.press_down }
  end
end

And("I tap on {string} icon") do |option|
  @menubar_screen = MenuBarScreen.new
  case option
  when "Home"
    step "tap on any menu icon"
  when "Shows"
    step "tap on any menu icon"
  when "Search"
    step "tap on any menu icon"
  when "Account"
    step "tap on any menu icon"
  end
end

When("I am taken to the top of the {string} screen") do |option|
  @menubar_screen = MenuBarScreen.new
  case option
  when "Home"
    @home_screen = HomeScreen.new
    step "I see the home hero"
    expect(@home_screen.home_hero.first.visible.eql?("true")).to be true
  when "Shows"
    @shows_screen = ShowScreen.new
    step "I see default network 'TLC' is selected"
    expect(@shows_screen.wait_until(30) { @shows_screen.tlc_shows_list.first.displayed? }).to be_truthy
    expect(@shows_screen.tlc_shows_list.first.visible.eql?("true")).to be true
  when "Search"
    @search_screen = SearchScreen.new
    step "I should see search box on Search screen"
    expect(@search_screen.search_box.focused.eql?("true")).to be true
  when "Account"
    @account_screen = AccountScreen.new
    step "I see Account screen sub menu list"
    expect(@account_screen.my_list.visible.eql?("true")).to be true
  end
end

And("tap on any menu icon") do
  @menubar_screen = MenuBarScreen.new
  @menubar_screen.press_menu
  @menubar_screen.press_select
end
