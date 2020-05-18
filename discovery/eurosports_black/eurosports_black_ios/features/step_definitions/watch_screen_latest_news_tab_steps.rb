Then("I should see {string} video carousels on watch screen latest news") do |video_carousel|
  @watch_screen = EuroWatchScreen.new
  case video_carousel
  when "MOST POPULAR"
    expect(@watch_screen.most_popular_carousel.displayed?).to be_truthy

  when "LATEST"
    expect(@watch_screen.latest_free_carousel.displayed?).to be_truthy
  end
end

And("I verify scroll to right horizontally on {string} carousel") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  case carousel_name
  when "MOST POPULAR"
    @watch_screen.scroll_to_first_row_carousel
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST"
    @watch_screen.scroll_to_second_row_carousel
    expect(@watch_screen.latest_free_carousel.displayed?).to be_truthy
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST PREMIUM"
    @watch_screen.scroll_to_first_row_carousel
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_description.displayed?) }
    before_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }
  end
end

And("I verify scroll to left horizontally on {string} carousel") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  case carousel_name
  when "MOST POPULAR"
    step 'I verify scroll to right horizontally on "MOST POPULAR" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST"
    step 'I verify scroll to right horizontally on "LATEST" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST PREMIUM"
    step 'I verify scroll to right horizontally on "LATEST PREMIUM" carousel'
    before_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }
  end
end
