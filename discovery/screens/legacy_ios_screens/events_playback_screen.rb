# frozen_string_literal: true

class EventsPlayBackScreen < BaseScreen
  def video_info_episode_name(element_index)
    @show_list = ShowScreen.new
    @video_name = @show_list.show_episode_title[element_index].text
    @show_list.watch_list_popup.click
    Kernel.puts "Video name is #{@video_name}"
  end

  def loading_icon
    driver.find_elements(:xpath, "//XCUIElementTypeActivityIndicator").size
  end

  def video_player_info_close_button
    driver.find_element(:id, "btn_dismiss")
  end

  def video_back_button
    driver.find_element(:id, "back button gray")
  end

  def video_player_current_info(element_index)
    @video = VideoScreen.new
    @show_video = ShowScreen.new
    retry_proc = proc do
      co = get_coordinates(@video.video_container)
      Kernel.puts "============ clicking ------------"
      @video.tap_by_coordinates(co[0], co[1])
    end
    Retriable.retriable(on: Selenium::WebDriver::Error::NoSuchElementError, tries: 12, base_interval: 1, on_retry: retry_proc) do
      co = get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      @video.video_info.click
      @current_video_name = @show_video.show_episode_title[element_index].text
    end
    @current_video_name
  end

  def get_coordinates(element)
    width = element.rect.width / 1.5
    height = element.rect.height / 1.5
    [width, height]
  end

  def watch_full_video(video_name_text)
    @video = VideoScreen.new
    loop do
      co = get_coordinates(@video.video_container)
      @video.tap_by_coordinates(co[0], co[1])
      Kernel.puts "tapped"
      @loading_icon = EventsPlayBackScreen.new
      if @loading_icon.loading_icon.positive?
        # sleep is to ignore load icon and let play the next video
        # rubocop:disable Custom/SleepCop.
        sleep(10)
        # rubocop:enable Custom/SleepCop.
      end
      @current_video_name = video_player_current_info(2)
      Kernel.puts "current video name is #{@current_video_name}"
      Kernel.puts "previous video name is #{video_name_text}"
      if video_name_text == @current_video_name
        redo
      else
        Kernel.puts "Video names are different #{video_name_text} and #{@current_video_name}"
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
