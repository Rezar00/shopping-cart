package com.atlavik.controller;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.dto.ShoppingCartDTO;
import com.atlavik.model.service.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ApiOperation(value = "add shopping cart", notes = "this api can add a shopping cart")
    public ResponseEntity<Void> add(@RequestBody ShoppingCartDTO dto) {
        this.shoppingCartService.addShoppingCart(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/{cartId}/products")
    @ApiOperation(value = "get products belong to a cart id", notes = "this api can list all products that belongs to given cart id")
    public ResponseEntity<List<ProductDTO>> getAllProductsForGivenCartId(@PathVariable(name = "cartId") Long cartId) {
        List<ProductDTO> response = this.shoppingCartService.getAllProductsForGivenCartId(cartId);
        return ResponseEntity.ok(response);
    }
}
