package com.saladbar.rinx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "goalies")
public class Goalie extends Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "shots_against")
    private int shotsAgainst;

    @Column(name = "saves")
    private int saves;

    @Column(name = "pim")
    private int pim;

    public Goalie() {}

    public Goalie(int memberId, int shotsAgainst, int saves) {
        this.memberId = memberId;
        this.shotsAgainst = shotsAgainst;
        this.saves = saves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(int memberId) {
//        this.memberId = memberId;
//    }

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
                "id=" + id +
                ", memberId=" + memberId +
                ", shotsAgainst=" + shotsAgainst +
                ", saves=" + saves +
                ", pim=" + pim +
                '}';
    }
}
