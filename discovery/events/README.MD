# Events V2 Testing


##  Installation

1. Install RVM  (https://rvm.io/rvm/install)
2. Install Ruby 2.5.1 using RVM .
3. Install bundler : gem install bundler
4. Install gems in gemfile using : bundle install


## Scenarios

1. Scripted scenarios

	1. Long Form (lean back)
	2. Long Form: Scrub backward outside of chapter
	3. Long Form: Ad Clicked and Pause / Play
	4. Long Form: Scrub forward outside of segment
	5. Live : In content and Ad
	6. Long Form: Continue watching nth segment
	7. Long Form: Scrub backward inside of segment
	8. Long Form: Scrub forward inside of segment

2. Single schema based scenarios.	
	
	1. Playback Schema
	2. Session Schema
	3. Chapter Schema
	4. Ad Schema
	5. AdBreak Schema

	## Note: The above includes TODO scenarios also


## Types of test cases performed on scenarios

1. Next Sequence Testing
2. Verify Count Testing
3. Row based data validation testing
4. Buffer Logic Testing
5. Data Sequence Validation Testing

	
## How to run the script.

### Parameters required to run the script.
	
1.  FILE_PATH: 
	The QUERY with CSV Headers as mentioned in folowing section where script fetches the log file using athena.  OR
	A LOG FILE fetched using Athena with CSV Headers as mentioned, path to be assigned above.  	OR 
	A SESSION ID where the script fetches the log file using athena.		

	Following CSV Headers are required.

    **timestamp, type, payload_action, payload_playback_type, payload_stream_type, session_id, payload_asset_id, payload_break_index, version, payload_client_attributes_connection_type, payload_chapter_duration, payload_client_attributes_device_version, session_timer, payload_product_attributes_build_number, payload_client_attributes_browser_name, uuid, time_offset, payload_stream_timer, payload_video_id, payload_cast_type, payload_player_name, payload_content_id, payload_product_attributes_name, payload_break_type, payload_client_attributes_device_brand, payload_client_attributes_os_version, payload_client_attributes_type, payload_ad_index, payload_content_position, payload_ad_unit_id, payload_content_stream_type, payload_content_video_id, payload_chapter_index, payload_num_ads, payload_duration, payload_client_attributes_advertising_id, payload_stream_provider_session_id, payload_client_attributes_device_model, payload_client_attributes_browser_version, payload_client_attributes_device_manufacturer, payload_client_attributes_id, payload_product_attributes_version, payload_creative_id, payload_type, payload_destination, payload_stream_position, payload_client_attributes_os_name**

2. TESTCASE_NAME:
	
	Select a testcase scenario. Find the list from Scenarios section above.

### Steps to run the script.


1. Assign the aboves values to ENV variables(TESTCASE_NAME, FILE_PATH)
    
   ```bash
   export TESTCASE_NAME = "Long Form (lean back)"
   export FILE_PATH = "/home/path_of_log_file_for_lean_back"
   ```
   
2. Run Rake Task

   ```bash
   rake data_service_events:run_events_v2
   ```

3. Run with Rspec
   ```bash
   rspec events/spec/test_spec.rb
   ```

## How to add a new test case.

1. Open file events/v2/config.rb
2. Add the test_case in TEST_CASES array with following fileds.
	1. name:
	2. slug:
	3. covered_testcases:
	4. rules:
	5. verify_count: 
	6. presence check: and specific_check: are related to verify_count. They are optional.
	7. inside_segment: 
	8. stream_type: 
    9. video_count: 
    10. playback_type_count: 1,
    11. data_seq_cols: 	
    12. data_seq_collection_cols:
    13. timestamp_cols: 
3. Create a config_file in events/v2/configs/ as test_case_name.rb    
4. Add the rules for next_sequence and count check in the above file. (rules: , veifycount:)
5. Add coloumns to be tested in data sequencing validations. (data_seq_cols:, data_seq_collection_cols:, timestamp_cols:)
6. Others to be populated with relevent data as below. 
	a. inside_segment: boolean. true if the scenario is scrubbing inside segment else false.
	b. stream_type: string. vod or live.
	c. video_count: integer. Equals no of different video ids.
	d. playback_type_count: integer. Equals the no of different playback types occured.  
7. covered_testcases: array. Contains the testcases implemented for this scenario.	
8. Update the verify_count.rb with variables contained in configurations file test_case_name.rb.
9. Update the count_data_of_events method in test_runner.rb
10. Update any other incidentals. 