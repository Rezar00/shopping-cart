package com.atlavik.model.service.impl;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.mapper.ProductMapper;
import com.atlavik.model.repository.ProductRepository;
import com.atlavik.model.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Get all products that belongs to given cart id
     *
     * @param cartId given shopping cart id
     * @return List of {{@link ProductDTO}}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllByCartId(Long cartId) {
        return this.mapper.entitiesToModels(this.repository.findAllByShoppingCart_Id(cartId));
    }
}
