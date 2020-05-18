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

  def affiliate_logo_images
    driver.find_elements(:xpath, "//XCUIElementTypeCollectionView/..//XCUIElementTypeImage")
  end

  def affiliate_serach_list
    driver.find_elements(:name, "More Info")
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
    when "DIRECTV"
      driver.find_element(:xpath, "//*[@value = 'email address']")
    when "Frontier Communications"
      driver.find_element(:xpath, "//*[@value = 'Username']")
    when "AT&T U-Verse"
      driver.find_element(:xpath, "//*[@name='Email/User ID']/../XCUIElementTypeTextField")
    when "Optimum"
      driver.find_element(:xpath, "//*[@name='Optimum Online']//XCUIElementTypeTextField")
    else
      driver.find_element(:id, "username")
    end
  end

  def password_element(provider)
    case provider
    when "DIRECTV"
      driver.find_element(:xpath, "//*[@value = 'password']")
    when "Frontier Communications"
      driver.find_element(:xpath, "//*[@value = 'Password']")
    when "Optimum"
      driver.find_element(:xpath, " //*[@name='Optimum Online']//XCUIElementTypeSecureTextField")
    when "AT&T U-Verse"
      driver.find_element(:xpath, "//*[@name='Password']/../XCUIElementTypeSecureTextField")
    else
      driver.find_element(:name, "password")
    end
  end

  def submit_element(provider)
    case provider
    when "DIRECTV"
      driver.find_element(:xpath, "//*[@name = 'DIRECTV Login']//XCUIElementTypeButton")
    when "Frontier Communications"
      driver.find_element(id: "SIGN IN")
    when "Optimum"
      driver.find_element(:xpath, "//*[@name = 'Forgot Password?']/parent::XCUIElementTypeOther//*[@type = 'XCUIElementTypeImage']")
    when "AT&T U-Verse"
      driver.find_element(:name, "Sign In")
    else
      driver.find_element(:css, "[value='Login']")
    end
  end
end
