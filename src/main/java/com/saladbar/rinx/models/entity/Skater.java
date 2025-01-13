package com.saladbar.rinx.models.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "skater")
@Table(name = "skaters")
public class Skater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long skaterId;

    @Column(name = "goals")
    private int goals = 0;

    @Column(name = "assists")
    private int assists = 0;

    @Column(name = "pim")
    private int pim = 0;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany(mappedBy = "skaters")
    private List<Team> teams;

    public Skater() {}

    public Skater(Member member) {
        this.member = member;
    }

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

    public Skater( int goals, int assists, int pim, Member member) {
        this.goals = goals;
        this.assists = assists;
        this.pim = pim;
        this.member = member;
    }

    public long getSkaterId() {
        return skaterId;
    }

    public void setSkaterId(long id) {
        this.skaterId = id;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPim() {
        return pim;
    }

    public void setPim(int pim) {
        this.pim = pim;
    }

    @Override
    public String toString() {
        return "Skater{" +
                "id=" + skaterId +
                ", member=" + member +
                ", goals=" + goals +
                ", assists=" + assists +
                ", pim=" + pim +
                '}';
    }

}
