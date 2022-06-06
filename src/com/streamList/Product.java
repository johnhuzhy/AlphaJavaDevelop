package com.streamList;

import java.math.BigDecimal;

public class Product {
    private int id;
    private int type;
    private String name;
    private BigDecimal price;

    public Product(int id) {
        this.id = id;
        this.type = -1;
    }

    public Product(int id, int type, String name, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
