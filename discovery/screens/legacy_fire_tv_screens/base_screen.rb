class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def logo
    driver.find_element(:id, "logo_image")
  end

  def menu_featured
    driver.find_element(:xpath, "//android.widget.Button[@text='Featured']")
  end

  def menu_signin
    driver.find_element(:xpath, "//android.widget.Button[@text='Sign In']")
  end

  def menu_shows
    driver.find_element(:xpath, "//android.widget.Button[@text='Shows']")
  end

  def menu_live
    driver.find_element(:xpath, "//android.widget.Button[@text='Live']")
  end

  def menu_browse
    driver.find_element(:xpath, "//android.widget.Button[@text='Browse']")
  end

  def menu_myvideos
    driver.find_element(:xpath, "//android.widget.Button[@text='My Videos']")
  end

  def menu_search
    driver.find_element(:xpath, "//android.widget.FrameLayout[6]/android.widget.ImageButton")
  end

  def menu_settings
    driver.find_element(:xpath, "//android.widget.FrameLayout[7]/android.widget.ImageButton")
  end

  def menu_search_box
    driver.find_element(:id, "search_editor")
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

  def driver
    $driver
  end
end
