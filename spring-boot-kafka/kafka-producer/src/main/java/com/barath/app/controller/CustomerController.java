package com.barath.app.controller;

import com.barath.app.model.Customer;
import com.barath.app.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @GetMapping
    public List<Customer> getCustomer(){

        return customerService.getCustomers();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Optional<Customer> customerOptional){

        return  customerService.saveCustomer(customerOptional);
    }
}
