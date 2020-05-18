Then("I should see the live screen with Network List, On Now and Up Next section") do
  @live_screen = LiveScreen.new
  @search_screen = SearchScreen.new
  expect(@live_screen.wait_until(60) { @live_screen.live_network_logo_list.size.positive? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_onnow_rail.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_upnext_rail.displayed? }).to be_truthy
end

Then("I should see the network list with different networks") do
  expect(@live_screen.wait_until(60) { @live_screen.live_network_logo_list.size.positive? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_network_logo_list.first.selected? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_network_logo_list.size }).to be == 18
end

Then("I should see Live content meta data") do
  expect(@live_screen.wait_until(60) { @live_screen.live_show_title.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_title_desc.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_age.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_badge.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_show_progress_bar.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_image.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_time.displayed? }).to be_truthy
end

Then("I should see This show is not aired yet with See past episodes button for VOD content") do
  step "I see UpNext rail on Live screen"
  expect(@live_screen.wait_until(60) { @live_screen.live_msg_not_airedyet }).to be == "This show has not aired yet"
  expect(@live_screen.wait_until(60) { @live_screen.live_btn_past_episodes.displayed? }).to be_truthy
  expect(@live_screen.wait_until(60) { @live_screen.live_btn_past_episodes.text }).to be == "See Past Episodes"
end

And("I see UpNext rail on Live screen") do
  2.times { @live_screen.press_down }
  expect(@live_screen.wait_until(60) { @live_screen.live_upnext_rail.displayed? }).to be_truthy
end
