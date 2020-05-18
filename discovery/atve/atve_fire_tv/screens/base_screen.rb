require "rspec/expectations"

class BaseScreen
  def driver
    $driver
  end

  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def press_up
    driver.press_keycode(19)
  end

  def press_down
    driver.press_keycode(20)
  end

  def press_left
    driver.press_keycode(21)
  end

  def press_right
    driver.press_keycode(22)
  end

  def press_back
    driver.press_keycode(4)
  end

  def press_select
    driver.press_keycode(23)
  end

  def press_media_play_pause
    driver.press_keycode(85)
  end

  def press_rewind
    driver.press_keycode(89)
  end

  def press_fast_forward
    driver.press_keycode(90)
  end

  def affiliate_logo
    driver.find_element(:id, "toolbarLogo")
  end

  def home_icon
    driver.find_element(:xpath, "//*[@text = 'Home']")
  end

  def settings_icon
    driver.find_element(:xpath, "//*[@text = 'Settings']")
  end

  def menu_section(string)
    driver.find_element(:xpath, "//android.widget.TextView[@text='" + string + "']").click
  end
end
