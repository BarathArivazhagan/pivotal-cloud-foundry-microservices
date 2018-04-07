package com.barath.app.service;

import com.barath.app.event.CustomerSaveEvent;
import com.barath.app.exception.CustomerExists;
import com.barath.app.model.Customer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private Map<Long,Customer> customerMap = new HashMap<>(5);

    private ApplicationEventPublisher eventPublisher;

    public CustomerService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher=eventPublisher;
    }

    public Customer saveCustomer(Optional<Customer> customerOptional){

        if(!customerOptional.isPresent()) throw new CustomerExists("customer already exists");
        Customer customer=customerOptional.get();
        eventPublisher.publishEvent(new CustomerSaveEvent(customer));
        return customerMap.putIfAbsent(customer.getCustomerId(),customer);
    }

    public List<Customer> getCustomers(){

        return customerMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

}
