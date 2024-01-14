package com.musicstore.tests;

import com.musicstore.domain.Customer;
import com.musicstore.domain.Order;
import com.musicstore.domain.Queue;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.service.OrderService;
import org.junit.Test;

import java.util.Set;

public class TestOrderService {

    @Test
    public void testOrderService() throws OrderAlreadyExistsException {

        Customer c1 = new Customer(
                1,
                "Clientul",
                "Strada Bulevard",
                "0712345678"
        );

        Order order1 = new Order(
                1,
                1
        );

        Order order2 = new Order(
                2,
                1
        );

        Order order3 = new Order(
                3,
                1
        );

        Queue queue = new Queue();

        c1.placeOrder(order1);
        c1.placeOrder(order2);
        c1.placeOrder(order3);

        c1.viewOrdersStatus();


        //Start to process orders in a new Thread

        OrderService orderService = new OrderService(c1, queue);

        orderService.processOrders();

        // Wait for the processing to finish (you might want to use more robust synchronization mechanisms)
        try {
            Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After processing, view the updated orders
        c1.viewOrdersStatus();


    }

}
