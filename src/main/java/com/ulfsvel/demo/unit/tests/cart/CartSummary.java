package com.ulfsvel.demo.unit.tests.cart;

import java.util.List;

public class CartSummary {
    /**
     * The products from the cart
     */
    private List<Product> products;
    /**
     * The total of the cart.
     * Calculated summing price*quantity of all products
     */
    private Double cartTotal;
    /**
     * The total number of products in the cart.
     * Calculated summing quantity of all products
     */
    private Integer productsTotal;

}
