# frozen_string_literal: true

class ShowScreen < BaseScreen
  def hero_show_description
    driver.find_element(:xpath, "//*[@text = 'MORE' or @label = 'MORE']")
  end

  def episode_card
    driver.find_element(:accessibility_id, "list-more-episodes-portrait__0__cell-video")
  end

  def season_episode_card
    driver.find_element(:accessibility_id, "list-season-episodes__0__cell-video")
  end

  def episode_info
    driver.find_element(:xpath, "//*[@content-desc='button-info' or @name='button-info']")
  end

  def show_description
    driver.find_element(:xpath, "//*[@text = 'WATCH' or @label = 'WATCH']")
  end

  # iOS locators for episode_description method is in progress
  def episode_description
    driver.find_element(:accessibility_id, "episode-description")
  end

  def playing_show_text
    driver.find_element(:xpath, "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
  end

  def hero
    driver.find_element(:accessibility_id, "hero")
  end

  def shows_list
    driver.find_element(:accessibility_id, "shelf__1__unlocked-seasons")
  end

  def shows_list_authenticate
    driver.find_element(:accessibility_id, "home-authenticated-1__0__cell-show")
  end

  def epicode_art(index)
    driver.find_element(:xpath, "(//*[@content-desc='button-info'])[#{index}]/../..")
  end
end
