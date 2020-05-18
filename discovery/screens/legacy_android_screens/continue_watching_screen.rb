# frozen_string_literal: true

class ContinueWatchingScreen < BaseScreen
  def layout_rows
    driver.find_elements(:id, "layout_row_container")
  end

  def video_thumbnail
    driver.find_elements(:id, "img_video_thumbnail")
  end
end
