# frozen_string_literal: true

class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end

  def scroll_by_coordinates(x_start, y_start, x_end, y_end)
    Appium::TouchAction.new.swipe(start_x: x_start, start_y: y_start, end_x: x_end, end_y: y_end).perform
  end

  def scroll_down
    size = $driver.driver.manage.window.size
    width = size.width / 2
    starty = size.height * 0.8
    finishy = 1
    Appium::TouchAction.new.swipe(startx: width, starty: starty, end_x: width, end_y: finishy).perform
  end

  def scroll_up
    size = $driver.driver.manage.window.size
    width = size.width / 2
    starty = size.height * 0.8
    finishy = 1
    Appium::TouchAction.new.swipe(startx: width, starty: finishy, end_x: width, end_y: starty).perform
  end
end
