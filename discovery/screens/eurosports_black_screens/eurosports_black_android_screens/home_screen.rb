class EuroHomeScreen < BaseScreen
  def home_option
    driver.find_element(:id, "navigation_home")
  end

  def watch_option
    driver.find_element(:id, "navigation_watch")
  end

  def results_option
    driver.find_element(:id, "navigation_results")
  end

  def sports_option
    driver.find_element(:id, "navigation_sports")
  end

  def original_series_sport
    driver.find_elements(:id, "originalSeriesTag")
  end

  def original_series_title
    driver.find_elements(:id, "originalSeriesTitle")
  end

  def original_series_videos
    driver.find_elements(:id, "originalSeriesDescription")
  end
end
