When("I click on {string}") do |account_option|
  @account_screen = AccountScreen.new
  @account_screen.wait_until(60) { @account_screen.about.displayed? }
  case account_option
  when "MyList"
    @account_screen.mylist.click
  when "App Information"
    @account_screen.app_information.click
  when "Help"
    @account_screen.help.click
  when "About"
    @account_screen.about.click
  when "Push Notifications"
    @account_screen.push_notifications.click
  when "Debug Settings"
    @account_screen.debug_settings.click
  end
end

Then("{string} details should be visible") do |account_option|
  @account_screen = AccountScreen.new
  case account_option
  when "MyList"
    step "I should see blank screen"
  when "App Information"
    @account_screen.wait_until(30) { @account_screen.search_by_name("Version Number").first.displayed? }
  when "About"
    step "I should see blank screen"
  when "Debug Settings"
    @account_screen.wait_until(30) { @account_screen.search_by_name("Configuration Name").first.displayed? }
  end
end

Then("I should be able to navigate to {string} website") do |account_option|
  @account_screen = AccountScreen.new
  case account_option
  when "Help"
    @account_screen.wait_until(30) { @account_screen.search_by_name("CONTACT US").first.displayed? }
  when "Push Notifications"
    @account_screen.wait_until(30) { @account_screen.contains_by_name("This Visitor Agreement").displayed? }
  end
end
