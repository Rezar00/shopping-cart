package com.altavik.model.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartDTO extends BaseDto {

    private String countryCode;

    private String currency;

    private Set<ProductDTO> products;
}
