package com.musicstore.tests;

import com.musicstore.domain.Customer;
import com.musicstore.domain.MusicStore;
import com.musicstore.domain.Order;
import com.musicstore.domain.ProductPickup;
import com.musicstore.exceptions.CustomerExistsException;
import com.musicstore.exceptions.OrderAlreadyExistsException;
import com.musicstore.exceptions.ProductAlreadyExistsException;
import com.musicstore.exceptions.ProductOOSException;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;
import org.junit.Test;

public class TestMusicStore {

    @Test
    public void testMusicStore() throws CustomerExistsException {


        MusicStore store = new MusicStore();

        Customer c1 = new Customer(
                1,
                "Clientul",
                "Strada Bulevard",
                "0712345678"
        );

        Customer c2 = new Customer(
                2,
                "Clientul",
                "Strada Bulevard",
                "0712345678"
        );

        store.addCustomer(c1);
        //should throw exception if c2 id is the same as c1 id
        store.addCustomer(c2);

    }

}
