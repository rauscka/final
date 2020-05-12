package com.example.finalproject.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.finalproject.interfaces.CartService;
import com.example.finalproject.objects.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private static Map<String, Cart> cartRepo = new HashMap<>();
    static {
        Cart cart = new Cart();
        cart.setCartId("44ef41f4-485b-44d6-8635-7418e026be89");
        cart.setCustomerId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f28");
        cartRepo.put(cart.getCartId(), cart);

        Cart cart2 = new Cart();
        cart2.setCartId("5581858f-a20e-4ada-9ccf-dd3e2cea0eb3");
        cart2.setCustomerId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f28");
        cartRepo.put(cart2.getCartId(), cart2);
    }
    @Override
    public void createCart(Cart cart) {
        cartRepo.put(cart.getCartId(), cart);
    }
    @Override
    public void updateCart(String id, Cart cart) {
        cartRepo.remove(id);
        cart.setCartId(id);
        cartRepo.put(id, cart);
    }
    @Override
    public void deleteCart(String id) {
        cartRepo.remove(id);

    }
    @Override
    public Collection<Cart> getCarts() {
        return cartRepo.values();
    }
    @Override
    public Cart getCart(String id){
        return cartRepo.get(id);
    }
}
