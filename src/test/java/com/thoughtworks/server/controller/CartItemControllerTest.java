package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.CartItem;
import com.thoughtworks.server.model.Category;
import com.thoughtworks.server.model.Item;
import com.thoughtworks.server.service.CartItemService;
import com.thoughtworks.server.service.CartItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CartItemControllerTest {
    CartItem cartItem;
    List<CartItem> cartItems = new ArrayList<CartItem>();

    CartItemService cartItemServiceImpl;
    CartItemController cartItemController;

    @Before
    public void init_items(){
        Category category = new Category(1, "水果");
        Item item = new Item(1, "葡萄", 6.5, "斤", category);
        cartItem = new CartItem(1, item, 9);
        cartItems.add(cartItem);

        cartItemServiceImpl = mock(CartItemServiceImpl.class);

        int id =1;
        when(cartItemServiceImpl.getCartItemById(id)).thenReturn(cartItem);
        when(cartItemServiceImpl.getCartItems()).thenReturn(cartItems);

        cartItemController = new CartItemController();
        ReflectionTestUtils.setField(cartItemController, "cartItemServiceImpl", cartItemServiceImpl);
    }

    @Test
    public void can_get_cartItem_by_id(){
        assertEquals("葡萄", cartItemController.getCartItemById(1).getItem().getName());
    }

    @Test
    public void can_get_all_cartItems(){
        assertEquals(1, cartItemController.getCartItems().size());
    }

    @Test
    public void can_insert_cartItem(){
        cartItemController.insertCartItem(cartItem);
        verify(cartItemServiceImpl).insertCartItem(cartItem);
    }

    @Test
    public void can_update_cartItem_by_id(){
        cartItemController.updateCartItemById(cartItem);
        verify(cartItemServiceImpl).updateCartItemById(cartItem);
    }

    @Test
    public void can_delete_cartItem_by_id(){
        cartItemController.deleteCartItemById(1);
        verify(cartItemServiceImpl).deleteCartItemById(1);
    }
}
