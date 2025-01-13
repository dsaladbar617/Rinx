package com.saladbar.rinx.league.service;

import com.saladbar.rinx.models.dto.LeagueView;
import com.saladbar.rinx.models.dto.TeamDto;
import com.saladbar.rinx.models.entity.Team;
import com.saladbar.rinx.league.repository.LeagueRepository;
import com.saladbar.rinx.models.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public League findById(long id) {
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

    @Override
    public void addTeamToLeague(long leagueId, TeamDto teamDto) {
        League league = leagueRepository.findById(leagueId).orElse(null);
        if (league == null) throw new RuntimeException("No League Found");
        Team team = new Team(teamDto.getTeamName(), league);
        league.getTeams().add(team);
        leagueRepository.save(league);
    }

    @Override
    public Set<LeagueView> findAllLeagueViews() {
        return leagueRepository.findAllBy();
    }

    @Override
    public LeagueView findTeamViewById(long id) {
        return leagueRepository.findByLeagueId(id);
    }
}
