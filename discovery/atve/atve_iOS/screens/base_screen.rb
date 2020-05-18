require "rspec/expectations"

class BaseScreen
  def driver
    $driver
  end

  def home_icon
    driver.find_element(:name, "Home")
  end

  def shows_icon
    driver.find_element(:name, "Shows")
  end

  def live_icon
    driver.find_element(:name, "Live")
  end

  def search_icon
    driver.find_element(:name, "Search")
  end

  def account_icon
    driver.find_element(:name, "Account")
  end

  def menubar_footer
    driver.find_elements(:xpath, "//XCUIElementTypeTabBar")
  end

  def back_button
    driver.find_element(:name, "Back")
  end

  def wait_until(timeout = 30, message = nil, &block)
    wait = Selenium::WebDriver::Wait.new(timeout: timeout, message: message)
    wait.until(&block)
  end

  def scroll_to_down
    driver.scroll(direction: "down")
  end

  def tap_by_coordinates(x_coordinate, y_coordinate)
    Appium::TouchAction.new.tap(x: x_coordinate, y: y_coordinate, count: 1).perform
  end

  def scroll_to_element_by_text(text)
    count = 0
    while search_by_name(text).empty?
      count += 1
      if count > 7
        puts("Did not find element even after scrolling for long")
        break
      else
        puts("Did not find the element hence scrolling down...")
        scroll_down_by_screen_coordinates("20%")
      end
    end
  end

  def scroll_to_object_list(object)
    count = 0
    while object.size.positive? == false
      count += 1
      if count > 7
        puts("Did not find object even after scrolling for long")
        break
      else
        puts("Did not find the object hence scrolling down...")
        scroll_down_by_screen_coordinates("20%")
      end
    end
  end

  def scroll_to_single_object(object)
    count = 0
    while object.displayed? == false
      count += 1
      if count > 7
        puts("Did not find object even after scrolling for long")
        break
      else
        puts("Did not find the object hence scrolling down...")
        scroll_down_by_screen_coordinates("20%")
      end
    end
  end

  def search_by_name(text)
    driver.find_elements(:name, text)
  end

  def contains_by_name(text)
    driver.find_element(:xpath, "//*[contains(@name, '#{text}')]")
  end

  def scroll_to_up
    driver.scroll(direction: "up")
  end

  def horizontal_forward_scroll(ref_element, scroll_steps)
    scroll_steps.times { driver.scroll(direction: "right", element: ref_element) }
  end

  def horizontal_backward_scroll(ref_element, scroll_steps)
    scroll_steps.times { driver.scroll(direction: "left", element: ref_element) }
  end

  def scroll_down_by_screen_coordinates(percentage)
    window_height = driver.window_size
    y_start = window_height[1] * 0.60
    case percentage
    when "10%"
      y_end = window_height[1] * 0.50
    when "20%"
      y_end = window_height[1] * 0.40
    end
    Appium::TouchAction.new.swipe(start_y: y_start, end_y: y_end).perform
  end
end
