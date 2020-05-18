# frozen_string_literal: true

class BrowseScreen < BaseScreen
  def genre_list
    driver.find_elements(:xpath, "//XCUIElementTypeTable/XCUIElementTypeCell")
  end

  def genre_text
    driver.find_elements(:xpath, "//XCUIElementTypeCell//XCUIElementTypeStaticText")
  end

  def genre_icons
    driver.find_elements(:xpath, "//XCUIElementTypeCell//XCUIElementTypeImage[2]")
  end

  def genre_navigation_bar
    driver.find_element(:xpath, "//XCUIElementTypeNavigationBar//XCUIElementTypeStaticText")
  end

  def browse_title
    driver.find_element(:name, "BROWSE")
  end

  def affiliate_logo_browse_screen
    driver.find_elements(:xpath, "//XCUIElementTypeNavigationBar//XCUIElementTypeButton")
  end
end
