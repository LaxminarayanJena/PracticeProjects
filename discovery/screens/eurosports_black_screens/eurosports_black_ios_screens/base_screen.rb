# frozen_string_literal: true

class BaseScreen
  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def driver
    $driver
  end

  def home_option
    driver.find_element(:id, "Home")
  end

  def scroll_to_down
    driver.scroll(direction: "down")
  end

  def scroll_to_right
    driver.scroll(direction: "right")
  end

  def scroll_to_left
    driver.scroll(direction: "left")
  end

  def scroll_by_coordinates(x_start, y_start, x_end, y_end)
    Appium::TouchAction.new.swipe(start_x: x_start, start_y: y_start, end_x: x_end, end_y: y_end).perform
  end

  def scroll_to_first_row_carousel
    start_x_coordinate = driver.window_size.width - 200
    start_y_coordinate = driver.window_size.height - 650
    end_x_coordinate = start_x_coordinate + 100
    end_y_coordinate = start_y_coordinate - 600
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def scroll_to_second_row_carousel
    window_height = driver.window_size
    y_start = window_height[1] * 0.60
    y_end = window_height[1] * 0.42
    Appium::TouchAction.new.swipe(start_y: y_start, end_y: y_end).perform
  end

  def scroll_to_third_row_carousel
    window_height = driver.window_size
    y_start = window_height[1] * 0.60
    y_end = window_height[1] * 0.27
    Appium::TouchAction.new.swipe(start_y: y_start, end_y: y_end).perform
  end

  def scroll_to_fourth_row_carousel
    window_height = driver.window_size
    y_start = window_height[1] * 0.60
    y_end = window_height[1] * 0.11
    Appium::TouchAction.new.swipe(start_y: y_start, end_y: y_end).perform
  end

  def scroll_to_fifth_row_carousel
    start_x_coordinate = driver.window_size.width
    start_y_coordinate = driver.window_size.height - 300
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 530
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def scroll_to_sixth_row_carousel
    start_x_coordinate = driver.window_size.width
    start_y_coordinate = driver.window_size.height - 300
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 700
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end

  def scroll_to_eurosport_originals
    start_x_coordinate = driver.window_size.width - 100
    start_y_coordinate = driver.window_size.height - 500
    end_x_coordinate = start_x_coordinate
    end_y_coordinate = start_y_coordinate - 400
    scroll_by_coordinates(start_x_coordinate, start_y_coordinate, end_x_coordinate, end_y_coordinate)
  end
end
