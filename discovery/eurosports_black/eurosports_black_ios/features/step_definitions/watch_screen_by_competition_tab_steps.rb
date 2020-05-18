Then(/^I verify \"([^\"]*)\" in Competition videos$/) do |competition_category|
  step "I'm on the eurosports landing screen"
  step "I click on 'WATCH SCREEN'"
  step "I click 'COMPETITION VIDEOS' tab on watch screen"
  @watch_screen = EuroWatchByCompetitionScreen.new
  case competition_category
  when "Football"
    @watch_screen.wait_until(60) { expect(@watch_screen.football_category.displayed?).to be_truthy }
    @watch_screen.football_category.click

  when "Cycling"
    @watch_screen.wait_until(60) { expect(@watch_screen.cycling_category.displayed?).to be_truthy }
    @watch_screen.cycling_category.click

  when "Snooker"
    @watch_screen.wait_until(60) { expect(@watch_screen.snooker_category.displayed?).to be_truthy }
    @watch_screen.snooker_category.click

  when "OlympicGames"
    @watch_screen.wait_until(60) { expect(@watch_screen.olympic_games_category.displayed?).to be_truthy }
    @watch_screen.olympic_games_category.click

  when "Tennis"
    @watch_screen.wait_until(60) { expect(@watch_screen.tennis_category.displayed?).to be_truthy }
    @watch_screen.tennis_category.click
  end
end

Then("I see list of competitions in competition videos category dropdown") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.expandable_arrow_opened.displayed?).to be_truthy
end

Given("PENDING") do
  # pending
end

Then(/^I click on \"([^\"]*)\" from by competition category$/) do |sport_type|
  @watch_screen = EuroWatchByCompetitionScreen.new
  case sport_type
  when "AUSTRALIAN OPEN"
    @watch_screen.wait_until(30) { expect(@watch_screen.australian_open_sport_type.displayed?).to be_truthy }
    @watch_screen.australian_open_sport_type.click

  when "WORLD CHAMPIONSHIPS"
    @watch_screen.wait_until(30) { expect(@watch_screen.world_championships_sport_type.displayed?).to be_truthy }
    @watch_screen.world_championships_sport_type.click

  when "UK CHAMPIONSHIP"
    @watch_screen.wait_until(30) { expect(@watch_screen.uk_championship_sport_type.displayed?).to be_truthy }
    @watch_screen.uk_championship_sport_type.click

  when "TRANSFERS"
    @watch_screen.wait_until(30) { expect(@watch_screen.transfers_sport_type.displayed?).to be_truthy }
    @watch_screen.transfers_sport_type.click

  when "TOKYO 2020"
    @watch_screen.wait_until(30) { expect(@watch_screen.tokyo_sport_type.displayed?).to be_truthy }
    @watch_screen.tokyo_sport_type.click
  end
end

Then("I should be on {string} selected sport from by competition category") do |selected_sport|
  @watch_screen = EuroWatchByCompetitionScreen.new
  case selected_sport
  when "AUSTRALIAN OPEN"
    @watch_screen.wait_until(30) { expect(@watch_screen.australian_open_sport_type.enabled?).to be_truthy }
    expect(@watch_screen.back_button.displayed?).to be_truthy

  when "WORLD CHAMPIONSHIPS"
    @watch_screen.wait_until(30) { expect(@watch_screen.world_championships_sport_type.enabled?).to be_truthy }
    expect(@watch_screen.back_button.displayed?).to be_truthy

  when "UK CHAMPIONSHIP"
    @watch_screen.wait_until(30) { expect(@watch_screen.uk_championship_sport_type.enabled?).to be_truthy }
    expect(@watch_screen.back_button.displayed?).to be_truthy

  when "TRANSFERS"
    @watch_screen.wait_until(30) { expect(@watch_screen.transfers_sport_type.enabled?).to be_truthy }
    expect(@watch_screen.back_button.displayed?).to be_truthy

  when "TOKYO 2020"
    @watch_screen.wait_until(30) { expect(@watch_screen.tokyo_sport_type.enabled?).to be_truthy }
    expect(@watch_screen.back_button.displayed?).to be_truthy
  end
end
