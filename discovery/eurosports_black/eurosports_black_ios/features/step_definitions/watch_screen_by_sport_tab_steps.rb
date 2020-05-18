Then("I should see popular and all sports") do
  @watch_screen = EuroWatchBySportScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.popular_sports_category.displayed?).to be_truthy }
  @watch_screen.wait_until(30) { expect(@watch_screen.all_sports_category.displayed?).to be_truthy }
end

Given("I'm on the {string} tab") do |tab_name|
  @watch_screen = EuroWatchScreen.new
  case tab_name
  when "SPORT VIDEOS"
    step "I'm on the eurosports landing screen"
    step 'I click on "WATCH SCREEN"'
    step 'I click "SPORT VIDEOS" tab on watch screen'
  end
end

When("I click on one of the sport from {string} sports category") do |sport_category|
  @watch_screen = EuroWatchBySportScreen.new
  case sport_category
  when "POPULAR"
    expect(@watch_screen.popular_sports_category.displayed?).to be_truthy
    @watch_screen.wait_until(60) { expect(@watch_screen.one_of_the_popular_sports.displayed?).to be_truthy }
    @watch_screen.one_of_the_popular_sports.click

  when "ALL"
    expect(@watch_screen.all_sports_category.displayed?).to be_truthy
    @watch_screen.wait_until(60) { expect(@watch_screen.one_of_the_all_sports.displayed?).to be_truthy }
    @watch_screen.one_of_the_all_sports.click
  end
end

When("I should be on a selected sport category") do
  @watch_screen = EuroWatchScreen.new
  @watch_screen.wait_until(30) { expect(@watch_screen.back_button.displayed?).to be_truthy }
end

Then(/^I see \"([^\"]*)\" carousel$/) do |carousel_name|
  @watch_screen = EuroWatchBySportScreen.new
  case carousel_name
  when "UPCOMING"
    @watch_screen.wait_until(30) { expect(@watch_screen.upcoming_carousel.displayed?).to be_truthy }

  when "LATEST VIDEOS"
    @watch_screen.scroll_to_second_row_carousel
    @watch_screen.wait_until(30) { expect(@watch_screen.latest_videos_carousel.displayed?).to be_truthy }

  when "MOST POPULAR"
    @watch_screen = EuroWatchScreen.new
    @watch_screen.scroll_to_down
    @watch_screen.wait_until(30) { expect(@watch_screen.most_popular_carousel.displayed?).to be_truthy }
  end
end
