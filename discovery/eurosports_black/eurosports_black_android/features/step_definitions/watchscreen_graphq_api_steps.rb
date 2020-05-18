Then("I scroll {string} and compare video titles on {string} on {string} tab carousel with graphql API") do |scroll, graphquery, tab|
  @watch_screen = EuroWatchScreen.new
  @graphql_methods = GraphqlMethods.new
  @uidata = []
  case scroll
  when "HORIZONTAL"
    @watch_screen.wait_until(30) { expect(@watch_screen.most_popular_video_title.first.displayed?) }
    expect(@watch_screen.most_popular_video_title.first.text.empty?).not_to be_truthy
    loop do
      @titles = @watch_screen.collect_video_titles
      @titles.each do |title|
        @uidata << title unless @uidata.include? title
      end
      @watch_screen.scroll_horizontal_by_carousel
      if tab == "HOME"
        break unless @watch_screen.home_tab.selected?
      else
        break unless @watch_screen.latest_videos_tab.selected?
      end
    end
  when "VERTICAL"
    scroll_count = 0
    loop do
      @titles = @watch_screen.collect_video_titles
      @titles.each do |title|
        @uidata << title unless @uidata.include? title
      end
      @watch_screen.scroll_down
      scroll_count += 1
      next unless scroll_count == 15

      @after_scroll = @watch_screen.collect_video_titles
      break if @after_scroll[0] == @titles[0]

      scroll_count = 0
    end
  end

  @response = @graphql_methods.api_request(graphquery, @uidata)
  expect(@response.first).to eq(@uidata.size)
end
