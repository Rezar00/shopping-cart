package com.atlavik.model.service;

import com.atlavik.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllByCartId(final Long cartId);
}
