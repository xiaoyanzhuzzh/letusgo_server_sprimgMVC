package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CartItemDao;
import com.thoughtworks.server.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDaoImpl;

    @Override
    public CartItem getCartItemById(int id) {
        return cartItemDaoImpl.getCartItemById(id);
    }

    @Override
    public void setCartItemDaoImpl(CartItemDao cartItemDaoImpl) {
        this.cartItemDaoImpl = cartItemDaoImpl;
    }
}
