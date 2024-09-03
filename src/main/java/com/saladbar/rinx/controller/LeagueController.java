package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.League;
import com.saladbar.rinx.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LeagueController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueService.findAll();
    }

    @PostMapping("/leagues")
    public League createLeague(@RequestBody League league) {
        return leagueService.save(league);
    }
}
