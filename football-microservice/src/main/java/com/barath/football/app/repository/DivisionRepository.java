package com.barath.football.app.repository;

import com.barath.football.app.document.Division;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
public interface DivisionRepository extends ReactiveMongoRepository<Division,String> {

    Mono<Division> findByDivisionName(Mono<String> divisionName);
}
