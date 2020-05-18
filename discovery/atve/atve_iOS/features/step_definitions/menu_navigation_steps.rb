Given("I go to {string} screen") do |menu_option|
  @base_screen = BaseScreen.new
  @home_screen = HomeScreen.new
  @search_screen = SearchScreen.new
  @account_screen = AccountScreen.new

  case menu_option
  when "Home"
    Support::Eventually.eventually(timeout: 20) { expect(@base_screen.home_icon.displayed?).to be_truthy }
    @base_screen.home_icon.click

  when "Shows"
    Support::Eventually.eventually(timeout: 20) { expect(@base_screen.shows_icon.displayed?).to be_truthy }
    @base_screen.shows_icon.click

  when "Live"
    Support::Eventually.eventually(timeout: 20) { expect(@base_screen.live_icon.displayed?).to be_truthy }
    @base_screen.live_icon.click

  when "Search"
    Support::Eventually.eventually(timeout: 20) { expect(@base_screen.search_icon.displayed?).to be_truthy }
    @base_screen.search_icon.click

  when "Account"
    Support::Eventually.eventually(timeout: 20) { expect(@base_screen.account_icon.displayed?).to be_truthy }
    @base_screen.account_icon.click
  end
end

Given("Validate i am on {string} screen") do |menu_option|
  @home_screen = HomeScreen.new
  @shows_screen = ShowScreen.new
  @search_screen = SearchScreen.new
  @account_screen = AccountScreen.new

  case menu_option
  when "Home"
    @home_screen.wait_until(30) { expect(@home_screen.home_hero.first.displayed?).to be_truthy }

  when "Shows"
    @base_screen.wait_until(30) { expect(@shows_screen.shows_list.size.positive?).to be_truthy }

  when "Live"
    step "PENDING"

  when "Search"
    Support::Eventually.eventually(timeout: 10) { expect(@search_screen.trending_now_rail.displayed?).to be_truthy }

  when "Account"
    @base_screen.wait_until(30) { expect(@account_screen.about.displayed?).to be_truthy }
  end
end

Then("I scroll down") do
  @home_screen = HomeScreen.new
  3.times { @home_screen.scroll_down_by_screen_coordinates("20%") }
end

Then("I validate menu bar is not present") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.menubar_footer.size.positive?).to be_falsey }
end
