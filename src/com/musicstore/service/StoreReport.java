package com.musicstore.service;

import com.musicstore.domain.Customer;
import com.musicstore.domain.MusicStore;
import com.musicstore.domain.Order;
import com.musicstore.utils.OrderStatus;

import java.util.*;

public class StoreReport {

    //get total number of clients
    //get total number of orders
    //get total sum of all orders
    //returns a set of all orders sorted by sum
    //returns a set of all finished orders

    private MusicStore musicStore;

    public StoreReport(MusicStore musicStore) {this.musicStore = musicStore;}

    public MusicStore getMusicStore() {return this.musicStore;}

    public int getNumberOfClients(){
        return musicStore.getCustomers().size();
    }

    public int getNumberOfOrders(){
        Set<Order> orders = new HashSet<Order>();

        for(Customer customer : musicStore.getCustomers()){
            orders.addAll(customer.getOrderHistory());
        }

        return orders.size();
    }

    public double sumAllOrders(){
        Set<Order> orders = new HashSet<Order>();
        double sum = 0.0;

        for(Customer customer : musicStore.getCustomers()){
            orders.addAll(customer.getOrderHistory());
        }

        for(Order order : orders){
            sum += order.getTotalPrice();
        }

        return sum;

    }

    public SortedSet<Order> getOrdersSortedByTotalPrice(){

        SortedSet<Order> result = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return (int) Math.round(o1.getTotalPrice() - o2.getTotalPrice());
            }
        });

        for(Customer customer : musicStore.getCustomers()){
            result.addAll(customer.getOrderHistory());
        }

        return result;

    }


    public Set<Order> finishedOrders(){

        Set<Order> orders = new HashSet<Order>();
        Set<Order> result = new HashSet<Order>();

        for(Customer customer : musicStore.getCustomers()){
            orders.addAll(customer.getOrderHistory());
        }

        for(Order order : orders){
            if(order.getOrderStatus()== OrderStatus.Finished)
                result.add(order);
        }

        return result;

    }

}
