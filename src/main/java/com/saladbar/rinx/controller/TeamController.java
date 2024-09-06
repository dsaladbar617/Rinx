package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Roster;
import com.saladbar.rinx.entity.Team;
import com.saladbar.rinx.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeamController {
    private TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team) {
//        Roster roster = new Roster();
        team.setRoster(new Roster());
        return teamService.save(team);
    }
}
