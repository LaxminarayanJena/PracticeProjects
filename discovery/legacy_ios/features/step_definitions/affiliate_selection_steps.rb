Then("I see mvpd logos") do
  @affiliate_login_screen = AffiliateLoginScreen.new
  @affiliate_login_screen.wait_until(30) { expect(@affiliate_login_screen.affiliate_logo_images.size.positive?).to be_truthy }
end

Then("I enter only 3 letters in affiliate search box and verify functionality") do
  @landing_screen = LandingScreen.new
  @affiliate_login_screen = AffiliateLoginScreen.new
  @landing_screen.search_providers.send_keys("Dir")
  @affiliate_login_screen.wait_until(30) { expect(@affiliate_login_screen.affiliate_serach_list.size.positive?).to be_truthy }
end
