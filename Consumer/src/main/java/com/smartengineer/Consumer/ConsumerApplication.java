package com.smartengineer.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void receiveMessage(String message) {
		System.out.println("Message received: " + message);
	}
}
