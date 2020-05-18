class EuroWatchByCompetitionScreen < BaseScreen
  def football_category
    driver.find_element(:id, "Football")
  end

  def cycling_category
    driver.find_element(:id, "Cycling")
  end

  def snooker_category
    driver.find_element(:id, "Snooker")
  end

  def olympic_games_category
    driver.find_element(:id, "Olympic Games")
  end

  def tennis_category
    driver.find_element(:id, "Tennis")
  end

  def back_button
    driver.find_element(:name, "Back")
  end

  def australian_open_sport_type
    driver.find_element(:name, "Australian Open")
  end

  def world_championships_sport_type
    driver.find_element(:name, "World Championships")
  end

  def uk_championship_sport_type
    driver.find_element(:name, "UK Championship")
  end

  def transfers_sport_type
    driver.find_element(:name, "Transfers")
  end

  def tokyo_sport_type
    driver.find_element(:name, "Tokyo 2020")
  end
end
