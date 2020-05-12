package com.example.finalproject.interfaces;

import com.example.finalproject.objects.CartItem;

import java.util.Collection;

public interface CartItemService {
    public abstract void createCartItem(CartItem cartItem);
    public abstract void updateCartItem(String id, CartItem cartItem);
    public abstract void deleteCartItem(String id);
    public abstract Collection<CartItem> getCartItems();
    public abstract CartItem getCartItem(String id);
}
