package com.ulfsvel.demo.unit.tests.cart;

public class CartService {

    private final ProductRepository productRepository;

    private final UserCartRepository userCartRepository;

    public CartService(ProductRepository productRepository, UserCartRepository userCartRepository) {
        this.productRepository = productRepository;
        this.userCartRepository = userCartRepository;
    }

    public void addProduct(Long productId, Long userId) {
        // @TODO: Implement
    }

    public CartSummary getSummary(Long userId) {
        // @TODO: Implement
        return null;
    }

}
