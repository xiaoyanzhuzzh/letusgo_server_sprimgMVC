package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CartItemDao;
import com.thoughtworks.server.model.CartItem;

public interface CartItemService {
    CartItem getCartItemById(int id);

    void setCartItemDaoImpl(CartItemDao cartItemDaoImpl);
}
