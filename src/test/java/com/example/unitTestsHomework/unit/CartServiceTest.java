package com.example.unitTestsHomework.unit;

import com.example.unitTestsHomework.model.CartModel;
import com.example.unitTestsHomework.model.ProductModel;
import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private UserService userService;


    //nu pot sa inteleg de ce testul asta nu merge chiar daca e copy paste din CartServiceTest doar ca e schimbat cu wishlist aici :)
    @Test
    public void whenCreateUserAddProductsToCart_ThenHaveProductsInCart(){
        UserModel user = new UserModel();
        user.setUsername("username1");
        user.setFirstName("Dorobantu");
        user.setLastName("Nicoleta");
        userService.createUser(user);

        ProductModel newProduct = new ProductModel();
        newProduct.setName("capsuni");
        newProduct.setPrice(2.55);
        newProduct.setQuantity(5);

        ProductModel newProduct2 = new ProductModel();
        newProduct.setName("capsuni2");
        newProduct.setPrice(4.55);
        newProduct.setQuantity(3);

        List<ProductModel>list=new ArrayList<>();
        list.add(newProduct);
        list.add(newProduct2);

        CartModel cart = new CartModel();
        cart.setProductModelList(list);

        List<CartModel> cartModelList = new ArrayList<>();
        cartModelList.add(cart);

        Assertions.assertEquals(1, cartModelList.size());

        ProductModel product = cart.getProductModelList().get(0);;
        Assertions.assertEquals("capsuni2", product.getName());
        Assertions.assertEquals(4.55, product.getPrice());
        Assertions.assertEquals(3, product.getQuantity());
    }
}
