package com.altavik.model.service.impl;

import com.altavik.model.dto.ShoppingCartDTO;
import com.altavik.model.mapper.ShoppingCartMapper;
import com.altavik.model.repository.ShoppingCartRepository;
import com.altavik.model.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    public final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    /**
     * Add Shopping cart
     * Service Layer have to deal with DTO only, So we use mapper to work with Repository layer
     * @param shoppingCart shopping cart model
     * @return ShoppingCartDTO
     * @see ShoppingCartDTO
     */
    @Override
    public ShoppingCartDTO addShoppingCart(ShoppingCartDTO shoppingCart) {
        return this.shoppingCartMapper.entityToModel(this.shoppingCartRepository.save(this.shoppingCartMapper.modelToEntity(shoppingCart)));
    }
}
