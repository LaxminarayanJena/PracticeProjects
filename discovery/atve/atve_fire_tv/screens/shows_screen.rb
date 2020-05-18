# frozen_string_literal: true

class ShowScreen < BaseScreen
  def shows_header
    driver.find_element(:id, "row_header")
  end

  def show_title
    driver.find_elements(:id, "textTitle")
  end

  def show_card
    driver.find_element(:id, "imageCarousel")
  end

  def show_list
    driver.find_elements(:id, "row_content")
  end

  def show_details_title
    driver.find_element(:id, "tv_title")
  end

  def shows_description
    driver.find_element(:id, "tv_description")
  end

  def add_show_button
    driver.find_element(:id, "btnAddShow")
  end

  def start_show_button
    driver.find_element(:id, "btnAction")
  end

  def shows_hero_image
    driver.find_element(:id, "container_hero")
  end

  def shows_gist
    driver.find_element(:id, "tv_gist")
  end

  def show_title_list(caurosel)
    driver.find_elements(:xpath, "//*[@content-desc='#{caurosel}']/..//child::android.widget.TextView")
  end

  def showimage_list(caurosel)
    driver.find_elements(:xpath, "//*[@content-desc='#{caurosel}']/..//child::android.widget.ImageView[1]")
  end
end
