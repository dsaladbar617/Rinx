package com.saladbar.rinx.location.controller;

import com.saladbar.rinx.location.service.LocationService;
import com.saladbar.rinx.model.entity.Location;
import com.saladbar.rinx.util.UriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable long id) {
        Location location = locationService.findById(id);
        return ResponseEntity.ok(location);
    }

    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.save(location);
        return ResponseEntity.created(UriBuilder.build(savedLocation.getLocationId())).body(savedLocation);
    }

}
