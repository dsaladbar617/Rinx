package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Skater;

import java.util.List;

public interface SkaterService {
    List<Skater> findAll();
    Skater findById(int id);
    Skater save(int skaterId);
    void delete(Skater skater);
}
