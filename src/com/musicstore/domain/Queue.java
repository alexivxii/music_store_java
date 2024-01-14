package com.musicstore.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Queue {

    private List<Order> orders = Collections.synchronizedList(new LinkedList<Order>());

    public void add(Order order){
        orders.add(order);
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public int getQueueSize(){
        return orders.size();
    }

    public Order removeOrder(){

        //primim primul order din coada si il stergem din lista din queue
        if(orders.size()>0){
            return orders.remove(0);
        }

        //list is empty
        return null;
    }

}
