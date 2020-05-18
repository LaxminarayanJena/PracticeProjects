Then("A list of shows are displayed") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.shows_list.size.positive?).to be_truthy }
end

When("I select a show") do
  @shows_screen = ShowScreen.new
  @shows_screen.shows_list.first.click
end

Given("I am on show details screen with seasons") do
  @shows_screen = ShowScreen.new
  step "I am on the home screen"
  step "I see Continue Watching rail then I press down"
  @shows_screen.press_down
  @shows_screen.carousels("Most Popular Shows")[3].click
end

When("I see the season listed") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.seasons_list.size.positive?).to be_truthy }
  @shows_screen.press_right
  2.times { @shows_screen.press_down }
end

When("I can select any of the available seasons") do
  @shows_screen = ShowScreen.new
  (1..@shows_screen.seasons_list.size - 1).each do |i|
    @shows_screen.seasons_list[i].click
  end
  @shows_screen.seasons_list.first.click
end

Then("I see episodes in order of newest episode to oldest episode for that season") do
  @shows_screen = ShowScreen.new
  i = 1
  episodes = @shows_screen.season_episode_name_list
  episode_count = episodes.size
  while i < episode_count
    puts("compare ep no " + episodes[i].text + " and " + episodes[i - 1].text)
    expect((episodes[i].text.split("E")[1]).split(" ")[0].to_i < (episodes[i - 1].text.split("E")[1]).split(" ")[0].to_i).to be_truthy
    i += 1
  end
end

Then("I see episodes list for the selected season below season picker") do
  @shows_screen = ShowScreen.new
  i = 1
  selected_season_name = @shows_screen.seasons_name_list.first.text
  episodes = @shows_screen.season_episode_name_list
  episode_count = episodes.size
  while i < episode_count
    puts("season " + selected_season_name + " present in episode  " + episodes[i].text)
    expect(episodes[i].text.include?(selected_season_name)).to be true
    i += 1
  end
end

When("I can select any of the seasons and validate focus") do
  @shows_screen = ShowScreen.new
  (1..@shows_screen.seasons_list.size - 1).each do |i|
    @selected_season = @shows_screen.seasons_list[i]
    @selected_season.click
    step "I see corresponding season is in selected state"
  end
  @selected_season = @shows_screen.seasons_list.first
  @selected_season.click
  step "I see corresponding season is in selected state"
end

Then("I see corresponding season is in selected state") do
  @shows_screen = ShowScreen.new
  expect(@selected_season.focused.eql?("true")).to be true
end

Then("I see the latest season listed first and the other seasons listed in decreasing order") do
  @shows_screen = ShowScreen.new
  i = 1
  seasons = @shows_screen.seasons_name_list
  season_count = seasons.size
  while i < season_count
    puts("comparison of season " + seasons[i].text + " and " + seasons[i - 1].text)
    expect(seasons[i].text.split("S")[1].to_i < seasons[i - 1].text.split("S")[1].to_i).to be_truthy
    i += 1
  end
end

Given("I am on show details screen with clip rail") do
  @shows_screen = ShowScreen.new
  step "I am on the home screen"
  step "I see Continue Watching rail then I press down"
  @shows_screen.press_down
  @shows_screen.carousels("Most Popular Shows")[1].click
end

Then("I see the clips rail below the series rail") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.seasons_list.size.positive?).to be_truthy }
  @shows_screen.press_right
  3.times { @shows_screen.press_down }
  @shows_screen.wait_until(30) { expect(@shows_screen.extra_clip_list.size.positive?).to be_truthy }
end

Then("I can select any of the available clips to view") do
  @shows_screen = ShowScreen.new
  @video_landing_screen = VideoLandingScreen.new
  @shows_screen.extra_clip_list[0].click
  # rubocop:disable Custom/SleepCop.
  sleep 10 # added it to overcome video buffering & rendering of videos
  # rubocop:enable Custom/SleepCop.
  @video_landing_screen.press_up
  @video_landing_screen.press_media_play_pause
  expect(@video_landing_screen.video_play.displayed?).to be true
end

Then("I see default network {string} is selected") do |network|
  @shows_screen = ShowScreen.new
  case network
  when "TLC"
    expect(@shows_screen.network_logo.visible.eql?("true")).to be true
    expect(@shows_screen.network_selection_list[2].visible.eql?("true")).to be true
  end
