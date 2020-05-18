When("I tap on live tv icon") do
  @livetv_screen = BaseScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.live_icon.displayed? }
  @livetv_screen.live_icon.click
end

And("I should see series and episode count details") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.series_episode_count.displayed? }
end

Then("I should see episode name below video player") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.episode_title.displayed? }
end

When("I should see video discription") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.video_discription.displayed? }
end

When("I should see series title") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.series_title.displayed? }
end

And("I should Navigate to episode details") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.episode_title.displayed? }
  @livetv_screen.episode_title.click
end

When("I should see episode name on description screen") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.episode_name_detail_view_src.displayed? }
end

Then("I should see next up on tlc section header") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.next_up_on_tlc.displayed? }
end

Then("I should see live content play's next with info") do
  @livetv_screen = LiveScreen.new
  @livetv_screen.wait_until(30) { @livetv_screen.scheduled_start.displayed? }
  @livetv_screen.wait_until(30) { @livetv_screen.nxt_video_thumbnail.displayed? }
  @livetv_screen.wait_until(30) { @livetv_screen.nxt_show_name.displayed? }
  @livetv_screen.wait_until(30) { @livetv_screen.episode_number.displayed? }
end
