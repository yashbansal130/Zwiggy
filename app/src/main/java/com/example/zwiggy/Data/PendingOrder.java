package com.example.zwiggy.Data;

public class PendingOrder {
    private String orderId;
    private String customerName;
    private int bill;

    public PendingOrder(String orderId, String customerName, int bill) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.bill = bill;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}

