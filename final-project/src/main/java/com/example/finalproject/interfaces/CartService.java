package com.example.finalproject.interfaces;

import com.example.finalproject.objects.Cart;

import java.util.Collection;

public interface CartService {
    public abstract void createCart(Cart cart);
    public abstract void updateCart(String id, Cart cart);
    public abstract void deleteCart(String id);
    public abstract Collection<Cart> getCarts();
    public abstract Cart getCart(String id);
}
