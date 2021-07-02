package com.atlavik.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

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
