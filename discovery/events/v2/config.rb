# TEST_CASES constant Array, config the values for running test cases.
# slug should be the method name for the appropriate test case. to call the dynamically.

require_relative "./configs/generic_case"
require_relative "./configs/long_form_lean_back"
require_relative "./configs/long_form_scrub_backward_outside_chapter"
require_relative "./configs/scrub_fwd_outside_seg"
require_relative "./configs/ad_clicked_pause_or_play"
require_relative "./configs/live_in_content_or_ad"
require_relative "./configs/long_form_continue_watching_nth_segment"
require_relative "./configs/long_form_scrub_backward_inside_segment"
require_relative "./configs/long_form_scrub_forward_inside_segment"
require_relative "./configs/playback_schema_validation"

# convered schemas
TYPES_OF_SCHEMA = %w[playback chapter adBreak ad session].freeze

# Types of testcases
TYPES_OF_TESTCASES = %w[NextSequence RowDataValidation VerifyCount BufferEvents DataSequenceValidation].freeze

VERIFYCOUNT_PRESENCE_CHECK = [%i[session_start session_stop], %i[playback_seekStart playback_seekStop],
                              %i[ad_pauseStart ad_resume], %i[ad_pauseStart ad_pauseStop]].freeze
VERIFYCOUNT_SPECIFIC_CHECK = [%i[session_start session_stop], %i[playback_start playback_stream_initiate],
                              %i[playback_start playback_stop]].freeze

DATA_SEQ_VALIDATIONS_COLS = %w[payload_stream_timer
                               payload_stream_position
                               payload_break_index
                               payload_chapter_index
                               payload_ad_index
                               payload_content_position].freeze

DATA_SEQ_COLLECTION_COLS = %w[uuid session_id payload_video_id payload_playback_is_paused
                              payload_stream_type payload_duration playback_type stream_provider_session_id].freeze

TIMESTAMP_COLUMNS = %w[payload_playback_progress payload_ad_progress].freeze

ALL_COLUMNS = DATA_SEQ_VALIDATIONS_COLS + TIMESTAMP_COLUMNS

# Types of covered test scenarios
TEST_CASES = [{ name: "Long Form (lean back)",
                slug: "long_form_lean_back", rules: LF_LEAN_BACK,
                covered_testcases: TYPES_OF_TESTCASES,
                verify_count: VERIFYCOUNT,
                presence_check: [],
                inside_segment: false,
                stream_type: "vod",
                video_count: 2,
                playback_type_count: 2,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Scrub backward outside of chapter",
                slug: "long_form_scrub_backward_outside_chapter",
                seek_start_segment: 3, seek_start_end: 1, rules: LF_SCRUB_BACKWARD,
                covered_testcases: %w[NextSequence RowDataValidation VerifyCount BufferEvents DataSequenceValidation],
                verify_count: VERIFYCOUNT_LF_SCRUB_BACK_OUTSIDE,
                presence_check: VERIFYCOUNT_PRESENCE_CHECK,
                inside_segment: false,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Ad Clicked and Pause / Play",
                slug: "ad_clicked_pause_or_play",
                ad_clicked: { adbreak: 1, ad: 2 },
                video_cliecked: { segment: 2 }, rules: LF_AD_CLICKED_PAUSE_PLAY,
                covered_testcases: %w[NextSequence RowDataValidation VerifyCount BufferEvents DataSequenceValidation],
                verify_count: VERIFYCOUNT_AD_PAUSE_PLAY,
                presence_check: VERIFYCOUNT_PRESENCE_CHECK,
                inside_segment: false,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Scrub forward outside of segment",
                slug: "scrub_fwd_outside_seg", rules: LF_SCRUB_FORWARD,
                covered_testcases: %w[NextSequence RowDataValidation VerifyCount BufferEvents DataSequenceValidation],
                verify_count: VERIFYCOUNT_LF_SCRUB_FORWARD_OUTSIDE,
                presence_check: VERIFYCOUNT_PRESENCE_CHECK,
                inside_segment: false,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Generic case",
                slug: "generic_case", rules: GENERIC,
                covered_testcases: %w[NextSequence RowDataValidation BufferEvents] },
              { name: "Live : In content and Ad",
                slug: "live_in_content_or_ad", rules: LIVE,
                covered_testcases: %w[NextSequence VerifyCount DataSequenceValidation],
                verify_count: VERIFYCOUNT_LIVE,
                presence_check: VERIFYCOUNT_PRESENCE_CHECK,
                inside_segment: false,
                stream_type: "live",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Continue watching nth segment",
                slug: "long_form_continue_watching_nth_segment", rules: LF_CONTINUE_WATCHING_NTH_SEGMENT,
                covered_testcases: %w[NextSequence VerifyCount DataSequenceValidation],
                verify_count: VERIFYCOUNT_LF_CONT_WATCH_NTH_SEG,
                specific_check: VERIFYCOUNT_SPECIFIC_CHECK,
                inside_segment: false,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Scrub backward inside of segment",
                slug: "long_form_scrub_backward_inside_segment", rules: SCRUB_BACK_INSIDE_SEGMENT,
                covered_testcases: %w[NextSequence VerifyCount DataSequenceValidation],
                verify_count: VERIFYCOUNT_LF_SCRUB_BACKWARD_INSIDE,
                inside_segment: true,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Long Form: Scrub forward inside of segment",
                slug: "long_form_scrub_forward_inside_segment", rules: SCRUB_FORWARD_INSIDE_SEGMENT,
                covered_testcases: %w[NextSequence VerifyCount DataSequenceValidation],
                verify_count: VERIFYCOUNT_LF_SCRUB_FORWARD_INSIDE,
                inside_segment: true,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: DATA_SEQ_VALIDATIONS_COLS,
                data_seq_collection_cols: DATA_SEQ_COLLECTION_COLS,
                timestamp_cols: TIMESTAMP_COLUMNS },
              { name: "Playback Schema",
                slug: "playback_schema_validation", rules: PLAYBACK_SCHEMA,
                covered_testcases: %w[NextSequence VerifyCount DataSequenceValidation],
                verify_count: VERIFYCOUNT_PLAYBACK_SCHEMA,
                inside_segment: false,
                stream_type: "vod",
                video_count: 1,
                playback_type_count: 1,
                data_seq_cols: %w[payload_stream_timer payload_content_position],
                data_seq_collection_cols: %w[stream_provider_session_id payload_stream_type],
                timestamp_cols: %w[payload_playback_progress] }].freeze

