And("I should see {string} video carousels") do |video_carousel|
  @watch_screen = EuroWatchScreen.new
  case video_carousel
  when "LATEST PREMIUM"
    expect(@watch_screen.latest_premium.displayed?).to be_truthy
  end
end

Then("I should see {string} on LATEST PREMIUM videos") do |button_type|
  @watch_screen = EuroWatchScreen.new
  case button_type
  when "PLAY BUTTON"
    expect(@watch_screen.play_button.displayed?).to be_truthy

  when "REPLAY BUTTON"
    expect(@watch_screen.replay_button.displayed?).to be_truthy
  end
end

And("I see meta data of each video of {string} carousel") do |carousel_type|
  @watch_screen = EuroWatchScreen.new
  case carousel_type
  when "LATEST PREMIUM"
    @watch_screen.scroll_to_first_row_carousel
    max_carousel_videos = 20
    (1..max_carousel_videos).each do |_i|
      @watch_screen.wait_until(30) { expect(@watch_screen.sport_description.displayed?) }
      before_scroll_video_text = @watch_screen.sport_description.text
      @watch_screen.scroll_to_right
      after_scroll_video_text = @watch_screen.sport_description.text
      break if before_scroll_video_text == after_scroll_video_text
    end
  end
end
