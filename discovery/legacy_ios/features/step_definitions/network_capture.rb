Then("I capture the network calls") do
  @video_screen = VideoScreen.new
  BMP.fetch_req_res_body("v1/events", "POST", "playback", @video_screen)
end

Given("I am on Landing screen") do
  step "I log in with a valid provider"
  @landing_screen = LandingScreen.new
  @landing_screen.hamburger_icon.click
  @landing_screen.hamburger_watch_live.click
end
