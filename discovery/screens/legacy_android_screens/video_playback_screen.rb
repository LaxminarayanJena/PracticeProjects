class VideoPalybackScreen < BaseScreen
  def get_coordinates(element)
    width = element.rect.width / 1.5
    height = element.rect.height / 1.5
    [width, height]
  end

  def video_player_info_close_button
    driver.find_element(:id, "btn_dismiss")
  end

  def video_info_episode_name
    @show_list = ShowScreen.new
    @video_name = @show_list.first_episode_title.text
    @show_list.watch_list_popup.click
    @video_name
  end

  def video_player_current_info
    @video = VideoScreen.new
    retry_proc = proc do
      co = get_coordinates(@video.video_container)
      Kernel.puts "============ clicking ------------"
      @video.tap_by_coordinates(co[0], co[1])
      @video.video_info.click
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 12, base_interval: 1, on_retry: retry_proc) do
      @video_name = @video.current_video_name.text
      video_player_info_close_button.click
    end
    @video_name
  end

  def watch_full_video(video_name)
    @video = VideoScreen.new
    loop do
      co = get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      Kernel.puts "tapped"
      if @video.loading_icon.positive?
        # sleep is to ignore load icon and let play the next video
        # rubocop:disable Custom/SleepCop.
        sleep(10)
        # rubocop:enable Custom/SleepCop.
      end
      @current_video_name = video_player_current_info
      Kernel.puts "currecnt video name is #{@current_video_name}"
      if video_name == @current_video_name
        redo
      else
        Kernel.puts "Video names are different #{video_name} and #{@current_video_name}"
        break
      end
    end
  end

  def tap_by_coordinates_eventplayback(x_coordinate, y_coordinate)
    Appium::TouchAction.new.tap(x: x_coordinate, y: y_coordinate, count: 1).perform
    # sleep is to tab the screen on a particular interval
    # rubocop:disable Custom/SleepCop.
    sleep(20)
    # rubocop:enable Custom/SleepCop.
  end
end
