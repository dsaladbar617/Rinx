package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "team")
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamId;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @ManyToMany
    @JoinTable(
            name = "teams_skaters",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "skater_id")
    )
    private List<Skater> skaters;

    @ManyToMany
    @JoinTable(
            name = "teams_goalies",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "goalie_id")
    )
    private List<Goalie> goalies;

    public Team() {}

    public Team( String name, League league) {
        this.teamName = name;
        this.league = league;
    }

    public Team(Builder builder) {
        this.teamId = builder.teamId;
        this.teamName = builder.teamName;
        this.league = builder.league;
        this.skaters = builder.skaters;
        this.goalies = builder.goalies;
    }

    public List<Goalie> getGoalies() {
        return goalies;
    }

    public void setGoalies(List<Goalie> goalies) {
        this.goalies = goalies;
    }

    public List<Skater> getSkaters() {
        return skaters;
    }

    public void setSkaters(List<Skater> skaters) {
        this.skaters = skaters;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long id) {
        this.teamId = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public static class Builder {
        private long teamId;
        private String teamName;
        private League league;
        private List<Skater> skaters;
        private List<Goalie> goalies;

        public Builder teamId(long id) {
            this.teamId = id;
            return this;
        }

        public Builder teamName(String name) {
            this.teamName = name;
            return this;
        }

        public Builder league(League league) {
            this.league = league;
            return this;
        }

        public Builder skaters(List<Skater> skaters) {
            this.skaters = skaters;
            return this;
        }

        public Builder goalies(List<Goalie> goalies) {
            this.goalies = goalies;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", league=" + league +
                '}';
    }
}
