package com.ulfsvel.demo.unit.tests.cart;

public class CartService {

    private final ProductRepository productRepository;

    private final UserCartRepository userCartRepository;

    public CartService(ProductRepository productRepository, UserCartRepository userCartRepository) {
        this.productRepository = productRepository;
        this.userCartRepository = userCartRepository;
    }

    public void addProduct(Long productId, Long userId) {
        Product product = productRepository.getProduct(productId);
        if (product == null) {
            throw new ProductNotFoundException();
        }
        UserCart userCart = userCartRepository.getCart(userId);
        if (userCart == null) {
            userCart = new UserCart();
        }
        userCart.getProducts().add(product);
        userCartRepository.saveCart(userCart);
    }

    public CartSummary getSummary(Long userId) {
        UserCart userCart = userCartRepository.getCart(userId);
        if (userCart == null) {
            return null;
        }
        CartSummary cartSummary = new CartSummary();
        cartSummary.setProducts(userCart.getProducts());
        double productTotal = 0D;
        int productCount = 0;
        for (Product product : cartSummary.getProducts()) {
            productCount += product.getQuantity();
            productTotal += product.getPrice() * product.getQuantity();
        }
        cartSummary.setCartTotal(productTotal);
        cartSummary.setProductsTotal(productCount);
        return cartSummary;
    }

}
