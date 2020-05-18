Given("I'm on the eurosports landing screen") do
  @home_screen = EuroHomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.home_option.displayed?).to be_truthy }
end

When("I click on {string}") do |screen_name|
  @home_screen = EuroHomeScreen.new
  case screen_name
  when "WATCH SCREEN"
    expect(@home_screen.watch_screen_option.displayed?).to be_truthy
    @home_screen.watch_screen_option.click

  when "RESULT SCREEN"
    expect(@home_screen.result_screen_option.displayed?).to be_truthy
    @home_screen.result_screen_option.click

  when "SPORTS SCREEN"
    expect(@home_screen.sports_screen_option.displayed?).to be_truthy
    @home_screen.sports_screen_option.click
  end
end

Then("I should see {string} options") do |screen_name|
  @home_screen = EuroHomeScreen.new
  case screen_name
  when "HOME SCREEN"
    expect(@home_screen.home_option.enabled?).to be_truthy

  when "WATCH SCREEN"
    expect(@home_screen.watch_screen_option.enabled?).to be_truthy

  when "RESULT SCREEN"
    expect(@home_screen.result_screen_option.enabled?).to be_truthy

  when "SPORTS SCREEN"
    expect(@home_screen.sports_screen_option.enabled?).to be_truthy
  end
end
