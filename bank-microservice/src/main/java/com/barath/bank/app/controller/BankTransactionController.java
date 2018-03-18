package com.barath.bank.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barath.bank.app.entity.Account;
import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.entity.Customer;
import com.barath.bank.app.entity.Account.AccountType;
import com.barath.bank.app.service.AccountService;
import com.barath.bank.app.service.BankService;
import com.barath.bank.app.service.CustomerService;

@RestController
public class BankTransactionController {
	
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/handleTransaction",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String handleTranscation(@RequestBody Map<String,Object> params){
		System.out.println("Request Params "+params);
		long customerId=((Number) params.get("customerId")).longValue();		
		String bankName=(String) params.get("bankName");
		String accountType=(String) params.get("accountType");
		long transactionAmount=((Number) params.get("transactionAmount")).longValue();
		if( !StringUtils.isEmpty(customerId) && !StringUtils.isEmpty(bankName) && !StringUtils.isEmpty(accountType) && !StringUtils.isEmpty(transactionAmount)){
			Customer customer=customerService.getCustomer(customerId);
			Bank bank=customer.getBank();
			System.out.println("bank details are "+ bank != null ? bank.toString() : bank);
			//Optional<Account> account =customer.getAccounts().stream().filter( acc -> acc.getAccountType().equals(accountType)).findFirst();
			List<Account> accounts =customer.getAccounts();
			for(Account custAccount: accounts){
				System.out.println("Condition check "+accountType.equals(AccountType.CURRENTACCOUNT));
				if(custAccount !=null ){					
					custAccount.setBalance(custAccount.getBalance()+transactionAmount);
					accountService.updateAccount(custAccount);
					return " Transcation is successfull";
				}
			}
		
		
		}
		return "Transcation is unsuccessful";
		
	}
	

	@RequestMapping(value="/handleFalseTransaction",method=RequestMethod.POST,produces="application/json")
	public String handleFalseTranscation(@RequestBody Map<String,Object> params){
		System.out.println("Request Params "+params);
		long customerId=((Number) params.get("customerId")).longValue();		
		String bankName=(String) params.get("bankName");
		String accountType=(String) params.get("accountType");
		long transactionAmount=((Number) params.get("transactionAmount")).longValue();
		if( !StringUtils.isEmpty(customerId) && !StringUtils.isEmpty(bankName) && !StringUtils.isEmpty(accountType) && !StringUtils.isEmpty(transactionAmount)){
			Customer customer=customerService.getCustomer(customerId);
			Bank bank=customer.getBank();
			System.out.println("bank details are "+ bank != null ? bank.toString() : bank);
			//Optional<Account> account =customer.getAccounts().stream().filter( acc -> acc.getAccountType().equals(accountType)).findFirst();
			List<Account> accounts =customer.getAccounts();
			for(Account custAccount: accounts){
				System.out.println("Condition check "+accountType.equals(AccountType.CURRENTACCOUNT));
				if(custAccount !=null ){					
					custAccount.setBalance(custAccount.getBalance()+transactionAmount);
					accountService.updateAccount(custAccount);
					return " Transcation is successfull";
				}
			}
		
		
		}
		return "Transcation is unsuccessful";
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex){
		return ex.getMessage();
	}

}
