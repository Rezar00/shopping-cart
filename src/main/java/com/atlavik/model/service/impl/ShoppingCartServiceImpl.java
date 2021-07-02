package com.atlavik.model.service.impl;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.dto.ShoppingCartDTO;
import com.atlavik.model.entity.ShoppingCart;
import com.atlavik.model.mapper.ShoppingCartMapper;
import com.atlavik.model.repository.ShoppingCartRepository;
import com.atlavik.model.service.ProductService;
import com.atlavik.model.service.ShoppingCartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    public final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ShoppingCartMapper shoppingCartMapper, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
        this.productService = productService;
    }

    /**
     * Get all shopping carts
     *
     * @param pageable for fetch data as page from database
     * @return Page<ShoppingCartDTO>
     * @see ShoppingCartDTO
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ShoppingCartDTO> getAll(Pageable pageable) {
        Page<ShoppingCart> shoppingCarts = this.shoppingCartRepository.findAll(pageable);
        return shoppingCarts.map(shoppingCartMapper::entityToModel);
    }

    /**
     * Add Shopping cart
     * Service Layer have to deal with DTO only, So we use mapper to work with Repository layer
     *
     * @param shoppingCartDTO shopping cart model
     * @return ShoppingCartDTO
     * @see ShoppingCartDTO
     */
    @Override
    @Transactional
    public ShoppingCartDTO addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartMapper.modelToEntity(shoppingCartDTO);
        if (shoppingCartDTO.getProducts() != null && !shoppingCartDTO.getProducts().isEmpty()) {
            shoppingCart.getProducts().forEach(product -> product.setShoppingCart(shoppingCart));
        }
        return this.shoppingCartMapper.entityToModel(this.shoppingCartRepository.save(shoppingCart));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProductsForGivenCartId(Long cartId) {
        return this.productService.getAllByCartId(cartId);
    }
}
