# frozen_string_literal: true

class BrowseScreen < BaseScreen
  def navigate_to_browse
    press_up
    press_right while menu_browse.attribute("focused") == "false"
    wait_until(10) { menu_browse.displayed? }
  end

  def show_row_content
    driver.find_element(:id, "title_text")
  end

  def show_season
    driver.find_element(:id, "card_image")
  end

  def lock_btn
    driver.find_element(:id, "status_image")
  end

  def show_season_size
    driver.find_elements(:id, "card_image").size
  end

  def genre_title
    driver.find_element(:id, "genre_title")
  end

  def genre_logo
    driver.find_element(:id, "logo_image_frame")
  end
end
