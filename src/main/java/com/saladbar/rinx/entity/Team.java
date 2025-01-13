package com.saladbar.rinx.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
            name = "TeamsGoalies",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "goalie_id")
    )
    private List<Goalie> goalies;

    public Team() {}

    public Team( String name, League league) {
        this.teamName = name;
        this.league = league;
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", league=" + league +
                '}';
    }
}
