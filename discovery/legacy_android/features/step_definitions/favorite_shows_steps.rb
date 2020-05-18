Then("There are no favorite shows in the favorite show screen") do
  step "I am on favorite show screen"
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.show_empty_list.displayed?
end

Then("There are favorite shows in the favorite show screen") do
  step "I am on favorite show screen"
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.favorite_show_list.displayed?
  expect(@favorite_show_screen.favorite_show_list.displayed?).to be_truthy
end

Given("I have favorite shows") do
  step "I mark a show as favorite"
  step "There are favorite shows in the favorite show screen"
end

Given("I am on favorite show screen") do
  step "I go to main menu"
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.hamburger_favorite_show.displayed?
  @favorite_show_screen.hamburger_favorite_show.click
end

And("I remove a favorite show") do
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.edit_btn.click
  @favorite_show_screen.edit_checkbox.click
  @favorite_show_screen.edit_btn.click
  @favorite_show_screen.hamburger_icon.click
end

And("I mark a show as favorite") do
  step "select a show from show list"
  @show_screen = ShowScreen.new
  @show_screen.mark_favorite_option.displayed?
  @show_screen.mark_favorite_option.click
  @show_screen.show_hero.displayed?
  @show_title = @show_screen.show_hero.text
  @show_screen.hamburger_icon.click
end

Then("Verify Search button,EDIT button, Show thumbnail and Show title on favorites when show is added") do
  @favorite_show_screen = FavoriteShowScreen.new
  expect(@favorite_show_screen.favorite_list_edit_btn.displayed?).to be true
  expect(@favorite_show_screen.favorite_show_img_thumbnail.displayed?).to be true
  expect(@favorite_show_screen.favorite_show_search_icon.displayed?).to be true
end

When("I tap on the show in Favorites screen") do
  @landing_screen = LandingScreen.new
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.wait_until(30) { @landing_screen.recent_video_title.displayed? }
  @favorite_show_title = @landing_screen.recent_video_title.text
  @landing_screen.recent_video_title.click
end

Then("I should navigate to show detail screen") do
  @favorite_show_screen = FavoriteShowScreen.new
  @show_screen = ShowScreen.new
  @show_title = @show_screen.show_hero.text
  expect(@favorite_show_title == @show_title).to be true
end

And("I should see Favorite screen empty messages") do
  @favorite_show_screen = FavoriteShowScreen.new
  @favorite_show_screen.wait_until(60) { expect(@favorite_show_screen.favorite_empty_list.displayed?).to be_truthy }
  @favorite_empty_message = @favorite_show_screen.favorite_empty_list.text
  expect(@favorite_empty_message == "Your favorite list is empty!").to be true
  @favorite_show_screen.wait_until(60) { expect(@favorite_show_screen.add_episode_favorite.displayed?).to be_truthy }
  @add_episode_favorite_message = @favorite_show_screen.add_episode_favorite.text
  expect(@add_episode_favorite_message == "add shows to favorite list").to be true
end

And(/^I click on Favorite Shows$/) do
  @menu = BaseScreen.new
  # This is a while because sometime there is an overlay that intercepts the click
  retry_proc = proc do
    @menu.hamburger_icon.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @menu.hamburger_watch_later_menu.displayed?
  end
  @menu.hamburger_watch_later_menu.click
end

Then("I should see same show in favorite screen") do
  @landing_screen = LandingScreen.new
  @favorite_show_title = @landing_screen .recent_video_title.text
  @favorite_show_screen.wait_until(60) do
    expect(@show_title == @favorite_show_title).to be true
  end
end
