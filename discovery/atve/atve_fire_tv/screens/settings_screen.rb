# frozen_string_literal: true

class SettingsScreen < BaseScreen
  def grid_menu_list
    driver.find_element(:id, "gridMenuList")
  end

  def tv_provider_subnav
    driver.find_element(:xpath, "//*[@text = 'TV Provider']")
  end

  def my_list_subnav
    driver.find_element(:xpath, "//*[@text = 'My List']")
  end

  def about_subnav
    driver.find_element(:xpath, "//*[@text = 'About']")
  end

  def help_subnav
    driver.find_element(:xpath, "//*[@text = 'Help']")
  end

  def nielsen_measurement_subnav
    driver.find_element(:xpath, "//*[@text = 'Nielsen Measurements']")
  end

  def tv_provider_title
    driver.find_element(:id, "tvProviderSettingTitle")
  end

  def tv_provider_subtitle
    driver.find_element(:id, "tvProviderSettingSubTitle")
  end

  def my_list_showstext
    driver.find_element(:id, "noShowsText")
  end

  def my_list_hinttext
    driver.find_element(:id, "hintText")
  end

  def my_list_myshows_tab
    driver.find_element(:id, "myListTab")
  end

  def my_list_myepisode_tab
    driver.find_element(:id, "myListTab")
  end

  def my_list_img
    driver.find_element(:id, "imgLongPress")
  end

  def about_details
    driver.find_element(:id, "details")
  end

  def about_terms_url
    driver.find_element(:xpath, "//*[contains(@text, 'https://corporate.discovery.com/visitor-agreement')]")
  end

  def about_privacy_url
    driver.find_element(:xpath, "//*[contains(@text, 'https://corporate.discovery.com/privacy-policy')]")
  end

  def about_online_url
    driver.find_element(:xpath, "//*[contains(@text, 'https://corporate.discovery.com/URL')]")
  end

  def about_california_url
    driver.find_element(:xpath, "//*[contains(@text, 'https://corporate.discovery.com/california_dns')]")
  end

  def help_details
    driver.find_element(:xpath, "//*[contains(@text, 'Looking for help?')]")
  end

  def help_link
    driver.find_element(:xpath, "//*[contains(@text, 'tlc.custhelp.com')]")
  end

  def nielsen_measurement_details
    driver.find_element(:xpath, "//*[contains(@text, 'Neilsen Measurements')]")
  end

  def link_tvprovider_btn
    driver.find_element(:id, "btnLinkProviderSetting")
  end
end
