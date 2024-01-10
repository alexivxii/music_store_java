package com.musicstore.domain;
import com.musicstore.utils.PickupDriverType;
import com.musicstore.utils.PickupOperatingMechanismType;

import java.util.*;
public class ProductPickup extends AbstractProduct{

    //Todo: Add enums for these properties
    private PickupOperatingMechanismType operatingMechanism; //manual/automatic
    private PickupDriverType driver; //belt/direct drive

    @Override
    public String toString() {
        return "ProductPickup{" +
                "operatingMechanism=" + operatingMechanism +
                ", driver=" + driver +
                '}';
    }

    public ProductPickup(int productId, String productName, double productPrice, int productStock, PickupOperatingMechanismType operatingMechanism, PickupDriverType driver) {
        super(productId, productName, productPrice, productStock);

        this.operatingMechanism = operatingMechanism;
        this.driver = driver;
    }
}
