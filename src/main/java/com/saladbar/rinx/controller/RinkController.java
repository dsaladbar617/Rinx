package com.saladbar.rinx.controller;

import com.saladbar.rinx.dto.RinkDto;
import com.saladbar.rinx.entity.Rink;
import com.saladbar.rinx.service.RinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RinkController {

    private final RinkService rinkService;

    @Autowired
    public RinkController(RinkService rinkService) {
        this.rinkService = rinkService;
    }

    @GetMapping("rinks")
    public ResponseEntity<List<Rink>> getRinks() {
        List<Rink> rinks = rinkService.findAll();
        return ResponseEntity.ok(rinks);
    }

    @GetMapping("rinks/{rinkId}")
    public ResponseEntity<Rink> getRinks(@PathVariable long rinkId) {
        Rink rink = rinkService.findById(rinkId);
        return ResponseEntity.ok(rink);
    }

    @PostMapping("/rinks")
    public ResponseEntity<Rink> createRink(@RequestBody RinkDto rink) {
        Rink rinkToSave = new Rink(rink.getRinkNumber(), rink.getRinkName());
        Rink savedRink = rinkService.save(rinkToSave);
        return ResponseEntity.ok(savedRink);
    }
}
