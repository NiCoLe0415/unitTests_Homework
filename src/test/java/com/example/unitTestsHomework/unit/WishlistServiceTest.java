package com.example.unitTestsHomework.unit;


import com.example.unitTestsHomework.model.ProductModel;
import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.model.WishlistModel;
import com.example.unitTestsHomework.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WishlistServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void whenCreateUserAddProductsToWishlist_ThenHaveProductsInWishlist() {
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

        WishlistModel wishlistModel = new WishlistModel();
        wishlistModel.setProductModelList(list);

        List<WishlistModel> cartModelList = new ArrayList<>();
        cartModelList.add(wishlistModel);

        Assertions.assertEquals(1, cartModelList.size());

        ProductModel product = wishlistModel.getProductModelList().get(0);;
        Assertions.assertEquals("capsuni2", product.getName());
        Assertions.assertEquals(4.55, product.getPrice());
        Assertions.assertEquals(3, product.getQuantity());
    }


}
