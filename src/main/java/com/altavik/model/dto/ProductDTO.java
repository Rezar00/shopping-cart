package com.altavik.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends BaseDto{


    private String description;


    private BigDecimal price;


    private String category;

    private Long shoppingCartId;
}
