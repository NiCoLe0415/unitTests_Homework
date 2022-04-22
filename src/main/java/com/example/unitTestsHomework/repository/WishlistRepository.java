package com.example.unitTestsHomework.repository;

import com.example.unitTestsHomework.model.WishlistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistModel,Integer> {
}
