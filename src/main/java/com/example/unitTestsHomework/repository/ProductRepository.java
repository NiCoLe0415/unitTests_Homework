package com.example.unitTestsHomework.repository;

import com.example.unitTestsHomework.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
 }
