package com.saladbar.rinx.skater.controller;

import com.saladbar.rinx.model.entity.Skater;
import com.saladbar.rinx.skater.service.SkaterService;
import com.saladbar.rinx.util.UriBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Skater", description = "Handles skater operations.")
public class SkaterController {

    private final SkaterService skaterService;

    @Autowired
    public SkaterController(SkaterService skaterService) {
        this.skaterService = skaterService;
    }

    @GetMapping("/skaters")
    public ResponseEntity<List<Skater>> getSkaters() {
        return ResponseEntity.ok(skaterService.findAll());
    }

    @PostMapping("/skaters")
    public ResponseEntity<Skater> addSkater(@RequestBody Skater skater) {
        Skater savedSkater = skaterService.save(skater);
        return ResponseEntity.created(UriBuilder.build(savedSkater.getSkaterId())).body(savedSkater);
    }

    @DeleteMapping("/skaters/{skaterId}")
    public ResponseEntity<String> removeSkater(@PathVariable int skaterId) {
        Skater skater = skaterService.findById(skaterId);
        skaterService.delete(skater);
        return ResponseEntity.ok("Deleted skater: " + skaterId);
    }
}
