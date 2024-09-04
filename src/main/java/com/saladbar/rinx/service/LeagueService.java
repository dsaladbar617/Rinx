package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.League;

import java.util.List;

public interface LeagueService {
    List<League> findAll();
    League findById(int id);
    League save(League league);
    void delete(League league);
}