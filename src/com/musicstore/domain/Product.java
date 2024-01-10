package com.musicstore.domain;

import java.util.*;

public interface Product {

    //ToDo: need exception for negative stock

    public int getProductId();
    public String getProductName();

    public double getProductPrice();

    public int getProductStock();

}
