package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

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

    public Member() {}

    public Member(String firstName, String lastName, String email, String memberPassword, Date dateJoined) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.memberPassword = memberPassword;
        this.dateJoined = new Date(System.currentTimeMillis());
    }

    public Member(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.memberPassword = builder.memberPassword;
        this.dateJoined = builder.dateJoined;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long id) {
        this.memberId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public static class Builder {
        private long memberId;
        private String firstName;
        private String lastName;
        private String email;
        private String memberPassword;
        private Date dateJoined;

        public Builder memberId(long id) {
            this.memberId = id;
            return this;
        }

        public Builder firstName(String name) {
            this.firstName = name;
            return this;
        }

        public Builder lastName(String name) {
            this.lastName = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder memberPassword(String password) {
            this.memberPassword = password;
            return this;
        }

        public Builder dateJoined(Date date) {
            this.dateJoined = date;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
