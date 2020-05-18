# frozen_string_literal: true

And(/^I add a show to watch later$/) do
  @show_screen = ShowScreen.new
  # Adding show to watch later
  # This isn't the watchlater screen
  @show_screen.show_home_info.click
  @showpage_show_title = @show_screen.show_hero.text
  @show_screen.watch_later_add_remove_option.click
  expect(@show_screen.watch_list_add_remove_desc.displayed?).to be true
  @show_screen.watch_list_popup.click
  @menu = BaseScreen.new
  @menu.navigate_to_previous_screen # Going back to shows menu
  @menu.navigate_to_previous_screen # Going back to main menu
end

And(/^I click on watch later$/) do
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

Then(/^I should see a show in the watch list$/) do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.watch_list.displayed?).to be true
  end
end

And(/^I remove a show from watch later$/) do
  @watch_later_screen = WatchLaterScreen.new
  # Removing show from watch later
  @watch_later_screen.edit_btn.click
  @watch_later_screen.edit_checkbox.click
  @watch_later_screen.edit_btn.click
end

Then(/^I should see no shows in the watch list$/) do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.show_empty_list.displayed?).to be true
  end
end

When("I add a show to my watch later list") do
  step "I go to a show page"
  step "I add a show to watch later"
  step "I go to main menu"
  step "I click on watch later"
end

When("I tap on {string} on watch later") do |watch_later_check|
  @watch_later_screen = WatchLaterScreen.new
  case watch_later_check
  when "+ icon"
    step "I check the episode info"
    @watch_later_screen.wait_until(60) { expect(@watch_later_screen.watch_later_icon.displayed?).to be_truthy }
    @watch_later_screen.watch_later_icon.click if @watch_later_screen.watch_later_icon_status.eql?("false")
  when "- icon"
    @watch_later_screen.wait_until(60) { expect(@watch_later_screen.watch_later_icon.displayed?).to be_truthy }
    @watch_later_screen.watch_later_icon.click if @watch_later_screen.watch_later_icon_status.eql?("true")
  end
end

And("I should see success message on watch later") do
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_success_message.displayed?).to be_truthy
end

And("I should see removal message on watch later") do
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_removal_message.displayed?).to be_truthy
end

Then("I should see - icon on watch later") do
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_icon_status.eql?("true")).to be_truthy
end

Then("I should see + icon on watch later") do
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_icon_status.eql?("false")).to be_truthy
end

Then("I see watch later is enabled") do
  step "I am on a show screen"
  step "I tap on '+ icon' on watch later"
  step "I should see success message on watch later"
  step "I should see - icon on watch later"
end

Then(/^I should see Watch Later empty message/) do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.watch_later_empty_list.displayed?).to be true
  end
  @watchlater_empty_message = @watch_later_screen.watch_later_empty_list.text
  expect(@watchlater_empty_message == "Your Watch Later is empty!").to be true
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.add_episode_watch_later.displayed?).to be true
  end
  @add_episode_watch_later_message = @watch_later_screen.add_episode_watch_later.text
  expect(@add_episode_watch_later_message == "add episodes to watch later").to be true
end

When("I click on play button of the show") do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.watch_later_play_button.displayed?).to be_truthy
  end
  @watch_later_screen.watch_later_play_button.click
end

Then("I should see same show in the watch list") do
  @landing_screen = LandingScreen.new
  @watchlater_show_title = @landing_screen.recent_video_title.text
  @watch_later_screen.wait_until(60) do
    expect(@watchlater_show_title == @showpage_show_title).to be true
  end
end

When("I click on Search icon on screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) do
    expect(@home_screen.search_icon.displayed?).to be true
  end
  @home_screen.search_icon.click
end

Then("I should see search screen should open") do
  @watch_later_screen = WatchLaterScreen.new
  @watch_later_screen.wait_until(60) do
    expect(@watch_later_screen.search_show_text_input.displayed?).to be true
  end
  @watch_later_screen.search_show_text_input.click
end
