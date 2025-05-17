package com.saladbar.rinx.model.dto.test;

import com.saladbar.rinx.model.dto.LeagueTeamView;
import com.saladbar.rinx.model.dto.LeagueView;

import java.util.List;

public class LeagueViewTest implements LeagueView {
    private long leagueId;
    private String leagueName;
    private List<LeagueTeamView> teams;

    public LeagueViewTest () {}

    public LeagueViewTest(long leagueId, String leagueName, List<LeagueTeamView> teams) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.teams = teams;
    }

    public LeagueViewTest(Builder builder) {
        this.leagueId = builder.leagueId;
        this.leagueName = builder.leagueName;
        this.teams = builder.teams;
    }

    @Override
    public long getLeagueId() {
        return leagueId;
    }

    @Override
    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public List<LeagueTeamView> getTeams() {
        return teams;
    }

    public void setLeagueId(long leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setTeams(List<LeagueTeamView> teams) {
        this.teams = teams;
    }

    public static class Builder {
        private long leagueId;
        private String leagueName;
        private List<LeagueTeamView> teams;

        public Builder leagueId(long id) {
            this.leagueId = id;
            return this;
        }
        public Builder leagueName(String name) {
            this.leagueName = name;
            return this;
        }
        public Builder teams(List<LeagueTeamView> teams) {
            this.teams = teams;
            return this;
        }

        public LeagueViewTest build() {
            return new LeagueViewTest(this);
        }
    }
}
