# frozen_string_literal: true

class HomeScreen < BaseScreen
  def hero
    driver.find_element(:xpath, "//*[@content-desc='hero' or @name='hero']")
  end

  def hero_play
    driver.find_element(:xpath, "//*[@content-desc='hero__button-action' or @name='hero__button-action']")
  end

  def unlocked_episode
    driver.find_element(:xpath, "//*[@content-desc='home-0__0__cell-video' or @name='home-0__0__cell-video']")
  end

  def unlocked_season
    driver.find_element(:xpath, "//*[@content-desc='home-2__0__cell-show' or @name='home-2__0__cell-show']")
  end

  # iOS locators are in progress for main_home_button, home_search_icon & home_settings_icon
  def main_home_button
    driver.find_element(:accessibility_id, "main-nav__home")
  end

  def home_search_icon
    driver.find_element(:xpath, "//android.view.ViewGroup[@content-desc='main-nav__home']/../../android.view.ViewGroup[2]")
  end

  def unlocked_episodes_header_desc
    driver.find_element(:xpath, "//*[@text = 'UNLOCKED EPISODES' or @label = 'UNLOCKED EPISODES']")
  end

  def unlocked_episodes_show_card(index)
    driver.find_element(:xpath, "//*[@content-desc='home-1__#{index}__cell-video' or @name='home-1__#{index}__cell-video']")
  end

  def unlocked_episodes_list
    driver.find_element(:xpath, "//*[@content-desc='shelf__0__unlocked-episodes' or @name='shelf__0__unlocked-episodes']")
  end

  def show_info_button
    driver.find_element(:xpath, "//*[@content-desc='button-info' or @name='button-info']")
  end

  def live_header_desc
    driver.find_element(:xpath, "//*[contains(@text, 'LIVE ON') or contains(@label, 'LIVE ON')]")
  end

  def live_video
    driver.find_element(:xpath, "//*[contains(@content-desc,'livestream-module') or contains(@name,'livestream-module')]")
  end

  def affiliate_search_screen
    driver.find_element(:xpath, "//*[@text = 'SELECT YOUR TV PROVIDER' or @label = 'SELECT YOUR TV PROVIDER']")
  end

  def scroll_to_live
    driver.scroll_to("LIVE ON")
  end

  def scroll_to_live_on_id
    driver.scroll_to("LIVE ET")
  end

  def scroll_to_recommended
    driver.scroll_to("RECOMMENDED FOR YOU")
  end

  def scroll_to_idgolists
    driver.scroll_to("ID GO LISTS")
  end

  def recommended_header_desc
    driver.find_element(:xpath, "//*[@text = 'RECOMMENDED FOR YOU' or @label = 'RECOMMENDED FOR YOU']")
  end

  def recent_episodes_header_desc
    driver.find_element(:xpath, "//*[@text = 'RECENT EPISODES' or @label = 'RECENT EPISODES']")
  end

  def scroll_to_recent
    driver.scroll_to("RECENT EPISODES")
  end

  def recent_episodes_info_option
    driver.find_element(:xpath, "//*[@content-desc='button-info' or @name='button-info']")
  end

  def recent_episode_info_text
    driver.find_element(:xpath, "//*[@text = 'WATCH' or @label = 'WATCH']")
  end

  def recent_episodes_play_button
    driver.find_element(:xpath, "//*[@content-desc='home-authenticated-2__0__cell-video' or @name='home-authenticated-2__0__cell-video']")
  end

  # iOS locators for hero_video_player method is in progress
  def hero_video_player
    driver.find_element(:accessibility_id, "player")
  end

  def hero_text
    driver.find_element(:xpath, '//android.view.ViewGroup[@content-desc="hero"]/android.widget.TextView[1]')
  end

  def affiliate_logo
    driver.find_element(:accessibility_id, "affiliate-logo")
  end

  def veriy_provider
    driver.find_element(:xpath, "//*[@text = 'Verify your TV provider to access even more videos']")
  end

  def curated_tile
    driver.find_element(:accessibility_id, "home-4__0__cell-curated-list")
  end

  def curated_tile_authenticate
    driver.find_element(:accessibility_id, "home-authenticated-5__0__cell-curated-list")
  end

  # Since element locators are not present therefore used xpath with index
  def mvpd_provider
    driver.find_element(:xpath, "(//android.view.ViewGroup)[26]")
  end

  # Since element locators are not present therefore i have used xpath
  def all_providers
    driver.find_element(:xpath, "//android.widget.ScrollView")
  end

  def series_title
    driver.find_element(:xpath, "//*[@content-desc='video-title' or @name='video-title']")
  end

  def scroll_to_up_next
    driver.scroll_to("UP NEXT")
  end

  def up_next_episodes_play_button
    driver.find_element(:accessibility_id, "list-more-episodes-portrait__1__cell-video")
  end
end
