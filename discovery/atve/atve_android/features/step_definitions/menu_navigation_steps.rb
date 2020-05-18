And("I go to the {string} screen") do |option|
  @base_screen = BaseScreen.new
  case option
  when "Home"
    expect(@base_screen.home_icon.displayed?).to be_truthy
    @base_screen.home_icon.click

  when "Shows"
    expect(@base_screen.shows_icon.displayed?).to be_truthy
    @base_screen.shows_icon.click

  when "Live"
    expect(@base_screen.live_icon.displayed?).to be_truthy
    @base_screen.live_icon.click

  when "Search"
    expect(@base_screen.search_icon.displayed?).to be_truthy
    @base_screen.search_icon.click

  when "Account"
    expect(@base_screen.account_icon.displayed?).to be_truthy
    @base_screen.account_icon.click
  end
end

Given("I am on {string} screen") do |menu_option|
  @base_screen = BaseScreen.new
  @home_screen = HomeScreen.new
  @search_screen = SearchScreen.new

  case menu_option
  when "Home"
    @home_screen.wait_until(30) { expect(@home_screen.home_hero.displayed?).to be_truthy }

  when "Shows"
    @base_screen.wait_until(30) { expect(@base_screen.shows_screen_title.displayed?).to be_truthy }

  when "Live"
    @base_screen.wait_until(30) { expect(@base_screen.live_screen_title.displayed?).to be_truthy }

  when "Search"
    @search_screen.wait_until(30) { expect(@search_screen.search_text_field.displayed?).to be_truthy }

  when "Account"
    @base_screen.wait_until(30) { expect(@base_screen.settings_title.displayed?).to be_truthy }
  end
end
