# frozen_string_literal: true

class WatchLiveTvScreen < BaseScreen
  def navigate_to_live
    press_up
    press_right while menu_live.attribute("focused") == "false"
  end

  def activate_button
    driver.find_element(:id, "activate")
  end

  def activation_container
    driver.find_element(:id, "sign_in_container")
  end

  def live_tv_video_controls
    driver.find_element(:id, "video_controls")
  end

  def live_tv_show_name
    driver.find_element(:id, "show_name")
  end

  def upnext_text
    driver.find_element(:xpath, "//*[@text='Up Next']")
  end

  def upnext_show_name
    driver.find_element(:id, "next_show_name")
  end

  def upnext_show_time
    driver.find_element(:id, "next_time")
  end

  def live_tv_player_captions_checkbox
    driver.find_element(:id, "captions_checkbox")
  end

  def live_tv_player_captions_text
    driver.find_element(:id, "captions_text")
  end

  def live_tv_player_seek_bar
    driver.find_element(:id, "live_seek_bar")
  end

  def live_tv_next_show_name
    driver.find_element(:id, "live_next_show_name")
  end

  def live_tv_start_time
    driver.find_element(:id, "live_start_time")
  end

  def live_tv_next_show_time
    driver.find_element(:id, "live_next_time")
  end

  def live_tv_other_text
    driver.find_element(:id, "other_text")
  end

  def live_tv_current_show_name
    driver.find_element(:id, "current_show_name")
  end

  def live_tv_current_title
    driver.find_element(:id, "current_title")
  end

  def live_tv_current_description
    driver.find_element(:id, "current_description")
  end

  def live_tv_title
    driver.find_element(:id, "title")
  end

  def live_tv_description
    driver.find_element(:id, "description")
  end

  def et_lable
    driver.find_element(:xpath, "//*[@text ='ET']")
  end

  def live_label
    driver.find_element(:xpath, "//*[@text ='Live']")
  end

  def current_show_name
    driver.find_element(:id, "current_show_name")
  end

  def current_title
    driver.find_element(:id, "current_title")
  end

  def current_description
    driver.find_element(:id, "current_description")
  end
end
