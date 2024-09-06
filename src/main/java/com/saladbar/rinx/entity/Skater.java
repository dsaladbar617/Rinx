package com.saladbar.rinx.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "skater")
@Table(name = "skaters")
public class Skater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "pim")
    private int pim;

    @Override
    public String toString() {
        return "Skater{" +
                "id=" + id +
                ", goals=" + goals +
                ", assists=" + assists +
                ", pim=" + pim +
                '}';
    }

}
