package com.musicstore.domain;

import com.musicstore.utils.OrderStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//ToDo: multithreading on making order

public class Order {

    private int orderId;
    private int customerId;
    private OrderStatus orderStatus; //pending, canceled, finished
    private HashMap<AbstractProduct, Integer> itemMap; //item, qty
    private int totalPrice;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderStatus = OrderStatus.Pending;
    }



    //addProducts and quantity
    //complete order^
    //cancel order (order is first in pending)


    public int getOrderId() {
        return orderId;
    }

    public int getCustomer() {
        return customerId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public HashMap<AbstractProduct, Integer> getItemMap() {
        return itemMap;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void showAllOrderItems(){

        //show all order items and quantity

        int i=0;
        //for each pair in this.itemMap, do:
        for (Map.Entry<AbstractProduct, Integer> entry : this.itemMap.entrySet()) {
            AbstractProduct key = entry.getKey();
            Integer value = entry.getValue();

            i+=1;
            System.out.println(i + ". " + key.getProductName() + " x" + value);
        }


    }

    public void addProduct(Product prod, int qty){

        //add product or list of products to the order

        if(this.itemMap == null)
            this.itemMap = new HashMap<AbstractProduct, Integer>();

        this.itemMap.put((AbstractProduct) prod,qty);

    }

    //Todo: Maybe modify to remove by product name instead of whole obj as arg
    public void removeProduct(AbstractProduct prod){

        //remove product from list of products

        this.itemMap.remove(prod);

    }

    public void updateProductQty(Product prod, int qty){

        //modify product quantity from list of products
        this.itemMap.replace((AbstractProduct) prod, qty);


    }

    public void cancelOrder(){

        this.orderStatus = OrderStatus.Canceled;

    }

    public void finishOrder(){

        this.orderStatus = OrderStatus.Finished;

    }

    public void showOrderStatus(){

        System.out.println(this.orderStatus);
    }


}
