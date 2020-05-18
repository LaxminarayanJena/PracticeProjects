# frozen_string_literal: true

class AffiliateLoginScreen < BaseScreen
  def front_email
    driver.find_element(:id, "username")
  end

  def front_password
    driver.find_element(:id, "password")
  end

  def front_submit
    driver.find_element(:id, "submit")
  end

  def search_cancel_btn
    driver.find_element(:id, "cancel_text")
  end

  def login_elements(provider)
    # Waiting for element to load
    wait_until(120) { username_element(provider).displayed? }
    username = username_element(provider)
    password = password_element(provider)
    submit_btn = submit_element(provider)
    [username, password, submit_btn]
  end

  def username_element(provider)
    case provider
    when "Frontier Communications"
      driver.find_element(:id, "username")
    when "DIRECTV"
      driver.find_element(:id, "usernameInputId")
    when "Comcast XFINITY"
      driver.find_element(:id, "user")
    when "Optimum"
      driver.find_element(:name, "IDToken1")
    else
      driver.find_element(:id, "username")
    end
  end

  def password_element(provider)
    case provider
    when "Frontier Communications"
      driver.find_element(:id, "password")
    when "Optimum"
      driver.find_element(:name, "IDToken2")
    when "Comcast XFINITY"
      driver.find_element(name: "passwd")
    when "DIRECTV"
      driver.find_element(:name, "password")
    when "West Alabama TV Cable"
      driver.find_element(:id, "password")
    else
      driver.find_element(name: "password")
    end
  end

  def submit_element(provider)
    case provider
    when "Frontier Communications"
      driver.find_element(id: "login")
    when "Optimum"
      driver.find_element(id: "signin_button")
    when "Comcast XFINITY"
      driver.find_element(id: "sign_in")
    when "AT&T U-Verse"
      driver.find_element(id: "submitLogin")
    when "DIRECTV"
      driver.find_element(id: "loginSubmitId")
    when "West Alabama TV Cable"
      driver.find_element(:css, "[value='Login']")
    else
      driver.find_element(name: "submit")
    end
  end
end
