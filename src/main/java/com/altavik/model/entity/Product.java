package com.altavik.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private String category;

    @ManyToOne
    @JoinColumn(name = "SHOPPING_CART_ID",
            foreignKey = @ForeignKey(name = "FK_SHOPPING_CART"), nullable = false)
    private ShoppingCart shoppingCart;
}
