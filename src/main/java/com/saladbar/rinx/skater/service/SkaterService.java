package com.saladbar.rinx.skater.service;

import com.saladbar.rinx.model.entity.Skater;

import java.util.List;

public interface SkaterService {
    List<Skater> findAll();
    Skater findById(long id);
    Skater save(Skater skater);
    void delete(Skater skater);
    Skater addSkaterToMember(long id);
}