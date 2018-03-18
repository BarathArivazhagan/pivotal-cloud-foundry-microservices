package com.barath.football.app.repository;

import com.barath.football.app.document.Team;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by barath on 18/03/18.
 */
public interface TeamRepository  extends ReactiveMongoRepository<Team,Long>{

	Flux<Team> findByTeamName(Mono<String> teamName);
}
