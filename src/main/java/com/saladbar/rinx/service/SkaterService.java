package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Skater;

import java.util.List;

public interface SkaterService {
    List<Skater> findAll();
    Skater findById(long id);
    Skater save(Skater skater);
    void delete(Skater skater);
    Skater addSkaterToMember(long id);
}