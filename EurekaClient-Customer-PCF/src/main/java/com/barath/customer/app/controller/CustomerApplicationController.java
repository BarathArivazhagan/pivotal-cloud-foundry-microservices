package com.barath.customer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.customer.app.model.Customer;
import com.barath.customer.app.service.CustomerService;

@RestController
public class CustomerApplicationController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String handleHome(){
		return "Welcome to Customer Application";
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public String addCustomer(@RequestBody Customer customer){
		if(customer !=null){
			customerService.addCustomer(customer);
			return "Customer is added successfully";
		}
		return "Customer is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("id") long customerId){
		
		return customerService.getCustomer(customerId);
	}
	
	@RequestMapping("/getCustomerByName")
	public Customer getCustomer(@RequestParam("name") String customerName){
		return customerService.getCustomer(customerName);
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(){
		return "Welcome to Customer Application";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
