# frozen_string_literal: true

class ShowDetailScreen < BaseScreen
  def shows_hero_button(text)
    driver.find_element(:xpath, " //XCUIElementTypeButton[@name='#{text}']")
  end

  def hero_network_logo
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeImage[2]")
  end
end
