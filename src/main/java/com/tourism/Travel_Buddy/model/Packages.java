package com.tourism.Travel_Buddy.model;

import jakarta.persistence.*;

@Entity
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;

    @Column(length = 10000)
    private String description;
    private float price;
    @Lob
    private String img;

    private int day;

    public Packages() {
    }

    public Packages(int id, String location, String description, float price, String img, int day) {
        this.id = id;
        this.location = location;
        this.description = description;
        this.price = price;
        this.img = img;
        this.day=day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Packages{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", day=" + day +
                '}';
    }
}
