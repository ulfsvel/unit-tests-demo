package com.ulfsvel.demo.unit.tests.cart;


public interface UserCartRepository {

    Product getProduct(Long id);

    UserCart getCart(Long userId);

    void saveCart(UserCart cart);

}
