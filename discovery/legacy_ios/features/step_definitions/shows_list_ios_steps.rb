Given(/^I'm on the home screen$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_icon.click
end

When(/^I navigate to Shows from hamburger menu$/) do
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_shows_menu.click
end

Then(/^I'm taken to Shows List Page$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.a_z_button.displayed?).to be_truthy
end

Given(/^I'm on the shows list screen$/) do
  @show_list = ShowListScreen.new
  @show_list.wait_until(30) { @show_list.a_z_button.displayed? }
end

And(/^I choose sorting by A to Z$/) do
  @show_list = ShowListScreen.new
  @show_list.a_z_button.click
end

Then(/^The list should be sorted correctly$/) do
  @show_list = ShowListScreen.new
  expect(@show_list.alphabet_selector("A").displayed?).to be_truthy
end

When(/^I choose sorting by Most Recent$/) do
  @show_list = ShowListScreen.new
  @show_list.most_recent_button.click
end

Then(/^The list should be sorted by most recent first$/) do
  @show_list = ShowListScreen.new
  not_found = false
  begin
    @show_list.alphabet_selector("A").displayed?
  rescue Selenium::WebDriver::Error::NoSuchElementError
    not_found = true
  end
  expect(not_found).to be_truthy
end

And(/^I select a letter to see a show starting from that letter$/) do
  @show_list = ShowListScreen.new
  @show_list.alphabet_selector("B").click
  @show_list.tap_by_coordinates(179, 249)
end

Then(/^The correct show screen is loaded$/) do
  @show_screen = ShowScreen.new
  expect(@show_screen.show_banner(NETWORK_DATA.show_hero_by_letter_b).text.empty?).not_to be_truthy
end

Then(/^I exit show list screen$/) do
  @show_list = ShowListScreen.new
  @show_list.wait_until(60) { @show_list.top_back_button.displayed? }
  @show_list.top_back_button.click
end
