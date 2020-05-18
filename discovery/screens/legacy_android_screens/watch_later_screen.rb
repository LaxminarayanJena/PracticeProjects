# frozen_string_literal: true

#:nodoc: all
class WatchLaterScreen < BaseScreen
  def watch_list
    driver.find_element(:id, "rv_videos")
  end

  def watch_later_empty_list
    driver.find_element(:id, "txt_empty_list")
  end

  def watch_later_icon
    driver.find_element(:id, "chk_watchlist_add_remove")
  end

  def watch_later_success_message
    driver.find_element(:xpath, "//*[@text = 'Added To Watch Later']")
  end

  def watch_later_removal_message
    driver.find_element(:xpath, "//*[@text = 'Removed From Watch Later']")
  end

  def watch_later_icon_status
    watch_later_icon.attribute("checked")
  end

  def add_episode_watch_later
    driver.find_element(:id, "txt_empty_add_label")
  end

  def watch_later_play_button
    driver.find_element(:id, "btn_play_lock")
  end

  def watch_later_search_text
    driver.find_element(:id, "search_src_text")
  end

  def learn_more
    driver.find_elements(:id, "btn_more_from_this_advertiser").size
  end

  def video_play_till_ad
    loop do
      @video = VideoScreen.new
      @video_playback = VideoPalybackScreen.new
      co = @video_playback.get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      Kernel.puts "tapped"

      if @video.ad_title.positive? && learn_more.positive?
        @video.tap_by_coordinates(co[0], co[1])
        Kernel.puts "ad is playing"
        break
      else
        puts "video is playing"
        @video.tap_by_coordinates(co[0], co[1])
      end
    end
  end

  def tap_on_play_button
    @video = VideoScreen.new
    @video_playback = VideoPalybackScreen.new
    co = @video_playback.get_coordinates(@video.video_container)
    @video.tap_by_coordinates(co[0], co[1])
    retry_proc = proc do
      Kernel.puts "============ clicking ------------"
      @video.tap_by_coordinates(co[0], co[1])
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 12, base_interval: 1, on_retry: retry_proc) do
      @video.play_button.click
      puts "button is clicked"
    end
  end
end
