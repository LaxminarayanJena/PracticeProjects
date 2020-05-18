# frozen_string_literal: true

class MenuBarScreen < BaseScreen
  def navigate_to_menubar
    press_menu
    wait_until(30) { menu_search.displayed? }
  end

  def just_added_label
    driver.find_element(:name, "Just Added Shows")
  end

  def go_ori_series_label
    driver.find_element(:name, "GO Original Series")
  end

  def popular_epi_label
    driver.find_element(:name, "Most Popular Shows")
  end

  def navigate_to_shows
    press_menu
    press_down
    wait_until(30) { menu_shows.displayed? }
  end

  def navigate_to_live
    press_menu
    2.times { press_down }
    wait_until(30) { menu_live.displayed? }
  end
end
