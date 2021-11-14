package com.example.zwiggy.Data;

public class OrderHistory {
    private String orderId;
    private String restaurantName;
    private int status;
    private int bill;

    public OrderHistory(String orderId, String restaurantName, int status, int bill) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.status = status;
        this.bill = bill;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
