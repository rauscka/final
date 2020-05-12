package com.example.finalproject.controllers;

import com.example.finalproject.interfaces.CustomerService;
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
public class CustomerServiceController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers")
    public ResponseEntity<Object> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {

        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>("Customer is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomer(@PathVariable("id") String id) {
        if(customerService.getCustomer(id) != null){
            return new ResponseEntity<>( customerService.getCustomer(id),HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }
}
