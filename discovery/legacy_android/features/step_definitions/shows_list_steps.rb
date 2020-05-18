When(/^I navigate to Shows from hamburger menu$/) do
  @show_list = BaseScreen.new
  @show_list.hamburger_icon.displayed?
  @show_list.hamburger_icon.click
  retry_proc = proc do
    @show_list.hamburger_icon.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    @show_list.hamburger_shows_menu.displayed?
    @show_list.hamburger_shows_menu.click
  end
end

Then(/^I'm taken to Shows List Page$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.a_z_button.displayed?).to be_truthy
end

Given(/^I'm on the shows list screen$/) do
  step "I'm on the home screen"
  step "I navigate to Shows from hamburger menu"
  step "I'm taken to Shows List Page"
  @show_list = ShowListScreen.new
  @show_list.a_z_button.displayed?
end

And(/^I choose sorting by A to Z$/) do
  @show_list = ShowListScreen.new
  @show_list.a_z_button.click
end

Then(/^The list should be sorted correctly$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.a_z_button.selected?).to be_truthy
end

When(/^I choose sorting by Most Recent$/) do
  @show_list = ShowListScreen.new
  @show_list.most_recent_button.click
end

Then(/^The list should be sorted by most recent first$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.most_recent_button.selected?).to be_truthy
end

And(/^I select a show from the list$/) do
  @show_list = ShowListScreen.new
  @show_list.first_list_item.click
end

Then(/^The correct show screen is loaded$/) do
  @show_screen = ShowScreen.new
  expect((@show_screen.show_hero.text == NETWORK_DATA.first_list_show)).to be_truthy
end

And("I go to show list screen") do
  step "I go to main menu"
  step "I navigate to Shows from hamburger menu"
end

And("select a show from show list") do
  step "I navigate to Shows from hamburger menu"
  @show_list = ShowListScreen.new
  expect(@show_list.first_list_item.displayed?).to be_truthy
  @show_list.first_list_item.click
end

And("I see list of available shows") do
  @show_list = ShowListScreen.new
  expect(@show_list.show_list.displayed?).to be_truthy
end

And("I see show art on each show in Most Recent") do
  @show_list = ShowListScreen.new
  max_swipping_round = 10
  (1..max_swipping_round).each do |_i|
    size = @show_list.show_art.size
    show = @show_list.show_art
    (1..size - 1).each do |j|
      @show_list.wait_until(30) { expect(show[j].displayed?).to be_truthy }
    end
    @show_list.scroll_to_last_show_by_coordinates
  end
end

And("I select a show from Most Recent shows list") do
  @show_list = ShowListScreen.new
  expect(@show_list.first_list_item.displayed?).to be_truthy
  @show_list.first_list_item.click
end

And("I select a show from A to Z shows list") do
  step "I select a show from Most Recent shows list"
end

And("I see search bar is enabled") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { expect(@landing_screen.search_show_text_input.enabled?).to be_truthy }
end
