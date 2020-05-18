Given("I am in signin screen") do
  step "I am on the Menu Bar"
  step "I navigate to 'Sign In' screen"
end

Then("I should see the details in signing screen") do
  @signin_screen = SigninScreen.new
  expect(@signin_screen.tv_sub_title.displayed?).to be_truthy
  expect(@signin_screen.tv_url.displayed?).to be_truthy
  expect(@signin_screen.tv_activation_code.displayed?).to be_truthy
  expect(@signin_screen.layout_activation_code.displayed?).to be_truthy
end
