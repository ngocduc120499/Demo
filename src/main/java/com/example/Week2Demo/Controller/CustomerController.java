package com.example.Week2Demo.Controller;

import com.example.Week2Demo.Dao.CustomerDAO;
import com.example.Week2Demo.Service.CustomerService;
import com.example.Week2Demo.Service.ProductService;
import com.example.Week2Demo.model.Address;
import com.example.Week2Demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){

        return ResponseEntity.ok(customerService.findAll());
    }
    @PostMapping
    public void saveAddress(@RequestBody Address address){
        customerService.saveAddress(address);
    }
    @PostMapping(path = "/addcustomer")
    public void saveCustomer(@Valid @RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }
    @PutMapping(path = "{id}")
    public void putNA(@PathVariable int id, @RequestBody Customer customer){
        customer.setId(id);
        customerService.updateNameandAddress(customer.getId(), customer.getName(),customer.getAddress());
    }

}
