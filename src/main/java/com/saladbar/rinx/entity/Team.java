package com.saladbar.rinx.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity(name = "team")
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "league_id")
    private int leagueId;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
//    private List<Skater> skaters;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
//    private List<Goalie> goalies;

    @OneToOne( cascade = CascadeType.ALL)
    private Roster roster;

//    public Team() {}
//
//    public Team( String name, int leagueId) {
//        this.name = name;
//        this.leagueId = leagueId;
//    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getLeagueId() {
//        return leagueId;
//    }
//
//    public void setLeagueId(int leagueId) {
//        this.leagueId = leagueId;
//    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", leagueId=" + leagueId +
//                '}';
//    }
}
