package com.saladbar.rinx.rink.controller;

import com.saladbar.rinx.model.dto.RinkDto;
import com.saladbar.rinx.model.entity.Rink;
import com.saladbar.rinx.rink.service.RinkService;
import com.saladbar.rinx.util.UriBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Rink", description = "Handles rink operations.")
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
        return ResponseEntity.created(UriBuilder.build(savedRink.getRinkId())).body(savedRink);
    }
}
