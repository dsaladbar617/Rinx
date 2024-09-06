package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Roster;
import com.saladbar.rinx.repository.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RosterServiceImpl implements RosterService {

    private RosterRepository rosterRepository;

    @Autowired
    public RosterServiceImpl(RosterRepository rosterRepository) {
        this.rosterRepository = rosterRepository;
    }

    @Override
    public List<Roster> findAll() {
        return rosterRepository.findAll();
    }

    @Override
    public Roster findById(int id) {
        return rosterRepository.findById(id).orElse(null);
    }

    @Override
    public Roster save(Roster roster) {
        return rosterRepository.save(roster);
    }

    @Override
    public void delete(Roster roster) {
        rosterRepository.delete(roster);
    }
}
