package com.musicstore.domain;
import java.util.*;

public class Customer {

    private int customerName;
    private String customerId;
    private String customerAddress;
    private String customerPhone;

    public List<Order> orderHistory;

    public Customer(int customerName, String customerId, String customerAddress, String customerPhone) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public int getCustomerName() {
        return customerName;
    }


    public String getCustomerId() {
        return customerId;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }


    public String getCustomerPhone() {
        return customerPhone;
    }

    public void viewOrders(){

        //show Orders from List: orderHistory

    }

    public void placeOrder(){
        //adds new Order to List: orderHistory
    }

    //ToDo: maybe implement a listener to changer the status of the order??

    public void cancelOrder(){
        //changes status of an order to canceled
    }

}
