# frozen_string_literal: true

Given("I navigate to sign in option") do
  @screen = LoginScreen.new
  @screen.wait_until(30) { @screen.logo.displayed? }
  @screen.navigate_to_signin
end

When("I see visit url & activate code") do
  @screen = LoginScreen.new
  expect(@screen.visit_activate_url.displayed?).to be true
  expect(@screen.activate_code.displayed?).to be true
  @activation_code = @screen.activate_code.text
end

And("I get and verify the activation code") do
  step "I see visit url & activate code"

  @page = ActivatePage.new
  @page.open_web_browser
  @page.url
  @page.wait_until(30) { expect(@page.captilized_code.displayed?).to be_truthy }
  @page.captilized_code.send_keys @activation_code
  expect(@page.activate_button.displayed?).to be_truthy
  @page.activate_button.click
end

And("I log in with valid provider for activate") do
  provider = "DIRECTV"

  @page = ActivatePage.new
  @affiliate = AffiliateLoginPage.new

  @page.wait_until(30) { @page.providers_search.displayed? }
  @page.providers_search.send_keys provider
  @page.providers_text_list_item.click

  user_field, password_field, submit_button = @affiliate.login_elements(provider)
  user_field.send_keys ProviderAffiliates.get(provider)[:user_name]
  password_field.send_keys ProviderAffiliates.get(provider)[:password]
  submit_button.click
  # rubocop:disable Custom/SleepCop
  sleep 10 # sleep is used to load firetv page after logged in
  # rubocop:enable Custom/SleepCop
end

Then("I see the activation success message") do
  @page = ActivatePage.new
  @page.wait_until(30) { expect(@page.activation_success_msg.displayed?).to be_truthy }
  @page.activation_success_msg.text.downcase.include?("success")
end

Then("I see the provider image") do
  @screen = LoginScreen.new
  @screen.wait_until(30) { @screen.provider_image.displayed? }
end

Then("I login with valid provider") do
  step "I navigate to sign in option"
  step "I get and verify the activation code"
  step "I log in with valid provider for activate"
  step "I see the activation success message"
  step "I see the provider image"
end
