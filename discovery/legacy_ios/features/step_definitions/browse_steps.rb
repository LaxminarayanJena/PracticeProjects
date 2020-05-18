Given("As an anonymous user i navigate to Browse screen from hamburger menu") do
  step "I'm on the landing screen"
  step "I click on hamburger menu"
  step "I see and click 'Browse' on hamburger menu"
  step "I should see 'Browse' page"
end

Given("I login with valid provider and go to Browse screen from hamburger menu") do
  step "I'm on the home screen"
  step "I log in with a valid provider"
  step "I see and click 'Browse' on hamburger menu"
  step "I should see 'Browse' page"
end

Then("I go back from Browse screen and Sign out") do
  step "I click on close button"
  step "I see and click on signout"
end

Then("I see show title, genre icon on the thumbnail") do
  @browse_screen = BrowseScreen.new
  @browse_screen.wait_until(10) { expect(@browse_screen.genre_text.size.positive?).to be_truthy }
  @browse_screen.wait_until(10) { expect(@browse_screen.genre_icons.size.positive?).to be_truthy }
end

Then("I tap on any genre") do
  @browse_screen = BrowseScreen.new
  @genre_text_from_list = @browse_screen.genre_text.first.text
  @browse_screen.genre_list.first.click
end

Then("I see genre landing screen") do
  @browse_screen = BrowseScreen.new
  @browse_screen.wait_until(30) { expect(@browse_screen.genre_navigation_bar.displayed?).to be_truthy }
  @genre_text_from_navigation_bar = @browse_screen.genre_navigation_bar.text
  @browse_screen.wait_until(10) { expect(@genre_text_from_list == @genre_text_from_navigation_bar).to be_truthy }
end

Then("I see Browse Page title, Affiliate logo & close icon in Header section") do
  @browse_screen = BrowseScreen.new
  @browse_screen.wait_until(10) { expect(@browse_screen.browse_title.displayed?).to be_truthy }
  @browse_screen.wait_until(10) { expect(@browse_screen.affiliate_logo_browse_screen.first.displayed?).to be_truthy }
  @browse_screen.wait_until(10) { expect(@browse_screen.top_close_button.displayed?).to be_truthy }
end
