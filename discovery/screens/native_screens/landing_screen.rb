# frozen_string_literal: true

class LandingScreen < BaseScreen
  def sign_in_button
    driver.find_element(
      :xpath, "//*[@text = 'SIGN IN FOR FULL ACCESS' or @label = 'SIGN IN FOR FULL ACCESS'
 or @text = 'Join Free Trial' or @label = 'Join Free Trial']"
    )
  end

  def free_limited_access
    driver.find_element(:xpath, "//*[@text = 'FREE LIMITED ACCESS' or @label = 'FREE LIMITED ACCESS']")
  end

  def close_icon
    driver.find_element(:xpath, "(//android.view.ViewGroup)[72]")
  end
end
