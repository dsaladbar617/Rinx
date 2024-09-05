package com.saladbar.rinx.service;

import com.saladbar.rinx.repository.TeamRepository;
import com.saladbar.rinx.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

//    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

//    @Override
    public Team findById(int id) {
        return teamRepository.findById(id).orElse(null);
    }

//    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

//    @Override
    public void delete(Team team) {
        teamRepository.delete(team);
    }
}
