package com.atlavik.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"products"})
public class ShoppingCart extends BaseEntity {

    @Column
    private String countryCode;

    @Column
    private String currency;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;
}
