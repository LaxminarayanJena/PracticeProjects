Given("I search a valid show in Apple TV") do
  @search_screen = SearchScreen.new
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }
  expect(@home_screen.menu_featured.displayed?).to be true
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  expect(@search_screen.search_box.displayed?).to be true
  @search_screen.search_show_send_keys(NETWORK_DATA.show_search[:show_name])
end

When("I select the show card") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_results_title[0].displayed? }
  expect(@search_screen.search_results_title[0].displayed?).to be true
  2.times { @search_screen.press_down }
  @search_screen.press_right
  @search_screen.search_results[0].click
end

Then("I should be on the Show screen") do
  @search_screen = SearchScreen.new
  @show_title_list = @search_screen.search_results_title
  @show_title_list.each do |title_list|
    @title = title_list.text
    puts @title
    next unless @title.eql?(NETWORK_DATA.show_search[:show_name])

    expect(@home_screen.play_latest_button.displayed?).to be true
    expect(@home_screen.play_favourites_button.displayed?).to be true
    if @home_screen.check_play_more_seasons_button.positive?
      expect(@home_screen.play_more_seasons_button.displayed?).to be true
    else
      puts "More seasons button not present"
    end
    step "I click on play button under Show tab"
  end
end

Given("I search an invalid show in Apple TV") do
  @search_screen = SearchScreen.new
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.menu_featured.displayed? }
  expect(@home_screen.menu_featured.displayed?).to be true
  @search_screen.navigate_to_search
  @search_screen.press_select
  @search_screen.wait_until(30) { @search_screen.search_box.displayed? }
  expect(@search_screen.search_box.displayed?).to be true
  @search_screen.search_show_send_keys(NETWORK_DATA.show_search[:invalidShowName])
end

Then("I should see no results found message") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(30) { @search_screen.search_no_results_msg.displayed? }
  expect(@search_screen.search_no_results_msg.displayed?).to be true
end
