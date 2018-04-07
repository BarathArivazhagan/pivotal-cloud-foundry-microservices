package com.barath.football.app;

import com.barath.football.app.document.Division;
import com.barath.football.app.service.DivisionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class FootballMicroserviceApplication {

	private DivisionService divisionService;

	public static void main(String[] args) {
		SpringApplication.run(FootballMicroserviceApplication.class, args);
	}


	public FootballMicroserviceApplication(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@PostConstruct
	public void init(){

		this.divisionService.addDivision(Mono.<Division>just(new Division(1L,"div2")));
	}
}
