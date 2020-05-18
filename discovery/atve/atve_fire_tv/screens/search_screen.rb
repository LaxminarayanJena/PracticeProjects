# frozen_string_literal: true

class SearchScreen < BaseScreen
  def navigate_to_search
    press_left
    3.times { press_down }
  end

  def search_box
    driver.find_element(:id, "editTextAtom")
  end

  def search_no_results_msg
    driver.find_element(:id, "searchErrorText")
  end

  def search_rails(search_rail)
    driver.find_element(:xpath, "//*[@text = '" + search_rail + "']")
  end

  def search_trendingnow_rail
    driver.find_element(:xpath, "//*[@text = 'Trending Now']")
  end

  def search_popularshowlist
    driver.find_elements(:id, "imageCarousel")
  end

  def search_trendingnowshowlist
    driver.find_elements(:id, "imageCarouselBasic")
  end

  def search_showslist
    driver.find_elements(:id, "ivSearchShow")
  end

  def search_header
    driver.find_element(:id, "headerTitle")
  end

  def search_showtitle
    driver.find_element(:id, "tvSearchTitle")
  end

  def search_episodelist
    driver.find_elements(:id, "ivSearchEpisode")
  end

  def search_show_title(search_showtitle)
    case search_showtitle
    when "Shows"
      driver.find_element(:id, "tvSearchTitle")
    when "Popular Shows this week"
      driver.find_element(:id, "textTitle")
    when "Trending Now"
      driver.find_element(:id, "textTitleBasic")
    when "Episodes"
      driver.find_element(:id, "tvSearchTitle")
    end
  end

  def search_show_list(search_showlist)
    case search_showlist
    when "Shows"
      driver.find_elements(:id, "ivSearchShow")
    when "Popular Shows this week"
      driver.find_elements(:id, "imageCarousel")
    when "Trending Now"
      driver.find_elements(:id, "imageCarouselBasic")
    when "Episodes"
      driver.find_elements(:id, "ivSearchEpisode")
    end
  end
end
