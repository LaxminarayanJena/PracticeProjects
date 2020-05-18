Given("I am in splash screen") do
  @splash_screen = SplashScreen.new
  expect(@splash_screen.splash_logo.displayed?).to be_truthy
end

Then("I navigate to welcome page") do
  expect(@splash_screen.splash_logo.displayed?).to be_truthy
  expect(@splash_screen.network_channels.displayed?).to be_truthy
end

And("I see the details in welcome page") do
  expect(@splash_screen.text_link_message.displayed?).to be_truthy
  expect(@splash_screen.link_tv_provider_btn.displayed?).to be_truthy
  expect(@splash_screen.maybe_later_btn.displayed?).to be_truthy
  expect(@splash_screen.available_newtwok_message.displayed?).to be_truthy
end

And("I click on maybe later button") do
  expect(@splash_screen.maybe_later_btn.displayed?).to be_truthy
  @splash_screen.press_down
  @splash_screen.maybe_later_btn.click
end

Then("I should be navigated to home screen") do
  @home_screen = HomeScreen.new
  @base_screen = BaseScreen.new
  expect(@base_screen.wait_until(30) { @base_screen.affiliate_logo.displayed? }).to be true
  expect(@home_screen.wait_until(30) { @home_screen.home_hero.first.displayed? }).to be true
end
