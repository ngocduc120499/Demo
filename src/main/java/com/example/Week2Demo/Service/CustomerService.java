package com.example.Week2Demo.Service;

import com.example.Week2Demo.Dao.CustomerDAO;
import com.example.Week2Demo.model.Address;
import com.example.Week2Demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;
    @Autowired
    public CustomerService(@Qualifier("customerDAO") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public List<Customer> findAll(){
        return customerDAO.getAll();
    }
    public void saveAddress(Address address){
        customerDAO.save(address);

    }
    public void saveCustomer(Customer customer){
        customerDAO.saveCustomer(customer);
    }
    public void updateNameandAddress( int id, String name, Address address){
        customerDAO.updateNameandAddress(id, name, address);
    }

}
