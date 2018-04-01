package com.barath.football.app.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barath.football.app.document.Referee;
import com.barath.football.app.repository.RefereeRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
@Service
public class RefereeService {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	    private final RefereeRepository refereeRepository;

	    public RefereeService(RefereeRepository refereeRepository) {
	        this.refereeRepository = refereeRepository;
	    }


	    public Mono<Referee> addReferee(Mono<Referee> playerMono){

	        return playerMono.doOnNext(refereeRepository::save).log();
	    }

	    public Flux<Referee> getReferees(){

	        return refereeRepository.findAll();
	    }

	    public Flux<Referee> getRefereesByRefereeName(Mono<String> playerName){

	        return refereeRepository.findByRefereeName(playerName);
	    }
}
