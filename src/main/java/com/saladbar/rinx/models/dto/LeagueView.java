package com.saladbar.rinx.models.dto;

import java.util.List;

public interface LeagueView {
    long getLeagueId();
    String getLeagueName();
    List<LeagueTeamView> getTeams();
}
