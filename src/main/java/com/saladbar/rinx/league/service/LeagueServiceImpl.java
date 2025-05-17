package com.saladbar.rinx.league.service;

import com.saladbar.rinx.exception.ResourceNotFoundException;
import com.saladbar.rinx.model.dto.LeagueView;
import com.saladbar.rinx.model.dto.TeamDto;
import com.saladbar.rinx.model.entity.Team;
import com.saladbar.rinx.league.repository.LeagueRepository;
import com.saladbar.rinx.model.entity.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<League> findById(long id) {
        Optional<League> league = leagueRepository.findById(id);
        if (league.isEmpty()) throw new ResourceNotFoundException("League not found with the id: " + id);

        return league;
    }

    @Override
    public League save(League league) {
        Optional<League> checkLeague = leagueRepository.findByLeagueName(league.getLeagueName());

        if (checkLeague.isPresent()) throw new ResourceNotFoundException("A league already exists with name: " + league.getLeagueName());

        return leagueRepository.save(league);
    }

    @Override
    public void delete(League league) {
        leagueRepository.delete(league);
    }

    @Override
    public void addTeamToLeague(long leagueId, TeamDto teamDto) {
        League league = leagueRepository.findById(leagueId).orElse(null);
        if (league == null) throw new ResourceNotFoundException("No League Found");
        Team team = new Team(teamDto.getTeamName(), league);
        league.getTeams().add(team);
        leagueRepository.save(league);
    }

    @Override
    public Set<LeagueView> findAllLeagueViews() {
        return leagueRepository.findAllBy();
    }

    @Override
    public Optional<LeagueView> findTeamViewById(long id) {
        return leagueRepository.findByLeagueId(id);
    }

    @Override
    public League updateLeague(League updatedLeague) {
        return leagueRepository.save(updatedLeague);
    }
}