end

Then("I see shows of the selected network {string} organised in content grids") do |option|
  @shows_screen = ShowScreen.new
  case option
  when "TLC"
    @displayed_show_card_network = @shows_screen.tlc_all_shows.text
    expect(@shows_screen.tlc_all_shows.displayed?).to be true
    expect(@shows_screen.network_logo.text.upcase.include?("TLC")).to be true
    expect(@shows_screen.tlc_all_shows.text.include?("TLC")).to be true
    step "Scrolling through selected network's show card in content grids"
  end
end

And("Scrolling through selected network's show card in content grids") do
  @shows_screen = ShowScreen.new
  @show_list = @shows_screen.tlc_shows_list
  @genre_card_count = @shows_screen.tlc_shows_list.size
  @shows_screen.press_right
  if @genre_card_count > 1
    @show_list.each do |cards|
      @shows_screen.press_down
      puts cards.text + " Scrolling down"
    end
    @show_list.each do |cards|
      @shows_screen.press_up
      puts cards.text + " Scrolling up"
    end
  end
end

When("I see the Show tiles with Show key art image and Show Title for selected network {string} organised in content grids") do |option|
  @shows_screen = ShowScreen.new
  case option
  when "TLC"
    @show_list = @shows_screen.tlc_shows_name
    @genre_card_count = @shows_screen.tlc_shows_name.size
    @shows_screen.press_right
    @shows_screen.press_down
    expect(@shows_screen.tlc_shows_list.first.displayed?).to be_truthy
    expect(@shows_screen.tlc_shows_list.size == @shows_screen.tlc_shows_name.size).to be_truthy
    @shows_screen.wait_until(30) { expect(@shows_screen.tlc_network_image.size.positive?).to be_truthy }
    if @genre_card_count > 1
      @show_list.each do |cards|
        @shows_screen.press_right
        puts("Selected network's show card title -" + cards.text)
      end
    end
  end
end

When("I click on any show tile of the selected network {string} organised in content grids") do |option|
  @shows_screen = ShowScreen.new
  case option
  when "TLC"
    step "I see default network 'TLC' is selected"
    @shows_screen.press_right
    @shows_screen.press_down
    if @shows_screen.tlc_shows_list.size.positive?
      expect(@shows_screen.tlc_shows_list.first.displayed?).to be_truthy
      @before_show_title = @shows_screen.tlc_shows_name.first.text
      @shows_screen.tlc_shows_list.first.click
    else
      puts "No tiles present in selected network 'TLC'"
    end
  end
end

Then("I am taken to the selected network's {string} Show Details page") do |option|
  @shows_screen = ShowScreen.new
  case option
  when "TLC"
    @shows_screen.wait_until(30) { @shows_screen.hero_show_carousel("1000-lb Sisters").displayed? }
    @after_show_title = @shows_screen.hero_show_carousel("1000-lb Sisters").text
    puts "Show title specific to Show on 'Show Hero screen' is : " + @after_show_title
    @before_show_title.eql?(@after_show_title)
  end
end

Then("I click on any episode") do
  @shows_screen = ShowScreen.new
  @shows_screen.season_episode_list[0].click
end

Then("I see list of all episodes") do
  @shows_screen = ShowScreen.new
  step "I see the season listed"
  @shows_screen.wait_until(30) { expect(@shows_screen.season_episode_list.size.positive?).to be_truthy }
end

Then("I see Episode Metadata") do
  @shows_screen = ShowScreen.new
  expect(@shows_screen.season_episode_list.size == @shows_screen.episode_thumbnail_list.size).to be_truthy
  (0..@shows_screen.season_episode_list.size - 1).each do |i|
    puts "Season muber,Epsiode number and tiltle:- " + @shows_screen.season_episode_name_list[i].text
    expect(@shows_screen.season_episode_name_list[i].text.empty?).not_to be_truthy
    puts "Episode description:- " + @shows_screen.episode_description_list[i].text
    expect(@shows_screen.episode_description_list[i].text.empty?).not_to be_truthy
    puts "Episode duration:- " + @shows_screen.episode_duration_list[i].text
    expect(@shows_screen.episode_duration_list[i].text.empty?).not_to be_truthy
  end
end
