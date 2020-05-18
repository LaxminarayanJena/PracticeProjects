class ShowScreen < BaseScreen
  def show_banner(show_name)
    driver.find_element(:id, show_name.to_s)
  end

  def favorite_button
    driver.find_element(:name, "heart")
  end

  def favorite_added_confirmation
    driver.find_element(:name, "Show added to Favorites")
  end

  def show_home_info
    driver.find_elements(:name, "info thin gray")
  end

  def show_first_tile
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def show_info
    driver.find_element(:name, "info white")
  end

  def watch_later_add_remove_option
    driver.find_element(:name, "Watch Later")
  end

  def watch_list_popup
    driver.find_element(:name, "X")
  end

  def watch_list_back_btn
    driver.find_element(:name, "back button")
  end

  def close_btn
    driver.find_element(:name, "close button")
  end

  def play_episode_button
    driver.find_element(:name, "episode play button blue")
  end

  def lock_key_episode_button
    driver.find_element(:name, "episode key button blue")
  end

  def play_episode
    driver.find_element(:name, "Play Episode")
  end

  def season_dropdown_menu
    driver.find_element(:xpath, "//XCUIElementTypeButton[contains(@name,'SEASON')]")
  end

  def select_season
    driver.find_element(:xpath, "//XCUIElementTypeCell[2]")
  end

  def episode_tile
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def close_x_mark
    driver.find_element(:name, "X")
  end

  def affiliate_logo_img_on_shows
    driver.find_element(:xpath, "//XCUIElementTypeButton[@name='search icon']//following-sibling::XCUIElementTypeButton")
  end

  def episode_key_button
    driver.find_elements(:name, "episode key button blue")
  end

  def signin_to_unlock_title
    driver.find_element(:name, "SIGN IN TO UNLOCK ALL SHOWS")
  end

  def first_episode_title
    driver.find_element(:id, "txt_episode_name")
  end

  def show_episode_title
    driver.find_elements(:xpath, "//XCUIElementTypeStaticText")
  end
end
