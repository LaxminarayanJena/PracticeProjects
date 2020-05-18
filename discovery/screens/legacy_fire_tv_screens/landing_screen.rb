# frozen_string_literal: true

class LandingScreen < BaseScreen
  def unlocked_episodes
    driver.find_elements(:id, "videoCard_wrapper")
  end

  def row_content
    driver.find_element(:id, "row_content")
  end

  def home_carousel_title_text
    driver.find_element(:id, "title_text")
  end

  def call_to_action_text
    driver.find_element(:id, "call_to_action_text")
  end

  def description_text
    driver.find_element(:id, "description_text")
  end

  def play_btn
    driver.find_element(:id, "play")
  end
end
