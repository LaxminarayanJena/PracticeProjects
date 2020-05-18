Then("I should see {string} video carousel on watch screen home") do |video_carousel|
  @watch_screen = EuroWatchScreen.new
  case video_carousel
  when "ON NEXT"
    @watch_screen.scroll_to_second_row_carousel
    expect(@watch_screen.on_next_carousel.displayed?).to be_truthy

  when "WHAT'S ON"
    expect(@watch_screen.whats_on_carousel.displayed?).to be_truthy
    expect(@watch_screen.whats_on_carousel.text.include?("WHAT'S ON")).to be_truthy

  when "MOST POPULAR"
    @watch_screen.scroll_to_third_row_carousel
    expect(@watch_screen.most_popular_carousel.displayed?).to be_truthy

  when "EUROSPORT ORIGINALS"
    @watch_screen.scroll_to_fourth_row_carousel
    expect(@watch_screen.eurosport_originals_carousel.displayed?).to be_truthy

  when "LATEST PREMIUM"
    @watch_screen.scroll_to_fifth_row_carousel
    expect(@watch_screen.latest_premium.displayed?).to be_truthy

  when "LATEST FREE"
    @watch_screen.scroll_to_sixth_row_carousel
    expect(@watch_screen.latest_free_carousel.displayed?).to be_truthy
  end
end

And("I see and click on one of the {string} series on watch hub") do |video_carousel|
  @watch_screen = EuroWatchScreen.new
  step "I should see 'EUROSPORT ORIGINALS' video carousel on watch screen home"
  case video_carousel
  when "EUROSPORT ORIGINALS"
    expect(@watch_screen.sport_name.displayed?).to be_truthy
    @watch_screen.sport_name.click
  end
end

Then("I should see {string} on EUROSPORT ORIGINALS series videos") do |button_type|
  @watch_screen = EuroWatchScreen.new
  case button_type
  when "BACK BUTTON"
    @watch_screen.wait_until(30) { expect(@watch_screen.back_button.displayed?).to be_truthy }

  when "PLAY BUTTON"
    @watch_screen.wait_until(30) { expect(@watch_screen.play_button.displayed?).to be_truthy }

  when "WATCH BUTTON"
    # rubocop:disable Custom/SleepCop.
    sleep 5
    # rubocop:enable Custom/SleepCop.
    @watch_screen.wait_until(30) { expect(@watch_screen.watch_button.displayed?).to be_truthy }
  end
end

And("I see {string} option on what’s on videos") do |button_type|
  @watch_screen = EuroWatchScreen.new
  case button_type
  when "PLAY BUTTON"
    expect(@watch_screen.play_button.displayed?).to be_truthy

  when "ON NOW"
    expect(@watch_screen.on_now_option.displayed?).to be_truthy

  when "LIVE"
    expect(@watch_screen.live_option.displayed?).to be_truthy
  end
end

And("I see {string} on most popular") do |button_type|
  @watch_screen = EuroWatchScreen.new
  case button_type
  when "PLAY BUTTON"
    expect(@watch_screen.play_button.displayed?).to be_truthy

  when "WATCH BUTTON"
    expect(@watch_screen.watch_button.displayed?).to be_truthy
  end
end

And("I see and verify scroll to right horizontal functionality on {string} carousel") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  case carousel_name
  when "WHAT'S ON"
    @watch_screen.scroll_to_first_row_carousel
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    expect(@watch_screen.sport_title.text.empty?).not_to be_truthy
    # only two videos are available in what's on carousel
    # will uncomment once more videos are available
    step "PENDING"
    # after_scroll_video_text = @watch_screen.sport_title.text
    # @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "ON NEXT"
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "MOST POPULAR"
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "EUROSPORT ORIGINALS"
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST PREMIUM"
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST FREE"
    @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_right
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }
  end
end

And("I see and verify scroll to left horizontal functionality on {string} carousel") do |carousel_name|
  @watch_screen = EuroWatchScreen.new
  case carousel_name
  when "ON NEXT"
    step 'I see and verify scroll to right horizontal functionality on "ON NEXT" carousel'
    before_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_description.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "MOST POPULAR"
    step 'I see and verify scroll to right horizontal functionality on "MOST POPULAR" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "EUROSPORT ORIGINALS"
    step 'I see and verify scroll to right horizontal functionality on "EUROSPORT ORIGINALS" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST PREMIUM"
    step 'I see and verify scroll to right horizontal functionality on "LATEST PREMIUM" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }

  when "LATEST FREE"
    step 'I see and verify scroll to right horizontal functionality on "LATEST FREE" carousel'
    before_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.scroll_to_left
    after_scroll_video_text = @watch_screen.sport_title.text
    @watch_screen.wait_until(30) { expect(before_scroll_video_text != after_scroll_video_text).to be_truthy }
  end
end

And("I see and verify metadata on each video tile of {string} carousel") do |video_carousel|
  @watch_screen = EuroWatchScreen.new
  # 20 max videos in each rail/carousel
  @max_carousel_videos = 20
  case video_carousel
  when "ON NEXT", "MOST POPULAR", "EUROSPORT ORIGINALS SERIES", "LATEST PREMIUM", "LATEST FREE"
    (1..@max_carousel_videos).each do
      @watch_screen.wait_until(30) { expect(@watch_screen.sport_title.displayed?) }
      before_scroll_video_text = @watch_screen.sport_title.text
      @watch_screen.scroll_to_right
      after_scroll_video_text = @watch_screen.sport_title.text
      break if before_scroll_video_text == after_scroll_video_text
    end
  end
end
