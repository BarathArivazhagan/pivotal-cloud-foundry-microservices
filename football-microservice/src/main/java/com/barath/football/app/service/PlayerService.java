package com.barath.football.app.service;

import com.barath.football.app.document.Player;
import com.barath.football.app.document.Team;
import com.barath.football.app.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;

/**
 * Created by barath on 18/03/18.
 */
@Service
public class PlayerService {


    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Mono<Player> addPlayer(Mono<Player> playerMono){

        return playerMono.doOnNext(playerRepository::save).log();
    }

    public Flux<Player> getPlayers(){

        return playerRepository.findAll();
    }

    public Flux<Player> getPlayersByPlayerName(Mono<String> playerName){

        return playerRepository.findByPlayerName(playerName);
    }

    @PostConstruct
    public void init(){

        playerRepository.save(new Player(1L,"hello",new Team(1L,"team2")));
    }
}
