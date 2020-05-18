# frozen_string_literal: true

class ShowScreen < BaseScreen
  def show_title
    driver.find_element(:id, "title_text")
  end

  def info_btn
    driver.find_element(:id, "info_button")
  end

  def favorite_btn
    driver.find_element(:id, "favorite_button")
  end

  def watch_later_btn
    driver.find_element(:id, "watch_later_button")
  end

  def play_video
    driver.find_elements(:id, "videoCard_wrapper")
  end

  def video_page
    driver.find_element(:id, "video_frame")
  end

  def continue_btn
    driver.find_element(:id, "continue_button")
  end

  def start_over_btn
    driver.find_element(:id, "start_over_button")
  end

  def continue_show_title
    driver.find_element(:id, "continue_show_name")
  end

  def navigate_to_shows
    press_up
    press_right while menu_shows.attribute("focused") == "false"
    wait_until(10) { menu_shows.displayed? }
  end

  def search_no_result
    driver.find_element(:xpath, "//*[@text='No Results Found']")
  end

  def continue_watching_title
    driver.find_element(:xpath, "//*[@text='CONTINUE WATCHING']")
  end

  def season_episode_text
    driver.find_element(:id, "season_episode_text")
  end

  def sesson_eposide_text
    driver.find_element(:id, "season_episode_text")
  end

  def episode_description_text
    driver.find_element(:id, "episode_description_text")
  end

  def row_content_text
    driver.find_element(:id, "row_content")
  end

  def duration_number_text
    driver.find_element(:id, "duration_number_text")
  end

  def status_image_btn
    driver.find_element(:id, "status_image")
  end

  def duration_text
    driver.find_element(:id, "duration_number_text")
  end

  def play_button
    driver.find_element(:id, "play")
  end

  def progress_bar
    driver.find_element(:id, "progress")
  end

  def subtitle_text
    driver.find_element(:id, "subtitle_text")
  end

  def episode_title
    driver.find_element(:xpath, "//android.widget.RelativeLayout/android.widget.TextView[2]").text
  end
end
