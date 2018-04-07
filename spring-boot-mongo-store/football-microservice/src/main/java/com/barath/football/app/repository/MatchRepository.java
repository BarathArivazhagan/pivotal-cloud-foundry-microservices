package com.barath.football.app.repository;

import com.barath.football.app.document.Match;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
public interface MatchRepository extends ReactiveMongoRepository<Match,String> {

    Mono<Match> findByMatchId(Long matchId);
}
