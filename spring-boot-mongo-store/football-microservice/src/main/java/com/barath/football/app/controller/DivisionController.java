package com.barath.football.app.controller;

import com.barath.football.app.document.Division;
import com.barath.football.app.service.DivisionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
@RestController
@RequestMapping(value = "/division")
public class DivisionController {

    private DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(value="/create")
    public Mono<Division> createDivision(@RequestBody Mono<Division> division){

        return divisionService.addDivision(division);
    }

    @GetMapping(value = "/all")
    public Flux<Division> getDivisions(){

        return divisionService.getDivisions();
    }

    @GetMapping(value = "/byName/{name}")
    public Mono<Division> getDivisionByName(@PathVariable Mono<String> divisionName){

        return divisionService.getDivisionByDivisionName(divisionName);
    }
}
