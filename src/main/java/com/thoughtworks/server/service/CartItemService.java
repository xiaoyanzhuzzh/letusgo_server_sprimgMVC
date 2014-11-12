package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CartItemDao;
import com.thoughtworks.server.model.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem getCartItemById(int id);

    void setCartItemDaoImpl(CartItemDao cartItemDaoImpl);

    List<CartItem> getCartItems();
}
