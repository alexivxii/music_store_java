package com.musicstore.domain;

import java.util.*;

public interface Product {

    public int getProductId();
    public String getProductName();

    public double getProductPrice();

    public int getProductStock();

    public void updateStock(int newStock) throws IllegalArgumentException;

}
