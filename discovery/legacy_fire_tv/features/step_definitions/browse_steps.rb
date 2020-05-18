Given("I navigate to browse screen") do
  @browse_screen = BrowseScreen.new
  @browse_screen.wait_until(30) { @browse_screen.logo.displayed? }
  @browse_screen.navigate_to_browse
end

When("I select the show from browse screen") do
  @browse_screen = BrowseScreen.new
  @browse_screen.press_down
  @browse_screen.wait_until(30) { @browse_screen.show_row_content.displayed? }
  @browse_screen.show_row_content.click
end

And("I click on show season") do
  @browse_screen = BrowseScreen.new
  @browse_screen.show_season.displayed?
  @browse_screen.show_season.click
end

And("I click on season and select an episode") do
  step "I click on show season"
  @season_screen = BrowseScreen.new
  @season_screen.wait_until(30) { @season_screen.lock_btn.displayed? }
  @season_screen.lock_btn.click
end

And("do forward scroll on genres") do
  @show_info.press_down
  @show_info.wait_until(30) { @show_info.show_title.displayed? }
  @before_carousel_text = @show_info.show_title.text
  3.times { @show_info.press_right }
  @after_carousel_text = @show_info.show_title.text
end

And("do backward scroll on genres") do
  @before_carousel_text = @after_carousel_text
  puts @before_carousel_text
  3.times { @show_info.press_left }
  @after_carousel_text = @show_info.show_title.text
end

And("do forward scroll on shows") do
  @card_info = BrowseScreen.new
  @show_info = ShowScreen.new
  @show_info.press_down
  @show_info.wait_until(30) { @show_info.show_title.displayed? }
  expect(@card_info.genre_logo.displayed?).to be_truthy
  @genre_card_text = @show_info.show_title.text
  @show_info.press_select
  @genre_title_text = @card_info.genre_title.text
  expect(@genre_card_text == @genre_title_text).to be true
  @card_info.wait_until(30) { @card_info.show_season.displayed? }
  @show_info.press_select
  @show_info.wait_until(30) { @show_info.show_title.displayed? }
  @before_carousel_text = @show_info.show_title.text
  @show_info.press_back
  if @card_info.show_season_size > 1
    @show_info.press_right
  elsif @card_info.show_season_size > 2
    2.times { @show_info.press_right }
  else
    puts "Not enough cards to scroll"
  end
  @show_info.press_select
  @after_carousel_text = @show_info.show_title.text
end

And("do backward scroll on shows") do
  @show_info = ShowScreen.new
  step "do forward scroll on shows"
  @before_carousel_text = @after_carousel_text
  @show_info.press_back
  if @card_info.show_season_size > 1
    @show_info.press_left
  elsif @card_info.show_season_size > 2
    2.times { @show_info.press_left }
  else
    puts "Not enough cards to scroll"
  end
  @show_info.press_select
  @after_carousel_text = @show_info.show_title.text
end

When("I do {string} on genres") do |scroll|
  @show_info = ShowScreen.new
  case scroll
  when "forward scroll"
    step "do forward scroll on genres"
  when "backward scroll"
    step "do forward scroll on genres"
    step "do backward scroll on genres"
  end
end

When("I do {string} on shows") do |scroll|
  @show_info = ShowScreen.new
  case scroll
  when "forward scroll"
    step "do forward scroll on shows"
  when "backward scroll"
    step "do forward scroll on shows"
    step "do backward scroll on shows"
  end
end

When("I select the show from browse screen and click on Remote back button") do
  @show_info = ShowScreen.new
  @card_info = BrowseScreen.new
  step "I select the show from browse screen"
  @card_info.press_left
  @card_info.press_back
end

Then("I see Browse tab") do
  @browse_screen = BrowseScreen.new
  @browse_screen.wait_until(30) { @browse_screen.menu_browse.attribute("focused") == "true" }
end
