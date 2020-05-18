# frozen_string_literal: true

class SearchScreen < BaseScreen
  def search_box
    driver.find_element(:id, "search_editor")
  end

  def content_view
    driver.find_element(:id, "main_content_view")
  end

  def results_view
    driver.find_elements(:xpath, "//android.support.v7.widget.RecyclerView[@content-desc='Search Results']//*")
  end

  def navigate_to_search
    press_up
    press_right while menu_search.attribute("focused") == "false"
    wait_until(10) { search_box.displayed? }
    press_down
  end

  def search_show(string)
    content_view.send_keys(string)
    press_media_play_pause
  end
end
