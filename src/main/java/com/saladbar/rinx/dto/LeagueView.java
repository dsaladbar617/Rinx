package com.saladbar.rinx.dto;

import java.util.List;

public interface LeagueView {
    long getLeagueId();
    String getLeagueName();
    List<LeagueTeamView> getTeams();
}
