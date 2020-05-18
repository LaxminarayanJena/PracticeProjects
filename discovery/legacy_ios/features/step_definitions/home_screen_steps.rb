When("I click on hamburger menu") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.hamburger_icon.displayed? }
  @landing_screen.hamburger_icon.click
end

When("I tap on any series tile") do
  @series_screen = SearchScreen.new
  @series_screen.search_show_icon.click
  @series_screen.search_field.send_keys(NETWORK_DATA.show_search[:show_name])
  @series_screen.search_result(NETWORK_DATA.show_search[:show_name]).first.click
end

Then("I should see that particular series show page") do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_banner(NETWORK_DATA.show_search[:show_name]).enabled?).to be_truthy
end

When("I tap on any playlist tile") do
  @lists_screen = LandingScreen.new
  @lists_screen.scroll_to_down
  @lists_screen.wait_until(30) { @lists_screen.network_lists.displayed? }
  expect(@lists_screen.network_play_list.displayed?).to be_truthy
  @page_text = @lists_screen.network_play_list.text
  @lists_screen.network_play_list.click
end

Then("I should see that particular playlist page") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.landing_page_details(@page_text).displayed?).to be_truthy
end

Then("I tap on watch button on episode tile") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.play_episode_button.displayed? }
  @show_screen.play_episode_button.click
end

Then("I see and click {string} on hamburger menu") do |option|
  @landing_screen = LandingScreen.new
  case option
  when "Home"
    expect(@landing_screen.hamburger_home_icon.displayed?).to be_truthy
    @landing_screen.hamburger_home_icon.click

  when "Shows"
    expect(@landing_screen.hamburger_shows_menu.displayed?).to be_truthy
    @landing_screen.hamburger_shows_menu.click

  when "Continue Watching"
    expect(@landing_screen.hamburger_continue_watching_menu.displayed?).to be_truthy
    @landing_screen.hamburger_continue_watching_menu.click

  when "Favorite Shows"
    expect(@landing_screen.hamburger_favorite_show_menu.displayed?).to be_truthy
    @landing_screen.hamburger_favorite_show_menu.click

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
    expect(@landing_screen.landing_page_details(page.upcase).displayed?).to be_truthy

  when "Favorite Shows"
    expect(@landing_screen.landing_page_details(page.upcase).displayed?).to be_truthy

  when "Watch Later"
    expect(@landing_screen.landing_page_details(page.upcase).displayed?).to be_truthy

  when "Browse"
    expect(@landing_screen.landing_page_details(page.upcase).displayed?).to be_truthy

  when "Settings"
    expect(@landing_screen.landing_page_details(page.upcase).displayed?).to be_truthy
  end
end

Then("I see {string} on header") do |icon|
  @landing_screen = LandingScreen.new
  case icon
  when "HAMBURGER ICON"
    @landing_screen.wait_until(30) { expect(@landing_screen.hamburger_icon.displayed?).to be_truthy }

  when "NETWORK LOGO"
    @landing_screen.wait_until(30) { expect(@landing_screen.network_logo.displayed?).to be_truthy }

  when "SEARCH ICON"
    @landing_screen.wait_until(30) { expect(@landing_screen.search_show_icon.displayed?).to be_truthy }

  when "AFFILIATE LOGO"
    @landing_screen.wait_until(30) { expect(@landing_screen.affiliate_logo.displayed?).to be_truthy }
  end
end

Then("I see hamburger icon, network logo and search icon") do
  step "I see 'HAMBURGER ICON' on header"
  step "I see 'NETWORK LOGO' on header"
  step "I see 'SEARCH ICON' on header"
end
