# frozen_string_literal: true

#:nodoc: all
class WatchLaterScreen < BaseScreen
  def watch_list
    driver.find_element(:xpath, "//XCUIElementTypeTable/parent::XCUIElementTypeOther")
  end

  def watch_later_empty_list
    driver.find_element(:name, "Your Watch Later is empty!")
  end

  def edit_btn
    driver.find_element(:name, "EDIT")
  end

  def done_btn
    driver.find_element(:name, "DONE")
  end

  def edit_checkbox
    driver.find_element(:name, "watchlist delete deselected")
  end

  def watch_later_success_message
    driver.find_element(:xpath, "//*[@text = 'Added To Watch Later']")
  end

  def watch_later_removal_message
    driver.find_element(:xpath, "//*[@text = 'Removed From Watch Later']")
  end
end
