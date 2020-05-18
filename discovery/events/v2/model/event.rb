require "active_model"

module Events
  module V2
    module Model
      class Event
        attr_accessor :event_id
        include ActiveModel::Validations
        include ActiveModel::Validations::Callbacks

        before_validation :strip_null

        def initialize(event_id)
          @event_id = event_id
        end

        def push_errors
          [].tap do |error|
            error.push(errors.full_messages) unless valid?
            self.class::ASSOCIATIONS.each do |attr|
              error.push(send(attr).errors.full_messages) unless send(attr).valid?
            end
          end
        end

        private

        def strip_null
          # From CSV file will get "NULL" as string or empty string ""
          # so convert "NULL" to ruby nil
          instance_variables.map do |attr|
            instance_variable_set(attr, nil) if ["NULL", ""].include?(instance_variable_get(attr))
          end
        end
      end
    end
  end
end
