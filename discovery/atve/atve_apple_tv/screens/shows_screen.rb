# frozen_string_literal: true

class ShowScreen < BaseScreen
  def shows_list
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def seasons_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[3]/XCUIElementTypeCell")
  end

  def seasons_name_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[3]//XCUIElementTypeStaticText")
  end

  def season_episode_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[4]//XCUIElementTypeCell")
  end

  def season_episode_name_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[4]//XCUIElementTypeImage//following::XCUIElementTypeStaticText[1]")
  end

  def episode_thumbnail_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[4]//XCUIElementTypeImage")
  end

  def episode_description_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[4]//XCUIElementTypeImage//following::XCUIElementTypeStaticText[2]")
  end

  def episode_duration_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[4]//XCUIElementTypeImage//following::XCUIElementTypeStaticText[3]")
  end

  def extra_clip_list
    driver.find_elements(:xpath, "//*[@name='Extra Clips']//..//following-sibling::XCUIElementTypeCell//XCUIElementTypeCell")
  end

  def network_selection_list
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell")
  end

  def tlc_all_shows
    driver.find_element(:name, "TLC - All Shows")
  end

  def tlc_shows_list
    driver.find_elements(:xpath, "//*[@name='TLC - All Shows']//..//following-sibling::XCUIElementTypeCell")
  end

  def tlc_shows_name
    driver.find_elements(:xpath, "//*[@name='TLC - All Shows']//..//following-sibling::XCUIElementTypeCell//..//XCUIElementTypeStaticText")
  end

  def tlc_network_image
    driver.find_elements(:xpath, "//*[@name='TLC - All Shows']//..//following-sibling::XCUIElementTypeCell//..//XCUIElementTypeImage")
  end

  def hero_show_carousel(text)
    driver.find_element(:xpath, " //XCUIElementTypeStaticText[@name='#{text}']")
  end
end
