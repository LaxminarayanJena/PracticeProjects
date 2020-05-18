# frozen_string_literal: true

class ShowScreen < BaseScreen
  def show_title
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView//*[@name='Shows']//following::XCUIElementTypeCell")
  end

  def show_inner_titles
    driver.find_elements(:xpath, "//XCUIElementTypeOther//XCUIElementTypeStaticText")
  end

  def show_played_outer_text
    driver.find_element(:xpath, "//*[contains(@name, 'Episodes')]//following::XCUIElementTypeCell[1]")
  end

  def show_played_inner
    driver.find_element(:name, "AVSubtitle").text
  end

  def show_played_inner_text
    show_played_inner[1...show_played_inner.length - 1]
  end

  def show_played_info_tab
    driver.find_element(:name, "Info")
  end

  def show_played_progress_bar
    driver.find_element(:xpath, "//*[contains(@name, '% complete')]")
  end

  def show_resume_playing_button
    driver.find_element(:name, "Resume Playing")
  end

  def navigate_to_shows
    press_right while menu_shows.attribute("focused") == "false"
    wait_until(10) { menu_shows.displayed? }
  end

  def more_season_inner_title
    driver.find_element(:xpath, "//XCUIElementTypeOther//XCUIElementTypeStaticText[1]")
  end

  def more_season_list
    driver.find_elements(:xpath, "//*[contains(@name, 'In vertical list')]//XCUIElementTypeCell")
  end

  def navigate_to_second_show
    press_right while show_title[2].attribute("focused") == "false"
    wait_until(30) { show_title[2].displayed? }
  end

  def favourites_button
    driver.find_element(:name, "Favorites")
  end

  def affiliate_icon
    driver.find_element(:xpath, "//*[contains(@name, 'Shows')]//XCUIElementTypeImage")
  end

  def favorites_show_list
    driver.find_elements(:xpath, "//*[contains(@name, 'Favorite Shows')]//following::XCUIElementTypeCell")
  end
end
