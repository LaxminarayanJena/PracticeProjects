Then("I see calendar on schedule tab on watch screen") do
  step "I click 'SCHEDULE' tab on watch screen"
  @watch_screen = EuroWatchScheduleScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.calendar.enabled?).to be_truthy }
end

And("Calendar should start from today") do
  @watch_screen = EuroWatchScheduleScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  expect(@watch_screen.today_label.enabled?).to be_truthy
end

Then("I should see seven days in calendar starting from today") do
  @watch_screen = EuroWatchScheduleScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  @watch_screen.scroll_right_from_today_label
  step "PENDING"
end

Then("I should see seven days in calendar prior from today") do
  @watch_screen = EuroWatchScheduleScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  @watch_screen.scroll_left_from_today_label
  step "PENDING"
end

Given("I'm on watch hub schedule tab") do
  step "I'm on the eurosports landing screen"
  step "I click on 'WATCH SCREEN'"
  step "I click 'SCHEDULE' tab on watch screen"
end

Then("I tap on {string} button") do |dropdown_button|
  @watch_screen = EuroWatchScheduleScreen.new
  case dropdown_button
  when "SHOW EARLIER TODAY"
    expect(@watch_screen.show_earlier_today.displayed?).to be_truthy
    @watch_screen.show_earlier_today.click

  when "HIDE EARLIER TODAY"
    expect(@watch_screen.hide_earlier_today.displayed?).to be_truthy
    @watch_screen.hide_earlier_today.click
  end
end

Then("I see button should be changed to {string}") do |dropdown_button|
  @watch_screen = EuroWatchScheduleScreen.new
  case dropdown_button
  when "SHOW EARLIER TODAY"
    expect(@watch_screen.show_earlier_today.displayed?).to be_truthy

  when "HIDE EARLIER TODAY"
    expect(@watch_screen.hide_earlier_today.displayed?).to be_truthy
  end
end
