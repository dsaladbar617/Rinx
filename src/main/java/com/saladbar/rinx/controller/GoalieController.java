package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Goalie;
import com.saladbar.rinx.service.GoalieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GoalieController {

    private GoalieService goalieService;

    @Autowired
    public GoalieController(GoalieService goalieService) {
        this.goalieService = goalieService;
    }

    @GetMapping("/goalies")
    public List<Goalie> getGoalies() {
        return goalieService.findAll();
    }

    @PostMapping("/goalies")
    public Goalie addGoalie(@RequestBody Goalie goalie) {
        return goalieService.save(goalie);
    }
}
