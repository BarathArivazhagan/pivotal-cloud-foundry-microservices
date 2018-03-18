package com.barath.football.app.service;

import com.barath.football.app.entity.Division;
import com.barath.football.app.repository.DivisionRepository;
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
public class DivisionService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }


    public Mono<Division> addDivision(Mono<Division> divisionMono){

        return divisionMono.doOnNext(divisionRepository::save).log();
    }

    public Flux<Division> getDivisions(){

        return divisionRepository.findAll();
    }

    public Mono<Division> getDivisionByDivisionName(Mono<String> divisionName){

        return divisionRepository.findByDivisionName(divisionName);
    }
}
