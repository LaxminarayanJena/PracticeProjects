# frozen_string_literal: true

class HomeScreen < BaseScreen
  def home_hero
    driver.find_elements(:id, "imageHeroBanner")
  end

  def hero_shows_count
    driver.find_elements(:xpath, "//android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab")
  end

  def hero_title
    driver.find_element(:id, "textHeroTitle")
  end

  def hero_detail
    driver.find_element(:id, "textHeroDetail")
  end

  def hero_description
    driver.find_element(:id, "textHeroDescription")
  end

  def btn_hero_action
    driver.find_element(:id, "btnHeroAction")
  end

  def just_added_rail
    driver.find_element(:xpath, "//*[@text = 'Just Added Shows']")
  end

  def most_popular_shows_rail
    driver.find_element(:xpath, "//*[@text = 'Most Popular Shows']")
  end

  def most_popular_episodes_rail
    driver.find_element(:xpath, "//*[@text = 'Most popular Episodes this month']")
  end

  def search_rail_by_name(text)
    press_right
    press_down until rail_header.attribute("text") == text
  end

  def rail_header
    driver.find_element(:id, "row_header")
  end

  def rail_row_content(string)
    driver.find_elements(:xpath, "//android.view.View[@content-desc='" + string + "']/android.widget.FrameLayout")
  end
end
