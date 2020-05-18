When("I go to browse") do
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(60) { @app_settings_screen.hamburger_icon.displayed? }
  @app_settings_screen.hamburger_icon.click
  @app_settings_screen.wait_until(60) { @app_settings_screen.hamburger_browse.displayed? }
  @app_settings_screen.hamburger_browse.click
end

When("I am on BROWSE screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.app_browse_screen.displayed?).to be_truthy }
end

Then("I see BROWSE screen with affiliate logo, search icon and hamburger menu") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.app_browse_screen.displayed?).to be_truthy }
  expect(@home_screen.hamburger_icon.displayed?).to be_truthy
  expect(@home_screen.affiliate_logo.displayed?).to be_truthy
  expect(@home_screen.search_icon.displayed?).to be_truthy
end

Then("I see all hamburger menu icon functionality") do
  @home_screen = HomeScreen.new
  @app_settings_screen = AppSettingsScreen.new
  @app_settings_screen.wait_until(60) { @app_settings_screen.hamburger_icon.displayed? }
  @app_settings_screen.hamburger_icon.click
  @app_settings_screen.wait_until(60) { expect(@app_settings_screen.hamburger_shows_menu.displayed?).to be_truthy }
  expect(@app_settings_screen.hamburger_watch_later_menu.displayed?).to be_truthy
  expect(@app_settings_screen.hamburger_favorite_show.displayed?).to be_truthy
  expect(@app_settings_screen.hamburger_app_settings.displayed?).to be_truthy
  expect(@app_settings_screen.hamburger_watch_live.displayed?).to be_truthy
  expect(@app_settings_screen.hamburger_continue_watching.displayed?).to be_truthy
  expect(@app_settings_screen.hamburger_home.displayed?).to be_truthy
end

Then("I click on search icon") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.search_icon.displayed?).to be_truthy }
  @home_screen.search_icon.click
end

Then("I see keypad is enabled") do
  @home_screen = HomeScreen.new
  is_keypad_enabled = @home_screen.driver.is_keyboard_shown
  expect(is_keypad_enabled).to be_truthy
  @home_screen.driver.hide_keyboard
end

Then("I click on device back button") do
  @home_screen = HomeScreen.new
  @home_screen.press_back
end

Then("I see app exits") do
  @home_screen = HomeScreen.new
  current_package = @home_screen.driver.current_package
  expect(!(current_package.eql? ENV["LEGACY_ANDROID_APP_PACKAGE"])).to be_truthy
end

Then("I click on device home button") do
  @home_screen = HomeScreen.new
  driver.close_app
  current_package = @home_screen.driver.current_package
  expect(!(current_package.eql? ENV["LEGACY_ANDROID_APP_PACKAGE"])).to be_truthy
end
