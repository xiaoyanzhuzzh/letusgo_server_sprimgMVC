package com.thoughtworks.server.model;

public class CartItemTest {
    private int id;
    private Item item;
    private int num;

    public CartItemTest() {
    }

    public CartItemTest(int id, Item item, int num) {
        this.id = id;
        this.item = item;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Item getItemId() {
        return item;
    }

    public void setItemId(Item item) {
        this.item = item;
    }
}
