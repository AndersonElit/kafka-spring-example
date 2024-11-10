# kafka-spring-example

created the kafka image, run into kafka dir:
docker build -t kafka-ubuntu .

create kafka container:
docker run -d -p 9092:9092 --name kafka kafka-ubuntu

enter container:
docker exec -it kafka bash

create topic:
/usr/local/kafka/bin/kafka-topics.sh --create \
--bootstrap-server localhost:9092 \
--replication-factor 1 \
--partitions 1 \
--topic test-topic

producer, send message:
docker exec -it kafka bash -c 'echo "Hola!" | /usr/local/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test-topic'

consumer:
docker exec -it kafka /usr/local/kafka/bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic test-topic \
--from-beginning


