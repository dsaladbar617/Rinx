package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "league")
@Table(name = "leagues")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long leagueId;

    @Column(name = "league_name")
    private String leagueName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private List<Team> teams = new ArrayList<>();

    public League() {}

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public League(Builder builder) {
        this.leagueId = builder.leagueId;
        this.leagueName = builder.leagueName;
        this.teams = builder.teams;
    }

    public long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(long id) {
        this.leagueId = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public static class Builder {
        private long leagueId;
        private String leagueName;
        private List<Team> teams = new ArrayList<>();

        public Builder leagueId(long id) {
            this.leagueId = id;
            return this;
        }

        public Builder leagueName(String name) {
            this.leagueName = name;
            return this;
        }

        public Builder teams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public League build() {
            return new League(this);
        }

    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                '}';
    }
}
