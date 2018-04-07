package com.barath.bank.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.barath.bank.app.entity.Account;
import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.service.AccountService;


public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	
	@RequestMapping(value="/addAccount",method=RequestMethod.POST)
	public String addAccount(@RequestBody Account account){
		if(account !=null){
			accountService.addAccount(account);
			return "Account is added successfully";
		}
		return "Account is not  added successfully. Check the logs for error ";
	}
	
	
	@RequestMapping("/getAccount")
	public Account getAccount(@RequestParam("id") long accountId){
		
		return accountService.getAccount(accountId);
	}
	
	@RequestMapping(value="/getAccounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	

	
	@RequestMapping("/updateAccount")
	public String updateAccount(){
		return "Welcome to Account Application";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
