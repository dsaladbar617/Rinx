package com.saladbar.rinx.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Override
    public String toString() {
        return "League{" +
                "id=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                '}';
    }
}
