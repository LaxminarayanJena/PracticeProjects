When("I see home hero carousel on home page") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
end

When("I see {string} carousel on home page") do |carousel_name|
  @home_screen = HomeScreen.new
  case carousel_name
  when "ON LAST NIGHT"
    @home_screen.scroll_to_on_last_night
    expect(@home_screen.on_last_night_desc.displayed?).to be_truthy

  when "POPULAR"
    @home_screen.scroll_to_popular
    expect(@home_screen.popular_desc.displayed?).to be_truthy

  when "UNLOCKED EPISODES"
    @home_screen.scroll_to_unlocked_episode
    expect(@home_screen.unlocked_episode_desc.displayed?).to be_truthy

  when "AHC LISTS"
    @home_screen.scroll_to_ahc_list
    expect(@home_screen.ahc_list_desc.displayed?).to be_truthy

  when "MORE FULL EPISODES"
    @home_screen.scroll_to_more_full_episode
    expect(@home_screen.more_full_episode_desc.displayed?).to be_truthy
  end
end

When("I click on hamburger menu") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.hamburger_icon.displayed? }
  @landing_screen.hamburger_icon.click
end

Then("I see and click {string} on hamburger menu") do |option|
  @landing_screen = LandingScreen.new
  case option
  when "Shows"
    expect(@landing_screen.hamburger_shows_menu.displayed?).to be_truthy
    @landing_screen.hamburger_shows_menu.click

  when "Continue Watching"
    expect(@landing_screen.continue_watching_icon.displayed?).to be_truthy
    @landing_screen.continue_watching_icon.click

  when "Favorite Shows"
    expect(@landing_screen.hamburger_favorite_show.displayed?).to be_truthy
    @landing_screen.hamburger_favorite_show.click

  when "Watch Later"
    expect(@landing_screen.hamburger_watch_later_menu.displayed?).to be_truthy
    @landing_screen.hamburger_watch_later_menu.click

  when "Watch Live TV"
    expect(@landing_screen.hamburger_watch_live.displayed?).to be_truthy
    @landing_screen.hamburger_watch_live.click

  when "Browse"
    expect(@landing_screen.hamburger_browse.displayed?).to be_truthy
    @landing_screen.hamburger_browse.click

  when "Settings"
    expect(@landing_screen.hamburger_app_settings.displayed?).to be_truthy
    @landing_screen.hamburger_app_settings.click
  end
end

Then("I should see {string} page") do |page|
  @landing_screen = LandingScreen.new
  case page
  when "Continue Watching"
    expect(@landing_screen.continue_watching_icon.displayed?).to be_truthy

  when "Favorite Shows"
    expect(@landing_screen.hamburger_favorite_show.displayed?).to be_truthy

  when "Watch Later"
    expect(@landing_screen.hamburger_watch_later_menu.displayed?).to be_truthy

  when "Browse"
    expect(@landing_screen.browse_page_header.displayed?).to be_truthy

  when "Settings"
    expect(@landing_screen.hamburger_app_settings.displayed?).to be_truthy
  end
end

Then("I should see info icon is displayed") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.info_button.displayed?).to be_truthy
end

When("I tap on info icon") do
  step "I should see info icon is displayed"
  @landing_screen = LandingScreen.new
  @landing_screen.info_button.click
end

Then("I see Info modal loads") do
  @video_screen = VideoScreen.new
  @video_screen.loading_icon.positive?
end

Then("I see watch later icon") do
  @show_screen = ShowScreen.new
  expect(@show_screen.watch_later_add_remove_option.displayed?).to be_truthy
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_icon.displayed?).to be_truthy
end

And("I see close button on info modal") do
  @show_screen = ShowScreen.new
  expect(@show_screen.watch_list_popup.displayed?).to be_truthy
end

Then("I tap on info modal close icon") do
  step "I see watch later icon"
  step "I see close button on info modal"
  @show_screen = ShowScreen.new
  @show_screen.watch_list_popup.click
  @home_screen = HomeScreen.new
  expect(@home_screen.hero.displayed?).to be_truthy
