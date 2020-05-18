module Events
  module V2
    module Model
      class ProductAttributes < Event
        attr_accessor :prod_attr_name, :prod_attr_version, :prod_attr_build_number

        validates :prod_attr_name, :prod_attr_version, presence: true

        def initialize(row)
          @prod_attr_name = row["payload_product_attributes_name"]
          @prod_attr_version = row["payload_product_attributes_version"]
          @prod_attr_build_number = row["payload_product_attributes_build_number"]
        end
      end
    end
  end
end
