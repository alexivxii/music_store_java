package com.musicstore.tests;

import com.musicstore.domain.Customer;
import com.musicstore.domain.Order;
import com.musicstore.domain.ProductPickup;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import org.junit.Test;

public class TestCustomer {

    @Test
    public void testCustomer(){

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

        for(int i=1; i<=5; i++){
            ProductPickup tempProd = new ProductPickup(
                    i,
                    "Pickup" + i,
                    i*100,
                    i+5,
                    PickupOperatingMechanismType.Manual,
                    PickupDriverType.Belt
            );

            order1.addProduct(tempProd, i);
        }

        for(int i=10; i<=15; i++){
            ProductPickup tempProd = new ProductPickup(
                    i,
                    "Pickup" + i,
                    i*100,
                    i-5,
                    PickupOperatingMechanismType.Manual,
                    PickupDriverType.Belt
            );

            order2.addProduct(tempProd, i);
        }

        //logic kind of weird,

        c1.placeOrder(order1);

        c1.placeOrder(order2);

        c1.viewOrders();


        //Finding order by id and canceling it
        Order temp = c1.getOrderById(2);

        temp.cancelOrder();

        c1.placeOrder(temp);

        c1.viewOrders();

    }



}
