package com.saladbar.rinx.models.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "goalies")
public class Goalie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long goalieId;

    @Column(name = "shots_against")
    private int shotsAgainst = 0;

    @Column(name = "saves")
    private int saves = 0;

    @Column(name = "pim")
    private int pim = 0;

    @ManyToMany(mappedBy = "goalies")
    private List<Team> teams;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Goalie() {}

    public Goalie(Member member) {
        this.member = member;
    }

    public Goalie(Member member, int shotsAgainst, int saves, int pim) {
        this.member = member;
        this.shotsAgainst = shotsAgainst;
        this.saves = saves;
        this.pim = pim;
    }

    public long getGoalieId() {
        return goalieId;
    }

    public void setGoalieId(long id) {
        this.goalieId = id;
    }

    public int getShotsAgainst() {
        return shotsAgainst;
    }

    public void setShotsAgainst(int shotsAgainst) {
        this.shotsAgainst = shotsAgainst;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getPim() {
        return pim;
    }

    public void setPim(int pim) {
        this.pim = pim;
    }

    @Override
    public String toString() {
        return "Goalie{" +
                "id=" + goalieId +
                ", member=" + member +
                ", shotsAgainst=" + shotsAgainst +
                ", saves=" + saves +
                ", pim=" + pim +
                '}';
    }
}
