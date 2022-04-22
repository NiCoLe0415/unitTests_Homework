package com.example.unitTestsHomework.controller;


import com.example.unitTestsHomework.model.WishlistModel;
import com.example.unitTestsHomework.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/getWishlistByUserId/{userId}")
    public WishlistModel getWishlistByUserId(@PathVariable Integer userId) {
        return wishlistService.getWishlistByUserId(userId);
    }
    @PostMapping("/postWishlistByUserId/{userId}")
    public WishlistModel createWishlist(@RequestBody WishlistModel wishlistModel, @PathVariable Integer userId) {
        return wishlistService.createWishlist(wishlistModel, userId);
    }

    @PutMapping("/updateWishListByUserId/{userId}")
    public void updateWishList(@RequestBody WishlistModel wishlistModel,@PathVariable Integer userId){
        wishlistService.updateWishList(wishlistModel,userId);
    }
    @DeleteMapping("/deleteWishListByUserId/{userId}")
    public void deleteCart(@PathVariable Integer userId) {
        wishlistService.deleteWishlistByUserId(userId);
    }

}
