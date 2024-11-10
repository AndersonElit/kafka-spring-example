# Use the latest Ubuntu image
FROM ubuntu:latest

# Set environment variables for Java and Kafka version
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV KAFKA_VERSION=3.9.0
ENV SCALA_VERSION=2.12

# Install necessary packages (OpenJDK, wget, nano, etc.)
RUN apt update && \
    apt install -y openjdk-17-jdk wget nano curl && \
    apt clean

# Install Kafka
RUN wget https://downloads.apache.org/kafka/${KAFKA_VERSION}/kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz && \
    tar -xvf kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz && \
    mv kafka_${SCALA_VERSION}-${KAFKA_VERSION} /usr/local/kafka && \
    rm kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz

# Update server.properties
RUN sed -i 's/^#listeners=PLAINTEXT:\/\/:9092/listeners=PLAINTEXT:\/\/0.0.0.0:9092/' /usr/local/kafka/config/server.properties && \
    sed -i 's/^#advertised.listeners=PLAINTEXT:\/\/your.host.name:9092/advertised.listeners=PLAINTEXT:\/\/localhost:9092/' /usr/local/kafka/config/server.properties

# Expose Kafka ports
EXPOSE 9092

# Set the default command to run Kafka and Zookeeper
CMD /usr/local/kafka/bin/zookeeper-server-start.sh /usr/local/kafka/config/zookeeper.properties & \
    /usr/local/kafka/bin/kafka-server-start.sh /usr/local/kafka/config/server.properties