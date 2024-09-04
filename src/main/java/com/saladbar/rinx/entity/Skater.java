package com.saladbar.rinx.entity;

import jakarta.persistence.*;


@Entity(name = "skater")
@Table(name = "skaters")
public class Skater extends Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "pim")
    private int pim;

    @Column(name = "member_id")
    private int memberId;

    public Skater() {}

    public Skater(int memberId, int goals, int assists, int pim) {
        this.memberId = memberId;
        this.goals = goals;
        this.assists = assists;
        this.pim = pim;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
                "id=" + id +
                ", memberId=" + memberId +
                ", goals=" + goals +
                ", assists=" + assists +
                ", pim=" + pim +
                '}';
    }

}