SEEK_BACK_DEC = %w[payload_content_position payload_stream_position payload_break_index payload_chapter_index].freeze

PLAYBACK_SEC = { start_at: 5, end_at: 15 }.freeze
AD_SEC = { start_at: 0, end_at: 3 }.freeze

PLAYBACK_TYPES = %w[userInitiated continuous].freeze

SCRUB_SCENARIOS = %w[long_form_scrub_backward_outside_chapter scrub_fwd_outside_seg
                     long_form_scrub_backward_inside_segment long_form_scrub_forward_inside_segment].freeze

EVENTS_SQL = "select timestamp as timestamp,type as type
                    ,coalesce(payload.action,null)  as payload_action
                    ,coalesce(payload.playbackType, null) as payload_playback_type
                    ,payload.streamType as payload_stream_type
                    ,sessionid as session_id
                    ,payload.assetId as payload_asset_id
                    ,payload.breakIndex as payload_break_index
                    ,version as version
                    ,payload.clientattributes.connectionType as payload_client_attributes_connection_type
                    ,payload.chapterDuration as payload_chapter_duration
                    ,payload.clientAttributes.device.version as payload_client_attributes_device_version
                    ,sessionTimer as session_timer
                    ,payload.productAttributes.buildNumber as payload_product_attributes_build_number
                    ,payload.clientAttributes.browser.name as payload_client_attributes_browser_name
                    ,uuid as uuid
                    ,timeOffset as time_offset
                    ,payload.streamTimer as payload_stream_timer
                    ,payload.videoId as payload_video_id
                    ,payload.castType as payload_cast_type
                    ,payload.playerName as payload_player_name
                    ,payload.content.videoId as payload_content_id
                    ,payload.productAttributes.name as payload_product_attributes_name
                    ,payload.breakType as payload_break_type
                    ,payload.clientAttributes.device.brand as payload_client_attributes_device_brand
                    ,payload.clientAttributes.os.version as payload_client_attributes_os_version
                    ,payload.clientattributes.type as payload_client_attributes_type
                    ,payload.adIndex as payload_ad_index
                    ,payload.contentPosition as payload_content_position
                    ,payload.adUnitId as payload_ad_unit_id
                    ,payload.content.streamType as payload_content_stream_type
                    ,payload.content.videoId as payload_content_video_id
                    ,payload.chapterIndex as payload_chapter_index
                    ,payload.numAds as payload_num_ads
                    ,payload.chapterDuration as payload_duration
                    ,payload.clientattributes.advertisingid as payload_client_attributes_advertising_id
                    ,payload.streamProviderSessionId as payload_stream_provider_session_id
                    ,payload.clientAttributes.device.model as payload_client_attributes_device_model
                    ,payload.clientAttributes.browser.version as payload_client_attributes_browser_version
                    ,payload.clientAttributes.device.manufacturer as payload_client_attributes_device_manufacturer
                    ,payload.clientattributes.id as payload_client_attributes_id
                    ,payload.productAttributes.version as payload_product_attributes_version
                    ,payload.creativeId as payload_creative_id
                    ,payload.type as payload_type
                    ,payload.destination as payload_destination
                    ,payload.streamPosition as payload_stream_position
                    ,payload.clientAttributes.os.name as payload_client_attributes_os_name
                    ,payload.ispaused as payload_playback_is_paused
                    FROM events
                    where type not in ('beacon','interaction','browse','authentication')
                    and sessionid = '%<session_id>s'
                    and dt BETWEEN '%<start_date>s' AND '%<end_date>s'
                    order by timestamp asc".freeze
