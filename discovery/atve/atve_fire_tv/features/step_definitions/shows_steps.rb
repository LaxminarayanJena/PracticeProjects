Given("I am on the Shows screen") do
  step "I am on the Menu Bar"
  step "I navigate to 'Shows' screen"
end

When("I go to {string} rail") do |option_rail|
  @shows_screen = ShowScreen.new
  @base_screen = BaseScreen.new
  case option_rail
  when "TLC - All Shows"
    expect(@shows_screen.shows_header.displayed?).to be_truthy
  when "Shows"
    @base_screen.press_down
    expect(@shows_screen.shows_header.displayed?).to be_truthy
  when "Editor's Pick"
    step "I see the details of shows hero content"
    3.times { @base_screen.press_down }
    expect(@shows_screen.shows_header.displayed?).to be_truthy
  end
end

Then("I do {string} scroll in {string} and verify functionality") do |direction, carousel_name|
  @shows_screen = ShowScreen.new
  8.times { @shows_screen.press_right } if direction.eql?("left")
  @before_scroll_carousel_text = @shows_screen.show_title_list(carousel_name).first.text
  if direction.eql?("right")
    5.times { @shows_screen.press_right }
  else
    6.times { @shows_screen.press_left }
  end
  @after_scroll_carousel_text = @shows_screen.show_title_list(carousel_name).first.text
  expect(@before_scroll_carousel_text == @after_scroll_carousel_text).to be false
end

Then("I see Metadata on the {string} tile containing thumbnail image, title") do |carousel_name|
  @shows_screen = ShowScreen.new
  expect(@shows_screen.show_title_list(carousel_name).first.displayed?).to be_truthy
  expect(@shows_screen.show_title_list(carousel_name).size == @shows_screen.showimage_list(carousel_name).size).to be_truthy
  @show_name_list = @shows_screen.show_title_list(carousel_name)
  @show_name_list.each do |showname|
    puts showname.text
    expect(showname.text.empty?).not_to be_truthy
  end
end

When("I click on show title of {string} shows") do |option|
  @shows_screen = ShowScreen.new
  case option
  when "TLC - All Shows"
    step "I go to 'TLC - All Shows' rail"
    if @shows_screen.show_title.size.positive?
      expect(@shows_screen.show_title.first.displayed?).to be_truthy
      @before_show_title = @shows_screen.show_title.first.text
      @shows_screen.show_title.first.click
      puts @before_show_title
    else
      puts "No titles present in 'TLC - All Shows'"
    end
  when "Shows"
    step "I go to 'Shows' rail"
    if @shows_screen.show_title.size.positive?
      expect(@shows_screen.show_title.first.displayed?).to be_truthy
      @before_show_title = @shows_screen.show_title.first.text
      @shows_screen.show_title.first.click
      puts @before_show_title
    else
      puts "No titles present in 'Shows'"
    end
  end
end

Then("I see the details of shows hero content") do
  @shows_screen = ShowScreen.new
  expect(@shows_screen.show_details_title.displayed?).to be_truthy
  expect(@shows_screen.shows_gist.displayed?).to be_truthy
  expect(@shows_screen.shows_description.displayed?).to be_truthy
  expect(@shows_screen.start_show_button.displayed?).to be_truthy
  expect(@shows_screen.add_show_button.displayed?).to be_truthy
  @after_show_title = @shows_screen.show_details_title.text
  @before_show_title.eql?(@after_show_title)
  puts @after_show_title
end
