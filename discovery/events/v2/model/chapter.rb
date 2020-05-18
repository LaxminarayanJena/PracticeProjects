module Events
  module V2
    module Model
      class Chapter < Event
        ASSOCIATIONS = %w[client_attributes general_attributes product_attributes].freeze

        attr_accessor :action,
                      :stream_provider_session_id,
                      :stream_timer,
                      :content_position,
                      :stream_position,
                      :chapter_index,
                      :chapter_duration,
                      :content_id,
                      :content_stream_type,
                      :client_attributes,
                      :product_attributes,
                      :general_attributes

        validates :action, :stream_provider_session_id, :stream_timer, :content_position,
                  :stream_position, :chapter_index, :chapter_duration, :content_stream_type, presence: true

        validates :action, inclusion: { in: %w[start complete] }, if: proc { |obj| obj.action }

        validates :stream_timer, numericality: { greater_than_or_equal_to: 0 }

        validates :content_stream_type, inclusion: { in: %w[vod live] }, if: proc { |obj| obj.content_stream_type }

        def initialize(row, event_id)
          super(event_id)
          @action = row["payload_action"]
          @stream_provider_session_id = row["payload_stream_provider_session_id"]
          @stream_timer = row["payload_stream_timer"]
          @content_position = row["payload_content_position"]
          @stream_position = row["payload_stream_position"]
          @chapter_index = row["payload_chapter_index"]
          @chapter_duration = row["payload_chapter_duration"]
          @content_id = row["payload_content_id"]
          @content_stream_type = row["payload_content_stream_type"]
          @client_attributes = ClientAttributes.new(row)
          @product_attributes = ProductAttributes.new(row)
          @general_attributes = GeneralSchema.new(row)
        end
      end
    end
  end
end
