package com.thoughtworks.server.dao;


import com.thoughtworks.server.model.CartItem;

public interface CartItemDao {
    CartItem getCartItemById(int id);
}
