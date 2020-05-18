When("I click {string} tab on watch screen") do |tab_name|
  @watch_screen = EuroWatchScreen.new
  case tab_name
  when "HOME"
    expect(@watch_screen.home_tab.displayed?).to be_truthy
    @watch_screen.home_tab.click
    expect(@watch_screen.home_tab.selected?).to be_truthy

  when "SCHEDULE"
    expect(@watch_screen.schedule_tab.displayed?).to be_truthy
    @watch_screen.schedule_tab.click
    expect(@watch_screen.schedule_tab.selected?).to be_truthy

  when "LATEST VIDEOS"
    expect(@watch_screen.latest_videos_tab.displayed?).to be_truthy
    @watch_screen.latest_videos_tab.click
    expect(@watch_screen.latest_videos_tab.selected?).to be_truthy

  when "PREMIUM"
    @watch_screen.wait_until(60) { expect(@watch_screen.premium_videos_tab.displayed?).to be_truthy }
    @watch_screen.wait_until(60) { @watch_screen.premium_videos_tab.click }
    # wait_until is not working here as it is taking much time to load so i have used sleep
    # rubocop:disable Custom/SleepCop.
    sleep 5
    # rubocop:enable Custom/SleepCop.
    @watch_screen.wait_until(60) { expect(@watch_screen.premium_videos_tab.selected?).to be_truthy }

  when "SPORT VIDEOS"
    @watch_screen.navigate_to_sports_tab
    @watch_screen.wait_until(60) { expect(@watch_screen.sport_videos_tab.displayed?).to be_truthy }
    @watch_screen.sport_videos_tab.click
    # rubocop:disable Custom/SleepCop.
    sleep 5
    # rubocop:enable Custom/SleepCop.
    @watch_screen.wait_until(60) { expect(@watch_screen.sport_videos_tab.selected?).to be_truthy }

  when "COMPETITON VIDEOS"
    @watch_screen.navigate_to_competition_tab
    @watch_screen.wait_until(60) { expect(@watch_screen.competition_videos_tab.displayed?).to be_truthy }
    @watch_screen.competition_videos_tab.click
    # rubocop:disable Custom/SleepCop.
    sleep 5
    # rubocop:enable Custom/SleepCop.
    @watch_screen.wait_until(60) { expect(@watch_screen.competition_videos_tab.selected?).to be_truthy }
  end
end

Then("I see content of sport videos load successfully") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.sport_video_category.displayed?).to be_truthy }
end

Then(/^I verify and tap \"([^\"]*)\" in Sport videos$/) do |sport_category|
  step "I'm on the home screen"
  step "I click 'WATCH' tab on home screen"
  step "I click 'SPORT VIDEOS' tab on watch screen"
  @watch_screen = EuroWatchScreen.new
  case sport_category
  when "POPULAR SPORTS"
    @watch_screen.wait_until(60) { expect(@watch_screen.popular_sports_category.displayed?).to be_truthy }
    @watch_screen.popular_sports_category.click

  when "ALL SPORTS"
    @watch_screen.wait_until(60) { expect(@watch_screen.all_sports_category.displayed?).to be_truthy }
    @watch_screen.all_sports_category.click
  end
end

Then("I see list of sports in sport videos category dropdown") do
  @watch_screen = EuroWatchScreen.new
  max_swipping_round = 3
  (1..max_swipping_round).each do |_i|
    size = @watch_screen.sports_name.size
    sport = @watch_screen.sports_name
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(sport[j].displayed?).to be_truthy }
    end
    @watch_screen.scroll_to_last_sport_by_coordinates
  end
end

Then(/^I select a sport from popular sports in Sport videos$/) do
  step "I'm on the home screen"
  step "I click 'WATCH' tab on home screen"
  step "I click 'SPORT VIDEOS' tab on watch screen"
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.first_popular_sport.displayed?).to be_truthy
  @selected_sport = @watch_screen.first_popular_sport.text
  @watch_screen.first_popular_sport.click
end

Then("I should be on selected sport page") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.sport_page_title.displayed?).to be_truthy }
  expect(@selected_sport.eql?(@watch_screen.sport_page_title.text)).to be_truthy
end

Then("I should see list of sports in competition videos") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.competition_videos_sport_list.displayed?).to be_truthy }
end

Then(/^I tap on a sport in competition videos category$/) do
  step "I'm on the home screen"
  step "I click 'WATCH' tab on home screen"
  step "I click 'COMPETITON VIDEOS' tab on watch screen"
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.sport_competition_videos.displayed?).to be_truthy }
  @watch_screen.sport_competition_videos.click
end

