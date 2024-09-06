package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.League;
import com.saladbar.rinx.entity.Roster;

import java.util.List;

public interface RosterService {
    List<Roster> findAll();
    Roster findById(int id);
    Roster save(Roster roster);
    void delete(Roster roster);
}
