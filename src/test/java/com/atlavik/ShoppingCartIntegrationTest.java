package com.atlavik;

import com.atlavik.model.dto.ProductDTO;
import com.atlavik.model.dto.ShoppingCartDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ShoppingCartIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api/v1";
    }


    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/carts",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getById() {
        ShoppingCartDTO shoppingCartDTO = restTemplate.getForObject(getRootUrl() + "/carts/1", ShoppingCartDTO.class);
        System.out.println(shoppingCartDTO.getCountryCode());
        assertNotNull(shoppingCartDTO);
    }

    @Test
    public void add() {
        ProductDTO productDTO = ProductDTO.builder().category("fruits")
                .description("fresh")
                .price(BigDecimal.valueOf(1200))
                .build();
        Set<ProductDTO> products = new HashSet<>();
        products.add(productDTO);
        ShoppingCartDTO shoppingCartDTO = ShoppingCartDTO.builder()
                .countryCode("0098")
                .currency("IRR")
                .products(products)
                .build();
        ResponseEntity<ShoppingCartDTO> postResponse = restTemplate.postForEntity(getRootUrl() + "/carts", shoppingCartDTO, ShoppingCartDTO.class);
        assertEquals(HttpStatus.CREATED.value(), postResponse.getStatusCode().value(), "OK");
    }

//    @Test
//    public void addProduct() {
//        int id = 1;
//        ShoppingCartDTO shoppingCartDTO = restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        shoppingCartDTO.setCurrency("USD");
//        restTemplate.put(getRootUrl() + "/shared-model", shoppingCartDTO);
//        ShoppingCartDTO updatedShoppingCart = restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        assertNotNull(updatedShoppingCart);
//    }
//
//    @Test
//    public void updateProduct() {
//        int id = 1;
//        ShoppingCartDTO shoppingCartDTO = restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        shoppingCartDTO.setCurrency("USD");
//        restTemplate.put(getRootUrl() + "/shared-model", shoppingCartDTO);
//        ShoppingCartDTO updatedShoppingCart = restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        assertNotNull(updatedShoppingCart);
//    }
//
//    @Test
//    public void deletePruduct() {
//        int id = 2;
//        ShoppingCartDTO shoppingCartDTO = restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        assertNotNull(shoppingCartDTO);
//        restTemplate.delete(getRootUrl() + "/carts/" + id);
//        try {
//            restTemplate.getForObject(getRootUrl() + "/carts/" + id, ShoppingCartDTO.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
}
