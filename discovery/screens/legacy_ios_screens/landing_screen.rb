class LandingScreen < BaseScreen
  def search_providers
    driver.find_element(:id, "Search providers")
  end

  def search_provider_results(provider_name)
    driver.find_element(:name, provider_name.to_s)
  end

  def unfinished_videos_list
    driver.find_element(:name, "CONTINUE WATCHING")
  end

  def landing_page_details(text)
    driver.find_element(:name, text.to_s)
  end

  def network_logo
    driver.find_element(:xpath, "(//XCUIElementTypeImage)[1]")
  end

  def affiliate_logo
    driver.find_element(:xpath, "//XCUIElementTypeButton[@name='search icon']//following-sibling::XCUIElementTypeButton")
  end

  def hero_episode_title
    driver.find_element(:xpath, "(//XCUIElementTypePageIndicator/..//XCUIElementTypeStaticText)[2]")
  end

  def hero_show_title
    driver.find_element(:xpath, "(//XCUIElementTypePageIndicator/..//XCUIElementTypeImage)[2]")
  end

  def hero_cta_btn
    driver.find_element(:xpath, "(//XCUIElementTypePageIndicator/..//XCUIElementTypeStaticText)[1]")
  end

  def carousel_headers
    titles = []
    carousel_headers = driver.find_elements(:xpath, "//XCUIElementTypeCollectionView/XCUIElementTypeOther/")
    carousel_headers.each do |carousel_header|
      titles << find_sibling_element(carousel_header, "XCUIElementTypeStaticText[1]").text.downcase
    end
    titles
  end

  def play_video_button
    driver.find_element(:name, "episode play button blue")
  end

  def forgot_password_text
    driver.find_element(:name, "Forgot password?")
  end

  def dont_see_provider_text
    driver.find_element(:name, "Don't see provider?")
  end

  def tv_provider_header
    driver.find_element(:name, "TV Provider Request")
  end

  def faq_text
    driver.find_element(:name, "FAQ")
  end

  def support_home_header
    driver.find_element(:name, "Support Home Page")
  end

  def scroll_to_down
    driver.scroll(direction: "down")
  end

  def network_lists
    driver.find_element(:xpath, "//XCUIElementTypeStaticText[contains(@name,'LISTS')]")
  end

  def network_play_list
    driver.find_element(:xpath, "//*[contains(@name,'LISTS')]/../../following-sibling::XCUIElementTypeCell[1]//XCUIElementTypeStaticText")
  end
end
