class HomeScreen < BaseScreen
  def home_hero
    driver.find_element(:id, "heroViewPager")
  end

  def scroll_to_just_added_shows
    driver.scroll_to("Just Added Shows")
  end

  def scroll_to_shows
    driver.scroll_to("Shows")
  end

  def scroll_to_most_popular_shows
    driver.scroll_to("Most Popular Shows")
  end

  def scroll_to_most_popular_episodes_this_month
    driver.scroll_to("Most popular Episodes this month")
  end

  def scroll_to_continue_watching
    driver.scroll_to("Continue Watching")
  end

  def shows_header_desc
    driver.find_element(:xpath, "//*[@text = 'Shows']")
  end

  def just_added_header_desc
    driver.find_element(:xpath, "//*[@text = 'Just Added Shows']")
  end

  def most_popular_episodes_this_month_header_desc
    driver.find_element(:xpath, "//*[@text = 'Most popular Episodes this month']")
  end

  def most_popular_shows_header_desc
    driver.find_element(:xpath, "//*[@text = 'Most Popular Shows']")
  end

  def continue_watching_header_desc
    driver.find_element(:xpath, "//*[@text = 'Continue Watching']")
  end

  def just_added_tiles(index)
    driver.find_element(:xpath, "//*[@text = 'Just Added Shows']/../*[2]/*[#{index}]")
  end

  def rail_header_name(header_name)
    driver.find_element(:xpath, "//*[@text = '#{header_name}']")
  end

  def carousel_tile_name(carousel)
    driver.find_element(:xpath, "//*[@text = '#{carousel}']/../*[2]/*[1]/*[1]/*[2]")
  end

  def network_logo
    driver.find_element(:id, "logo")
  end
end
