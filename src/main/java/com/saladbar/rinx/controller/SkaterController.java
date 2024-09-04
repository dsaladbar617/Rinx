package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Player;
import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.service.PlayerService;
import com.saladbar.rinx.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SkaterController {

    @Qualifier("Skater")
    private final PlayerService skaterService;

    @Autowired
    public SkaterController(@Qualifier("Skater") PlayerService skaterService) {
        this.skaterService = skaterService;
    }

    @GetMapping("/skaters")
    public List<Player> getSkaters() {
        return skaterService.findAll();
    }

    @PostMapping("/skaters")
    public ResponseEntity<Player> addSkater(@RequestBody Skater skater) {
        Player savedSkater = skaterService.save(skater);
        return ResponseEntity.ok(savedSkater);
    }
}
