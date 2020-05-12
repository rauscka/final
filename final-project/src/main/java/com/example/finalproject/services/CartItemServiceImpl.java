package com.example.finalproject.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.finalproject.interfaces.CartItemService;
import com.example.finalproject.objects.Cart;
import com.example.finalproject.objects.CartItem;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private static Map<String, CartItem> cartItemRepo = new HashMap<>();
    static {
        CartItem cartItem = new CartItem();
        cartItem.setCartId("44ef41f4-485b-44d6-8635-7418e026be89");
        cartItem.setCartItemId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f28");
        cartItem.setItemId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f29");
        cartItem.setQuantity(2);
        cartItemRepo.put(cartItem.getCartId(), cartItem);
    }
    @Override
    public void createCartItem(CartItem cartItem) {
        cartItemRepo.put(cartItem.getCartItemId(), cartItem);
    }
    @Override
    public void updateCartItem(String id, CartItem cartItem) {
        cartItemRepo.remove(id);
        cartItem.setCartId(id);
        cartItemRepo.put(id, cartItem);
    }
    @Override
    public void deleteCartItem(String id) {
        cartItemRepo.remove(id);

    }
    @Override
    public Collection<CartItem> getCartItems() {
        return cartItemRepo.values();
    }
    @Override
    public CartItem getCartItem(String id){
        return cartItemRepo.get(id);
    }
}
