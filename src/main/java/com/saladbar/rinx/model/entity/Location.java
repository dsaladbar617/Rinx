package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

@Entity(name = "location")
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private long locationId;

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))
    })
    private Address address;

    @Column(name = "location_name")
    private String locationName;

    public Location() {}

    public Location(long locationId, Address address, String locationName) {
        this.locationId = locationId;
        this.address = address;
        this.locationName = locationName;
    }

    public Location(Builder builder) {
        this.locationId = builder.locationId;
        this.address = builder.address;
        this.locationName = builder.locationName;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public static class Builder {
        private long locationId;
        private Address address;
        private String locationName;

        public Builder locationId(long id) {
            this.locationId = id;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder locationName(String name) {
            this.locationName = name;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("locationId=").append(locationId);
        sb.append(", address=").append(address);
        sb.append(", locationName='").append(locationName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
