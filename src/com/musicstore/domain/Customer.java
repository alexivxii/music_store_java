package com.musicstore.domain;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.utils.OrderStatus;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return customerId;
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

    public void placeOrder(Order order) throws OrderAlreadyExistsException {

        if(this.orderHistory.contains(order)){
            throw new OrderAlreadyExistsException("Order already exists");
        }
        //adds new Order to List: orderHistory

        this.orderHistory.add(order);

    }

    public void updateOrder(int id, OrderStatus status){

        for(Order order : orderHistory){
            if(order.getOrderId() == id){
                if(status == OrderStatus.Canceled) order.cancelOrder();
                if(status == OrderStatus.Finished) order.cancelOrder();
            }
        }

    }

    public void Order(int id){

        for(Order order : orderHistory){
            if(order.getOrderId() == id){
                order.cancelOrder();
            }
        }

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

}
