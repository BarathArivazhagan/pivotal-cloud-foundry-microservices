package com.barath.football.app.repository;

import com.barath.football.app.entity.Match;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by barath on 18/03/18.
 */
public interface MatchRepository extends ReactiveMongoRepository<Match,Long> {
}
