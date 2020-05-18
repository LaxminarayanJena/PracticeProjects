class LiveScreen < BaseScreen
  def series_episode_count
    driver.find_element(:id, "overline")
  end

  def episode_title
    driver.find_element(:id, "headline")
  end

  def video_discription
    driver.find_element(:id, "expandable_tv")
  end

  def series_title
    driver.find_element(:id, "videoOverline")
  end

  def episode_name_detail_view_src
    driver.find_element(:id, "videoTitle")
  end

  def next_up_on_tlc
    driver.find_element(:xpath, "//*[@text = 'Next Up on TLC']")
  end

  def scheduled_start
    driver.find_element(:id, "scheduledStart")
  end

  def nxt_video_thumbnail
    driver.find_element(:id, "image")
  end

  def nxt_show_name
    driver.find_element(:id, "headline")
  end

  def episode_number
    driver.find_element(:id, "underline")
  end
end
