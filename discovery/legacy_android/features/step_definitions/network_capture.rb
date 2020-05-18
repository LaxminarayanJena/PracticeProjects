Then("I capture the network calls") do
  step "I log in with a valid provider"
  @landing_screen = LandingScreen.new
  BMP.fetch_req_res_body("/v1/events", "POST", "playback", @landing_screen)
end
