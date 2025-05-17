package com.saladbar.rinx.model.entity;

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

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    public Rink() {
    }

    public Rink( int rinkNumber, String rinkName) {
        this.rinkNumber = rinkNumber;
        this.rinkName = rinkName;
    }

    public Rink(Builder builder) {
        this.rinkId = builder.rinkId;
        this.rinkNumber = builder.rinkNumber;
        this.rinkName = builder.rinkName;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class Builder {
        private long rinkId;
        private int rinkNumber;
        private String rinkName;

        public Builder rinkId(long id) {
            this.rinkId = id;
            return this;
        }

        public Builder rinkNumber(int num) {
            this.rinkNumber = num;
            return this;
        }

        public Builder rinkName(String name) {
            this.rinkName = name;
            return this;
        }

        public Rink build() {
            return new Rink(this);
        }
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
