# frozen_string_literal: true

class HomeScreen < BaseScreen
  def navigate_to_featured
    press_up
    press_right while menu_featured.attribute("focused") == "false"
  end

  def featured_show
    driver.find_element(:id, "featuredCard_wrapper")
  end

  def show_season_episode_text
    driver.find_element(:id, "season_episode_text")
  end

  def onlastnight_carousel_title
    driver.find_element(:xpath, "//*[@content-desc='ON LAST NIGHT']")
  end

  def video_card_wrapper
    driver.find_element(:id, "videoCard_wrapper")
  end

  def watch_tv_icon
    driver.find_element(:id, "tv_icon")
  end

  def watch_tv_text
    driver.find_element(:id, "watch_text")
  end

  def watch_tv_video_image_icon
    driver.find_element(:id, "video_image_icon_relative_layout")
  end

  def popular_title
    driver.find_element(:xpath, "//*[@content-desc='Popular']")
  end

  def popular_logo_image
    driver.find_element(:id, "logo_image")
  end

  def unlocked_episodes_desc
    driver.find_element(:xpath, "//*[@content-desc='Unlocked Episodes']")
  end

  def go_lists_desc
    driver.find_element(:xpath, "//*[@content-desc='Discovery GO Lists']")
  end

  def carousel(text)
    driver.find_elements(:xpath, "//*[@content-desc='#{text}']/..//child::android.widget.TextView")
  end

  def scrubber
    driver.find_element(:id, "scrubber_thumb")
  end

  def app_cancel_option
    driver.find_element(:xpath, "//*[@text='Cancel']")
  end

  def app_exit_option
    driver.find_element(:xpath, "//*[@text='Exit']")
  end

  def app_exit_message
    driver.find_element(:xpath, "//*[@text='Are you sure that you want to leave Discovery GO?']")
  end

  def popular_show_title
    driver.find_element(:id, "title_text")
  end
end
