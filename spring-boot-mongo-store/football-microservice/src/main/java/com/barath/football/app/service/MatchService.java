package com.barath.football.app.service;

import com.barath.football.app.document.Match;
import com.barath.football.app.repository.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

/**
 * Created by barath on 18/03/18.
 */
@Service
public class MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }



    public Mono<Match> saveMatchReportCard(Mono<Match> match){



         return   match.flatMap(this.matchRepository::save).log();

    }


    public Flux<Match> getMatches(){
        return matchRepository.findAll();
    }


}
