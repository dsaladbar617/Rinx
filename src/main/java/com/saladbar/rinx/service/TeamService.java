package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();
    Team findById(int id);
    Team save(Team team);
    void delete(Team team);
}
