package com.example.springrest.domain;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand, color, model, registerNumber;
    private int yearMade, price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner" )
    private Owner owner;


    public Car(String brand, String model, String color, String registerNumber, int yearMade, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.yearMade = yearMade;
        this.price = price;
    }

    public Car() {

    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setYearMade(int year) {
        this.yearMade = year;
    }

    public int getYearMade() {
        return yearMade;
    }

    public int getPrice() {
        return price;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", yearMade=" + yearMade +
                ", price=" + price +
                '}';
    }
}
