class SearchScreen < BaseScreen
  def search_text_field
    driver.find_element(:id, "searchToolbar")
  end

  def searched_episode
    driver.find_element(:id, "videoRecyclerView")
  end

  def no_result_found
    driver.find_element(:xpath, "//*[@text = 'No results found']")
  end

  def clear_text
    driver.find_element(:accessibility_id, "Clear text")
  end

  def search_help_text
    driver.find_element(:xpath, "//*[@text='Search for Shows, Episodes, and More']")
  end

  def search_show_details_title
    driver.find_element(:id, "showDetailsTitle")
  end

  def search_show_details_desc
    driver.find_element(:id, "showDetailsDescription")
  end

  def popular_shows
    driver.find_element(:xpath, "//*[@text = 'Popular Shows this week']")
  end

  def trending_now
    driver.find_element(:xpath, "//*[@text = 'Trending Now ']")
  end
end
