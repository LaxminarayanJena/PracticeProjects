# frozen_string_literal: true

class LiveScreen < BaseScreen
  def live_screen_nw_list
    driver.find_elements(:xpath, "(//XCUIElementTypeCollectionView)[2]/XCUIElementTypeCell")
  end
end
