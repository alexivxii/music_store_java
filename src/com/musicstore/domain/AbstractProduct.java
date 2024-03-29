package com.musicstore.domain;

import java.util.List;

public class AbstractProduct implements Product{

    private int productId;
    private String productName;
    private double productPrice;
    private int productStock;

    public AbstractProduct(int productId, String productName, double productPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;

        if(this.productStock < 0){
            throw new IllegalArgumentException("Product stock cannot be negative");
        }
        this.productStock = productStock;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void updateStock(int qty){

        int newStock = this.productStock - qty;
        if(newStock<0){
            throw new IllegalArgumentException("Product stock cannot be negative");
        }
        this.productStock = newStock;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractProduct that = (AbstractProduct) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return productId;
    }

}
