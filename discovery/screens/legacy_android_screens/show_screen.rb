# frozen_string_literal: true

class ShowScreen < BaseScreen
  def play_episode_button
    driver.find_element(:id, "btn_play_lock")
  end

  def video
    driver.find_element(:id, "surface_view")
  end

  def show_hero
    driver.find_element(:id, "txt_show_name")
  end

  def show_home_info
    driver.find_element(:id, "img_home_info_button")
  end

  def watch_later_add_remove_option
    driver.find_element(:id, "txt_watch_later")
  end

  def watch_list_popup
    driver.find_element(:id, "btn_close")
  end

  def watch_list_add_remove_desc
    driver.find_element(:id, "txt_episode_desc")
  end

  def mark_favorite_option
    driver.find_element(:id, "txt_favorite")
  end

  def show_info_button
    driver.find_element(:id, "img_home_info_button")
  end

  def info_layout
    driver.find_element(:id, "layout_episode_info")
  end

  def info_title
    driver.find_element(:id, "title")
  end

  def info_text
    driver.find_element(:id, "txt_episode_desc")
  end

  def first_episode_title
    driver.find_element(:id, "txt_episode_name")
  end

  def first_episode_season_number
    driver.find_element(:id, "txt_season_episode_numbers")
  end

  def play_episode_btn
    driver.find_element(:id, "txt_play_episode")
  end

  def show_season_text
    driver.find_element(:id, "txt_season_number")
  end

  def show_season_selector
    driver.find_element(:id, "txt_dropdown_selected")
  end

  def season_select_list
    driver.find_elements(:id, "txt_season_dropdown_number")
  end

  # Changes the season selected.
  def change_season
    current_season = show_season_selector.text
    show_season_selector.click
    current_index = season_select_list.index { |x| x.text.downcase == current_season.downcase }
    season_select_list[current_index + 1].click
  end

  def season_dropdown_list
    driver.find_element(class: "android.widget.ListView")
          .find_elements(class: "android.widget.RelativeLayout")[1]
  end

  def episode_count
    driver.find_elements(:id, "txt_season_episode_numbers")
  end

  def show_key_art
    driver.find_element(:id, "container_show_metadata")
  end

  def watch_more_shows_like_this_btn
    driver.find_element(:id, "btn_watch_more_shows")
  end

  def similar_shows
    driver.find_element(:xpath, "//*[@text = 'Similar Shows']")
  end

  def share_icon
    driver.find_element(:id, "txt_share")
  end

  def episode_art
    driver.find_elements(:id, "gradient")
  end

  def season_picker
    driver.find_element(:xpath, "//*[contains(@text,'SEASON')]")
  end

  def season_number
    driver.find_elements(:id, "txt_season_dropdown_number")
  end

  def scroll_to_last_episode_by_coordinates
    start_x_coordinate = driver.window_size.width - 50
    start_y_coordinate = driver.window_size.height - 500
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 400
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def play_icon
    driver.find_elements(:id, "btn_play_lock")
  end
end
