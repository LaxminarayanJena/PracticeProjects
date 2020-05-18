require "retriable"
# frozen_string_literal: true

Given(/^I'm on the home screen$/) do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://home")
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.hamburger_icon.displayed? }
end

Given("I go to a Login page") do
  @landing_screen = LandingScreen.new
end

And("I click on sign in") do
  @landing_screen = LandingScreen.new
  retry_proc = proc do
    @landing_screen.hamburger_icon.click
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 7, base_interval: 1, on_retry: retry_proc) do
    expect(@landing_screen.network_slider.displayed?).to eq(true)
    @landing_screen.scroll_to_bottom
    @landing_screen.signin_button.click
  end
end

When("I log in with a valid provider") do
  step "I click on sign in"
  common_login_steps(affiliates)
end

When("Search provider and login with valid credential") do
  common_login_steps(affiliates)
end

def affiliates
  ["DIRECTV", "U-Verse", "Optimum", "Frontier Communications"]
end

def authz_affiliates
  ["HTC Digital Cable-SC"]
end

When("I log in with an authz provider") do
  step "I click on sign in"
  common_login_steps(authz_affiliates)
end

def common_login_steps(affiliates)
  attempt = 0
  provider = affiliates[attempt]
  @landing_screen = LandingScreen.new
  while ProviderAffiliates.get(provider).nil?
    attempt += 1
    provider = affiliates[attempt]
  end
  puts provider
  retry_proc = proc do
    attempt += 1
    provider = affiliates[attempt]
    puts "Retrying with a different provider"
    step "I'm on the home screen"
  end
  Retriable.retriable(on: [Selenium::WebDriver::Error::NoSuchElementError, Selenium::WebDriver::Error::UnknownError, NoMethodError],
                      tries: 3, on_retry: retry_proc, base_interval: 3) do
    step "search and go to \"#{provider}\" providers page"
  end
end

When(/^search and go to "(.+)" providers page$/) do |provider|
  puts "Searching the provider"
  @landing_screen.search_providers.clear
  @landing_screen.search_providers.send_keys(provider)
  @landing_screen.select_provider.click
  puts "Select the provider"

  @affiliate_screen = AffiliateLoginScreen.new
  user_field, password_field, submit_button = @affiliate_screen.login_elements(provider)
  @affiliate_screen.wait_until(60) { user_field.displayed? }
  puts "Entering the username and password"

  driver.hide_keyboard
  user_field.send_keys ProviderAffiliates.get(provider)[:user_name]
  driver.hide_keyboard
  password_field.send_keys ProviderAffiliates.get(provider)[:password]
  driver.hide_keyboard
  submit_button.click
end

Then("User has to be logged in") do
  @landing_screen = LandingScreen.new
  retry_proc = proc do
    step "I'm on the home screen"
    @landing_screen.wait_until(30) { @landing_screen.affiliate_img.displayed? }
  end
  Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 2, base_interval: 1, on_retry: retry_proc) do
    @landing_screen.wait_until(30) { @landing_screen.affiliate_img.displayed? }
    expect(@affiliate_screen.affiliate_img.displayed?).to be_truthy
  end
end

Then("User has to be logged in for authz user") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
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
  expect(@landing_screen.tv_provider_header.displayed?).to be_truthy
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
  expect(@landing_screen.support_home_header.displayed?).to be_truthy
end

Given("PENDING") do
  pending
end

Then("I search for {string} on affiliate screen") do |text|
  @landing_screen = LandingScreen.new
  @landing_screen.search_providers.clear
  @landing_screen.search_providers.send_keys(text)
end

Then("I go back to previous screen from affiliate screen") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.hamburger_icon.displayed? }
  @landing_screen.hamburger_icon.click
end

Then("I see affiliate picker search text field is empty") do
  @landing_screen = LandingScreen.new
  expect(@landing_screen.search_providers.text.eql?("Search providers")).to be_truthy
end

And("I am on affiliate screen") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  @affiliate_login_screen.wait_until(30) { expect(@affiliate_login_screen.affiliate_screen_search.displayed?).to be_truthy }
end

Then("I see all network provider affiliate logos") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  (0..11).each do |id|
    @affiliate_login_screen.wait_until(30) { expect(@affiliate_login_screen.all_providers_logo(id).displayed?).to be_truthy }
  end
  @affiliate_login_screen.wait_until(30) { expect(@affiliate_login_screen.all_providers_a_z.displayed?).to be_truthy }
end

Then("I see no results") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  driver.hide_keyboard
  expect(@affiliate_login_screen.blank_affiliate_screen.displayed?).to be_truthy
end

Then("I click on close icon on search bar for search providers") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  @affiliate_login_screen.wait_until(30) { @affiliate_login_screen.search_provider_close_btn.displayed? }
  @affiliate_login_screen.search_provider_close_btn.click
end

And("I tap on cancel button on search bar") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  driver.hide_keyboard
  @affiliate_login_screen.wait_until(30) { @affiliate_login_screen.search_cancel_btn.displayed? }
  @affiliate_login_screen.search_cancel_btn.click
end

And("I enter wrong credential") do
  attempt = 0
  provider = affiliates[attempt]
  @landing_screen = LandingScreen.new
  while ProviderAffiliates.get(provider).nil?
    attempt += 1
    provider = affiliates[attempt]
  end
  step "go to \"#{provider}\" providers page and provide wrong credential"
end

And(/^go to "(.+)" providers page and provide wrong credential$/) do |provider|
  puts "Searching the provider"
  @landing_screen.search_providers.clear
  @landing_screen.search_providers.send_keys(provider)
  @landing_screen.select_provider.click
  puts "Select the provider"

  @affiliate_screen = AffiliateLoginScreen.new
  user_field, password_field, submit_button = @affiliate_screen.login_elements(provider)
  @affiliate_screen.wait_until(60) { user_field.displayed? }
  puts "Entering the username and password"
  user_field.send_keys("xyz")
  driver.hide_keyboard
  password_field.send_keys("xyz")
  driver.hide_keyboard
  submit_button.click
end

And("login is unsuccessful") do
  @affiliate_screen = AffiliateLoginScreen.new
  expect(@affiliate_screen.provider_page.displayed?).to be_truthy
end
