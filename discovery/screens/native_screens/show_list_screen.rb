class ShowListScreen < BaseScreen
  def first_show_in_list
    driver.find_element(:xpath, "//*[@content-desc = 'list-all-shows__0__cell-show' or @name = 'list-all-shows__0__cell-show']")
  end

  def search_list_first_show
    driver.find_element(:xpath, "//*[@content-desc = 'list-search-results__0__cell-show' or @name = 'list-search-results__0__cell-show']")
  end

  def for_you_tab_first_show
    driver.find_element(:xpath, "//*[@content-desc = 'list-shows-recommended__0__cell-show' or
                                  @name = 'list-shows-recommended__0__cell-show']")
  end

  def search_text_button
    driver.find_element(:xpath, "//*[@text = 'Search Shows' or @label = 'Search Shows']")
  end

  def no_results_text
    driver.find_element(:xpath, "//*[@text = 'No results.' or @label = 'No results.']")
  end

  def all_shows_tab
    driver.find_element(:xpath, "//*[@text = 'ALL SHOWS' or @label = 'ALL SHOWS']")
  end

  def for_you_tab
    driver.find_element(:xpath, "//*[@text = 'FOR YOU' or @label = 'FOR YOU']")
  end

  def search_text_field
    driver.find_element(:xpath, "//*[@content-desc = 'search-input' or @name = 'search-input']//android.widget.EditText")
  end

  def detail_view
    driver.find_element(:xpath, "//android.view.ViewGroup[@content-desc='hero']/android.view.ViewGroup[3]/android.view.View")
  end

  def episode_card
    driver.find_element(:accessibility_id, "list-season-episodes__0__cell-video")
  end
end
