package com.musicstore.domain;

import java.util.HashMap;
import java.util.List;



//ToDo: multithreading on making order

public class Order {

    private int orderId;
    private Customer customer;
    private String orderStatus; //pending, canceled, finished
    private HashMap<AbstractProduct, Integer> itemMap; //item, qty
    private int totalPrice;

    public Order(int orderId, Customer customer, String orderStatus) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderStatus = orderStatus;
    }


    //getCustomer
    //getProducts
    //getTotalPrice
    //getStatus

    //addProducts and quantity
    //complete order^
    //cancel order (order is first in pending)



}
