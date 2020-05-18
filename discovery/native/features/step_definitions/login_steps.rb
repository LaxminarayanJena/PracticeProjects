require "retriable"
# frozen_string_literal: true

Given("I go to a Login page") do
  @landing_screen = LandingScreen.new
end

Given(/^I'm on the home screen$/) do
  Kernel.puts "Activity: #{current_activity}"
  if current_activity == "com.discovery.MainActivity"
    @landing_screen = LandingScreen.new
    @landing_screen.wait_until(60) { @landing_screen.free_limited_access.displayed? }
  end
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://home")
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { @home_screen.hero.displayed? }
end

And("I navigate to the home screen") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://home")
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { @home_screen.hero.displayed? }
end

When("I login as anonymous user") do
  @landing_screen = LandingScreen.new
  @landing_screen.free_limited_access.click
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { @home_screen.hero.displayed? }
end

When(/^I restart the application$/) do
  driver.reset
end

Then(/^The returning user should be on the homescreen$/) do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.hero.displayed? }
end

And("I log in with a valid provider from the home screen") do
  @home_screen = HomeScreen.new
  @home_screen.sign_in_button.click
  common_login_steps(affiliates)
end

When("I log in with a valid provider") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.sign_in_button.displayed? }
  @landing_screen.sign_in_button.click
  common_login_steps(affiliates)
end

And("I log in with common login steps") do
  common_login_steps(affiliates)
end

When("I log in with an authz provider") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.sign_in_button.displayed? }
  @landing_screen.sign_in_button.click
  common_login_steps(authz_affiliates)
end

def affiliates
  ["Frontier Communications", "Optimum", "DIRECTV", "AT&T U-Verse"]
end

def authz_affiliates
  ["West Alabama TV Cable"]
end

def common_login_steps(affiliates)
  attempt = 0
  provider = affiliates[attempt]
  while ProviderAffiliates.get(provider).nil?
    attempt += 1
    provider = affiliates[attempt]
  end
  puts provider
  retry_proc = proc do |exception|
    Kernel.puts "=====Retrying====== /n #{exception}"
    attempt += 1
    provider = affiliates[attempt]
    puts "Retrying with a different provider: #{provider}"
    step "I navigate to the home screen"
    @home_screen.sign_in_button.click
  end
  Retriable.retriable(on: [Selenium::WebDriver::Error::NoSuchElementError, Selenium::WebDriver::Error::UnknownError, NoMethodError,
                           Selenium::WebDriver::Error::TimeoutError], tries: 4, on_retry: retry_proc, base_interval: 3) do
    step "search and go to \"#{provider}\" providers page"
    step "User has to be logged in"
  end
end

When(/^search and go to "(.+)" providers page$/) do |provider|
  @affiliate_search = AffiliateProviderSearchScreen.new
  Kernel.puts "Searching the provider"
  @affiliate_search.wait_until(60) { @affiliate_search.search_providers.displayed? }
  @affiliate_search.search_providers.clear
  @affiliate_search.search_providers.send_keys(provider)
  # Need to click twice to exit the search box
  @affiliate_search.wait_until(60) { @affiliate_search.select_provider(provider).displayed? }
  @affiliate_search.select_provider(provider).click
  @affiliate_search.select_provider(provider).click
  puts "Select the provider"

  @affiliate_screen = AffiliateLoginScreen.new
  @affiliate_screen.switch_context_to_web

  user_field, password_field, submit_button = @affiliate_screen.login_elements(provider)

  @affiliate_screen.wait_until(60) { user_field.displayed? }
  @affiliate_screen.wait_until(60) { password_field.displayed? }

  puts "Entering the username and password"
  if provider == "West Alabama TV Cable"
    user_field.send_keys(ENV["AUTH_Z_USER"])
    password_field.send_keys(ENV["AUTH_Z_PASSWORD"])
  else
    user_field.send_keys ProviderAffiliates.get(provider)[:user_name]
    password_field.send_keys ProviderAffiliates.get(provider)[:password]
  end
  driver.hide_keyboard
  submit_button.click
  @affiliate_screen.switch_context_to_native
end

Then("User has to be logged in") do
  @homescreen = HomeScreen.new
  @homescreen.wait_until(60) { @homescreen.affiliate_logo.displayed? }
end

Given("I am on affiliate login screen") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(60) { expect(@landing_screen.sign_in_button.displayed?).to be_truthy }
  @landing_screen.sign_in_button.click
end

When("I close the affiliate picker") do
  step "I am on affiliate picker screen"
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { expect(@landing_screen.close_icon.displayed?).to be_truthy }
  @landing_screen.close_icon.click
end

Then("I click on sign in button on Home Page") do
  @home_screen = HomeScreen.new
  @home_screen.sign_in_button.click
end

Then("I am on affiliate picker screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.affiliate_search_screen.displayed?).to be_truthy }
end

Then("I see all providers list including mvpd") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.mvpd_provider.displayed?).to be_truthy }
  # rubocop:disable Custom/SleepCop.
  sleep 5 # wait_until is not working here as it is taking much time to load so i have used sleep
  # rubocop:enable Custom/SleepCop.
  start_x_coordinate = @home_screen.device_width - 50
  start_y_coordinate = @home_screen.device_height - 500
  end_x_coordinate = start_x_coordinate
  end_y_coordinate = 200
  @home_screen.scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  @home_screen.wait_until(30) { expect(@home_screen.all_providers.displayed?).to be_truthy }
end

Given("PENDING") do
  pending
end
