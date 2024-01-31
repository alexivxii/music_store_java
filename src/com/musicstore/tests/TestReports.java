package com.musicstore.tests;

import com.musicstore.domain.*;
import com.musicstore.exceptions.CustomerExistsException;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.exceptions.ProductAlreadyExistsException;
import com.musicstore.exceptions.ProductOOSException;
import com.musicstore.service.StoreReport;
import com.musicstore.utils.OrderStatus;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import com.musicstore.utils.RecordType;
import org.junit.Test;

import java.util.Set;

public class TestReports {

    @Test
    public void testReports() throws ProductOOSException, ProductAlreadyExistsException, OrderAlreadyExistsException, CustomerExistsException {

        MusicStore musicStore = new MusicStore();

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

        Customer c2 = new Customer(
                2,
                "Customerul",
                "Strada Alee",
                "0798765432"
        );

        Order order3 = new Order(
                3,
                2
        );

        Order order4 = new Order(
                4,
                2
        );

        for(int i=1; i<=7; i++){
            ProductMusicRecord tempProd = new ProductMusicRecord(
                    i,
                    "CD" + i,
                    i*50,
                    i+5,
                    RecordType.CD

            );

            order3.addProduct(tempProd, i);
        }

        for(int i=1; i<=3; i++){
            ProductPickup tempProd = new ProductPickup(
                    i,
                    "Vinyl" + i,
                    i*150,
                    i+1,
                    PickupOperatingMechanismType.Manual,
                    PickupDriverType.Belt
            );

            //If productStock is 0, throws exception on addProduct
            //if the qty on addProduct is bigger than the stock, throws exception

            order4.addProduct(tempProd, i);
        }

        c2.placeOrder(order3);

        c2.placeOrder(order4);

        c1.updateOrder(2, OrderStatus.Finished);
        c2.updateOrder(3, OrderStatus.Finished);
        c2.updateOrder(4, OrderStatus.Finished);


        musicStore.addCustomer(c1);
        musicStore.addCustomer(c2);

        //REPORTS
        StoreReport storeReport = new StoreReport(musicStore);

        System.out.println("Number of clients: " + storeReport.getNumberOfClients());
        System.out.println("Number of orders: " + storeReport.getNumberOfOrders());
        System.out.println("Sum of all orders: $" + storeReport.sumAllOrders());

        Set<Order> finishedOrders = storeReport.finishedOrders();
        Set<Order> ordersSorted = storeReport.getOrdersSortedByTotalPrice();

        System.out.println("Finished orders: ");
        for(Order order : finishedOrders){
            System.out.println("Id: " + order.getOrderId());
        }

        System.out.println("Sorted orders by sum: ");
        for(Order order : ordersSorted){
            System.out.println("Id: " + order.getOrderId() + ", Sum: $" + order.getTotalPrice());
        }

    }

    @Test
    public void testStreamReports(){

    }

}
