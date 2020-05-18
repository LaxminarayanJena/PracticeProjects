module PageHelpers
  class Graphql
    include HTTParty

    def initialize
      @uri = ENV["GRAPHQL_URL"]
      initialize_httparty
    end

    def initialize_httparty
      self.class.base_uri @uri
      self.class.format :json
      self.class.headers("x-introspection-key" => "4P6bKdUp502EEflJdGLcvRlq8EKnHIY3vlFmMF5f", "domain" => "www.eurosport.co.uk+mobile",
                         "Content-Type" => "application/json")
    end

    def graphql_menu_method(query:)
      self.class.post(self.class.base_uri, headers: self.class.headers, body: { query: query }.to_json)
    end

    def compare_graphqldata_uidata(graphqldata, uidata)
      count = 0
      failedtitles = []
      uidata.each do |title|
        status = graphqldata.include? title
        if status == true
          count += 1
        else
          puts "Matching Failed===>>>" + title
          failedtitles << title
        end
      end
      [count, failedtitles]
    end
  end
end
