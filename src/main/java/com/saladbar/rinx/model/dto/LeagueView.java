package com.saladbar.rinx.model.dto;

import java.util.List;

public interface LeagueView {
    long getLeagueId();
    String getLeagueName();
    List<LeagueTeamView> getTeams();
}
