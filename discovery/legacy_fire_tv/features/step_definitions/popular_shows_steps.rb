And("I check the title of the popular show") do
  @home_screen = HomeScreen.new
  @title_before_caurosal = @home_screen.popular_show_title.text
  3.times { @home_screen.press_up }
  @home_screen.wait_until(30) { @home_screen.popular_title.displayed? }
end

And("I move the caurosal right") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.popular_logo_image.displayed? }
  10.times { @home_screen.press_right }
  @home_screen.press_select
  @title_after_caurosal = @home_screen.popular_show_title.text
end

Then("I verfy the title of the show") do
  @home_screen = HomeScreen.new
  expect(@title_before_caurosal == @title_after_caurosal).to be_falsey
end

And("I move the caurosal left") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(30) { @home_screen.popular_logo_image.displayed? }
  10.times { @home_screen.press_right }
  5.times { @home_screen.press_left }
  @home_screen.press_select
  @title_after_caurosal = @home_screen.popular_show_title.text
end

Then("I check for the title info watch later and favourate button") do
  @show_screen = ShowScreen.new
  @show_screen.wait_until(10) { @show_screen.info_btn.displayed? }
  expect(@show_screen.info_btn.displayed?).to be_truthy
  expect(@show_screen.favorite_btn.displayed?).to be_truthy
  expect(@show_screen.watch_later_btn.displayed?).to be_truthy
  expect(@show_screen.show_title.displayed?).to be_truthy
end

Given("I navigate to search option") do
  @search_screen = SearchScreen.new
  @search_screen.wait_until(60) { @search_screen.logo.displayed? }
  @search_screen.navigate_to_search
  @search_screen.press_down
end

When("I view and click the popular show in search screen") do
  @home_screen = HomeScreen.new
  @home_screen.wait_until(60) { @home_screen.popular_logo_image.displayed? }
  @home_screen.press_select
end

And("I check the title of the popular show in search screen") do
  @home_screen = HomeScreen.new
  @title_before_caurosal = @home_screen.popular_show_title.text
  3.times { @home_screen.press_up }
end
