class AffiliateProviderSearchScreen < BaseScreen
  def search_providers
    driver.find_element(:class, "android.widget.EditText")
  end

  def select_provider(provider)
    driver.find_element(:xpath, "//android.widget.TextView[@text = '#{provider}']")
  end
end
