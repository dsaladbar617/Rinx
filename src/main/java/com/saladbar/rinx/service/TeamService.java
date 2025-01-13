package com.saladbar.rinx.service;

import com.saladbar.rinx.dto.TeamView;
import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.entity.Team;

import java.util.List;
import java.util.Set;

public interface TeamService {
    List<Team> findAll();
    Team findById(long id);
    Team save(Team team);
    void delete(Team team);
    TeamView addSkaterToTeam(long teamId, long skaterId);
    TeamView addGoalieToTeam(long teamId, long goalieId);
    Set<TeamView> findAllTeamView();
    TeamView findByIdTeamView(long id);
}
