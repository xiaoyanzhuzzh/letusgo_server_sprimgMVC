package com.thoughtworks.server.model;

public class Item {
    private int id;
    private String name;
    private double price;
    private String unit;
    private int categoryId;

    public Item(int id, String name, double price, String unit, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
