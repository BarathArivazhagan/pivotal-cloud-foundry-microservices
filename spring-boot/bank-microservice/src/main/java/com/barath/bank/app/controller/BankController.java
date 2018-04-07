package com.barath.bank.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@RequestMapping("/")
	public String handleHome(){
		return "Welcome to Bank Application";
	}
	
	@RequestMapping(value="/addBank",method=RequestMethod.POST)
	public String addBank(@RequestBody Bank bank){
		if(bank !=null){
			bankService.addBank(bank);
			return "Bank is added successfully";
		}
		return "Bank is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping(value="/getBank")
	public Bank getBank(@RequestParam("id") long bankId){
		
		return bankService.getBank(bankId);
	}
	
	@RequestMapping(value="/getBankByName")
	public Bank getBank(@RequestParam("name") String bankName){
		return bankService.getBank(bankName);
	}
	
	@RequestMapping(value="/updateBank",method=RequestMethod.POST)
	public String updateBank(){
		return "Welcome to Bank Application";
	}
	
	@RequestMapping(value="/getBanks")
	public List<Bank> getAllBanks(){
		return bankService.getBanks();
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
