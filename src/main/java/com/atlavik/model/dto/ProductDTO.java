package com.atlavik.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO extends BaseDto{


    private String description;


    private BigDecimal price;


    private String category;

    private Long shoppingCartId;
}
