package com.atlavik.model.mapper;


import com.atlavik.model.dto.ShoppingCartDTO;
import com.atlavik.model.entity.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ShoppingCartMapper extends GenericMapper<ShoppingCart, ShoppingCartDTO> {
}
