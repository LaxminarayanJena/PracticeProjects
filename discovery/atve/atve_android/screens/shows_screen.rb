class ShowScreen < BaseScreen
  def list_of_shows
    driver.find_elements(:id, "title")
  end

  def show_thumbnail
    driver.find_element(:xpath, "//*[@text='Shows']/../*[2]/*[1]")
  end

  def more_less_option(option)
    driver.find_element(:xpath, "//*[@text='#{option}']")
  end

  def eposode_description
    driver.find_elements(:xpath, "//*[@text='More' or @text='Less']/../*[1]")
  end

  def episode_image
    driver.find_elements(:xpath, "//*[@text='More']/../../*[@class='android.widget.ImageView']")
  end

  def episode_number
    driver.find_elements(:xpath, "//*[@text='More']/../../*[@class='android.widget.TextView'][1]")
  end

  def episode_name
    driver.find_elements(:xpath, "//*[@text='More']/../../*[@class='android.widget.TextView'][2]")
  end

  def episode_duration
    driver.find_elements(:xpath, "//*[@text='More']/../../*[@class='android.widget.TextView'][3]")
  end

  def scroll_to_traves_complete_episode_list
    start_x = driver.window_size.width / 2
    start_y = driver.window_size.height - 100
    end_x = start_x
    end_y = start_y - 300
    scroll_by_coordinates(start_x, start_y, end_x, end_y)
  end

  def season_picker_rail
    driver.find_element(:id, "labelsRecyclerView")
  end

  def listed_seasons
    driver.find_elements(:xpath, "//*[contains(@text,'Season ')]/../*[@class='android.widget.TextView']")
  end

  def selected_season_episode_numbers(season)
    driver.find_elements(:xpath, "//*[contains(@text,'S#{season} E')]")
  end

  def selected_state_season(season)
    driver.find_element(:xpath, "//*[@text='Season #{season}']")
  end

  def episode_list
    driver.find_element(:id, "itemsRecyclerView")
  end

  def show_hero_image
    driver.find_element(:id, "showDetailsImageHero")
  end

  def show_hero_title
    driver.find_element(:id, "showDetailsTitle")
  end
end
