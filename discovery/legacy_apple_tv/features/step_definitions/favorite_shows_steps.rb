# frozen_string_literal: true

When("I add the show to Favorites") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(10) { @show_screen.favourites_button.displayed? }
  @show_screen.favourites_button.click
  @show_subtitle_list = @show_screen.show_inner_titles
  @title_expect = @show_subtitle_list[0].text
  puts @title_expect
end

Then("Favorite Shows screen should display the show added from {string} as my favorites") do |screen_tab_options|
  @show_screen = ShowScreen.new
  case screen_tab_options
  when "Shows Screen"
    @show_screen.press_menu
    # rubocop:disable Custom/SleepCop.
    sleep(5)
    # rubocop:enable Custom/SleepCop.
    @show_screen.press_up
    3.times { @show_screen.press_right }
    @show_screen.wait_until(10) { @show_screen.menu_favorite_shows.displayed? }
    step "Check the expected show title with actual show title"
  end
end

And("Check the expected show title with actual show title") do
  @show_screen = ShowScreen.new
  @fav_sublist = @show_screen.favorites_show_list
  @fav_sublist.each do |season|
    puts season.text
    puts @title_expect
    if season.text.eql?(@title_expect)
      puts "same"
      season.click
    end
  end
end

Given("I have a Favorite Show in {string}") do |screen_tab|
  case screen_tab
  when "Shows Screen"
    step "I select the show under Show tab"
    step "I add the show to Favorites"
    step "Favorite Shows screen should display the show added from 'Shows Screen' as my favorites"
  end
end

And("I remove the show from Favorites") do
  @show_screen = ShowScreen.new
  @show_screen.favourites_button.click
  @show_screen.press_menu
end

Then("Favorite Shows screen should NOT display the show added from {string} as my favorites") do |screen_tab_remove|
  @show_screen = ShowScreen.new
  case screen_tab_remove
  when "Shows Screen"
    @fav_sublist = @show_screen.favorites_show_list
    @fav_sublist.each do |season|
      puts season.text
      puts @title_expect
      if season.text.eql?(@title_expect)
        season.click
      else
        expect(season.text.include?(@title_expect)).to be true
        puts "Video has removed from Favorite Shows"
      end
    end
  end
end
