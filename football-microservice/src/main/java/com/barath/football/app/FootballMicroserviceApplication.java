package com.barath.football.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class FootballMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballMicroserviceApplication.class, args);
	}
}
