require_relative "event"
module Events
  module V2
    module Model
      class Ad < Event
        ASSOCIATIONS = %w[client_attributes general_attributes product_attributes].freeze

        attr_accessor :action,
                      :stream_provider_session_id,
                      :stream_timer,
                      :content_position,
                      :stream_position,
                      :asset_id,
                      :creative_id,
                      :ad_unit_id,
                      :duration,
                      :player_name,
                      :break_index,
                      :ad_index,
                      :break_type,
                      :playback_type,
                      :cast_type,
                      :content_video_id,
                      :content_stream_type,
                      :client_attributes,
                      :product_attributes,
                      :general_attributes

        validates :action,
                  :stream_provider_session_id,
                  :stream_timer,
                  :content_position,
                  :stream_position,
                  :asset_id,
                  :player_name,
                  :ad_index,
                  :break_index,
                  :break_type,
                  :content_video_id,
                  :content_stream_type,
                  presence: true

        validates :action, inclusion: { in: %w[start progress pauseStart
                                               seekStart bufferStart pauseStop
                                               seekStop bufferStop resume
                                               skip complete stop] },
                           if: proc { |obj| obj.action }

        validates :stream_timer, numericality: { greater_than_or_equal_to: 0 }

        validates :content_stream_type, inclusion: { in: %w[vod live] }, if: proc { |obj| obj.content_stream_type }

        def initialize(row, event_id)
          super(event_id)
          @action = row["payload_action"]
          @stream_provider_session_id = row["payload_stream_provider_session_id"]
          @stream_timer = row["payload_stream_timer"]
          @content_position = row["payload_content_position"]
          @stream_position = row["payload_stream_position"]
          @asset_id = row["payload_asset_id"]
          @creative_id = row["payload_creative_id"]
          @ad_unit_id = row["payload_ad_unit_id"]
          @payload_duration = row["payload_duration"]
          @player_name = row["payload_player_name"]
          @ad_index = row["payload_ad_index"]
          @break_index = row["payload_break_index"]
          common_attrs(row)
        end

        # This is small hack for rubocop
        # TODOS have to do meta-programming stuff to
        # Refactor the common attributes
        def common_attrs(row)
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
