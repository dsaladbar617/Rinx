package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.service.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SkaterController {

    private final SkaterService skaterService;

    @Autowired
    public SkaterController(SkaterService skaterService) {
        this.skaterService = skaterService;
    }

    @PostMapping("/skaters/{id}")
    public ResponseEntity<Skater> addSkater(@PathVariable int id) {
        return null;
    }
}
