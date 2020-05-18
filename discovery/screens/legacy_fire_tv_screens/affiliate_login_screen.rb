# frozen_string_literal: true

# rubocop:disable Style/GlobalVars

class AffiliateLoginPage < BaseScreen
  def front_email
    $browser.find_element(:id, "username")
  end

  def front_password
    $browser.find_element(:id, "password")
  end

  def front_submit
    $browser.find_element(:id, "submit")
  end

  def search_cancel_btn
    $browser.find_element(:id, "cancel_text")
  end

  def login_elements(provider)
    # Waiting for element to load
    username = username_element(provider)
    password = password_element(provider)
    submit_btn = submit_element(provider)
    [username, password, submit_btn]
  end

  def username_element(provider)
    case provider
    when "Frontier Communications"
      $browser.find_element(:name, "username")
    when "DIRECTV"
      $browser.find_element(:id, "usernameInputId")
    when "Comcast XFINITY"
      $browser.find_element(:id, "username")
    when "Optimum"
      $browser.find_element(:name, "IDToken1")
    else
      $browser.find_element(:id, "username")
    end
  end

  def password_element(provider)
    case provider
    when "Frontier Communications"
      $browser.find_element(:name, "password")
    when "Optimum"
      $browser.find_element(:name, "IDToken2")
    when "Comcast XFINITY"
      $browser.find_element(name: "passwd")
    when "DIRECTV"
      $browser.find_element(:name, "password")
    else
      $browser.find_element(name: "password")
    end
  end

  def submit_element(provider)
    case provider
    when "Frontier Communications"
      $browser.find_element(id: "login")
    when "Optimum"
      $browser.find_element(id: "signin_button")
    when "Comcast XFINITY"
      $browser.find_element(id: "sign_in")
    when "AT&T U-Verse"
      $browser.find_element(id: "submitLogin")
    when "DIRECTV"
      $browser.find_element(id: "loginSubmitId")
    else
      $browser.find_element(name: "submit")
    end
  end
end
# rubocop:enable Style/GlobalVars
