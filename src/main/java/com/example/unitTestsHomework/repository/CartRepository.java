package com.example.unitTestsHomework.repository;

import com.example.unitTestsHomework.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<CartModel,Integer> {
}
