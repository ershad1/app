package com.data.app.server.entity.reservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
    private String firstName;
    private String lastName;
    @Id
    @GeneratedValue
    private Long id;

    public Reservation(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Reservation(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Reservation() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
