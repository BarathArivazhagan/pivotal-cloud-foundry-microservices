package com.barath.customer.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository){
		this.customerRepository=customerRepository;
	}
	
	public void addCustomer(Customer customer){
		customerRepository.save(customer);
	}
	
	public Customer getCustomer(final long customerId){
		Customer customer=null;
		if(customerRepository.exists(customerId)){
			customer=customerRepository.findOne(customerId);
		}
		
		return customer;
	}

	public void updateCustomer(Customer customer){
		if(isCustomerExists(customer)){
			customerRepository.save(customer);
		}
	}
	public void deleteCustomer(long customerId){
		if(isCustomerExists(customerId)){
			customerRepository.delete(customerId) ;
		}
	}
	public void deleteCustomer(Customer customer){
		if(isCustomerExists(customer)){
			customerRepository.delete(customer) ;
		}
	}
	
	public boolean isCustomerExists(long customerId){
		return customerRepository.exists(customerId);
	}
	
	public boolean isCustomerExists(Customer customer){
		if(customer != null){
			return customerRepository.exists(customer.getCustomerId());
		}
		return false;
	}

	public Customer getCustomer(String customerName) {
		
		return customerRepository.findByCustomerName(customerName);
	}

	
	

}
