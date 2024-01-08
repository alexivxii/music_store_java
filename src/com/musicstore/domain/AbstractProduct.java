package com.musicstore.domain;

import java.util.List;

public class AbstractProduct implements Product{

    private int productId;
    private String productName;
    private String productPrice;
    private String productGenre;
    private int duration; //seconds
    private int productStock;
    private List<String> tracks;

}
