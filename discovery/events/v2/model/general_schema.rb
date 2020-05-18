module Events
  module V2
    module Model
      class GeneralSchema < Event
        attr_accessor :type, :uuid, :version, :timestamp, :session_id, :session_timer

        validates :type, :uuid, :version, :timestamp, :session_id, :session_timer, presence: true

        validates :version,
                  inclusion: { in: %w[v2] },
                  if: proc { |obj| obj.version }

        validate :validate_uuid_format, if: proc { |obj| obj.uuid }
        validate :validate_session_format, if: proc { |obj| obj.session_id }
        validate :validate_rfc3339_format, if: proc { |obj| obj.timestamp }

        def initialize(row)
          @type = row["type"]
          @uuid = row["uuid"]
          @version = row["version"]
          @timestamp = row["timestamp"]
          @session_id = row["session_id"]
          @session_timer = row["session_timer"]
        end

        private

        def validate_uuid_format
          errors.add(:uuid, "is not a valid UUID") unless valid_uuid?(uuid)
        end

        def validate_session_format
          errors.add(:session_id, "is not a valid session id") unless valid_uuid?(session_id)
        end

        def validate_rfc3339_format
          errors.add(:timestamp, "is not a valid format") unless rfc3339?(timestamp)
        end
      end
    end
  end
end
