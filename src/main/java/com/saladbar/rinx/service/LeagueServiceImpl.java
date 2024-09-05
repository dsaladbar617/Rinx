package com.saladbar.rinx.service;

import com.saladbar.rinx.repository.LeagueRepository;
import com.saladbar.rinx.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public List<League> findAll() {
        return leagueRepository.findAll();
    }

    @Override
    public League findById(int id) {
        return leagueRepository.findById(id).orElse(null);
    }

    @Override
    public League save(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public void delete(League league) {
        leagueRepository.delete(league);
    }
}
