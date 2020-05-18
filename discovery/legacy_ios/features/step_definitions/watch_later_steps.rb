# frozen_string_literal: true

And(/^I add a show to watch later$/) do
  @show_screen = ShowScreen.new
  # Adding show to watch later
  # This isn't the watchlater screen
  @show_screen.wait_until(30) { @show_screen.show_home_info.first.displayed? }
  @show_screen.show_home_info.first.click
  @show_screen.watch_later_add_remove_option.click
  expect(@show_screen.watch_later_add_remove_option.attribute("value")).to eq("1")
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
  @watch_later_screen.done_btn.click
end

Then(/^I should see no shows in the watch list$/) do
  @watch_later_screen = WatchLaterScreen.new
  expect(@watch_later_screen.watch_later_empty_list.displayed?).to be true
end

When("I add a show to my watch later list") do
  step "I go to a show page"
  step "I add a show to watch later"
  step "I close the show popup and go back to main menu"
  step "I go to main menu"
  step "I click on watch later"
end

Then("I close the show popup and go back to main menu") do
  @show_screen = ShowScreen.new
  @show_screen.watch_list_popup.click
  @show_screen.wait_until(30) { @show_screen.watch_list_back_btn.displayed? }
  @show_screen.watch_list_back_btn.click
  @show_screen.close_btn.click
end

Then("I should see success/removal message on watch later") do
  @show_screen = ShowScreen.new
  expect(@show_screen.watch_later_success_message.displayed?).to be_truthy
  @show_screen.wait_until(30) { expect(@show_screen.watch_later_add_remove_option.displayed?).to be_truthy }
  @show_screen.watch_later_add_remove_option.click
  expect(@show_screen.watch_later_removal_message.displayed?).to be_truthy
end
