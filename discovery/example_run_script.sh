#!/usr/bin/env bash
bundle exec rake clean_log_directories
bundle exec rake check_bs_builds
bundle exec rake get_affiliates
bundle exec rake wait_for_browserstack_sessions
bundle exec rake your_project:run_network[device_name, device_os_version, discovery]
bundle exec rake save_device_logs
bundle exec rake generate_report