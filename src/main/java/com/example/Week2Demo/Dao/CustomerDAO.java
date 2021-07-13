package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.Address;
import com.example.Week2Demo.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAll();
    void save(Address address);
    void saveCustomer(Customer customer);
    void updateNameandAddress(int id, String name, Address address);
    void listEmployee();
}
