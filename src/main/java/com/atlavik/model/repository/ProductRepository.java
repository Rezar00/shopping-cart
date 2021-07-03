package com.atlavik.model.repository;

import com.atlavik.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByShoppingCart_Id(Long cartId);

    Optional<Product> findByIdAndShoppingCart_Id(Long id, Long cartId);
}
