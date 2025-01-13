package com.saladbar.rinx.controller;

import com.saladbar.rinx.dto.LeagueView;
import com.saladbar.rinx.entity.League;
import com.saladbar.rinx.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class LeagueController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/leagues")
    public Set<LeagueView> getAllLeagues() {
        return leagueService.findAllLeagueViews();
    }

    @GetMapping("/leagues/{id}")
    public LeagueView getLeague(@PathVariable long id) {
        return leagueService.findTeamViewById(id);
    }

    @PostMapping("/leagues")
    public LeagueView createLeague(@RequestBody League league) {
        League savedLeague = leagueService.save(league);
        return leagueService.findTeamViewById(savedLeague.getLeagueId());
    }

    @DeleteMapping("/leagues/{id}")
    public ResponseEntity<Object> deleteLeague(@PathVariable long id) {
        League league = leagueService.findById(id);
        leagueService.delete(league);
        return ResponseEntity.noContent().build();
    }
}
