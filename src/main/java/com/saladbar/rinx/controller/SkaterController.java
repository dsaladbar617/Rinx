package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Skater;
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
    private final SkaterService skaterService;

    @Autowired
    public SkaterController(SkaterService skaterService) {
        this.skaterService = skaterService;
    }

    @GetMapping("/skaters")
    public List<Skater> getSkaters() {
        return skaterService.findAll();
    }

    @PostMapping("/skaters")
    public ResponseEntity<Skater> addSkater(@RequestBody Skater skater) {
        Skater savedSkater = skaterService.save(skater);
        return ResponseEntity.ok(savedSkater);
    }

    @DeleteMapping("/skaters/{skaterId}")
    public ResponseEntity<String> removeSkater(@PathVariable int skaterId) {
        Skater skater = skaterService.findById(skaterId);
        skaterService.delete(skater);
        return ResponseEntity.ok("Deleted skater: " + skaterId);
    }
}
