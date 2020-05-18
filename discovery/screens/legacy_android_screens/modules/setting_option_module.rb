module SettingOptionModule
  def screen_title_bar
    driver.find_element(:id, "toolbar")
  end

  def screen_title_text
    screen_title_bar.find_element(:class, "android.widget.TextView")
  end
end
