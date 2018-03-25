package com.barath.customer.app.controller;

import org.springframework.web.bind.annotation.*;

import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/")
	public String handleHome(){
		return "Welcome to Customer Application";
	}
	
	@PostMapping(value="/add")
	public String addCustomer(@RequestBody Customer customer){
		if(customer !=null){
			customerService.addCustomer(customer);
			return "Customer is added successfully";
		}
		return "Customer is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping(value="/get")
	public Customer getCustomer(@RequestParam("id") long customerId){
		
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping(value="/getCustomerByName")
	public Customer getCustomer(@RequestParam("name") String customerName){
		return customerService.getCustomer(customerName);
	}
	
	@PutMapping("/update")
	public String updateCustomer(){
		return "Welcome to Customer Application";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex){
		return ex.getMessage();
	}
	
	

}
