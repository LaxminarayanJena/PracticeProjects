When("I see the app launches and navigates to Show screen") do
  @show_screen = ShowScreen.new
  show_name = @show_screen.show_hero.text
  expect(show_name.eql?(NETWORK_DATA.show_search[:show_name])).to be_truthy
end

When("I enter the deep link URL of any free content") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.unlocked_episode}")
end

When("I enter the deep link URL of any locked content") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.locked_episode}")
end

When("I enter the deep link URL of any live content") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://live/#{NETWORK_DATA.watch_live}")
end

When("I should not be able to play locked episode without login") do
  @show_screen = ShowScreen.new
  expect(@show_screen.search_providers.displayed?).to be_truthy
end

And("I should be able to play the locked episode after logging in") do
  step "Search provider and login with valid credential"
  step "I should see the video playing"
end

And("I should be able to play the live video after logging in") do
  step "Search provider and login with valid credential"
  step "I should see live video playing"
end

Then("I see the video screen with a proper error message") do
  @video_screen = VideoScreen.new
  expect(@video_screen.red_key_err_mssg.displayed?).to be_truthy
end

When("I enter the deep link URL of any red key content") do
  driver.get("#{NETWORK_DATA.deeplink_prefix}-go-app://episodes/#{NETWORK_DATA.red_key_content}")
end
