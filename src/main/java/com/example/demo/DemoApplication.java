package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DemoApplication {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void testKafka() {
		producer.sendMessage("message sent to consumer 1!");
		producer.sendMessage("message sent to consumer 2!");
		producer.sendMessage("message sent to consumer 3!");
	}

}
