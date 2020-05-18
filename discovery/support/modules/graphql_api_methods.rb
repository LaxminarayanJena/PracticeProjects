
class GraphqlMethods
  JSON_FILE = File.join(Support::Paths.eurosport_graphql_data, "grapghql_query_data.json")

  def graphql_query_form(querytype)
    file = File.open JSON_FILE
    data = JSON.load file
    data[querytype]
  end

  def graphql_api_post(graphquery)
    Graphql.graphql_menu_method(query: graphquery)
  end

  def api_request(graphquery, uidata)
    @api_query = graphql_query_form(graphquery)
    @api_hit = graphql_api_post(@api_query)
    @api_response = parse_response(graphquery, @api_hit)
    @compare_response = Graphql.compare_graphqldata_uidata(@api_response, uidata)
  end

  def parse_response(type, response)
    case type
    when "MOST POPULAR"
      response["data"]["mostPopularVideos"].each { |x| x }.map { |x| x["seoTitle"] }
    when "EUROSPORT ORIGINALS"
      response["data"]["Tennis"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Football"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Snooker"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Olympics"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["AlpineSkiing"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Adventure"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Athletics"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Basketball"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Biathlon"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Motorsports"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Rugby"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["WEC"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["NordicCombined"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Curling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["CyclingTrack"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Equestrian"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Fencing"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["OtherSports"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Formula1"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["FormulaE"].each { |x| x }.map { |x| x["seoTitle"] }+
          response["data"]["Tennis"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Football"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Snooker"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Olympics"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["AlpineSkiing"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Adventure"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Athletics"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Basketball"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Biathlon"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Motorsports"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Rugby"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["WEC"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["NordicCombined"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Curling"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["CyclingTrack"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Equestrian"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Fencing"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["OtherSports"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["Formula1"].each { |x| x }.map { |x| x["title"] } +
          response["data"]["FormulaE"].each { |x| x }.map { |x| x["title"] }

    when "LATEST PREMIUM"
      response["data"]["premiumFER"]["edges"].each { |x| x }.map { |x| x["node"]["title"] }
    when "LATEST"
      # Facing issue with array flatten with array for each so adding sport events
      # Recursion is also failing
      response["data"]["Tennis"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Football"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Cycling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Snooker"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Olympics"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["AlpineSkiing"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Adventure"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Athletics"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Basketball"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Biathlon"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Motorsports"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Rugby"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["WEC"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["NordicCombined"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Curling"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["CyclingTrack"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Equestrian"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Fencing"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["OtherSports"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["Formula1"].each { |x| x }.map { |x| x["seoTitle"] } +
          response["data"]["FormulaE"].each { |x| x }.map { |x| x["seoTitle"] }
    when "TENNIS", "CYCLING", "FOOTBALL"
      response["data"]["home"]["blocks"][1]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][2]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][3]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][4]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][5]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][6]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][7]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] } +
          response["data"]["home"]["blocks"][8]["contents"]["edges"].each { |x| x }.map { |x| x["node"]["title"] }
    end
  end
end
