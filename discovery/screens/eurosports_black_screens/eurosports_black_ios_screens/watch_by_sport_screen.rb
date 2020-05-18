class EuroWatchBySportScreen < BaseScreen
  def popular_sports_category
    driver.find_element(:id, "Most popular sports")
  end

  def all_sports_category
    driver.find_element(:id, "All Sports")
  end

  def upcoming_carousel
    driver.find_element(:id, "UPCOMING")
  end

  def latest_videos_carousel
    driver.find_element(:id, "LATEST VIDEOS")
  end

  def one_of_the_popular_sports
    driver.find_element(:id, "Cycling")
  end

  def one_of_the_all_sports
    driver.find_element(:id, "Athletics")
  end
end
