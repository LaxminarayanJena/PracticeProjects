When("I click {string} tab on watch screen") do |tab_name|
  @watch_screen = EuroWatchScreen.new
  case tab_name
  when "SCHEDULE"
    expect(@watch_screen.schedule_tab.displayed?).to be_truthy
    @watch_screen.schedule_tab.click

  when "Latest News"
    expect(@watch_screen.latest_news_tab.displayed?).to be_truthy
    @watch_screen.latest_news_tab.click

  when "PREMIUM VIDEOS"
    expect(@watch_screen.premium_videos_tab.displayed?).to be_truthy
    @watch_screen.premium_videos_tab.click

  when "SPORT VIDEOS"
    @watch_screen.navigate_to_sports_tab
    @watch_screen.wait_until(60) { expect(@watch_screen.sport_videos_tab.displayed?).to be_truthy }
    @watch_screen.sport_videos_tab.click

  when "COMPETITION VIDEOS"
    @watch_screen.navigate_to_competition_tab
    @watch_screen.wait_until(60) { expect(@watch_screen.competition_videos_tab.displayed?).to be_truthy }
    @watch_screen.competition_videos_tab.click
  end
end

Then("I should be on the {string} tab") do |tab_name|
  @watch_screen = EuroWatchScreen.new
  case tab_name
  when "HOME"
    expect(@watch_screen.home_option.enabled?).to be_truthy

  when "SCHEDULE"
    expect(@watch_screen.schedule_tab.enabled?).to be_truthy

  when "Latest News"
    expect(@watch_screen.latest_news_tab.enabled?).to be_truthy

  when "PREMIUM VIDEOS"
    expect(@watch_screen.premium_videos_tab.enabled?).to be_truthy

  when "SPORT VIDEOS"
    @watch_screen.wait_until(60) { expect(@watch_screen.sport_videos_tab.enabled?).to be_truthy }

  when "COMPETITION VIDEOS"
    @watch_screen.wait_until(60) { expect(@watch_screen.competition_videos_tab.enabled?).to be_truthy }
  end
end
