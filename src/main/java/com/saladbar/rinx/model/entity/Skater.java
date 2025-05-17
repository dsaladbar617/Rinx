package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
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

    public Skater(Builder builder) {
        this.skaterId = builder.skaterId;
        this.goals = builder.goals;
        this.assists = builder.assists;
        this.pim = builder.pim;
        this.teams = builder.teams;
        this.member = builder.member;
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

    public static class Builder {
        private long skaterId;
        private int goals = 0;
        private int assists = 0;
        private int pim = 0;
        private List<Team> teams;
        private Member member;

        public Builder skaterId(long id) {
            this.skaterId = id;
            return this;
        }

        public Builder goals(int goals) {
            this.goals = goals;
            return this;
        }

        public Builder assists(int assists) {
            this.assists = assists;
            return this;
        }

        public Builder pim(int pim) {
            this.pim = pim;
            return this;
        }

        public Builder teams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Builder member(Member member) {
            this.member = member;
            return this;
        }

        public Skater build() {
            return new Skater(this);
        }
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
