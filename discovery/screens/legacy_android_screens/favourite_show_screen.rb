class FavoriteShowScreen < BaseScreen
  def favorite_show_list
    driver.find_element(:id, "layout_row_container")
  end

  def favorite_list_edit_btn
    driver.find_element(:id, "txt_video_description")
  end

  def favorite_show_img_thumbnail
    driver.find_element(:id, "img_video_thumbnail")
  end

  def favorite_show_search_icon
    driver.find_element(:id, "Search")
  end

  def favorite_empty_list
    driver.find_element(:id, "txt_empty_list_favorites")
  end

  def add_episode_favorite
    driver.find_element(:id, "txt_empty_add_label_favorites")
  end
end
