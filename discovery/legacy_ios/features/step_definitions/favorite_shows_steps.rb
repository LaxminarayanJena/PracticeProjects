Given("there are no favorite shows in the favorite show screen") do
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.hamburger_favorite_show_menu.click
  @favorite_show_screen.wait_until(60) { @favorite_show_screen.favorite_show_header.displayed? }
  @favorite_show_screen.wait_until(60) { @favorite_show_screen.empty_favorite_list.displayed? }
  expect(@favorite_show_screen.empty_favorite_list.displayed?).to be_truthy
  @favorite_show_screen.close_button.click
end

Then("there are favorite shows in the favorite show screen") do
  step "I am on favorite show screen"
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.wait_until(60) { @favorite_show_screen.edit_button.displayed? }
  expect(@favorite_show_screen.edit_button.displayed?).to be_truthy
end

Given("I have favorite shows") do
  step "I mark a show as favorite"
  step "there are favorite shows in the favorite show screen"
end

Given("I am on favorite show screen") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.hamburger_icon.displayed? }
  @landing_screen.hamburger_icon.click
  @landing_screen.hamburger_favorite_show_menu.click
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.wait_until(60) { @favorite_show_screen.favorite_show_header.displayed? }
end

And("I remove a favorite show") do
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.edit_button.click
  @favorite_show_screen.select_show.click
  @favorite_show_screen.done_button.click
  @favorite_show_screen.top_close_button.click
end

And("I mark a show as favorite") do
  step "I'm on the home screen"
  step "I navigate to Shows from hamburger menu"
  step "I select a letter to see a show starting from that letter"
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.favorite_button.displayed? }
  @show_screen.favorite_button.click
  @show_screen.wait_until(60) { @show_screen.top_back_button.displayed? }
  @show_screen.top_back_button.click
end

When("Verify edit button and show title on favorites when show is added") do
  @favorite_show_screen = FavoriteShowScreen.new
  expect(@favorite_show_screen.edit_button.displayed?).to be true
  expect(@favorite_show_screen.fav_show_title.displayed?).to be true
end

When("I tap on the show in Favorites screen") do
  @favorite_show_screen = FavoriteShowScreen.new
  expect(@favorite_show_screen.fav_show_title.displayed?).to be true
  @favorite_show_screen.fav_show_title.click
end

Then("I should navigate to show detail screen") do
  @show_screen = VideoScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.info_button.displayed?).to be true }
end
