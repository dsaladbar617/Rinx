package com.saladbar.rinx.location.service;

import com.saladbar.rinx.exception.ResourceNotFoundException;
import com.saladbar.rinx.location.repository.LocationRepository;
import com.saladbar.rinx.model.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location findById(long id) {
        Optional<Location> found = locationRepository.findById(id);
        if (found.isEmpty()) throw new ResourceNotFoundException("No Location found");
        return found.get();
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }
}
