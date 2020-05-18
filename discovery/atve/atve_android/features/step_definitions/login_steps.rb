When(/^I login as anonymous user$/) do
  @login_screen = LoginScreen.new
  @login_screen.wait_until(30) { @login_screen.maybe_later.displayed? }
  @login_screen.maybe_later.click
end

And("I tap on {string}") do |button|
  @login_screen = SettingScreen.new
  if button == "login"
    @login_screen.wait_until(30) { @login_screen.login_button.displayed? }
    @login_screen.login_button.click
  elsif button == "logout"
    @login_screen.wait_until(30) { @login_screen.logout_button.displayed? }
    @login_screen.logout_button.click
  end
end

And("I login with valid credentials") do
  step "I am on home screen"
  step "I go to account"
  step "I tap on 'login'"
  @login_screen = LoginScreen.new
  @login_screen.wait_until(60) { @login_screen.email_field.displayed? }
  @login_screen.email_field.send_keys("roku@discovery.com")
  @login_screen.wait_until(30) { @login_screen.password_field.displayed? }
  @login_screen.password_field.send_keys("111111")
  @login_screen.sign_in_button.click
end

Then("User should be logged in") do
  @login_screen = LoginScreen.new
  expect(@login_screen.email_field.displayed?).to be_falsy
end

Given("I login with invalid credentials") do
  step "I am on home screen"
  step "I go to account"
  step "I tap on 'login'"
  @login_screen = LoginScreen.new
  @login_screen.wait_until(60) { @login_screen.email_field.displayed? }
  @login_screen.email_field.send_keys("abc@discovery.com")
  @login_screen.wait_until(30) { @login_screen.password_field.displayed? }
  @login_screen.password_field.send_keys("1234")
  @login_screen.sign_in_button.click
end

Then("I see error message") do
  @login_screen = LoginScreen.new
  expect(@login_screen.error_msg.displayed?).to be_truthy
end
