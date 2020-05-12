package com.example.finalproject.controllers;

import com.example.finalproject.interfaces.CartService;
import com.example.finalproject.objects.Cart;
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
public class CartServiceController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = "/carts")
    public ResponseEntity<Object> getCarts() {
        return new ResponseEntity<>(cartService.getCarts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Carts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateCart(@PathVariable("id") String id, @RequestBody Cart cart) {

        cartService.updateCart(id, cart);
        return new ResponseEntity<>("Cart is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/carts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCart(@PathVariable("id") String id) {
        if(cartService.getCart(id) != null){
            return new ResponseEntity<>( cartService.getCart(id),HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/carts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCart(@PathVariable("id") String id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/carts", method = RequestMethod.POST)
    public ResponseEntity<Object> createCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
        return new ResponseEntity<>("Cart is created successfully", HttpStatus.CREATED);
    }
}

