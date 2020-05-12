package com.example.finalproject.controllers;

import com.example.finalproject.interfaces.ItemService;
import com.example.finalproject.objects.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemServiceController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items")
    public ResponseEntity<Object> getItems() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateItem(@PathVariable("id") String id, @RequestBody Item item) {

        itemService.updateItem(id, item);
        return new ResponseEntity<>("Item is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getItem(@PathVariable("id") String id) {
        if(itemService.getItem(id) != null){
            return new ResponseEntity<>( itemService.getItem(id),HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteItem(@PathVariable("id") String id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>("Item is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public ResponseEntity<Object> createItem(@RequestBody Item item) {
        itemService.createItem(item);
        return new ResponseEntity<>("Item is created successfully", HttpStatus.CREATED);
    }
}
