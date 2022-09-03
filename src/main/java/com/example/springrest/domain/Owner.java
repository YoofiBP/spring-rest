package com.example.springrest.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerid;
    private String firstName, lastName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_owner", joinColumns = {@JoinColumn(name = "ownerid" )}, inverseJoinColumns = {@JoinColumn(name = "id" )})
    private Set<Car> cars = new HashSet<>();

    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Iterable<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public long getOwnerId() {
        return ownerid;
    }

    public void setOwnerId(long id) {
        this.ownerid = id;
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
}
