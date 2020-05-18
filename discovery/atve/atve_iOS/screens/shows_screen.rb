class ShowScreen < BaseScreen
  def shows_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[2]/XCUIElementTypeCell")
  end

  def first_show_homescreen
    driver.find_element(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
  end

  def list_of_all_seasons
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView//XCUIElementTypeCollectionView//XCUIElementTypeStaticText")
  end

  def season_episode_info
    driver.find_elements(:xpath, "//XCUIElementTypeImage/../XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
  end

  def extra_clips_rail
    driver.find_elements(:xpath, "//*[@name='Extra Clips']//..//following-sibling::XCUIElementTypeCell//XCUIElementTypeCell")
  end

  def extra_clip_showname
    driver.find_elements(:xpath, "//*[@name='Extra Clips']//..//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText")
  end

  def extra_clip_showname_videoscreen
    driver.find_element(:xpath, "//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[2]")
  end

  def first_episode_more_less_button(text)
    driver.find_element(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]//XCUIElementTypeButton[@name='#{text}']")
  end

  def first_episode_description
    driver.find_elements(:xpath, "//XCUIElementTypeCell[3]//XCUIElementTypeOther/XCUIElementTypeStaticText")
  end

  def show_hero_image
    driver.find_elements(:xpath, "//XCUIElementTypeImage[1]")
  end

  def show_hero_network_logo_image
    driver.find_elements(:xpath, "//XCUIElementTypeImage[2]")
  end

  def show_hero_title_description
    driver.find_elements(:xpath, "//XCUIElementTypeStaticText")
  end

  def episode_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[1]/XCUIElementTypeCell[3]")
  end

  def episode_metadata_info
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[1]/XCUIElementTypeCell[3]//XCUIElementTypeStaticText")
  end

  def episode_image
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[1]/XCUIElementTypeCell[3]//XCUIElementTypeImage")
  end
end
