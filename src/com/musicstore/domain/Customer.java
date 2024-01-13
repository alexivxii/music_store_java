package com.musicstore.domain;
import java.util.*;

public class Customer {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    public Set<Order> orderHistory = new HashSet<Order>();

    public Customer(int customerId, String customerName, String customerAddress, String customerPhone) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public int getCustomerName() {
        return customerId;
    }


    public String getCustomerId() {
        return customerName;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }


    public String getCustomerPhone() {
        return customerPhone;
    }

    public Set<Order> getOrderHistory(){

        return Collections.unmodifiableSet(this.orderHistory);

    }

    public void viewOrders(){

        //show Orders from List: orderHistory

        Iterator<Order> iterator = this.orderHistory.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            System.out.println("Id " + order.getOrderId());
            System.out.println("Status " + order.getOrderStatus());
            order.showAllOrderItems();
        }


    }

    public void placeOrder(Order order){
        //adds new Order to List: orderHistory

        this.orderHistory.add(order);

    }

    public Order getOrderById(int id){

        Iterator<Order> iterator = this.orderHistory.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            if (order.getOrderId() == id)
                return order;
        }

        return null;

    }

    //ToDo: maybe implement a listener to changer the status of the order??

}
