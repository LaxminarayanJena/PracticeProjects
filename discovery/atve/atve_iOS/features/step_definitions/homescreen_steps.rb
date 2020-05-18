Given("I am on home screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_icon.displayed? }
end

When("I see home hero") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.home_hero.first.displayed? }
end

When("I start home hero series") do
  step "I see home hero"
  @home_screen.home_hero.first.click
end

Then("I should see the series name and description") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.series_name.displayed? }
  @home_screen.wait_until(30) { @home_screen.series_description.displayed? }
end

When("I navigate to the live tv screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.live.displayed? }
  @home_screen.live.click
end

Then("I should see blank screen") do
  # pending
end

Then("I see {string} carousel on homepage") do |carousel_name|
  @home_screen = HomeScreen.new
  case carousel_name
  when "Most Popular Shows"
    @home_screen.scroll_to_element_by_text(carousel_name)
    @home_screen.wait_until(30) { expect(@home_screen.home_screen_carousels(carousel_name).size.positive?).to be_truthy }
  when "Shows"
    @home_screen.scroll_down_by_screen_coordinates("20%") while @home_screen.search_by_name(carousel_name).size < 2
    @home_screen.wait_until(30) { expect(@home_screen.home_screen_carousels(carousel_name).size.positive?).to be_truthy }
  when "Just Added Shows"
    @home_screen.scroll_to_element_by_text(carousel_name)
    @home_screen.wait_until(15) { expect(@home_screen.search_by_name(carousel_name).first.displayed?).to be_truthy }
  end
end

Then("I see home hero carousel is updating periodically") do
  @home_screen = HomeScreen.new
  initial_show_name = @home_screen.series_name.text
  Support::Eventually.eventually(timeout: 10) { expect(initial_show_name != @home_screen.series_name.text).to be_truthy }
end

Then("I scroll down and up and see home hero carousel not automatically updating") do
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_down
  @home_screen.scroll_to_up
  initial_show_name = @home_screen.series_name.text
  Support::Eventually.eventually(timeout: 10) { expect(initial_show_name == @home_screen.series_name.text).to be_truthy }
end

Then("I click on Home hero and verify CTA based on the content type") do
  @home_screen = HomeScreen.new
  @video_screen = VideoScreen.new
  @home_screen.scroll_to_down
  @home_screen.scroll_to_up
  show_name_in_homehero = @home_screen.series_name.text
  @home_screen.watch_now_start_series_button.first.click
  @home_screen.wait_until(30) { expect(@home_screen.search_by_name(show_name_in_homehero).size.positive?).to be_truthy }
end

Then("I open all the navigation screens and check network logo is present in it") do
  @home_screen = HomeScreen.new
  step "I go to 'Home' screen"
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
  step "I go to 'Shows' screen"
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
  step "I go to 'Live' screen"
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
  step "I go to 'Search' screen"
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
  step "I go to 'Settings' screen"
  @home_screen.wait_until(30) { expect(@home_screen.tlc_logo.displayed?).to be_truthy }
end

Then("I click on tlc logo") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.tlc_logo.displayed? }
  @home_screen.tlc_logo.click
end

Then("I see Metadata on the {string} tile containing thumbnail image, title") do |carousel_name|
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { expect(@home_screen.home_screen_carousels(carousel_name).size.positive?).to be_truthy }
  @home_screen.wait_until(30) { expect(@home_screen.home_screen_carousels(carousel_name).first.displayed?).to be_truthy }
  expect(@home_screen.home_screen_carousel_elements(carousel_name).first.name.empty?).not_to be_truthy
end

Then("I scroll forward horizontally in {string} carousel and verify it") do |carousel_name|
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_single_object(@home_screen.home_screen_carousel_elements(carousel_name)[0])
  before_scroll_show_text = @home_screen.home_screen_carousel_elements(carousel_name)[0].text
  @home_screen.homescreen_carousel_horizontal_forward_scroll(carousel_name, 5)
  after_scroll_show_text = @home_screen.home_screen_carousel_elements(carousel_name)[0].text
  @home_screen.wait_until(30) { expect(before_scroll_show_text != after_scroll_show_text).to be_truthy }
end

Then("I scroll backward horizontally in {string} carousel and verify it") do |carousel_name|
  @home_screen = HomeScreen.new
  @home_screen.scroll_to_single_object(@home_screen.home_screen_carousel_elements(carousel_name)[0])
  @home_screen.homescreen_carousel_horizontal_forward_scroll(carousel_name, 5)
  before_back_scroll_show_text = @home_screen.home_screen_carousel_elements(carousel_name)[2].text
  @home_screen.homescreen_carousel_horizontal_backward_scroll(carousel_name, 5)
  after_back_scroll_show_text = @home_screen.home_screen_carousel_elements(carousel_name)[2].text
  @home_screen.wait_until(30) { expect(before_back_scroll_show_text != after_back_scroll_show_text).to be_truthy }
end
