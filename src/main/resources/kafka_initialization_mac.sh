#!/bin/bash

#Make sure that use installed kafka and zookeeper via home-brew:
# brew install kafka
# Also important:
# in the /usr/local/etc/kafka/server.properties use must have such line uncommented and changed - listeners=PLAINTEXT://localhost:9092

brew services restart zookeeper
brew services restart kafka

kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic electricity

kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic water_usage

kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic gas
