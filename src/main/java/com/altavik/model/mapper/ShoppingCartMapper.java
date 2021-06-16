package com.altavik.model.mapper;


import com.altavik.model.dto.ShoppingCartDTO;
import com.altavik.model.entity.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper extends GenericMapper<ShoppingCart, ShoppingCartDTO> {
}
