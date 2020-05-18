require "csv"
require "active_model"

module Events
  module V2
    class Base
      include ActiveModel::Validations
      attr_accessor :request_path, :streaming_api_path, :duration

      validates :request_path, presence: true # , :streaming_api_path, :duration, presence: true

      validate :file_exist_request_path, if: proc { |obj| obj.request_path }
      validate :file_exist_streaming_api_path, if: proc { |obj| obj.streaming_api_path }

      def initialize(request_path, streaming_api_path = nil, duration = nil)
        @request_path = request_path
        @streaming_api_path = streaming_api_path
        @duration = duration || 5000
      end

      def actual_data
        CSV.parse(File.open(request_path, "r"), headers: true)
      end

      def streaming_resp
        JSON.parse(File.read(streaming_api_path)) if streaming_api_path
      end

      # config the different types of seqence templates
      # for generate the expected seqence
      def initial_seqence
        [{ type: "playback", action: "start", result: nil },
         { type: "chapter", action: "start", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "chapter", action: "complete", result: nil }]
      end

      def resume_seqence
        [{ type: "playback", action: "resume", result: nil },
         { type: "chapter", action: "start", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "chapter", action: "complete", result: nil }]
      end

      def complete_seqence
        [{ type: "playback", action: "resume", result: nil },
         { type: "chapter", action: "start", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "playback", action: "complete", result: nil },
         { type: "chapter", action: "complete", result: nil }]
      end

      def ad_seqence
        [{ type: "ad", action: "start", result: nil },
         { type: "ad", action: "progress", result: nil },
         { type: "ad", action: "complete", result: nil }]
      end

      def seek_seqence
        [{ type: "playback", action: "progress", result: nil },
         { type: "playback", action: "seekStart", result: nil },
         { type: "playback", action: "seekStop", result: nil },
         { type: "playback", action: "resume", result: nil }]
      end

      def ad_pause_seqence
        [{ type: "ad", action: "start", result: nil },
         { type: "ad", action: "pauseStart", result: nil },
         { type: "ad", action: "progress", result: nil },
         { type: "ad", action: "pauseStop", result: nil },
         { type: "ad", action: "resume", result: nil },
         { type: "ad", action: "complete", result: nil }]
      end

      def palyback_pause_seqence
        [{ type: "playback", action: "resume", result: nil },
         { type: "chapter", action: "start", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "playback", action: "pauseStart", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "playback", action: "pauseStop", result: nil },
         { type: "playback", action: "resume", result: nil },
         { type: "playback", action: "progress", result: nil },
         { type: "chapter", action: "complete", result: nil }]
      end

      private

      def file_exist_request_path
        errors.add(:request_path, "File does not exist") unless File.exist?(request_path)
      end

      def file_exist_streaming_api_path
        errors.add(:streaming_api_path, "File does not exist") unless File.exist?(streaming_api_path)
      end
    end
  end
end
