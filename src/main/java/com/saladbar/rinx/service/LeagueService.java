package com.saladbar.rinx.service;

import com.saladbar.rinx.dto.LeagueView;
import com.saladbar.rinx.dto.TeamDto;
import com.saladbar.rinx.entity.League;
import com.saladbar.rinx.entity.Team;

import java.util.List;
import java.util.Set;

public interface LeagueService {
    List<League> findAll();
    League findById(long id);
    League save(League league);
    void delete(League league);
    void addTeamToLeague(long leagueId, TeamDto team);
    Set<LeagueView> findAllLeagueViews();
    LeagueView findTeamViewById(long id);
}