# frozen_string_literal: true

class ShowInfoScreen < BaseScreen
  def title
    driver.find_element(:id, "info_title_text")
  end

  def description
    driver.find_element(:id, "info_description_text")
  end
end
