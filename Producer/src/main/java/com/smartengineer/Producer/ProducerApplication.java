package com.smartengineer.Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Bean
	CommandLineRunner sendMessage(RabbitTemplate rabbitTemplate,
								  @Value("${rabbitmq.exchange.name}") String exchange,
								  @Value("${rabbitmq.routing.key}") String routingKey) {
		return args -> {
			String message = "Hello from Producer!";
			rabbitTemplate.convertAndSend(exchange, routingKey, message);
			System.out.println("Message sent: " + message);
		};
	}

}
