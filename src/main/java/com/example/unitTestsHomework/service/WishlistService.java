package com.example.unitTestsHomework.service;

import com.example.unitTestsHomework.model.WishlistModel;
import com.example.unitTestsHomework.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishlistModel getWishlistByUserId(Integer userId) {
        return userRepository.getById(userId).getWishlistModel();
    }

    public WishlistModel createWishlist(WishlistModel wishlistModel, Integer userId) {
        userRepository.getById(userId).setWishlistModel(wishlistModel);
        return wishlistRepository.save(wishlistModel);
    }

    public void updateWishList(WishlistModel wishlistModel, Integer userId){
        userRepository.getById(userId).setWishlistModel(wishlistModel);
    }

    public void deleteWishlistByUserId(Integer userId) {
        userRepository.getById(userId).setWishlistModel(null);
        wishlistRepository.deleteAll();
    }




}
