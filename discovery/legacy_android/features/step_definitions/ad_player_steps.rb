Then(/^I play video till advert$/) do
  @video = VideoScreen.new
  @video.wait_until { @video.video_container.displayed? }
  if @video.ad_title.positive?
    # Tapping the screen until AD is playing
    @video.tap_by_coordinates(300, 150) while @video.learn_more.size.positive?
  end
  @video.video_till_ad_play
end

Then(/^I click on learn more to see web view$/) do
  @video = VideoScreen.new
  list = @video.learn_more
  list[0].click
  @video.wait_until { @video.web_view.displayed? }
end
