# frozen_string_literal: true

Given("I am on the shows screen") do
  step "I search a show"
  step "I select the show's card"
end

When("I add the show to favorites") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(10) { @show_screen.favorite_btn.displayed? }
  @show_screen.favorite_btn.click
  @title_expect = @show_screen.show_title.text
end

Then("the my videos screen should display the show added from {string} as my favorite") do |screen_option_add|
  @my_videos_screen = MyVideosScreen.new
  @home_screen = HomeScreen.new
  case screen_option_add
  when "Search Screen"
    6.times { @my_videos_screen.press_up }
    @my_videos_screen.press_left
    @my_videos_screen.favorite_shows.first.click
    step "I should be on the show's show screen"
  when "Browse Screen"
    3.times { @my_videos_screen.press_up }
    2.times { @my_videos_screen.press_right }
    step "Check the expected show title with actual show title"
  when "Shows Screen"
    3.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    step "Check the expected show title with actual show title"
  when "Featured Screen"
    3.times { @my_videos_screen.press_up }
    @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
    4.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    step "Check the expected show title with actual show title"
  end
end

Given("I have a favorite show in {string}") do |screen_option|
  case screen_option
  when "Featured Screen"
    step "I navigate to featured option"
    step "I view & click the popular show"
    step "I add the show to favorites"
    step "the my videos screen should display the show added from 'Featured Screen' as my favorite"
  when "Shows Screen"
    step "I am on shows screen"
    step "I click on show season"
    step "I add the show to favorites"
    step "the my videos screen should display the show added from 'Shows Screen' as my favorite"
  when "Browse Screen"
    step "I navigate to browse screen"
    step "I select the show from browse screen"
    step "I click on show season"
    step "I add the show to favorites"
    step "the my videos screen should display the show added from 'Browse Screen' as my favorite"
  when "Search Screen"
    step "I am on the shows screen"
    step "I add the show to favorites"
    step "the my videos screen should display the show added from 'Search Screen' as my favorite"
    step "I should be on the show's show screen"
  end
end

And("I remove the show from favorites") do
  @show_screen = ShowScreen.new
  @show_screen.favorite_btn.click
end

Then("the my videos screen should not display the show removed from {string} as my favorite") do |screen_option_remove|
  @my_videos_screen = MyVideosScreen.new
  @home_screen = HomeScreen.new
  case screen_option_remove
  when "Search Screen"
    6.times { @my_videos_screen.press_up }
    @my_videos_screen.press_left
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Browse Screen"
    3.times { @my_videos_screen.press_up }
    2.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Shows Screen"
    3.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  when "Featured Screen"
    3.times { @my_videos_screen.press_up }
    @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
    4.times { @my_videos_screen.press_up }
    4.times { @my_videos_screen.press_right }
    expect(@my_videos_screen.list_emtpy_msg.displayed?).to be true
  end
end

And("Check the expected show title with actual show title") do
  @my_videos_screen.favorite_shows.first.click
  @title_actual = @show_screen.show_title.text
  expect(@title_expect == @title_actual).to be_truthy
end
