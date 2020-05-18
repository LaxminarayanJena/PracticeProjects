module Events
  module V2
    module Model
      class Session < Event
        ASSOCIATIONS = %w[client_attributes general_attributes product_attributes].freeze

        attr_accessor :action, :start_type, :client_attributes, :product_attributes, :general_attributes

        validates :action, presence: true

        validates :action, inclusion: { in: %w[start stop] }, if: proc { |obj| obj.action }

        validates :start_type, inclusion: { in: %w[first cold resume] }, if: proc { |obj| obj.start_type }

        def initialize(row, event_id)
          super(event_id)
          @action = row["payload_action"]
          @start_type = row["start_type"]
          @client_attributes = ClientAttributes.new(row)
          @product_attributes = ProductAttributes.new(row)
          @general_attributes = GeneralSchema.new(row)
        end
      end
    end
  end
end
