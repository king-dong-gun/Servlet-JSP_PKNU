package com.example.servlet.day06;

public class Product {
    private String id;
    private String name;
    private double price;
    private String maker;
    private String date;

    public Product(String id, String name, double price, String maker, String date) {
        // 생성자
        this.id = id;
        this.name = name;
        this.price = price;
        this.maker = maker;
        this.date = date;
    }
    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    public String getDate() {
        return date;
    }
}
