SCRUB_FORWARD_INSIDE_SEGMENT = [{ type: "session", payload_action: "start",
                                  next_seq: [{ type: "playback", payload_action: "playbackRequest" }] },
                                { type: "playback", payload_action: "playbackRequest",
                                  next_seq: [{ type: "playback", payload_action: "streamInitiate" }] },
                                { type: "playback", payload_action: "streamInitiate",
                                  next_seq: [{ type: "playback", payload_action: "start" }] },
                                { type: "playback", payload_action: "start",
                                  next_seq: [{ type: "chapter", payload_action: "start" }] },
                                { type: "chapter", payload_action: "start",
                                  next_seq: [{ type: "playback", payload_action: "progress" }] },
                                { type: "playback", payload_action: "progress",
                                  next_seq: [{ type: "chapter", payload_action: "complete" },
                                             { type: "playback", payload_action: "streamComplete" },
                                             { type: "playback", payload_action: "progress" },
                                             { type: "playback", payload_action: "stop" },
                                             { type: "playback", payload_action: "seekStart" },
                                             { type: "playback", payload_action: "pauseStart" },
                                             { type: "playback", payload_action: "pauseStop" }] },
                                { type: "playback", payload_action: "pauseStart",
                                  next_seq: [{ type: "playback", payload_action: "seekStart" },
                                             { type: "playback", payload_action: "progress" }] },
                                { type: "playback", payload_action: "seekStart",
                                  next_seq: [{ type: "playback", payload_action: "seekStop" }] },
                                { type: "playback", payload_action: "seekStop",
                                  next_seq: [{ type: "playback", payload_action: "resume" },
                                             { type: "playback", payload_action: "pauseStop" }] },
                                { type: "playback", payload_action: "pauseStop",
                                  next_seq: [{ type: "playback", payload_action: "resume" }] },
                                { type: "chapter", payload_action: "complete",
                                  next_seq: [{ type: "adBreak", payload_action: "start" },
                                             { type: "playback", payload_action: "complete" },
                                             { type: "playback", payload_action: "streamComplete" }] },
                                { type: "adBreak", payload_action: "start",
                                  next_seq: [{ type: "ad", payload_action: "start" }] },
                                { type: "ad", payload_action: "start",
                                  next_seq: [{ type: "ad", payload_action: "progress" }] },
                                { type: "ad", payload_action: "progress",
                                  next_seq: [{ type: "ad", payload_action: "complete" },
                                             { type: "ad", payload_action: "progress" },
                                             { type: "ad", payload_action: "pauseStop" }] },
                                { type: "ad", payload_action: "complete",
                                  next_seq: [{ type: "ad", payload_action: "start" },
                                             { type: "adBreak", payload_action: "complete" }] },
                                { type: "adBreak", payload_action: "complete",
                                  next_seq: [{ type: "playback", payload_action: "resume" }] },
                                { type: "playback", payload_action: "resume",
                                  next_seq: [{ type: "chapter", payload_action: "start" },
                                             { type: "playback", payload_action: "progress" }] },
                                { type: "playback", payload_action: "stop",
                                  next_seq: [{ type: "session", payload_action: "stop" }] }].freeze

VERIFYCOUNT_LF_SCRUB_FORWARD_INSIDE = [%i[session_start session_stop], %i[playback_start playback_stream_initiate],
                                       %i[ad_start ad_complete], %i[ad_break_start ad_break_complete],
                                       %i[playback_seekStart playback_seekStop], %i[chapter_start chapter_complete],
                                       %i[playback_pauseStart playback_pauseStop], %i[playback_resume sum_pausestop_seekstop_adbreak],
                                       %i[playback_playbackRequest playback_stream_initiate], %i[ad_buffer_start ad_buffer_stop],
                                       %i[playback_buffer_start playback_buffer_stop]].freeze

# [playback.resume = (playback.pausestop + playback.seekstop + adbreak.complete) = sum_pausestop_seekstop_adbreak]
