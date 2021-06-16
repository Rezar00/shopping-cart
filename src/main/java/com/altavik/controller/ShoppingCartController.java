package com.altavik.controller;

import com.altavik.model.dto.ShoppingCartDTO;
import com.altavik.model.service.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    @ApiOperation(value = "add shopping cart", notes = "this api can add a shopping cart")
    public ResponseEntity<Void> add(@RequestBody ShoppingCartDTO dto) {
        this.shoppingCartService.addShoppingCart(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
