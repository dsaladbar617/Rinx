package com.saladbar.rinx.team.controller;

import com.saladbar.rinx.model.dto.TeamDto;
import com.saladbar.rinx.model.dto.TeamView;
import com.saladbar.rinx.model.entity.Team;
import com.saladbar.rinx.league.service.LeagueService;
import com.saladbar.rinx.team.service.TeamService;
import com.saladbar.rinx.util.UriBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Team", description = "Handles team operations.")
public class TeamController {
    private final TeamService teamService;
    private final LeagueService leagueService;

    @Autowired
    public TeamController(TeamService teamService, LeagueService leagueService) {
        this.teamService = teamService;
        this.leagueService = leagueService;
    }

    @GetMapping("/teams")
    public ResponseEntity<Set<TeamView>> getTeams() {
        return ResponseEntity.ok(teamService.findAllTeamView());
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamView> createTeam(@RequestBody TeamDto teamDto) {
        leagueService.addTeamToLeague(teamDto.getLeagueId(), teamDto);
        Team savedTeam = teamService.save(new Team(teamDto.getTeamName(), null));
        TeamView teamView = teamService.findByIdTeamView(savedTeam.getTeamId());
        return ResponseEntity.created(UriBuilder.build(savedTeam.getTeamId())).body(teamView);
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
