# kafka-spring-example

created the kafka image, run into kafka dir:
docker build -t kafka-ubuntu .

create kafka container:
docker run -d -p 9092:9092 --name kafka kafka-ubuntu
