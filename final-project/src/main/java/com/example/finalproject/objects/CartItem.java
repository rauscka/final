package com.example.finalproject.objects;

public class CartItem {
    private String cartId;
    private String CartItemId;
    private String itemId;
    private int quantity;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCartItemId() {
        return CartItemId;
    }

    public void setCartItemId(String cartItemId) {
        CartItemId = cartItemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
