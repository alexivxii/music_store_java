package com.musicstore.tests;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.musicstore.domain.*;
import com.musicstore.utils.OrderStatus;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import com.musicstore.utils.RecordType;
import org.junit.Test;

public class TestOrder {

    @Test
    public void testOrder(){

        Order order1 = new Order(
                1,
                1
        );

        HashMap<AbstractProduct, Integer> prodMap = new HashMap<AbstractProduct, Integer>();

        for(int i=10; i>=1; i--){
            ProductPickup tempProd = new ProductPickup(
                    i,
                    "Pickup" + i,
                    i*100,
                    i+5,
                    PickupOperatingMechanismType.Manual,
                    PickupDriverType.Belt
            );

            prodMap.put(tempProd, i);
            order1.addProduct(tempProd, i);
        }

        assertEquals(prodMap, order1.getItemMap());


        ProductPickup tempProd = new ProductPickup(
                4,
                "Pickup" + 4,
                4*100,
                4+5,
                PickupOperatingMechanismType.Manual,
                PickupDriverType.Belt
        );


        //order1.removeProduct(tempProd);

        //prodMap.remove(tempProd);
        //assertEquals(prodMap, order1.getItemMap());

        order1.updateProductQty(tempProd, 99);

        order1.showAllOrderItems();

    }

}
