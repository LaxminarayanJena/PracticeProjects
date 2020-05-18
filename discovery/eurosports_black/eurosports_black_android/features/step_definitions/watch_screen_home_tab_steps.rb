When("I see {string} carousel on Home tab on watch screen") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.whats_on_label.displayed?).to be_truthy }
  case carousel_name
  when "WHAT'S ON"
    expect(@watch_screen.whats_on_label.displayed?).to be_truthy

  when "MOST POPULAR"
    @watch_screen.scroll_to_most_popular
    @watch_screen.wait_until(60) { expect(@watch_screen.most_popular_label.displayed?).to be_truthy }

  when "EUROSPORT ORIGINALS"
    @watch_screen.scroll_to_eurosport_originals
    @watch_screen.wait_until(60) { expect(@watch_screen.eurosports_original_label.displayed?).to be_truthy }

  when "LATEST PREMIUM"
    @watch_screen.scroll_to_latest_premium
    @watch_screen.wait_until(60) { expect(@watch_screen.latest_premium_label.displayed?).to be_truthy }

  when "LATEST"
    @watch_screen.scroll_to_latest_corousel
    @watch_screen.wait_until(60) { expect(@watch_screen.latest_label.displayed?).to be_truthy }

  when "TENNIS"
    @watch_screen.scroll_to_tennis
    @watch_screen.wait_until(60) { expect(@watch_screen.tennis_label.displayed?).to be_truthy }

  when "CYCLING"
    @watch_screen.scroll_to_cycling
    @watch_screen.wait_until(60) { expect(@watch_screen.cycling_label.displayed?).to be_truthy }

  when "FOOTBALL"
    @watch_screen.scroll_to_football
    @watch_screen.wait_until(60) { expect(@watch_screen.football_label.displayed?).to be_truthy }
  end
end

Then("I click on one of the EUROSPORT ORIGINALS series on watch hub") do
  step "I see 'EUROSPORT ORIGINALS' carousel on Home tab on watch screen"
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.eurosport_originals_series.displayed?).to be_truthy }
  @watch_screen.eurosport_originals_series.click
end

Then("I should see back button on selected EUROSPORT ORIGINALS series") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.back_icon.displayed?).to be_truthy }
end

When("I verify {string} filter on series videos") do |filter_name|
  @watch_screen = EuroWatchScreen.new
  case filter_name
  when "LATEST"
    expect(@watch_screen.latest_filter_label.displayed?).to be_truthy

  when "MOST POPULAR"
    expect(@watch_screen.most_popular_filter_label.displayed?).to be_truthy
  end
end

