# frozen_string_literal: true

class HomeScreen < BaseScreen
  def shows_section
    driver.find_element(:xpath, "(//XCUIElementTypeButton[@name='Shows'])[1]")
  end

  def home_hero
    driver.find_elements(:xpath, "//XCUIElementTypeCell")
  end

  def series_name
    driver.find_element(:xpath, "(//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1])[1]")
  end

  def series_description
    driver.find_element(:xpath, "(//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[2])[1]")
  end

  def focus_hero
    home_hero.first.attribute("focused")
  end

  def hero_after_rotation
    driver.find_element(:xpath, "(//XCUIElementTypeCell[1]//XCUIElementTypeStaticText[1])[1]")
  end
end
