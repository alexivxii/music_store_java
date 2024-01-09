package com.musicstore.domain;

import java.util.*;

public interface Product {

    //ToDo: need exception for negative stock

    public int getProductId();
    public String getProductName();

    public String getProductPrice();

    public int getProductStock();

    public void setProductId(int productId);

    public void setProductName(String productName);

    public void setProductPrice(String productPrice);

    public void setProductStock(int productStock);

}
