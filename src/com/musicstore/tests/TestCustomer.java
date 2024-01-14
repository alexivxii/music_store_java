package com.musicstore.tests;

import com.musicstore.domain.Customer;
import com.musicstore.domain.Order;
import com.musicstore.domain.ProductPickup;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.exceptions.ProductAlreadyExistsException;
import com.musicstore.exceptions.ProductOOSException;
import com.musicstore.utils.OrderStatus;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import org.junit.Test;

public class TestCustomer {

    @Test
    public void testCustomer() throws OrderAlreadyExistsException, ProductAlreadyExistsException, ProductOOSException {

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
                    i+1,
                    PickupOperatingMechanismType.Manual,
                    PickupDriverType.Belt
            );

            //If productStock is 0, throws exception on addProduct
            //if the qty on addProduct is bigger than the stock, throws exception

            order2.addProduct(tempProd, i);
        }

        c1.placeOrder(order1);

        c1.placeOrder(order2);

        c1.viewOrders();

        c1.updateOrder(2, OrderStatus.Canceled);

        //Finding order by id and canceling it
//        Order temp = c1.getOrderById(2);
//
//        temp.cancelOrder();
//
//        c1.placeOrder(temp);

        c1.viewOrders();

    }



}
