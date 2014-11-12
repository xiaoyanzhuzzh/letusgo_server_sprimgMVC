package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CartItemDao;
import com.thoughtworks.server.dao.CartItemDaoImpl;
import com.thoughtworks.server.model.CartItem;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartItemServiceImplTest {
    CartItemDao cartItemDaoImpl;

    @Before
    public void mock_cartItemDaoImpl(){
        cartItemDaoImpl = mock(CartItemDaoImpl.class);

        int id = 1;
        CartItem cartItem = new CartItem(1, 1, 4);
        when(cartItemDaoImpl.getCartItemById(id)).thenReturn(cartItem);
    }
}