end

Given("I tap on info button of locked content") do
  step "I'm on the landing screen"
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { @landing_screen.show_logo.displayed? }
  @landing_screen.search_show(NETWORK_DATA.show_search[:locked_show])
  step "I tap on info icon"
end

And("I tap on Play Episode button on info modal") do
  @show_screen = ShowScreen.new
  expect(@show_screen.play_episode_btn.displayed?).to be_truthy
  @show_screen.play_episode_btn.click
end

Then("I see affiliate picker screen") do
  @show_screen = ShowScreen.new
  expect(@show_screen.search_providers.displayed?).to be_truthy
end

Then(/^I get the show title from info screen$/) do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(60) { @show_screen.show_hero.displayed? }
  expect(@show_screen.show_hero.text.empty?).not_to be_truthy
  expect(@show_screen.show_hero.text.include?(NETWORK_DATA.show_with_seasons[:show_name])).to be true
end

And("I tap on show title on info modal") do
  step "I get the show title from info screen"
  @show_screen = ShowScreen.new
  @show_screen.show_hero.click
end

Then("I see specific show screen") do
  step "I see show key art on show details screen"
  step "I get the show title from info screen"
end

When("I see {string} on home page") do |icon|
  @home_screen = HomeScreen.new
  case icon
  when "HAMBURGER ICON"
    @home_screen.wait_until(30) { expect(@home_screen.hamburger_icon.displayed?).to be_truthy }

  when "NETWORK_LOGO"
    @home_screen.wait_until(30) { expect(@home_screen.network_logo.displayed?).to be_truthy }

  when "SEARCH ICON"
    @home_screen.wait_until(30) { expect(@home_screen.search_show_icon.displayed?).to be_truthy }
  end
end

When("I see {string} on home page present on sign-in") do |auth_icon|
  @home_screen = HomeScreen.new
  case auth_icon
  when "Provider ICON"
    step "User has to be logged in"

  when "HAMBURGER ICON"
    step "User has to be logged in"
    @home_screen.wait_until(30) { expect(@home_screen.hamburger_icon.displayed?).to be_truthy }

  when "NETWORK_LOGO ICON"
    step "User has to be logged in"
    @home_screen.wait_until(30) { expect(@home_screen.network_logo.displayed?).to be_truthy }

  when "SEARCH ICON"
    step "User has to be logged in"
    @home_screen.wait_until(30) { expect(@home_screen.search_show_icon.displayed?).to be_truthy }
  end
end

When("I tap on any video tile with locked key") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.lock_btn.displayed?).to be_truthy }
  @home_screen.lock_btn.click
end

Then("I see series artwork along with title as metadata on show card") do
  @show_screen = ShowListScreen.new
  @landing_screen = LandingScreen.new
  expect(@show_screen.first_list_item.displayed?).to be_truthy
  expect(@landing_screen.recent_infopage_video_title.displayed?).to be_truthy
end

Then("I see episode title,episode number & show art on episode tile") do
  @landing_screen = LandingScreen.new
  @home_screen = HomeScreen.new
  expect(@home_screen.unlocked_episodes_show_card.displayed?).to be_truthy
  expect(@landing_screen.video_episodeinfo.displayed?).to be_truthy
  expect(@landing_screen.recent_video_title.displayed?).to be_truthy
  video_title = @landing_screen.video_episodeinfo.text
  expect(video_title.include?("Episode" || "Season")).to be_truthy
end

And("I tap on AHC LISTS") do
  @home_screen = HomeScreen.new
  expect(@home_screen.ahc_lists_show_card.displayed?).to be_truthy
  @ahc_video_title = @home_screen.ahc_lists_show_title.text
  @home_screen.ahc_lists_show_card.click
end

Then("I see that particular playlist page") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.show_screen_title.displayed?).to be_truthy }
  show_title = @home_screen.show_screen_title.text
  expect(@ahc_video_title.include?(show_title)).to be_truthy
end
