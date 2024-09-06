package com.saladbar.rinx.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity(name = "Member")
@Data
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "date_joined")
    private Date dateJoined;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    private Skater skater;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
    private Goalie goalie;


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
