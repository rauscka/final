package com.example.finalproject.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.finalproject.interfaces.CustomerService;
import com.example.finalproject.objects.Cart;
import com.example.finalproject.objects.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Map<String, Customer> customerRepo = new HashMap<>();
    static {
        Customer customer = new Customer();
        customer.setCustomerId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f28");
        customer.setEmail("jason.bradley@drake.edu");
        customer.setFirstName("Jason");
        customer.setLastName("Bradley");
        customerRepo.put(customer.getCustomerId(), customer);
    }
    @Override
    public void createCustomer(Customer customer) {
        customerRepo.put(customer.getCustomerId(), customer);
    }
    @Override
    public void updateCustomer(String id, Customer customer) {
        customerRepo.remove(id);
        customer.setCustomerId(id);
        customerRepo.put(id, customer);
    }
    @Override
    public void deleteCustomer(String id) {
        customerRepo.remove(id);

    }
    @Override
    public Collection<Customer> getCustomers() {
        return customerRepo.values();
    }
    @Override
    public Customer getCustomer(String id){
        return customerRepo.get(id);
    }
}

