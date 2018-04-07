package com.barath.customer.app.service;


import org.springframework.stereotype.Service;

import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.repository.CustomerRepository;

import java.util.Objects;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	

	public CustomerService(CustomerRepository customerRepository){
		this.customerRepository=customerRepository;
	}
	
	public Customer addCustomer(Customer customer){
		 return customerRepository.save(customer);
	}
	
	public Customer getCustomer(final long customerId){

		return customerRepository.findOne(customerId);

	}

	public Customer updateCustomer(Customer customer){

		return addCustomer(customer);
	}
	public void deleteCustomer(long customerId){

		customerRepository.delete(customerId) ;

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
		if(Objects.nonNull(customer)){
			return customerRepository.exists(customer.getCustomerId());
		}
		return false;
	}

	public Customer getCustomer(String customerName) {
		
		return customerRepository.findByCustomerName(customerName);
	}

	
	

}
