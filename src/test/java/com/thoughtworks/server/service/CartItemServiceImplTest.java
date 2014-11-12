package com.thoughtworks.server.service;

import com.thoughtworks.server.dao.CartItemDao;
import com.thoughtworks.server.dao.CartItemDaoImpl;
import com.thoughtworks.server.model.CartItem;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CartItemServiceImplTest {
    CartItemDao cartItemDaoImpl;
    CartItemService cartItemServiceImpl;
    CartItem cartItem;

    @Before
    public void mock_cartItemDaoImpl(){
        cartItemDaoImpl = mock(CartItemDaoImpl.class);

        int id = 1;
        cartItem = new CartItem(1, 1, 4);
        when(cartItemDaoImpl.getCartItemById(id)).thenReturn(cartItem);

        cartItemServiceImpl = new CartItemServiceImpl();
        cartItemServiceImpl.setCartItemDaoImpl(cartItemDaoImpl);
    }

    @Test
    public void can_get_cartItem_by_id(){
        assertThat(cartItemServiceImpl.getCartItemById(1)).isEqualTo(cartItem);
        verify(cartItemDaoImpl).getCartItemById(1);
    }
}
