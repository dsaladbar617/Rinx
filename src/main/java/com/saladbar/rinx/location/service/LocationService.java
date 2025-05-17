package com.saladbar.rinx.location.service;


import com.saladbar.rinx.model.entity.League;
import com.saladbar.rinx.model.entity.Location;
import com.saladbar.rinx.model.entity.Rink;

import java.util.List;

public interface LocationService {
    Location findById(long id);
    List<Location> findAll();
    Location save(Location location);
    void delete(Location location);
}
