class ShowListScreen < BaseScreen
  def a_z_button
    driver.find_element(:xpath, "//*[@text = 'A-Z']")
  end

  def most_recent_button
    driver.find_element(:xpath, "//*[@text = 'MOST RECENT']")
  end

  def shows_sorted_atoz
    driver.find_element(:id, "container_shows_atoz")
  end

  def first_list_item
    driver.find_elements(:id, "img_show_thumbnail").first
  end

  def fetch_show(show_index)
    driver.find_elements(id: "img_show_thumbnail", index: show_index)
  end

  def no_results_text
    driver.find_element(:id, "search_noresults_textview")
  end

  def season_dropdown
    driver.find_element(:id, "txt_dropdown_selected")
  end

  def lock_icon
    driver.find_elements(:id, "btn_play_lock")
  end

  def show_list
    driver.find_element(:id, "rv_shows")
  end

  def show_art
    driver.find_elements(:id, "layout_thumbnail")
  end

  def scroll_to_last_show_by_coordinates
    start_x_coordinate = driver.window_size.width - 50
    start_y_coordinate = driver.window_size.height - 500
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 1200
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def hero_show_info
    driver.find_element(:id, "txt_info")
  end
end
