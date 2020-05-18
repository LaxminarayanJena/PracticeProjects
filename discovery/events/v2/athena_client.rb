require "aws-sdk"
module Events
  module V2
    class AthenaClient
      attr_accessor :client, :query, :results
      POLLING_INTERVAL = ENV["POLLING_INTERVAL"] || 5
      TOTAL_POLL_COUNT = ENV["TOTAL_POLL_COUNT"] || 20
      START_DATE = ENV["START_DATE"] || Time.now.strftime("%Y/%m/%d")
      END_DATE = ENV["END_DATE"] || Time.now.strftime("%Y/%m/%d")

      STATUS = %w[QUEUED RUNNING SUCCEEDED FAILED CANCELLED].freeze
      FAILED_STATUS = %w[FAILED CANCELLED].freeze
      SUCCESS_STATUS = ["SUCCEEDED"].freeze

      def initialize(query = nil)
        @query = query
        @client = Aws::Athena::Client.new(credentials: Aws::InstanceProfileCredentials.new.credentials)
      end

      def batch_query
        puts "===================SQL========================="
        puts query
        resp = client.start_query_execution(
          query_string: query, # required
          query_execution_context: {
            database: ENV["ATHENA_DB_NAME"]
          },
          result_configuration: { # required
            output_location: ENV["ATHENA_DB_LOCATION"], # required
            encryption_configuration: {
              encryption_option: "SSE_S3", # required, accepts SSE_S3, SSE_KMS, CSE_KMS
              kms_key: "String"
            }
          }
        )
        polling(resp)
      end

      def polling(resp)
        0.upto(TOTAL_POLL_COUNT) do |_i|
          state = client.get_query_execution(query_execution_id: resp.query_execution_id)["query_execution"]["status"]["state"]
          if SUCCESS_STATUS.include?(state)
            @results = client.get_query_results(query_execution_id: resp.query_execution_id)
            break
          elsif FAILED_STATUS.include?(state)
            puts "------------State: #{state}-----------"
            raise "AWS Athena response FAILED or CANCELLED"
          else
            puts "------------State: #{state}-----------"
            # rubocop:disable Custom/SleepCop
            sleep POLLING_INTERVAL
            # rubocop:enable Custom/SleepCop
          end
        end
      end

      def events_query(session_id, start_date, end_date)
        sql = format(EVENTS_SQL, session_id: session_id, start_date: start_date, end_date: end_date)
        sql.gsub(/\s+/, " ").strip
      end

      def sessionids_query
        "with a as(select sessionid, timestamp FROM events where
                  dt > date_format(current_timestamp - interval '#{ENV['INTERVAL']}' day to hour, '%Y/%m/%d/%H')
                  and version ='v2'
                  and payload.clientattributes.advertisingid = '#{ENV['ADVERTISING_ID']}'
                  group by distinct sessionid, timestamp
                  order by  timestamp desc),
              b as(select sessionid, max(timestamp) as time from a group by sessionid)
        select sessionid, b.time from b
        order by b.time desc".gsub(/\s+/, " ").strip
      end

      def csv_obj
        # TODOS remove CSV.
        csv_string = CSV.generate do |csv|
          results.result_set.rows.each do |row|
            csv << row.data.inject([]) { |acc, r| acc << r.var_char_value }
          end
        end
        csv_string
      end
    end
  end
end
