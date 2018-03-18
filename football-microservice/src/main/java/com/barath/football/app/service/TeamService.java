package com.barath.football.app.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barath.football.app.document.Team;
import com.barath.football.app.repository.TeamRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 18/03/18.
 */
@Service
public class TeamService {
	
	 private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	    private TeamRepository teamRepository;

	    public TeamService(TeamRepository teamRepository) {
	        this.teamRepository = teamRepository;
	    }


	    public Mono<Team> addTeam(Mono<Team> teamMono){

	        return teamMono.doOnNext(teamRepository::save).log();
	    }

	    public Flux<Team> getTeams(){

	        return teamRepository.findAll();
	    }

	    public Flux<Team> getTeamsByTeamName(Mono<String> teamName){

	        return teamRepository.findByTeamName(teamName);
	    }
}
