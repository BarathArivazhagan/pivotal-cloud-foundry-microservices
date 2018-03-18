package com.barath.football.app.repository;

import com.barath.football.app.document.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
public interface PlayerRepository extends ReactiveMongoRepository<Player,Long>{

    Flux<Player> findByPlayerName(Mono<String> playerName);
}
