Given("I am on shows screen") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(30) { @show_screen.shows_icon.displayed? }
  @show_screen.shows_icon.click
end

Then("A list of shows are displayed") do
  @shows_screen = ShowScreen.new
  @show_screen.wait_until(30) { expect(@shows_screen.shows_list.size.positive?).to be_truthy }
end

When("I select a show") do
  @shows_screen = ShowScreen.new
  @shows_screen.shows_list.first.click
end

Then("I should see {string}") do |showslist|
  @shows_screen = ShowScreen.new
  case showslist
  when "All Shows"
    @shows_screen.wait_until(30) { @shows_screen.search_by_name("All Shows").first.displayed? }
  end
end

Then("I see the Metadata on the tiles containing thumbnail image, title") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.search_by_name("#TeamTrees").first.displayed? }
end

When("I am on show details screen of {string} show") do |show_name|
  @shows_screen = ShowScreen.new
  step "I am on home screen"
  @shows_screen.scroll_to_element_by_text(show_name)
  @shows_screen.search_by_name(show_name).first.click
end

When("I am on show details screen") do
  @shows_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  step "I see 'Most Popular Shows' carousel on homepage"
  @home_screen.scroll_to_single_object(@home_screen.home_screen_carousel_elements("Most Popular Shows")[0])
  @home_screen.home_screen_carousel_elements("Most Popular Shows")[0].click
end

When("I see the season listed") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.list_of_all_seasons.size.positive?).to be_truthy }
end

When("I can select any of the available seasons") do
  @shows_screen = ShowScreen.new
  (1..@shows_screen.list_of_all_seasons.size - 1).each do |i|
    @shows_screen.list_of_all_seasons[i].click
  end
  @shows_screen.list_of_all_seasons.first.click
end

Then("I see episodes in order of newest episode to oldest episode for that season") do
  @shows_screen = ShowScreen.new
  episode_initial = @shows_screen.episode_metadata_info[0].text
  puts("Initinal Episode is: " + episode_initial)
  @shows_screen.scroll_to_down
  episode_afterscroll = @shows_screen.episode_metadata_info[0].text
  puts("After scrolling Episode is: " + episode_afterscroll)
  @shows_screen.wait_until(30) { expect(episode_initial > episode_afterscroll).to be_truthy }
end

Then("I see the latest season listed first and the other seasons listed in decreasing order") do
  @shows_screen = ShowScreen.new
  latest_season = @shows_screen.list_of_all_seasons[1].text
  previous_season = @shows_screen.list_of_all_seasons[2].text
  puts("latest season is :" + latest_season)
  puts("previous season is " + previous_season)
  @shows_screen.wait_until(30) { expect(latest_season > previous_season).to be_truthy }
end

Then("I see the clips rail below the series rail") do
  @shows_screen = ShowScreen.new
  @shows_screen.scroll_to_element_by_text("Extra Clips")
  @shows_screen.wait_until(30) { expect(@shows_screen.search_by_name("Extra Clips").size.positive?).to be_truthy }
  @shows_screen.wait_until(30) { expect(@shows_screen.extra_clips_rail.size.positive?).to be_truthy }
end

Then("I can select any of the available clips to view") do
  @shows_screen = ShowScreen.new
  @video_screen = VideoScreen.new
  @shows_screen.scroll_to_single_object(@shows_screen.extra_clip_showname.first)
  extra_clip_showname = @shows_screen.extra_clip_showname.first.text
  @shows_screen.extra_clip_showname.first.click
  @shows_screen.wait_until(30) { expect(@video_screen.video_title.displayed?).to be_truthy }
  extra_clip_showname_videoscreen = @video_screen.video_title.text
  @shows_screen.wait_until(30) { expect(extra_clip_showname.upcase == extra_clip_showname_videoscreen.upcase).to be_truthy }
end

Then("I click on More button on first episode") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.first_episode_more_less_button("More").displayed? }
  @shows_screen.first_episode_more_less_button("More").click
end

Then("I click on Less button on first episode") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.first_episode_more_less_button("Less").displayed? }
  @shows_screen.first_episode_more_less_button("Less").click
end

Then("I click on More button on description for first available episode and validate it") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.first_episode_description.last.displayed? }
  episode_description = @shows_screen.first_episode_description.last.text
  step "I click on More button on first episode"
  @shows_screen.wait_until(30) { @shows_screen.first_episode_more_less_button("Less").displayed? }
  @shows_screen.wait_until(30) { expect(@shows_screen.first_episode_description.last.text.include?(episode_description)).to be_truthy }
end

Then("I click on Less button on description for first available episode and validate it") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { @shows_screen.first_episode_description.last.displayed? }
  step "I click on More button on first episode"
  @shows_screen.wait_until(30) { @shows_screen.first_episode_more_less_button("Less").displayed? }
  episode_description = @shows_screen.first_episode_description.last.text
  step "I click on Less button on first episode"
  @shows_screen.wait_until(30) { @shows_screen.first_episode_more_less_button("More").displayed? }
  @shows_screen.wait_until(30) { expect(episode_description.include?(@shows_screen.first_episode_description.last.text)).to be_truthy }
end

Then("I check episode description and click on episode and validate description in video screen") do
  @shows_screen = ShowScreen.new
  @video_screen = VideoScreen.new
  episode_description = @shows_screen.episode_metadata_info[4].text
  @shows_screen.episode_list.first.click
  @shows_screen.wait_until(30) { expect(episode_description == @video_screen.video_desc.text).to be_truthy }
end

Then("I see a Show hero image") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.show_hero_image.size.positive?).to be_truthy }
end

Then("I see a network logo on Show hero") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.show_hero_network_logo_image.size.positive?).to be_truthy }
end

Then("I see Show title over show hero") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.show_hero_title_description.first.displayed?).to be_truthy }
end

Then("I click on back button and validate functionality") do
  @shows_screen = ShowScreen.new
  @home_screen = HomeScreen.new
  @shows_screen.back_button.click
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
end

Then("I see list of all episodes") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_list.size.positive?).to be_truthy }
end

Then("I see Episode metadata") do
  @shows_screen = ShowScreen.new
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_metadata_info[0].text.empty?).not_to be_truthy }
  puts("Season and episode info :" + @shows_screen.episode_metadata_info[0].text)
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_metadata_info[1].text.empty?).not_to be_truthy }
  puts("Episode title :" + @shows_screen.episode_metadata_info[1].text)
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_metadata_info[2].text.empty?).not_to be_truthy }
  puts("Episode time :" + @shows_screen.episode_metadata_info[2].text)
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_metadata_info[4].text.empty?).not_to be_truthy }
  puts("Episode description :" + @shows_screen.episode_metadata_info[4].text)
  @shows_screen.wait_until(30) { expect(@shows_screen.episode_image.size.positive?).to be_truthy }
end
