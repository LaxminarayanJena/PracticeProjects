class HomeScreen < BaseScreen
  def hero
    driver.find_element(:id, "img_feature_bg")
  end

  def scroll_to_on_last_night
    driver.scroll_to("ON LAST NIGHT")
  end

  def on_last_night_desc
    driver.find_element(:xpath, "//*[@text = 'ON LAST NIGHT']")
  end

  def scroll_to_popular
    driver.scroll_to("POPULAR")
  end

  def popular_desc
    driver.find_element(:xpath, "//*[@text = 'POPULAR']")
  end

  def scroll_to_unlocked_episode
    driver.scroll_to("UNLOCKED EPISODES")
  end

  def unlocked_episode_desc
    driver.find_element(:xpath, "//*[@text = 'UNLOCKED EPISODES']")
  end

  def scroll_to_ahc_list
    driver.scroll_to("AHC LISTS")
  end

  def ahc_list_desc
    driver.find_element(:xpath, "//*[@text = 'AHC LISTS']")
  end

  def scroll_to_more_full_episode
    driver.scroll_to("MORE FULL EPISODES")
  end

  def hero_cta_btn
    driver.find_element(:id, "view_call_to_action")
  end

  def more_full_episode_desc
    driver.find_element(:xpath, "//*[@text = 'MORE FULL EPISODES']")
  end

  def unlocked_episodes_show_card
    driver.find_element(:xpath, "//*[@text = 'UNLOCKED EPISODES']//following-sibling
      ::androidx.recyclerview.widget.RecyclerView
      //android.widget.FrameLayout/android.widget.ImageView")
  end

  def ahc_lists_show_card
    driver.find_element(:xpath, "//*[@text = 'AHC LISTS']//following-sibling
      ::androidx.recyclerview.widget.RecyclerView
      //android.widget.FrameLayout/android.widget.ImageView")
  end

  def ahc_lists_show_title
    driver.find_element(:xpath, "//*[@text = 'AHC LISTS']//following-sibling
      ::androidx.recyclerview.widget.RecyclerView
      //android.widget.FrameLayout//android.widget.RelativeLayout/android.widget.TextView")
  end

  def show_screen_title
    driver.find_element(:id, "txt_curatedlist_name")
  end

  def app_browse_screen
    driver.find_element(:xpath, "//*[@text='BROWSE']")
  end

  def affiliate_logo
    driver.find_element(:id, "img_affiliate")
  end

  def search_icon
    driver.find_element(:id, "action_search")
  end

  def press_back
    driver.press_keycode(4)
  end

  # sibling xpath locator for network_logo in Header
  def network_logo
    driver.find_element(:xpath, "//*[@content-desc='Navigate up']//following::android.widget.ImageView[1]")
  end

  def lock_btn
    driver.find_element(:id, "btn_play_lock")
  end
end