Then("I see list of competitions in selected sport") do
  @watch_screen = EuroWatchScreen.new
  size = @watch_screen.competitions_name.size
  competition = @watch_screen.competitions_name
  (1..size - 1).each do |j|
    @watch_screen.wait_until(30) { expect(competition[j].displayed?).to be_truthy }
  end
end

Then("I tap on first competition from selected sport") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.first_competition.displayed?).to be_truthy }
  @selected_competition = @watch_screen.first_competition.text
  @watch_screen.first_competition.click
end

Then("I should be on selected competion page") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.competition_page_title.displayed?).to be_truthy }
  expect(@selected_competition.eql?(@watch_screen.competition_page_title.text)).to be_truthy
end

Then("I should be navigated back to Watch screen") do
  @watch_screen = EuroWatchScreen.new
  @home_screen = EuroHomeScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.back_icon.displayed?).to be_truthy }
  @watch_screen.back_icon.click
  expect(@home_screen.watch_option.selected?).to be_truthy
end

Then("I see calender on schedule tab on watch screen") do
  step "I'm on the home screen"
  step "I click 'WATCH' tab on home screen"
  step "I click 'SCHEDULE' tab on watch screen"
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.calender.displayed?).to be_truthy }
end

Then("I navigate to the schedule tab on the watch screen") do
  step "I click 'WATCH' tab on home screen"
  step "I click 'SCHEDULE' tab on watch screen"
end

Then("Calender should start from today") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  expect(@watch_screen.today_label.selected?).to be_truthy
end

Then("I should see seven days in calender starting from today") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  @watch_screen.scroll_right_from_today_label
  expect(@watch_screen.regular_day_label.size).to be == 7
end

Then("I should see seven days in calender prior to today") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.today_label.displayed?).to be_truthy }
  @watch_screen.scroll_left_from_today_label
  expect(@watch_screen.regular_day_label.size).to be == 7
end

Then("I see Show Earlier Today button for today's date") do
  step "Calender should start from today"
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.show_earlier_today_button.displayed?).to be_truthy }
end

Then("I should not see any button if any other day is selected") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.scroll_left_from_today_label
  @watch_screen.wait_until(60) { expect(@watch_screen.regular_day.displayed?).to be_truthy }
  @watch_screen.regular_day.click
  # rubocop:disable Custom/SleepCop.
  sleep 5
  # rubocop:enable Custom/SleepCop.
  expect(@watch_screen.show_hide_earlier_today_button.size).nil?
end

When("I tap on {string} button") do |button_name|
  @watch_screen = EuroWatchScreen.new
  case button_name
  when "Show Earlier Today"
    expect(@watch_screen.show_earlier_today_button.displayed?).to be_truthy
    @watch_screen.show_earlier_today_button.click
    expect(@watch_screen.hide_earlier_today_button.displayed?).to be_truthy
  when "Hide Earlier Today"
    expect(@watch_screen.hide_earlier_today_button.displayed?).to be_truthy
    @watch_screen.hide_earlier_today_button.click
    expect(@watch_screen.show_earlier_today_button.displayed?).to be_truthy
  end
end

Then("I see past programs list should be displayed") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.program_list_view.size).to be_truthy
end

Then("I see past programs list should not be displayed") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.program_list_view.size).nil?
end

Then("I verify show card on upcoming program list") do
  @watch_screen = EuroWatchScreen.new
  max_swipping_round = 20
  (1..max_swipping_round).each do |_i|
    size = @watch_screen.card_on_program_list.size
    show_card = @watch_screen.card_on_program_list
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(show_card[j].displayed?).to be_truthy }
    end
    @watch_screen.scroll_down
  end
end

Then("I see Previous and Next day button at bottom of Schedule tab") do
  @watch_screen = EuroWatchScreen.new
  max_swipping_round = 20
  (1..max_swipping_round).each do |_i|
    @watch_screen.scroll_down
  end
  expect(@watch_screen.previous_button.displayed?).to be_truthy
  expect(@watch_screen.next_button.displayed?).to be_truthy
end

Then("I navigate to next day") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.next_button.displayed?).to be_truthy
  @watch_screen.next_button.click
end

Then("I should be on next day of Schedule Calender") do
  @watch_screen = EuroWatchScreen.new
  max_swipping_round = 20
  (1..max_swipping_round).each do |_i|
    @watch_screen.scroll_up
  end
  expect(@watch_screen.next_day.selected?).to be_truthy
end

Then("I see upcoming program list on schedule tab") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.today_label.displayed?).to be_truthy
  @watch_screen.scroll_down
  expect(@watch_screen.upcoming_program_list.size).to be_truthy
end

Then("I see On Now shows for today's date") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.on_now_label.displayed?).to be_truthy
end

Then("I see latest premium carousel on Premium tab on watch screen") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.latest_premium_label.displayed?).to be_truthy }
end
