package com.saladbar.rinx.league.service;

import com.saladbar.rinx.model.dto.LeagueView;
import com.saladbar.rinx.model.dto.TeamDto;
import com.saladbar.rinx.model.entity.League;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LeagueService {
    List<League> findAll();
    Optional<League> findById(long id);
    League save(League league);
    void delete(League league);
    void addTeamToLeague(long leagueId, TeamDto team);
    Set<LeagueView> findAllLeagueViews();
    Optional<LeagueView> findTeamViewById(long id);
    League updateLeague(League league);
}