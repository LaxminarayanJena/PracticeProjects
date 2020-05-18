module Events
  module V2
    module Model
      class Adbreak < Event
        ASSOCIATIONS = %w[client_attributes general_attributes product_attributes].freeze

        attr_accessor :action,
                      :stream_provider_session_id,
                      :content_position,
                      :stream_position,
                      :num_ads,
                      :break_index,
                      :break_type,
                      :playback_type,
                      :content_video_id,
                      :content_stream_type,
                      :cast_type,
                      :client_attributes,
                      :product_attributes,
                      :general_attributes

        validates :action,
                  :stream_provider_session_id,
                  :content_position,
                  :stream_position,
                  :num_ads,
                  :break_index,
                  :break_type,
                  :content_video_id,
                  :content_stream_type,
                  presence: true

        validates :action, inclusion: { in: %w[start complete] }, if: proc { |obj| obj.action }

        def initialize(row, event_id)
          super(event_id)
          @action = row["payload_action"]
          @stream_provider_session_id = row["payload_stream_provider_session_id"]
          @content_position = row["payload_content_position"]
          @stream_position = row["payload_stream_position"]
          @num_ads = row["payload_num_ads"]
          @break_index = row["payload_break_index"]
          @break_type = row["payload_break_type"]
          @playback_type = row["payload_playback_type"]
          @cast_type = row["payload_cast_type"]
          @content_video_id = row["payload_content_video_id"]
          @content_stream_type = row["payload_content_stream_type"]
          @client_attributes = ClientAttributes.new(row)
          @product_attributes = ProductAttributes.new(row)
          @general_attributes = GeneralSchema.new(row)
        end
      end
    end
  end
end
