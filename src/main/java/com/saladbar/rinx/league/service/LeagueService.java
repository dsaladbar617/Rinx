package com.saladbar.rinx.league.service;

import com.saladbar.rinx.models.dto.LeagueView;
import com.saladbar.rinx.models.dto.TeamDto;
import com.saladbar.rinx.models.entity.League;

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