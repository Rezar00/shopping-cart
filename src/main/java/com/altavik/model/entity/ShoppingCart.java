package com.altavik.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCart extends BaseEntity {

    @Column
    private String countryCode;

    @Column
    private String currency;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;
}
