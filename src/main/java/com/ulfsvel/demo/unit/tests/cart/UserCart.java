package com.ulfsvel.demo.unit.tests.cart;

import java.util.List;

public class UserCart {

    private Long userId;

    private List<Product> products;

    public Long getUserId() {
        return userId;
    }

    public UserCart setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public UserCart setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
