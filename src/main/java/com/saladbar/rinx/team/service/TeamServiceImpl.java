package com.saladbar.rinx.team.service;

import com.saladbar.rinx.exception.ResourceNotFoundException;
import com.saladbar.rinx.model.dto.TeamView;
import com.saladbar.rinx.model.entity.Goalie;
import com.saladbar.rinx.model.entity.Skater;
import com.saladbar.rinx.goalie.service.GoalieService;
import com.saladbar.rinx.skater.service.SkaterService;
import com.saladbar.rinx.team.repository.TeamRepository;
import com.saladbar.rinx.model.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final SkaterService skaterService;
    private final GoalieService goalieService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, SkaterService skaterService, GoalieService goalieService) {
        this.teamRepository = teamRepository;
        this.skaterService = skaterService;
        this.goalieService = goalieService;
    }

//    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

//    @Override
    public Team findById(long id) {
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

    @Override
    public TeamView addSkaterToTeam(long teamId, long skaterId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Skater skater = skaterService.findById(skaterId);
        if (team.isEmpty()) throw new ResourceNotFoundException("No Team found");

        team.get().getSkaters().add(skater);
        Team savedTeam = teamRepository.save(team.get());
        return teamRepository.findTeamViewByTeamId(savedTeam.getTeamId());

    }

    @Override
    public TeamView addGoalieToTeam(long teamId, long goalieId) {
        Optional<Team> team = teamRepository.findById(teamId);
        Goalie goalie = goalieService.findById(goalieId);
        if (team.isEmpty()) throw new ResourceNotFoundException("No Team found");

        team.get().getGoalies().add(goalie);
        Team savedTeam = teamRepository.save(team.get());
        return teamRepository.findTeamViewByTeamId(savedTeam.getTeamId());
    }

    @Override
    public Set<TeamView> findAllTeamView() {
        return teamRepository.findAllBy();
    }

    @Override
    public TeamView findByIdTeamView(long id) {
        return teamRepository.findTeamViewByTeamId(id);
    }
}
