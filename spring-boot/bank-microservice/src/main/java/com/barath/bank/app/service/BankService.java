package com.barath.bank.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.repository.BankRepository;

@Service
public class BankService {
	
	private BankRepository bankRep; 
	
	
	@Autowired
	public BankService(BankRepository bankRep){
		this.bankRep=bankRep;
	}
	
	public void addBank(Bank bank){
		bankRep.save(bank);
	}
	
	public Bank getBank(long bankId){
		Bank bank=null;
		if(bankRep.exists(bankId)){
			bank=bankRep.findOne(bankId);
		}
		
		return bank;
	}

	public void updateBank(Bank bank){
		if(isBankExists(bank)){
			bankRep.save(bank);
		}
	}
	public void deleteBank(long bankId){
		if(isBankExists(bankId)){
			bankRep.delete(bankId) ;
		}
	}
	public void deleteBank(Bank bank){
		if(isBankExists(bank)){
			bankRep.delete(bank) ;
		}
	}
	
	public boolean isBankExists(long bankId){
		return bankRep.exists(bankId);
	}
	
	public boolean isBankExists(Bank bank){
		if(bank != null){
			return bankRep.exists(bank.getBankId());
		}
		return false;
	}

	public Bank getBank(String bankName) {
		
		return bankRep.findByBankName(bankName);
	}

	public List<Bank> getBanks() {
		
		return bankRep.findAll();
	}

	
	

}
