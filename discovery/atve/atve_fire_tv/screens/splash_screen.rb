class SplashScreen < BaseScreen
  def splash_logo
    driver.find_element(:id, "networkLogo")
  end

  def text_link_message
    driver.find_element(:id, "textLinkMessage")
  end

  def network_channels
    driver.find_element(:id, "lytChannels")
  end

  def available_newtwok_message
    driver.find_element(:id, "textAvailableNetworkMessage")
  end

  def link_tv_provider_btn
    driver.find_element(:id, "btnLinkProvider")
  end

  def maybe_later_btn
    driver.find_element(:id, "btnMaybeLater")
  end
end
