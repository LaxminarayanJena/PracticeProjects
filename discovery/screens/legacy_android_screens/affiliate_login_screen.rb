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
    wait_until(30) { username_element(provider).displayed? }
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
      driver.find_element(:id, "username")
    when "Optimum"
      driver.find_element(:id, "IDToken1")
    when "HTC Digital Cable-SC"
      driver.find_element(id: "j_username")
    else
      driver.find_element(:id, "username")
    end
  end

  def password_element(provider)
    case provider
    when "Frontier Communications"
      driver.find_element(id: "password")
    when "Optimum"
      driver.find_element(id: "password")
    when "Comcast XFINITY"
      driver.find_element(name: "passwd")
    when "DIRECTV"
      driver.find_elements(xpath: "//*[@text='Password:']/../..//android.widget.EditText").last
    when "HTC Digital Cable-SC"
      driver.find_element(id: "j_password")
    else
      driver.find_element(name: "password")
    end
  end

  def submit_element(provider)
    case provider
    when "Frontier Communications"
      driver.find_element(id: "submit")
    when "Optimum"
      driver.find_element(id: "signin_button")
    when "Comcast XFINITY"
      driver.find_element(id: "sign_in")
    when "U-Verse"
      driver.find_element(id: "submitLogin")
    when "DIRECTV"
      driver.find_element(id: "loginSubmitId")
    else
      driver.find_element(xpath: "//*[@text='Sign In']")
    end
  end

  def directv_password_field
    ele = driver.find_element(:class, "android.widget.EditText")
    ele[1]
  end

  def affiliate_screen_search
    driver.find_element(:xpath, "//*[@text = 'SIGN IN TO UNLOCK ALL SHOWS!']")
  end

  def all_providers_logo(id)
    driver.find_element(:id, "img_affiliate_thumbnail_#{id}")
  end

  def all_providers_a_z
    driver.find_element(:id, "txt_all_providers_a_z")
  end

  def blank_affiliate_screen
    driver.find_element(:id, "rv_affiliates_search")
  end

  def search_provider_close_btn
    driver.find_element(:id, "clear_search_image_view")
  end

  def provider_page
    driver.find_element(:xpath, "//*[@text = 'Sign in to your TV Provider:']")
  end
end
