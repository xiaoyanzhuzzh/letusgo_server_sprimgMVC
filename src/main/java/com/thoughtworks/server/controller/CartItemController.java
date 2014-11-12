package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.CartItem;
import com.thoughtworks.server.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartItemController {
    @Autowired
    private CartItemService cartItemServiceImpl;

    @RequestMapping(value = "/cartItems/{id}", method = RequestMethod.GET)
    public @ResponseBody
    CartItem getCartItemById(@PathVariable int id){
        return cartItemServiceImpl.getCartItemById(id);
    }

    @RequestMapping(value = "/cartItems", method = RequestMethod.GET)
    public @ResponseBody
    List<CartItem> getCartItems(){
        return cartItemServiceImpl.getCartItems();
    }

    @RequestMapping(value = "/cartItems", method = RequestMethod.POST)
    public void getCartItems(@RequestBody CartItem cartItem){
        cartItemServiceImpl.insertCartItem(cartItem);
    }
}
