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



    //addProducts and quantity
    //complete order^
    //cancel order (order is first in pending)


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public HashMap<AbstractProduct, Integer> getItemMap() {
        return itemMap;
    }

    public void setItemMap(HashMap<AbstractProduct, Integer> itemMap) {
        this.itemMap = itemMap;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void showAllOrderItems(){

        //show all order items and quantity

    }

    public void addProduct(Product prod, int qty){

        //add product or list of products to the order

        itemMap.put((AbstractProduct) prod,qty);

    }

    public void removeProduct(Product prod){

        //remove product from list of products

        itemMap.remove(prod);

    }

    public void updateProductQty(Product prod, int qty){

        //modify product quantity from list of products
        itemMap.replace((AbstractProduct) prod, qty);


    }
}
