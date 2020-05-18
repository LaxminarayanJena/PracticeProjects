Then("I see show title, episode title and cta button") do
  step "I see 'SHOW TITLE' on home hero"
  step "I see 'EPISODE TITLE' on home hero"
  step "I see 'CTA BUTTON' on home hero"
end

Then("I see {string} on home hero") do |title|
  @landing_screen = LandingScreen.new
  case title
  when "SHOW TITLE"
    @landing_screen.wait_until(30) { expect(@landing_screen.hero_show_title.displayed?).to be_truthy }

  when "EPISODE TITLE"
    @landing_screen.wait_until(30) { expect(@landing_screen.hero_episode_title.displayed?).to be_truthy }

  when "CTA BUTTON"
    @landing_screen.wait_until(30) { expect(@landing_screen.hero_cta_btn.displayed?).to be_truthy }
  end
end

And("I tap on CTA button") do
  @landing_screen = LandingScreen.new
  @landing_screen.wait_until(30) { expect(@landing_screen.hero_cta_btn.displayed?).to be_truthy }
  @landing_screen.hero_cta_btn.click
end
