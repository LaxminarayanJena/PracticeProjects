# frozen_string_literal: true

class BrowseScreen < BaseScreen
  def navigate_browse
    2.times { press_right }
    wait_until(30) { menu_browse.displayed? }
  end

  def menu_watch_live
    driver.find_element(:name, "Watch Live")
  end

  def genre_list
    driver.find_elements(:xpath, "//*[@name ='In vertical list']//XCUIElementTypeCell")
  end

  def genre_list_first
    driver.find_element(:name, "In vertical list")
  end

  def show_card_count
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell").size
  end

  def genre_card_list
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell")
  end

  def genre_card_list1
    driver.find_elements(:xpath, "//XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell")
  end
end