When("I scroll what's on carousel videos left and right") do
  @watch_screen = EuroWatchScreen.new
  start_x = @watch_screen.whats_on_video_card[0].location.x
  y = @watch_screen.whats_on_video_card[0].location.y
  end_x = 1
  size = @watch_screen.whats_on_video_card.size
  card = @watch_screen.whats_on_video_card
  max_swipping_round = 3
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |_j|
      @watch_screen.wait_until(30) { expect(card[0].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x.to_i + 1000, end_y: y, duration: 400).perform.release
  end
end

When("I scroll most popular carousel videos left and right") do
  @watch_screen = EuroWatchScreen.new
  expect(@watch_screen.most_popular_label.displayed?).to be_truthy
  @watch_screen.wait_until(60) { @watch_screen.scroll_to_most_popular }
  start_x = @watch_screen.most_popular_home_video_card[0].location.x
  y = @watch_screen.most_popular_home_video_card[0].location.y
  end_x = 1
  size = @watch_screen.most_popular_home_video_card.size
  card = @watch_screen.most_popular_home_video_card
  max_swipping_round = 9
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |_j|
      @watch_screen.wait_until(30) { expect(card[0].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x.to_i + 1000, end_y: y, duration: 400).perform.release
  end
end

When("I scroll latest premium carousel videos left and right") do
  @watch_screen = EuroWatchScreen.new
  # rubocop:disable Custom/SleepCop.
  sleep 5
  # rubocop:enable Custom/SleepCop.
  @watch_screen.scroll_to_latest_premium
  start_x = @watch_screen.latest_premium_video_card[0].location.x
  y = @watch_screen.latest_premium_video_card[0].location.y
  end_x = 1
  size = @watch_screen.latest_premium_video_card.size
  card = @watch_screen.latest_premium_video_card
  max_swipping_round = 9
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |_j|
      @watch_screen.wait_until(30) { expect(card[0].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x.to_i + 1000, end_y: y, duration: 400).perform.release
  end
end

Then("I verify series details on Eurosport Original Series on Home Tab") do
  @home_screen = EuroHomeScreen.new
  expect(@home_screen.original_series_sport[1].displayed?).to be_truthy
  expect(@home_screen.original_series_title[1].displayed?).to be_truthy
  expect(@home_screen.original_series_videos[1].displayed?).to be_truthy
end

Then("I see list of available videos in latest filter") do
  @video_screen = EuroVideoScreen.new
  expect(@video_screen.video_list.displayed?).to be_truthy
end

Then("I verify video details on each video in latest filter") do
  @video_screen = EuroVideoScreen.new
  max_swipping_round = 4
  (1..max_swipping_round).each do |_i|
    size = @video_screen.video_art.size
    art = @video_screen.video_art
    (1..size - 1).each do |j|
      @video_screen.wait_until(30) { expect(art[j].displayed?).to be_truthy }
      expect(@video_screen.video_title.displayed?).to be_truthy
      expect(@video_screen.video_description.displayed?).to be_truthy
    end
    @video_screen.scroll_down
  end
end

When("I see metadata on each video tile in WHAT'S ON in Home Tab") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  start_x = @watch_screen.whats_on_video_card[0].location.x
  y = @watch_screen.whats_on_video_card[0].location.y
  end_x = 1
  size = @watch_screen.whats_on_video_card.size
  card = @watch_screen.whats_on_video_card
  max_swipping_round = 3
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
      expect(@video_screen.video_title.displayed?).to be_truthy
      expect(@video_screen.video_description.displayed?).to be_truthy
      expect(@video_screen.video_sport_label.displayed?).to be_truthy
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
end

When("I see metadata on each video tile in MOST POPULAR in Home Tab") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  expect(@watch_screen.most_popular_label.displayed?).to be_truthy
  @watch_screen.wait_until(60) { @watch_screen.scroll_to_most_popular }
  start_x = @watch_screen.most_popular_home_video_card[0].location.x
  y = @watch_screen.most_popular_home_video_card[0].location.y
  end_x = 1
  size = @watch_screen.most_popular_home_video_card.size
  card = @watch_screen.most_popular_home_video_card
  max_swipping_round = 9
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
    expect(@video_screen.video_title.displayed?).to be_truthy
    expect(@video_screen.video_description.displayed?).to be_truthy
    expect(@video_screen.video_sport_label.displayed?).to be_truthy
  end
end

When("I see metadata on each video tile in LATEST PREMIUM in Home Tab") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  @watch_screen.wait_until(60) { expect(@watch_screen.home_tab.selected?).to be_truthy }
  @watch_screen.wait_until(60) { expect(@watch_screen.whats_on_label.displayed?).to be_truthy }
  expect(@watch_screen.home_tab.selected?).to be_truthy
  @watch_screen.wait_until(30) { @watch_screen.scroll_to_latest_premium }
  start_x = @watch_screen.latest_premium_video_card[0].location.x
  y = @watch_screen.latest_premium_video_card[0].location.y
  end_x = 1
  size = @watch_screen.latest_premium_video_card.size
  card = @watch_screen.latest_premium_video_card
  max_swipping_round = 9
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
      expect(@video_screen.video_title.displayed?).to be_truthy
      expect(@video_screen.video_description.displayed?).to be_truthy
      expect(@video_screen.video_sport_label.displayed?).to be_truthy
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
end
