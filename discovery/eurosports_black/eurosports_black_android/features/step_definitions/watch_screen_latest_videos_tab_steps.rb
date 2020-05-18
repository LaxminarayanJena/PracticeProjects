When("I see {string} carousel on latest videos tab on watch screen") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  case carousel_name
  when "MOST POPULAR"
    expect(@watch_screen.most_popular_label.displayed?).to be_truthy

  when "LATEST"
    expect(@watch_screen.latest_label.displayed?).to be_truthy
  end
end

Then("I scroll most popular videos left and right") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  @current_video_title = @video_screen.video_title.text
  start_x = @watch_screen.most_popular_video_card[0].location.x
  y = @watch_screen.most_popular_video_card[0].location.y
  end_x = 1
  size = @watch_screen.most_popular_video_card.size
  card = @watch_screen.most_popular_video_card
  max_swipping_round = 10
  # To scroll from left to right
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |j|
      @watch_screen.wait_until(30) { expect(card[j].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: start_x.to_i + 1000, start_y: y, end_x: end_x.to_i, end_y: y, duration: 400).perform.release
  end
  @after_swiping_video_title = @video_screen.video_title.text
  expect(@current_video_title != @after_swiping_video_title).to be true
  # To scroll from right to left
  (1..max_swipping_round).each do |_i|
    (1..size - 1).each do |_j|
      @watch_screen.wait_until(30) { expect(card[0].displayed?).to be_truthy }
    end
    Appium::TouchAction.new.swipe(start_x: end_x.to_i, start_y: y, end_x: start_x.to_i + 1000, end_y: y, duration: 400).perform.release
  end
  @video_screen.wait_until(30) { @video_screen.video_title.displayed? }
end

Then("I see metadata on each video tile in Most Popular in latest videos") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  start_x = @watch_screen.most_popular_video_card[0].location.x
  y = @watch_screen.most_popular_video_card[0].location.y
  end_x = 1
  size = @watch_screen.most_popular_video_card.size
  card = @watch_screen.most_popular_video_card
  max_swipping_round = 10
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

Then("I scroll latest carousel videos left and right") do
  @watch_screen = EuroWatchScreen.new
  @video_screen = EuroVideoScreen.new
  expect(@watch_screen.latest_label.displayed?).to be_truthy
  @watch_screen.wait_until(60) { @watch_screen.scroll_to_latest }
  start_x = @watch_screen.latest_video_card[0].location.x
  y = @watch_screen.latest_video_card[0].location.y
  end_x = 1
  size = @watch_screen.latest_video_card.size
  card = @watch_screen.latest_video_card
  max_swipping_round = 10
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
  @video_screen.wait_until(30) { @video_screen.video_title.displayed? }
end
