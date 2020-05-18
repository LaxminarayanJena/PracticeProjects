# frozen_string_literal: true

class MyVideosScreen < BaseScreen
  def favorite_shows
    driver.find_elements(:id, "card_image")
  end

  def list_emtpy_msg
    driver.find_element(:xpath, "//*[@text = 'Your list is empty!']")
  end

  def episode_show_name
    # Show name displayed above episode/season info
    driver.find_element(:id, "title_text")
  end

  def my_videos
    driver.find_element(:id, "row_header")
  end

  def season_episode_num
    driver.find_element(:id, "subtitle_text")
  end

  def my_videos_image
    driver.find_element(:id, "card_image")
  end

  def auth_video
    # affiliate video locator
    driver.find_element(:xpath, "//android.widget.ImageView[1]")
  end

  def navigate_to_myvideos
    press_up
    press_right while menu_myvideos.attribute("focused") == "false"
    swait_until(10) { menu_myvideos.displayed? }
    press_down
  end
end
