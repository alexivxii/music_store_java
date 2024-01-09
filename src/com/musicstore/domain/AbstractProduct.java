package com.musicstore.domain;

import java.util.List;

public class AbstractProduct implements Product{

    //ToDo: need exception for negative stock

    private int productId;
    private String productName;
    private String productPrice;
    private int productStock;

    public AbstractProduct(int productId, String productName, String productPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }


}
