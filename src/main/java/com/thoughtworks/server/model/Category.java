package com.thoughtworks.server.model;

public class Category {
    private int id;
    private String name;
    private int numberOfItem;

    public Category() {
    }

    public Category(int id, String name, int numberOfItem) {
        this.id = id;
        this.name = name;
        this.numberOfItem = numberOfItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
