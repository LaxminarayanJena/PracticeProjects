module Events
  module V2
    module Model
      class ClientAttributes < Event
        attr_accessor :browser_name, :browser_version, :device_brand, :device_manufacturer,
                      :device_model, :device_version, :os_name, :os_version, :client_attr_type,
                      :client_attr_id, :advertising_id, :connection_type

        # presence validations
        validates :os_name, :os_version, :client_attr_type, :client_attr_id, :advertising_id, presence: true
        validates :browser_name, :browser_version, presence: true, if: proc { |obj| obj.client_attr_type == "web" }

        validates :device_brand,
                  :device_manufacturer,
                  :device_model,
                  :device_version,
                  presence: true,
                  if: proc { |obj| obj.client_attr_type != "web" }

        # inclusion validations
        validates :client_attr_type,
                  inclusion: { in: %w[web console settop mobile tablet smarttv] }, if: proc { |obj| obj.client_attr_type }

        validates :connection_type,
                  inclusion: { in: %w[none wifi cellular ethernet ethernet bluetooth wimax] }, if: proc { |obj| obj.connection_type }

        def initialize(row)
          @browser_name = row["payload_client_attributes_browser_name"]
          @browser_version = row["payload_client_attributes_browser_version"]
          @device_brand = row["payload_client_attributes_device_brand"]
          @device_manufacturer = row["payload_client_attributes_device_manufacturer"]
          @device_model = row["payload_client_attributes_device_model"]
          @device_version = row["payload_client_attributes_device_version"]
          @os_name = row["payload_client_attributes_os_name"]
          @os_version = row["payload_client_attributes_os_version"]
          @client_attr_type = row["payload_client_attributes_type"]
          @client_attr_id = row["payload_client_attributes_id"]
          @advertising_id = row["payload_client_attributes_advertising_id"]
          @connection_type = row["payload_client_attributes_connection_type"]
        end
      end
    end
  end
end
