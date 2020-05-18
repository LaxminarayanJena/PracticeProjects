# frozen_string_literal: true

require "csv"

class ProviderAffiliates
  CSV_FILE = File.join Support::Paths.cucumber_root, "affiliates_login.csv"

  class << self
    def get(provider)
      raise "empty affiliates csv file, please fill with values from google sheet" if File.zero?(CSV_FILE)

      store = fetch_store(provider)
      index = fetch_index(store)

      return nil unless index

      # Rubocop sees the return on the line above and assumes this can't be reached.
      # rubocop:disable Style/RedundantReturn
      return { user_name: store[index]["Username"], password: store[index]["Password"] }
      # rubocop:enable Style/RedundantReturn
    end

    def fetch_store(provider)
      # Search affiliates_login.csv for a user with access to the site_code
      csv = CSV.parse(File.open(CSV_FILE, "r"), headers: true)
      csv.map { |r| r if r.to_s.downcase.split(",").include?(provider.downcase) }.compact
    end

    def fetch_index(store)
      if ENV["PROD_AFFILIATE"]
        store.index { |x| x[(ENV["NETWORK_CODE"]).to_s] == "X" && x["Prod"] == "X" }
      else
        store.index { |x| x[(ENV["NETWORK_CODE"]).to_s] == "X" }
      end
    end
  end
end
