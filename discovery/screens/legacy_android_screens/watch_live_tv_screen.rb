# frozen_string_literal: true

#:nodoc: all
class WatchLiveTvScreen < BaseScreen
  def main_menu_hamburger
    driver.find_element(:accessibility_id, "Navigate up")
  end

  def sign_into_unlock
    driver.find_element(:id, "txt_signin")
  end

  def live_tv_back
    driver.find_element(:id, "btn_video_back")
  end
end
