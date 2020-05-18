# frozen_string_literal: true

class VideoScreen < BaseScreen
  #  Video Controls
  def video_container
    driver.find_element(:id, "container_video_player")
  end

  def video_controls
    driver.find_element(:id, "video_controls")
  end

  def video_id
    driver.find_element(:id, "surface_view")
  end

  def loading_icon
    driver.find_elements(:id, "custom_progressbar").size
  end

  def learn_more
    driver.find_element(:id, "btn_more_from_this_advertiser")
  end

  def play_button
    driver.find_element(:id, "play")
  end

  def ad_title
    driver.find_elements(:id, "layout_ad_title_container").size
  end

  def ad_countdown
    ad_title.positive? ? driver.find_element(:id, "txt_ad_countdown").text : "0"
  end

  def video_current_time
    driver.find_element(:id, "current_time")
  end

  def seek_bar
    driver.find_element(:id, "seek_bar")
  end

  def end_time
    driver.find_element(:id, "end_time")
  end

  def volume
    driver.find_element(:id, "volume")
  end

  def captions
    driver.find_element(:id, "captions")
  end

  def live_video_icon
    driver.find_element(:id, "img_network_logo")
  end

  # Video Sharing and info
  def share_video
    driver.find_element(:id, "btn_video_share")
  end

  def video_info
    driver.find_element(:id, "btn_video_info")
  end

  def current_video_name
    driver.find_element(:id, "txt_video_name")
  end

  def video_back_btn
    driver.find_element(:id, "back_arrow_network_logo_layout")
  end

  def ad_continue_time
    driver.find_element(:id, "txt_ad_will_continue_in_label")
  end

  def ad_count
    driver.find_element(:id, "txt_ad_countdown")
  end

  def web_view
    driver.find_element(:id, "com.sec.android.app.sbrowser:id/sbrowser_tab_holder")
  end

  def video_till_ad_play
    loop do
      tap_by_coordinates(300, 150)
      next unless learn_more.size.positive?

      play_button.click
      break
    end
  end

  def red_key_err_mssg
    driver.find_element(:xpath, "//*[@text='Unauthorized']")
  end
end
