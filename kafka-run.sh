#!/bin/sh

docker run --rm --name zookeeper-sample -p 127.0.0.1:2181:2181  wurstmeister/zookeeper &

sleep 2

docker run --rm -it --name kafka-sample --network=host -e KAFKA_ZOOKEEPER_CONNECT=localhost:2181 -e KAFKA_LISTENERS=PLAINTEXT://:9092  wurstmeister/kafka

docker stop zookeeper-sample