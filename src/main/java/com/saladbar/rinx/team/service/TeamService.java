package com.saladbar.rinx.team.service;

import com.saladbar.rinx.models.dto.TeamView;
import com.saladbar.rinx.models.entity.Team;

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
