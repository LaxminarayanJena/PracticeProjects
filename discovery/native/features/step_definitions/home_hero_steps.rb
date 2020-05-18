Then("I see Hero show title") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero_text.displayed?).to be_truthy }
end

And("I see recommended show content on hero") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
end

And("I see video playing in portrait mode") do
  @home_screen = HomeScreen.new
  @show_screen = ShowScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero_video_player.displayed?).to be_truthy }
  mode = driver.orientation
  expect(mode).to eq :portrait
end

And("I see up next videos") do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.up_next.displayed?).to be_truthy }
end

When(/^I tap on back button$/) do
  @video_screen = VideoScreen.new
  @video_screen.wait_until(30) { expect(@video_screen.back_button.displayed?).to be_truthy }
  @video_screen.back_button.click
end
