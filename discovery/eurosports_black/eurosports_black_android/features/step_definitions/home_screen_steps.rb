Given("I'm on the home screen") do
  @landing_screen = EuroLandingScreen.new
  @home_screen = EuroHomeScreen.new
  # rubocop:disable Custom/SleepCop.
  sleep 20
  # rubocop:enable Custom/SleepCop.
  # @landing_screen.wait_until(60) { expect(@landing_screen.latest_option.displayed?).to be_truthy }
  expect(@home_screen.home_option.displayed?).to be_truthy
  expect(@home_screen.home_option.selected?).to be_truthy
end

When("I see {string} tab on home screen") do |tab_name|
  @home_screen = EuroHomeScreen.new
  case tab_name
  when "HOME"
    expect(@home_screen.home_option.displayed?).to be_truthy

  when "WATCH"
    expect(@home_screen.watch_option.displayed?).to be_truthy

  when "RESULTS"
    expect(@home_screen.results_option.displayed?).to be_truthy

  when "SPORTS"
    expect(@home_screen.sports_option.displayed?).to be_truthy
  end
end

When("I click {string} tab on home screen") do |tab_name|
  @home_screen = EuroHomeScreen.new
  case tab_name
  when "WATCH"
    expect(@home_screen.watch_option.displayed?).to be_truthy
    @home_screen.watch_option.click
    expect(@home_screen.watch_option.selected?).to be_truthy

  when "RESULTS"
    expect(@home_screen.results_option.displayed?).to be_truthy
    @home_screen.results_option.click
    expect(@home_screen.results_option.selected?).to be_truthy

  when "SPORTS"
    expect(@home_screen.sports_option.displayed?).to be_truthy
    @home_screen.sports_option.click
    expect(@home_screen.sports_option.selected?).to be_truthy
  end
end

Then("I see and tap on account option") do
  @landing_screen = EuroLandingScreen.new
  @landing_screen.wait_until(60) { expect(@landing_screen.account_option.displayed?).to be_truthy }
  @landing_screen.account_option.click
end
