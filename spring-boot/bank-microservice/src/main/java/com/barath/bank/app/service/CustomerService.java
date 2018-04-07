package com.barath.bank.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.bank.app.entity.Customer;
import com.barath.bank.app.repository.CustomerRepository;



@Service
public class CustomerService {
	
	private CustomerRepository customerRep; 
	
	
	@Autowired
	public CustomerService(CustomerRepository customerRep){
		this.customerRep=customerRep;
	}
	
	public void addCustomer(Customer customer){
		customerRep.save(customer);
	}
	
	public Customer getCustomer(long customerId){
		Customer customer=null;
		if(customerRep.exists(customerId)){
			customer=customerRep.findOne(customerId);
		}
		
		return customer;
	}

	public void updateCustomer(Customer customer){
		if(isCustomerExists(customer)){
			customerRep.save(customer);
		}
	}
	public void deleteCustomer(long customerId){
		if(isCustomerExists(customerId)){
			customerRep.delete(customerId) ;
		}
	}
	public void deleteCustomer(Customer customer){
		if(isCustomerExists(customer)){
			customerRep.delete(customer) ;
		}
	}
	
	public boolean isCustomerExists(long customerId){
		return customerRep.exists(customerId);
	}
	
	public boolean isCustomerExists(Customer customer){
		if(customer != null){
			return customerRep.exists(customer.getCustomerId());
		}
		return false;
	}

	public Customer getCustomer(String customerName) {
		
		return customerRep.findByCustomerName(customerName);
	}

	public List<Customer> getAllCustomers() {
		
		return customerRep.findAll();
	}

	
	

}
