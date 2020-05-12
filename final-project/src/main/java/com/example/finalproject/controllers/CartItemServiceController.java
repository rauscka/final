package com.example.finalproject.controllers;

import com.example.finalproject.interfaces.CartItemService;
import com.example.finalproject.objects.Cart;
import com.example.finalproject.objects.CartItem;
import com.example.finalproject.objects.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemServiceController {
    @Autowired
    CartItemService cartItemService;

    @RequestMapping(value = "/cartItems")
    public ResponseEntity<Object> getCartItems() {
        return new ResponseEntity<>(cartItemService.getCartItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/CartItems/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateCartItem(@PathVariable("id") String id, @RequestBody CartItem cartItem) {

        cartItemService.updateCartItem(id, cartItem);
        return new ResponseEntity<>("Cart Item is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/cartItems/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCartItems(@PathVariable("id") String id) {
        if(cartItemService.getCartItem(id) != null){
            return new ResponseEntity<>( cartItemService.getCartItem(id),HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cartItems/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCartItems(@PathVariable("id") String id) {
        cartItemService.deleteCartItem(id);
        return new ResponseEntity<>("Cart Item is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/cartItems", method = RequestMethod.POST)
    public ResponseEntity<Object> createCartItem(@RequestBody CartItem cartItem) {
        cartItemService.createCartItem(cartItem);
        return new ResponseEntity<>("Cart Item is created successfully", HttpStatus.CREATED);
    }
}
