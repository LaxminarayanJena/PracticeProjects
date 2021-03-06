PLAYBACK_SCHEMA = [{ type: "playback", payload_action: "playbackRequest",
                     next_seq: [{ type: "playback", payload_action: "streamInitiate" }] },
                   { type: "playback", payload_action: "streamInitiate",
                     next_seq: [{ type: "playback", payload_action: "start" }] },
                   { type: "playback", payload_action: "progress",
                     next_seq: [{ type: "playback", payload_action: "progress" },
                                { type: "playback", payload_action: "streamComplete" },
                                { type: "playback", payload_action: "stop" },
                                { type: "playback", payload_action: "seekStart" },
                                { type: "playback", payload_action: "pauseStart" },
                                { type: "playback", payload_action: "pauseStop" }] },
                   { type: "playback", payload_action: "pauseStart",
                     next_seq: [{ type: "playback", payload_action: "progress" },
                                { type: "playback", payload_action: "seekStart" }] },
                   { type: "playback", payload_action: "seekStart",
                     next_seq: [{ type: "playback", payload_action: "seekStop" },
                                { type: "playback", payload_action: "pauseStart" }] },
                   { type: "playback", payload_action: "seekStop",
                     next_seq: [{ type: "playback", payload_action: "resume" },
                                { type: "playback", payload_action: "pauseStop" }] },
                   { type: "playback", payload_action: "pauseStop",
                     next_seq: [{ type: "playback", payload_action: "resume" }] },
                   { type: "playback", payload_action: "resume",
                     next_seq: [{ type: "playback", payload_action: "progress" }] }].freeze

VERIFYCOUNT_PLAYBACK_SCHEMA = [%i[playback_playbackRequest playback_stream_initiate],
                               %i[playback_start playback_stream_initiate],
                               %i[playback_seekStart playback_seekStop],
                               %i[playback_pauseStart playback_pauseStop]].freeze
