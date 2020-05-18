# frozen_string_literal: true

require "rubocop"

module RuboCop
  module Cop
    module Custom
      #
      # A cap to warn on any sleep calls.
      #
      class SleepCop < Cop
        MSG = "Do not call sleep. Only call it if your polling a method. " \
              "You can decorate that with: rubocop:disable Custom/SleepCop."

        def on_send(node)
          return unless node.method_name == :sleep

          add_offense(node, severity: :warning)
        end
      end
    end
  end
end
