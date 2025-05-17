package com.saladbar.rinx.league.controller;

import com.saladbar.rinx.model.dto.LeagueView;
import com.saladbar.rinx.model.entity.League;
import com.saladbar.rinx.league.service.LeagueService;
import com.saladbar.rinx.util.UriBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@Tag(name = "League", description = "Handles league operations.")
public class LeagueController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/leagues")
    public ResponseEntity<Set<LeagueView>> getAllLeagues() {
        return ResponseEntity.ok(leagueService.findAllLeagueViews());
    }

    @GetMapping("/leagues/{id}")
    public ResponseEntity<LeagueView> getLeague(@PathVariable long id) {
//        return ResponseEntity.ok(leagueService.findTeamViewById(id));

        return leagueService.findTeamViewById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/leagues")
    public ResponseEntity<LeagueView> createLeague(@RequestBody League league) {
        League savedLeague = leagueService.save(league);
        return leagueService.findTeamViewById(savedLeague.getLeagueId())
                .map(leagueView -> ResponseEntity.created(UriBuilder.build(leagueView.getLeagueId())).body(leagueView))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/leagues/{id}")
    public ResponseEntity<Object> deleteLeague(@PathVariable long id) {
        Optional<League> league = leagueService.findById(id);
        league.ifPresent(leagueService::delete);
        return ResponseEntity.noContent().build();
    }
}
