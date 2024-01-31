package com.musicstore.service;

import com.musicstore.domain.Customer;
import com.musicstore.domain.MusicStore;
import com.musicstore.domain.Order;
import com.musicstore.utils.OrderStatus;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StoreReportStreams {

    private MusicStore musicStore;

    public StoreReportStreams(MusicStore musicStore) {this.musicStore = musicStore;}

    public MusicStore getMusicStore() {return this.musicStore;}

    public int getNumberOfClients(){
        return this.musicStore.getCustomers().size();
    }

    public int getNumberOfOrders(){
        return this.musicStore.getCustomers().stream().mapToInt(client -> client.getOrderHistory().size()).sum();
    }

    public double sumAllOrders(){
        return this.musicStore.getCustomers().stream().flatMap(client -> client.getOrderHistory().stream()).mapToDouble(Order::getTotalPrice).sum();
    }

    public SortedSet<Order> getOrdersSortedByTotalPrice(){
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getTotalPrice() < o1.getTotalPrice() ? 1 : -1;
            }
        };

        return this.musicStore.getCustomers().stream().flatMap(client -> client.getOrderHistory().stream()).collect(Collectors.toCollection(() -> new TreeSet<Order>(comparator)));

    }

    public Set<Order> finishedOrders(){
        return this.musicStore.getCustomers()
                .stream()
                .flatMap(customer -> customer.getOrderHistory().stream())
                .filter(order -> order.getOrderStatus() == OrderStatus.Finished)
                .collect(Collectors.toSet());
    }

}
