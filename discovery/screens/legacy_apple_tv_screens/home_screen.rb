# frozen_string_literal: true

class HomeScreen < BaseScreen
  def navigate_to_featured
    press_right while menu_featured.attribute("focused") == "false"
  end

  def featured_show
    driver.find_element(:xpath, "(//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2])[2]")
  end

  def featured_show_season
    driver.find_element(:xpath, "//XCUIElementTypeStaticText")
  end

  def just_added_title
    driver.find_element(:name, "Just Added")
  end

  def just_added_video
    driver.find_element(:xpath, "//*[@name='Just Added']//following::XCUIElementTypeCell[2]")
  end

  def popular_shows_title
    driver.find_element(:name, "Popular Shows")
  end

  def popular_shows_video
    driver.find_element(:xpath, "//*[@name='Popular Shows']//following::XCUIElementTypeCell[2]")
  end

  def play_latest_button
    driver.find_element(:name, "Play Latest")
  end

  def play_more_seasons_button
    driver.find_element(:name, "More Seasons")
  end

  def check_play_more_seasons_button
    driver.find_elements(:name, "More Seasons").size
  end

  def play_favourites_button
    driver.find_element(:name, "Favorites")
  end

  def start_from_beginning_button
    driver.find_element(:name, "Start from Beginning")
  end

  def check_start_from_beginning_button
    driver.find_elements(:name, "Start from Beginning").size
  end

  def time_scrubbing
    driver.find_element(:xpath, "//*[@name='Media Controls']//XCUIElementTypeOther[@name='AXElapsedTime']")
  end

  def time_scrubbing_value
    time_scrubbing.text
  end

  def stream_free_title
    driver.find_element(:name, "Stream Free Episodes")
  end

  def stream_free_video
    driver.find_element(:xpath, "//*[@name='Stream Free Episodes']//following::XCUIElementTypeCell[2]")
  end

  def classic_series_title
    driver.find_element(:name, "Classic Series for Free")
  end

  def classic_series_video
    driver.find_element(:xpath, "//*[@name='Classic Series for Free']//following::XCUIElementTypeCell[2]")
  end

  def carousel_title(options)
    case options
    when "Featured carousel"
      driver.find_element(:xpath, "(//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2])[2]")
    when "Just Added"
      driver.find_element(:xpath, "//*[@name='Just Added']//following::XCUIElementTypeCell[1]")
    when "Popular Shows"
      driver.find_element(:xpath, "//*[@name='Popular Shows']//following::XCUIElementTypeCell[1]")
    when "Stream Free Episodes"
      driver.find_element(:xpath, "//*[@name='Stream Free Episodes']//following::XCUIElementTypeCell[1]")
    when "Classic Series for Free"
      driver.find_element(:xpath, "//*[@name='Classic Series for Free']//following::XCUIElementTypeCell[1]")
    else
      "No Matching carousel found, please enter valid carousel name"
    end
  end

  def focus_featured_header
    menu_featured.attribute("focused")
  end

  def featured_show_rotation
    driver.find_element(:xpath, "(//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2])[2]")
  end

  def navigate_to_featured_menu
    press_up
    press_left while menu_featured.attribute("focused") == "false"
  end
end
