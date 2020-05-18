# frozen_string_literal: true

# rubocop:disable Style/GlobalVars

class ActivatePage < BaseScreen
  def open_web_browser
    $browser = Selenium::WebDriver.for :chrome
    $browser.manage.window.maximize
  end

  def url
    $browser.navigate.to(ENV["FIRE_TV_ACTIVATION_URL"]).to_s
  end

  def captilized_code
    $browser.find_element(:name, "code")
  end

  def activate_button
    $browser.find_element(:class, "activateDeviceSubmit")
  end

  def providers_search
    $browser.find_element(:class, "affiliateSelector__input")
  end

  def providers_text_list_item
    $browser.find_element(:class, "affiliateSelector__item")
  end

  def activation_success_msg
    $browser.find_element(:class, "activateDevice__mainSuccess")
  end
end
# rubocop:enable Style/GlobalVars
