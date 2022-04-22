package com.example.unitTestsHomework.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String name;
    private double price;
    private Integer quantity;

    @ManyToOne
    CartModel cartModel;

    @ManyToOne
    WishlistModel wishlistModel;

}
