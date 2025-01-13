package com.saladbar.rinx.entity;

import jakarta.persistence.*;

@Entity(name = "rink")
@Table(name = "rinks")
public class Rink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rinkId;

    @Column(name = "rink_number")
    private int rinkNumber;

    @Column(name = "rink_name")
    private String rinkName;

    public Rink() {
    }

    public Rink( int rinkNumber, String rinkName) {
        this.rinkNumber = rinkNumber;
        this.rinkName = rinkName;
    }

    public long getRinkId() {
        return rinkId;
    }

    public void setRinkId(long id) {
        this.rinkId = id;
    }

    public int getRinkNumber() {
        return rinkNumber;
    }

    public void setRinkNumber(int number) {
        this.rinkNumber = number;
    }

    public String getRinkName() {
        return rinkName;
    }

    public void setRinkName(String name) {
        this.rinkName = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rink{");
        sb.append("rinkId=").append(rinkId);
        sb.append(", rinkNumber=").append(rinkNumber);
        sb.append(", rinkName='").append(rinkName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
