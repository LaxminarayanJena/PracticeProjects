When("I check for {string}") do |element_name|
  @landing_screen = LandingScreen.new
  @home_screen = HomeScreen.new
  case element_name
  when "home hero"
    expect(@home_screen.hero.displayed?).to be_truthy

  when "show_logo"
    expect(@landing_screen.show_logo.displayed?).to be_truthy

  when "episode title"
    expect(@landing_screen.hero_episode_title.displayed?).to be_truthy
  end
end

When("I see and click on home hero") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.hero.displayed? }
  @home_screen.hero.click
end

And("I play any episode") do
  @landing_screen = LandingScreen.new
  @landing_screen.hero_episode_play.click
  step "Search provider and login with valid credential" if @landing_screen.affiliate_search_providers.size.positive?
end

Then("I click on add to favorites") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.mark_favorite_option.displayed? }
  @show_screen.mark_favorite_option.click
end

And("I click on back button") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { @landing_screen.back_icon.displayed? }
  @landing_screen.back_icon.click
end

When("I see Show Title") do
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
  expect(@landing_screen.show_logo.displayed?).to be_truthy
end

When("I see episode title") do
  @home_screen = HomeScreen.new
  @landing_screen = LandingScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
  expect(@landing_screen.hero_episode_title.displayed?).to be_truthy
end

When("I see CTA button") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero.displayed?).to be_truthy }
  expect(@home_screen.hero_cta_btn.displayed?).to be_truthy
end

And("I tap on CTA button") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.hero_cta_btn.displayed?).to be_truthy }
  @home_screen.hero_cta_btn.click
end

And("I see show info screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@show_screen.mark_favorite_option.displayed?).to be_truthy }
end
