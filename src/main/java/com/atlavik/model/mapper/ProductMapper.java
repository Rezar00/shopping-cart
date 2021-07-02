package com.atlavik.model.mapper;


import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ShoppingCartMapper.class})
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {

    @Override
    @Mapping(source = "shoppingCartId", target = "shoppingCart.id")
    Product modelToEntity(ProductDTO model);

    @Override
    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    ProductDTO entityToModel(Product product);
}
