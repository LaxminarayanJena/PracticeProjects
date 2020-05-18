# frozen_string_literal: true

class LandingScreen < BaseScreen
  def show_logo
    driver.find_element(:id, "img_show_logo")
  end

  def comcast_user
    driver.find_element(:id, "user")
  end

  def comcast_pass
    driver.find_element(:id, "passwd")
  end

  def search_providers_results
    driver.find_element(:id, "txt_affiliate_name")
  end

  def continue_watching_icon
    driver.find_element(:xpath, "//*[@text = 'Continue Watching']")
  end

  def network_slider
    driver.find_element(:id, "vsl_network_slider")
  end

  def signin_button
    driver.find_element(:xpath, "//*[@text = 'SIGN IN']")
  end

  def select_provider
    driver.find_element(:id, "txt_affiliate_name")
  end

  def scroll_to_unlocked_episode
    driver.scroll_to("UNLOCKED EPISODES")
  end

  def info_button
    driver.find_element(:id, "img_home_info_button")
  end

  def recent_episodes_play_button
    driver.find_element(:id, "btn_play")
  end

  def recent_video_title
    driver.find_element(:id, "txt_video_name")
  end

  def recent_infopage_video_title
    driver.find_element(:id, "txt_show_name")
  end

  def video_episodeinfo
    driver.find_element(:id, "txt_season_episode_numbers")
  end

  def forgot_password_text
    driver.find_element(:id, "tv_sign_in_forgot_password")
  end

  def dont_see_provider_text
    driver.find_element(:id, "tv_sign_in_select_tv_provider_missing_link")
  end

  def tv_provider_header
    driver.find_element(:xpath, "//*[@text='TV Provider Request']")
  end

  def faq_text
    driver.find_element(:id, "tv_sign_in_faq")
  end

  def support_home_header
    driver.find_element(:xpath, "//*[@text='Support Home Page']")
  end

  def browse_page_header
    driver.find_element(:xpath, "//*[@text='BROWSE']")
  end

  def hero_episode_title
    driver.find_element(:id, "txt_tune_in")
  end

  def hero_episode_play
    driver.find_element(:id, "layout_play_lock_buttons")
  end

  def continue_watching_header
    driver.find_element(:id, "txt_continue_watching_header")
  end

  def search_results
    driver.find_element(:id, "search_results_text_layout")
  end

  def search_close_button
    driver.find_element(:id, "search_close_btn")
  end

  def search_text
    driver.find_element(:xpath, "//*[@text = 'Search']")
  end

  def affiliate_search_providers
    driver.find_elements(:id, "MVPDEditText")
  end
end
