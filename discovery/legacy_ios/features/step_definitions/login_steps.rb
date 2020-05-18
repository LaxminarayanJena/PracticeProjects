require "retriable"
# frozen_string_literal: true

Given("I go to a Login page") do
  @landing_screen = LandingScreen.new
end

And("I see and click on hamburger icon") do
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_icon.displayed?
  @landing_screen.hamburger_icon.click
end

And("I see and click on sign in") do
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_sign_in_menu.displayed?
  @landing_screen.hamburger_sign_in_menu.click
end

When("I log in with a valid provider") do
  step "I see and click on hamburger icon"
  step "I see and click on sign in"
  common_login_steps(affiliates)
end

When("I search provider and login with valid credential") do
  common_login_steps(affiliates)
end

def affiliates
  # TODO: need to login with different provider when login fails
  ["DIRECTV", "U-Verse", "Optimum", "Frontier Communications"]
end

And("Retrying with different provider") do
  @affiliate_screen = AffiliateLoginScreen.new
  @affiliate_screen.top_close_button.click
  @landing_screen.hamburger_icon.click
end

def common_login_steps(affiliates)
  attempt = 0
  provider = affiliates[attempt]
  @landing_screen = LandingScreen.new
  # Find a provider with credentials
  while ProviderAffiliates.get(provider).nil?
    attempt += 1
    provider = affiliates[attempt]
  end
  retry_proc = proc do
    attempt += 1
    provider = affiliates[attempt]
    puts "Retrying with a different provider"
    begin step "Retrying with different provider"
    rescue Selenium::WebDriver::Error::NoSuchElementError => e
      puts "Tried to get back to home screen but got an error:" + e
    end
  end
  Retriable.retriable(on: [Selenium::WebDriver::Error::NoSuchElementError, Selenium::WebDriver::Error::UnknownError, NoMethodError],
                      tries: 7, on_retry: retry_proc, base_interval: 3) do
    step "search and go to \"#{provider}\" providers page"
  end
end

When(/^search and go to "(.+)" providers page$/) do |provider|
  puts "Searching the provider"
  @landing_screen.search_providers.clear
  @landing_screen.search_providers.send_keys(provider)
  provider = "AT&T U-Verse" if provider == "U-Verse"
  @landing_screen.search_provider_results(provider).click
  puts "Select the provider"
  @affiliate_screen = AffiliateLoginScreen.new
  # @affiliate_screen.switch_context_to_web

  user_field, password_field, submit_button = @affiliate_screen.login_elements(provider)

  puts "Entering the username and password"
  @affiliate_screen.wait_until(60) { user_field.displayed? }
  user_field.send_keys ProviderAffiliates.get(provider)[:user_name]

  @affiliate_screen.wait_until(60) { password_field.displayed? }
  password_field.click
  password_field.send_keys ProviderAffiliates.get(provider)[:password]
  # driver.hide_keyboard

  @affiliate_screen.wait_until(60) { submit_button.displayed? }
  submit_button.click

  # @affiliate_screen.switch_context_to_native
end

Then("I see and click on signout") do
  @settings_screen = SettingsScreen.new
  @settings_screen.hamburger_icon.click if @settings_screen.hamburger_icon.displayed?
  @settings_screen.wait_until(30) { @settings_screen.hamburger_settings_menu.displayed? }
  @settings_screen.hamburger_settings_menu.click
  expect(@settings_screen.sign_out_button.displayed?).to be_truthy
  @settings_screen.sign_out_button.click
  step "I click on close button"
end

Then("I check if Forgot password is present") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.forgot_password_text.displayed?).to be_truthy
end

And("I check if Don't see provider is present") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.dont_see_provider_text.displayed?).to be_truthy
end

And("I click on Don't see provider") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.dont_see_provider_text.displayed? }
  @landing_screen.dont_see_provider_text.click
end

Then("I see Don't see provider page") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.tv_provider_header.displayed? }
end

And("I check if FAQ is present") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.faq_text.displayed?).to be_truthy
end

And("I click on FAQ") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.faq_text.displayed? }
  @landing_screen.faq_text.click
end

Then("I see FAQ page") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.support_home_header.displayed? }
end
