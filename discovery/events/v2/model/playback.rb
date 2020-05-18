module Events
  module V2
    module Model
      class Playback < Event
        ASSOCIATIONS = %w[client_attributes general_attributes product_attributes].freeze

        attr_accessor :player_name,
                      :video_id,
                      :stream_provider_session_id,
                      :playback_type,
                      :stream_type,
                      :cast_type,
                      :action,
                      :content_position,
                      :stream_position,
                      :stream_timer,
                      :event_id,
                      :client_attributes,
                      :product_attributes,
                      :general_attributes

        validates :player_name, :video_id, :event_id, :playback_type, :stream_type, :action, :stream_timer,
                  :content_position, :stream_position, presence: true

        validates :stream_provider_session_id,
                  presence: true,
                  unless: proc { |obj| %w[playbackRequest streamInitiate].include? obj.action }

        validates :playback_type, inclusion: { in: %w[auto continuous userInitiated] }, if: proc { |obj| obj.playback_type }
        validates :stream_type, inclusion: { in: %w[vod live] }, if: proc { |obj| obj.stream_type }
        validates :action, inclusion: { in: %w[playbackRequest streamInitiate
                                               start progress pauseStart
                                               pauseStop seekStart seekStop
                                               bufferStart bufferStop resume
                                               complete stop streamComplete] },
                           if: proc { |obj| obj.action }
        validates :cast_type, inclusion: { in: %w[chromecast airplay] },
                              if: proc { |obj| obj.cast_type }

        validates :stream_timer, numericality: { greater_than_or_equal_to: 0 }

        def initialize(row, event_id)
          super(event_id)
          @player_name = row["payload_player_name"]
          @video_id = row["payload_video_id"]
          @stream_provider_session_id = row["payload_stream_provider_session_id"]
          @playback_type = row["payload_playback_type"]
          @stream_type = row["payload_stream_type"]
          @cast_type = row["payload_cast_type"]
          @action = row["payload_action"]
          @content_position = row["payload_content_position"]
          @stream_position = row["payload_stream_position"]
          @stream_timer = row["payload_stream_timer"]
          @event_id = event_id
          @client_attributes = ClientAttributes.new(row)
          @product_attributes = ProductAttributes.new(row)
          @general_attributes = GeneralSchema.new(row)
        end
      end
    end
  end
end
