package com.example.finalproject.interfaces;

import com.example.finalproject.objects.Customer;

import java.util.Collection;

public interface CustomerService {
    public abstract void createCustomer(Customer customer);
    public abstract void updateCustomer(String id, Customer customer);
    public abstract void deleteCustomer(String id);
    public abstract Collection<Customer> getCustomers();
    public abstract Customer getCustomer(String id);
}

