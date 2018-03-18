package com.barath.bank.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.bank.app.entity.Customer;
import com.barath.bank.app.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomer(@RequestBody Customer customer){
		if(customer !=null){
			customerService.addCustomer(customer);
			return "Customer is added successfully";
		}
		return "Customer is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping(value="/getCustomer")
	public Customer getCustomer(@RequestParam("id") long customerId){
		
		return customerService.getCustomer(customerId);
	}
	
	@RequestMapping(value="/getCustomerByName")
	public Customer getCustomer(@RequestParam("name") String customerName){
		return customerService.getCustomer(customerName);
	}
	
	@RequestMapping(value="/updateCustomer")
	public String updateCustomer(){
		return "Welcome to Customer Application";
	}
	
	@RequestMapping(value="/getCustomers")
	public List<Customer> findAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
