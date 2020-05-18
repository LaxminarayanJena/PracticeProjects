Given("I am on Browse screen as an authorized user") do
  @browse_screen = BrowseScreen.new
  @browse_screen.verify_landing_screen
  @browse_screen.navigate_browse
  expect(@browse_screen.menu_browse.displayed?).to be true
  @browse_screen.wait_until(30) { @browse_screen.genre_list_first.displayed? }
end

When("I scroll through the genre") do
  @browse_screen = BrowseScreen.new
  @browse_list = @browse_screen.genre_list
  @browse_screen.press_down
  @browse_screen.press_left
  @browse_list.each do |genre|
    @browse_screen.press_down
    puts genre.text + " Scrolling down"
  end
  @browse_list.each do |genre|
    puts genre.text + " Scrolling up"
    @browse_screen.press_up
  end
  expect(@browse_screen.genre_list.first.displayed?).to be true
end

And("I select any genre") do
  @browse_screen = BrowseScreen.new
  @browse_screen.press_down
  @browse_screen.press_left
  2.times { @browse_screen.press_down }
  # rubocop:disable Custom/SleepCop.
  sleep 2 # added it to overcome video buffering & rendering.
  # rubocop:enable Custom/SleepCop.
end

Then("I see card thumbnail & show name below the thumbnail") do
  @browse_screen = BrowseScreen.new
  @browse_screen.press_right
  @first_card_title = @browse_screen.genre_card_list1.first.text
  @genre_card_count = @browse_screen.genre_card_list1.size
  if @genre_card_count >= 1
    @browse_screen.wait_until(10) { @browse_screen.genre_card_list1.first.displayed? }
    expect(@browse_screen.genre_card_list1.first.displayed?).to be true
    puts "Card Metadata -> Show Name as : " + @first_card_title
  else
    puts "No card thumbnail & show name below thumbnail to display"
  end
end

Then("I see user is able to access all cards by scrolling horizontally & vertically") do
  @browse_screen = BrowseScreen.new
  @browse_screen.press_right
  @genre_cards_list = @browse_screen.genre_card_list1
  @genre_card_count = @browse_screen.genre_card_list1.size
  if @genre_card_count > 1
    @genre_cards_list.each do |cards|
      @browse_screen.press_down
      puts cards.text + " Scrolling down"
    end
    @genre_cards_list.each do |cards|
      @browse_screen.press_up
      puts cards.text + " Scrolling up"
    end
  end
  @browse_screen.press_left
end
