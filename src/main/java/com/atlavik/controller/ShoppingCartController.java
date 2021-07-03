package com.atlavik.controller;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.dto.ShoppingCartDTO;
import com.atlavik.model.service.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    @ApiOperation(value = "get all shopping carts", notes = "with this api, you can see all carts")
    public ResponseEntity<Page<ShoppingCartDTO>> getAll(Pageable pageable) {
        Page<ShoppingCartDTO> response = this.shoppingCartService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "get shopping cart by id", notes = "with this api, you can see a shopping cat by given id")
    public ResponseEntity<ShoppingCartDTO> getOne(@PathVariable Long id) {
        ShoppingCartDTO response = this.shoppingCartService.getOne(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ApiOperation(value = "add shopping cart", notes = "this api can add a shopping cart")
    public ResponseEntity<ShoppingCartDTO> add(@RequestBody ShoppingCartDTO dto) {
        ShoppingCartDTO response = this.shoppingCartService.addShoppingCart(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{cartId}/products")
    @ApiOperation(value = "get products belong to a cart id", notes = "this api can list all products that belongs to given cart id")
    public ResponseEntity<List<ProductDTO>> getAllProductsForGivenCartId(@PathVariable(name = "cartId") Long cartId) {
        List<ProductDTO> response = this.shoppingCartService.getAllProductsForGivenCartId(cartId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{cartId}/products")
    @ApiOperation(value = "get products belong to a cart id", notes = "this api can list all products that belongs to given cart id")
    public ResponseEntity<ProductDTO> getAllProductsForGivenCartId(@PathVariable(name = "cartId") Long cartId,
                                                                   @RequestBody ProductDTO productDTO) {
        ProductDTO response = this.shoppingCartService.updateProductByGivenCart(cartId, productDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{cartId}/products/{productId}")
    @ApiOperation(value = "get products belong to a cart id", notes = "this api can list all products that belongs to given cart id")
    public ResponseEntity<Void> getAllProductsForGivenCartId(@PathVariable Long cartId,
                                                             @PathVariable Long productId) {
        this.shoppingCartService.deleteProductByGivenCartIdAndProductId(cartId, productId);
        return ResponseEntity.noContent().build();
    }
}
