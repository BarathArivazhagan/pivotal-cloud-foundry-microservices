package com.barath.app.model;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 1135548552630635709L;

	private Long orderId;

    private String productName;

    private String locationName;

    private int quantity;
    
    

    public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order(Long orderId, String productName, String locationName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.locationName = locationName;
        this.quantity = quantity;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
