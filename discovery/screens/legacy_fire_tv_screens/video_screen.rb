# frozen_string_literal: true

class VideoScreen < BaseScreen
  def unlocked_episode_elements
    driver.find_elements(:xpath, "//android.support.v7.widget.RecyclerView[@content-desc='Unlocked Episodes']//android.widget.ImageView[1]")
  end

  def video_container
    driver.find_element(:id, "container_video_player")
  end

  def video_current_time
    driver.find_element(:id, "current_time").text
  end

  def video_content
    driver.find_element(:id, "content")
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

  def play_button
    driver.find_element(:id, "play")
  end

  def ad_title
    driver.find_elements(:id, "layout_ad_title_container").size
  end

  def ad_countdown
    ad_title.positive? ? driver.find_element(:id, "txt_ad_countdown").text : "0"
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

  def continue_watching_txt
    driver.find_element(:id, "title_text")
  end

  def continue_show_name
    driver.find_element(:id, "continue_show_name")
  end

  def continue_title
    driver.find_element(:id, "continue_title")
  end

  def continue_description
    driver.find_element(:id, "continue_description")
  end

  def ad_count
    driver.find_elements(:id, "ad_counter").size
  end

  def watch_ad
    puts "add is playing" if @video_screen.ad_count.positive?
  end

  def watch_full_video(video_name)
    @video = VideoScreen.new
    loop do
      Kernel.puts "ad is playing" if ad_count.positive?
      @current_video_name = video_player_current_info
      # sleep is to allowing appium to process multiple requests
      # rubocop:disable Custom/SleepCop.
      sleep(30)
      # rubocop:enable Custom/SleepCop.
      Kernel.puts "current video name is #{@current_video_name}"
      if video_name == @current_video_name
        Kernel.puts "in if condition"
        redo
      else
        # sleep is to ignore load icon and let play the next video
        # rubocop:disable Custom/SleepCop.
        sleep(10)
        # rubocop:enable Custom/SleepCop.
        Kernel.puts "Video names are different #{video_name} and #{@current_video_name}"
        break
      end
    end
  end

  def video_player_current_info
    @video = VideoScreen.new
    retry_proc = proc do
      press_up
      Kernel.puts "============ clicking ------------"
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 12, base_interval: 1, on_retry: retry_proc) do
      @video_name = video_text.text
    end
    @video_name
  end

  def video_text
    driver.find_element(:id, "title")
  end
end
