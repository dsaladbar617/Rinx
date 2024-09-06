package com.saladbar.rinx.controller;

import com.saladbar.rinx.entity.Roster;
import com.saladbar.rinx.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RosterController {

    private RosterService rosterService;

    @Autowired
    public RosterController(RosterService rosterService) {
        this.rosterService = rosterService;
    }

    @PostMapping("/rosters")
    public Roster addRoster(@RequestBody Roster roster) {
        return rosterService.save(roster);
    }


}
