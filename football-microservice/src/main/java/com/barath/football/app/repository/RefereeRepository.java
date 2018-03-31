package com.barath.football.app.repository;

import com.barath.football.app.document.Referee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by barath on 18/03/18.
 */
public interface RefereeRepository extends ReactiveMongoRepository<Referee,String> {

	Flux<Referee> findByRefereeName(Mono<String> refereeName);
}
