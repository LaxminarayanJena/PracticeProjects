Given("I am on splash screen") do
  @welcome_screen = WelcomeScreen.new
  if @welcome_screen.splash_logo.size.positive?
    expect(@welcome_screen.wait_until(30) { @welcome_screen.screen_loading_spinner.displayed? }).to be true
  end
end

When("I navigate to welcome page") do
  @welcome_screen = WelcomeScreen.new
  expect(@welcome_screen.welcome_tlc_logo.size.positive?).to be_truthy
  expect(@welcome_screen.nw_availability_label.displayed?).to be_truthy
end

And("I see a Welcome screen with message 'Link your TV provider to unlock thousands of episodes from network discovery'") do
  @welcome_screen = WelcomeScreen.new
  expect(@welcome_screen.link_tv_provider_msg.displayed?).to be_truthy
end

And("I see 'Link TV Provider'' and 'May be later' buttons") do
  @welcome_screen = WelcomeScreen.new
  expect(@welcome_screen.maybe_later_button.displayed?).to be_truthy
  expect(@welcome_screen.link_provider_button.displayed?).to be_truthy
end

And("I click on 'Maybe Later' button") do
  @welcome_screen = WelcomeScreen.new
  @welcome_screen.press_down
  @welcome_screen.maybe_later_button.click
end

Then("I should be navigated to home screen") do
  step "I am on the home screen"
end

Given("I am on splash screen after installation of app first time") do
  step "I am on splash screen"
end

Given("I am on splash screen after freshly launch the app") do
  step "I am on splash screen"
end
