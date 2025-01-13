package com.saladbar.rinx.controller;

import com.saladbar.rinx.dto.TeamDto;
import com.saladbar.rinx.dto.TeamView;
import com.saladbar.rinx.entity.Team;
import com.saladbar.rinx.service.LeagueService;
import com.saladbar.rinx.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class TeamController {
    private final TeamService teamService;
    private final LeagueService leagueService;

    @Autowired
    public TeamController(TeamService teamService, LeagueService leagueService) {
        this.teamService = teamService;
        this.leagueService = leagueService;
    }

    @GetMapping("/teams")
    public Set<TeamView> getTeams() {
        return teamService.findAllTeamView();
    }

    @PostMapping("/teams")
    public TeamView createTeam(@RequestBody TeamDto teamDto) {
        leagueService.addTeamToLeague(teamDto.getLeagueId(), teamDto);
        Team savedTeam = teamService.save(new Team(teamDto.getTeamName(), null));
        return teamService.findByIdTeamView(savedTeam.getTeamId());
    }

    @PutMapping("/teams/{teamId}/skaters/{skaterId}")
    public ResponseEntity<TeamView> addSkaterToTeam(@PathVariable long teamId, @PathVariable long skaterId) {
        TeamView team = teamService.addSkaterToTeam(teamId, skaterId);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/teams/{teamId}/goalies/{goalieId}")
    public ResponseEntity<TeamView> addGoalieToTeam(@PathVariable long teamId, @PathVariable long goalieId) {
        TeamView team = teamService.addGoalieToTeam(teamId, goalieId);
        return ResponseEntity.ok(team);
    }
}
