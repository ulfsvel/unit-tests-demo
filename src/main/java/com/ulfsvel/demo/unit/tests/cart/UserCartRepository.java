package com.ulfsvel.demo.unit.tests.cart;


public interface UserCartRepository {

    UserCart getCart(Long userId);

    void saveCart(UserCart cart);

}
