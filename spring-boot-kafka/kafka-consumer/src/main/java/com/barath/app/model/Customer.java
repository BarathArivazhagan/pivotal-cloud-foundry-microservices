package com.barath.app.model;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 2664126733454805417L;

	private Long customerId;

    private String customerName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer(Long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Customer() {
    }
}
