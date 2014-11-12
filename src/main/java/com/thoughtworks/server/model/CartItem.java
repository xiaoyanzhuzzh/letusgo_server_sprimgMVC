package com.thoughtworks.server.model;

public class CartItem {
    private int id;
    private int itemId;
    private int num;

    public CartItem() {
    }

    public CartItem(int id, int itemId, int num) {
        this.id = id;
        this.itemId = itemId;
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
