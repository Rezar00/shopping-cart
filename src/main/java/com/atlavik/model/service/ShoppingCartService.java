package com.atlavik.model.service;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.dto.ShoppingCartDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCartDTO addShoppingCart(ShoppingCartDTO shoppingCart);

    Page<ShoppingCartDTO> getAll(Pageable pageable);

    List<ProductDTO> getAllProductsForGivenCartId(Long cartId);

    ProductDTO updateProductByGivenCart(Long cartId, ProductDTO productDTO);

    void deleteProductByGivenCartIdAndProductId(Long cartId, Long productId);

    ShoppingCartDTO getOne(Long id);
}
