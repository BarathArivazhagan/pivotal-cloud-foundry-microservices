package com.barath.bank.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT",schema="PCFSCHEMA")
public class Account {
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;
	
	
	@Column(name="ACCOUNT_TYPE")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@Column(name="BALANCE")
	private long balance;
	
	
	public Account(long accountNumber, AccountType accountType, Customer customer, long balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customer = customer;
		this.balance = balance;
	}









	public long getBalance() {
		return balance;
	}









	public void setBalance(long balance) {
		this.balance = balance;
	}









	public Account() {
		super();
		
	}









	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
	}









	public Account(long accountNumber, AccountType accountType, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customer = customer;
	}









	public long getAccountNumber() {
		return accountNumber;
	}









	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}









	public AccountType getAccountType() {
		return accountType;
	}









	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}









	public Customer getCustomer() {
		return customer;
	}









	public void setCustomer(Customer customer) {
		this.customer = customer;
	}









	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}









	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType != other.accountType)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}









	public enum AccountType{
		CURRENTACCOUNT,
		SAVINGSACCOUNT
		
	}

}
