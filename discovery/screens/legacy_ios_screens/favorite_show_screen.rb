class FavoriteShowScreen < BaseScreen
  def edit_button
    driver.find_element(:name, "EDIT")
  end

  def close_button
    driver.find_element(:name, "close button")
  end

  def select_show
    driver.find_element(:name, "--")
  end

  def empty_favorite_list
    driver.find_element(:name, "Shows you add to Favorites will appear here.")
  end

  def favorite_show_header
    driver.find_element(:name, "FAVORITE SHOWS")
  end

  def done_button
    driver.find_element(:name, "DONE")
  end

  def fav_show_title
    driver.find_element(:xpath, "//XCUIElementTypeCell/XCUIElementTypeStaticText")
  end
end
