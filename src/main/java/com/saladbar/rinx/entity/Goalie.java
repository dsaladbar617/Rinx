package com.saladbar.rinx.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "goalies")
public class Goalie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "shots_against")
    private int shotsAgainst;

    @Column(name = "saves")
    private int saves;

    @Column(name = "pim")
    private int pim;

//    @ManyToOne
//    private Team team;

//    public Goalie() {}
//
//    public Goalie( int shotsAgainst, int saves) {
//        this.shotsAgainst = shotsAgainst;
//        this.saves = saves;
//    }

//    public int getShotsAgainst() {
//        return shotsAgainst;
//    }
//
//    public void setShotsAgainst(int shotsAgainst) {
//        this.shotsAgainst = shotsAgainst;
//    }
//
//    public int getSaves() {
//        return saves;
//    }
//
//    public void setSaves(int saves) {
//        this.saves = saves;
//    }
//
//    public int getPim() {
//        return pim;
//    }
//
//    public void setPim(int pim) {
//        this.pim = pim;
//    }

    @Override
    public String toString() {
        return "Goalie{" +
                "id=" + id +
                ", shotsAgainst=" + shotsAgainst +
                ", saves=" + saves +
                ", pim=" + pim +
                '}';
    }
}
