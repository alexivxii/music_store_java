package com.musicstore.service;

import com.musicstore.domain.Customer;
import com.musicstore.domain.Order;
import com.musicstore.domain.Queue;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.utils.OrderStatus;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderService{

    //process orders simultaneously like EmailService in bank app 1

    //FLOW:
    //1. the orders are created
    //2. the products are being added to the order
    //3. the order status is PENDING on creation
    //4. The orders are then being added to the orderService
    //to be processed simultaneously.
    //5. If there is enough stock and no exceptions,
    //the orders status are updated to finished

    private Queue queue;
    private Customer customer;

    public OrderService(Customer customer, Queue queue) {
        this.customer = customer;
        this.queue = queue;
    }

    public void processOrders() {
        // Add customer's orders to the queue
        for (Order order : customer.orderHistory) {
            queue.add(order);
        }

        // Create a new thread to process orders
        Thread processingThread = new Thread(() -> {
            while (!queue.isEmpty()) {
                Order order = queue.removeOrder();
                if (order != null) {
                    // Process the order (update status to Finished)
                    this.customer.updateOrder(order.getOrderId(), OrderStatus.Finished);
                }
            }
        });

        // Start the processing thread
        processingThread.start();

        try {
            // Wait for the processing thread to finish
            processingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //this.customer.viewOrdersStatus();
    }


}
