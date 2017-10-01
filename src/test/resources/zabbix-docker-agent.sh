#!/usr/bin/env bash

docker run  --name=dockbix-agent-xxl \
            --net=host \
            --privileged \
            -v /:/rootfs \
            -v /var/run:/var/run \
            --restart unless-stopped \
            -e "ZA_Server=devops-centos-01.aws.streaming-platform.com" \
            -e "ZA_ServerActive=devops-centos-01.aws.streaming-platform.com" \
            -d monitoringartist/dockbix-agent-xxl-limited:latest
