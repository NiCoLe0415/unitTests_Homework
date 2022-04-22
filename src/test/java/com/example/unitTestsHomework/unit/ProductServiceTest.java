package com.example.unitTestsHomework.unit;

import com.example.unitTestsHomework.model.CartModel;
import com.example.unitTestsHomework.model.ProductModel;
import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.service.CartService;
import com.example.unitTestsHomework.service.ProductService;
import com.example.unitTestsHomework.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Test
    public void whenCreateProduct_ThenInProductCartMustBeOne() {
        UserModel userModel = new UserModel();
        userModel.setUsername("username1");
        userModel.setFirstName("Dorobantu");
        userModel.setLastName("Nicoleta");
        userService.createUser(userModel);

        CartModel cart = new CartModel();
        cartService.insertCart( userModel.getId(),cart);

        ProductModel product = new ProductModel();
        productService.addProductToCart( cart.getId(),product);

        List<ProductModel> products = new ArrayList<>();
        for(int i=0;i<productService.getAllProducts().size();++i)
            products.add(productService.getAllProducts().get(i));

        Assertions.assertEquals(1, products.size());

    }

}
