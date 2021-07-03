package com.atlavik.model.service.impl;

import com.atlavik.exception.ResourceNotFoundException;
import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.entity.Product;
import com.atlavik.model.mapper.ProductMapper;
import com.atlavik.model.repository.ProductRepository;
import com.atlavik.model.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    /**
     * update a product by given id and shopping cart id
     *
     * @param productDTO product model
     * @return {@link ProductDTO}
     */
    @Override
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO, Long cartId) {
        Optional<Product> optionalProduct = this.repository.findByIdAndShoppingCart_Id(productDTO.getId(), cartId);
        if (optionalProduct.isPresent()) {
            if (productDTO.getCategory() != null && !productDTO.getCategory().isEmpty()) {
                optionalProduct.get().setCategory(productDTO.getCategory());
            }
            if (productDTO.getDescription() != null && !productDTO.getDescription().isEmpty()) {
                optionalProduct.get().setDescription(productDTO.getDescription());
            }
            if (productDTO.getPrice() != null) {
                optionalProduct.get().setPrice(productDTO.getPrice());
            }
            return this.mapper.entityToModel(this.repository.save(optionalProduct.get()));
        } else
            throw new ResourceNotFoundException("Product with id: " + productDTO.getId() + " not found");
    }


    /**
     * delete a product by id that belongs to a cart
     *
     * @param id     product id
     * @param cartId shopping cart id
     */
    @Override
    @Transactional
    public void deleteProduct(Long id, Long cartId) {
        Optional<Product> optionalProduct = this.repository.findByIdAndShoppingCart_Id(id, cartId);
        if (optionalProduct.isPresent()) {
            this.repository.delete(optionalProduct.get());
        } else
            throw new ResourceNotFoundException("Product with id: " + id + " not found");
    }
}
