package com.barath.bank.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BANK",schema="PCFSCHEMA")
public class Bank {
	
	@Id
	@Column(name="BANK_ID")
	private long bankId;
	
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="bank")
	private List<Customer> customers;
	
	


	public Bank(long bankId, String bankName, List<Customer> customers) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.customers = customers;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public long getBankId() {
		return bankId;
	}


	public void setBankId(long bankId) {
		this.bankId = bankId;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bankId ^ (bankId >>> 32));
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
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
		Bank other = (Bank) obj;
		if (bankId != other.bankId)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}


	public Bank() {
		super();
		
	}


	public Bank(long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	
	
	

}
