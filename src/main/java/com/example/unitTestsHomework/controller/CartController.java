package com.example.unitTestsHomework.controller;

import com.example.unitTestsHomework.model.CartModel;
import com.example.unitTestsHomework.model.ProductModel;
import com.example.unitTestsHomework.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @GetMapping("/getAllcarts")
    public List<CartModel> getAllPCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/getCartById/{id}")
    public CartModel getById(@PathVariable Integer id){
        return cartService.getById(id);
    }

    @PostMapping("/postCartByUserId/{userId}")
    public void createCart(@RequestBody CartModel cartModel,@PathVariable Integer idUser){
        cartService.insertCart(idUser,cartModel);

    }
    @PutMapping ("/updateCartByCartId/{cartId}")
    public void updateCart(@RequestBody List<ProductModel>list, @PathVariable Integer cartId){
        cartService.updateCart(cartId,list);
    }

    @DeleteMapping("/deleteCartByUserId/{userId}/{cartId}")
    public void deleteCart(@PathVariable Integer userId, @PathVariable Integer cartId) {
        cartService.delete(userId, cartId);

    }

}
