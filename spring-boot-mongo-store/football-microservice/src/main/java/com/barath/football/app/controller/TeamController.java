package com.barath.football.app.controller;

import com.barath.football.app.document.Team;
import com.barath.football.app.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by barath on 18/03/18.
 */
@RestController
@RequestMapping(value = "/team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/all")
    public Flux<Team> getTeams(){

        return teamService.getTeams();
    }
}
