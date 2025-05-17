package com.saladbar.rinx.goalie.controller;

import com.saladbar.rinx.model.entity.Goalie;
import com.saladbar.rinx.goalie.service.GoalieService;
import com.saladbar.rinx.util.UriBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Goalie", description = "Handles goalie operations.")
public class GoalieController {

    private final GoalieService goalieService;

    @Autowired
    public GoalieController(GoalieService goalieService) {
        this.goalieService = goalieService;
    }

    @GetMapping("/goalies")
    public ResponseEntity<List<Goalie>> getGoalies() {
        return ResponseEntity.ok(goalieService.findAll());
    }

    @PostMapping("/goalies")
    public ResponseEntity<Goalie> addGoalie(@RequestBody Goalie goalie) {
        Goalie savedGoalie = goalieService.save(goalie);
        return ResponseEntity.created(UriBuilder.build(savedGoalie.getGoalieId())).body(savedGoalie);
    }
}
