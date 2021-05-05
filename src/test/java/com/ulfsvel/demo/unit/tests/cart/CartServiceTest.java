package com.ulfsvel.demo.unit.tests.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    private final static long USER_ID = 99L;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserCartRepository userCartRepository;

    @Captor
    private ArgumentCaptor<UserCart> userCartArgumentCaptor;

    @InjectMocks
    private CartService cartService;

    @Test
    public void givenProductCanNotBeFound_whenAddProduct_thenThrowProductNotFoundException() {
        Mockito.when(productRepository.getProduct(Mockito.any())).thenReturn(null);
        Assertions.assertThrows(
                ProductNotFoundException.class,
                () -> cartService.addProduct(1L, 2L)
        );
    }

    @Test
    public void givenUserCartCanNotBeFound_whenAddProduct_thenCreateUserCartAndAddProduct() {
        Product product = new Product();
        product.setId(1L);
        Mockito.when(productRepository.getProduct(1L)).thenReturn(product);

        cartService.addProduct(1L, USER_ID);
        Mockito.verify(userCartRepository).saveCart(userCartArgumentCaptor.capture());
        UserCart userCart = userCartArgumentCaptor.getValue();
        Assertions.assertNull(userCart.getUserId());
        Assertions.assertEquals(1, userCart.getProducts().size());
        Assertions.assertEquals(product, userCart.getProducts().get(0));
    }

    @Test
    public void givenProductExistsAndUserCartExists_whenAddProduct_thenAddProductToCart() {
        Product product = new Product();
        product.setId(1L);
        Mockito.when(productRepository.getProduct(1L)).thenReturn(product);

        Product existingProduct = new Product();
        existingProduct.setId(2L);
        UserCart userCart = new UserCart();
        userCart.setUserId(USER_ID);
        userCart.getProducts().add(existingProduct);
        Mockito.when(userCartRepository.getCart(USER_ID)).thenReturn(userCart);

        cartService.addProduct(1L, USER_ID);
        Mockito.verify(userCartRepository).saveCart(userCartArgumentCaptor.capture());
        Assertions.assertEquals(USER_ID, userCart.getUserId());
        Assertions.assertEquals(2, userCart.getProducts().size());
        Assertions.assertEquals(existingProduct, userCart.getProducts().get(0));
        Assertions.assertEquals(product, userCart.getProducts().get(1));
    }

    @Test
    public void givenUserCartCanNotBeFound_whenGetSummary_thenReturnNull() {
        Assertions.assertNull(cartService.getSummary(USER_ID));
    }

    @Test
    public void givenUserCartCanBeFound_whenGetSummary_thenReturnCart() {
        Product existingProduct1 = new Product();
        existingProduct1.setId(1L);
        existingProduct1.setPrice(7D);
        existingProduct1.setQuantity(1);

        Product existingProduct2 = new Product();
        existingProduct2.setId(2L);
        existingProduct2.setPrice(5D);
        existingProduct2.setQuantity(2);

        UserCart userCart = new UserCart();
        userCart.setUserId(USER_ID);
        userCart.getProducts().add(existingProduct1);
        userCart.getProducts().add(existingProduct2);
        Mockito.when(userCartRepository.getCart(USER_ID)).thenReturn(userCart);

        CartSummary cartSummary = cartService.getSummary(USER_ID);
        Assertions.assertEquals(3, cartSummary.getProductsTotal());
        Assertions.assertEquals(17D, cartSummary.getCartTotal());
    }


}
