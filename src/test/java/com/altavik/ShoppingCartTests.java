package com.altavik;

import com.altavik.controller.ShoppingCartController;
import com.altavik.model.dto.ShoppingCartDTO;
import com.altavik.model.entity.ShoppingCart;
import com.altavik.model.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ShoppingCartController.class)
@WithMockUser
public class ShoppingCartTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartService shoppingCartService;

    ShoppingCartDTO mockShoppingCart = new ShoppingCartDTO("0021", "IRR", null);
    String exampleShoppingCartJson = "{\"countryCode\":\"0021\",\"currency\":\"IRR\",\"products\":[]}";

    @Test
    public void addShoppingCart() throws Exception {

        ShoppingCartDTO mockCourse = ShoppingCartDTO.builder()
                .countryCode("0010")
                .currency("USD")
                .build();

        Mockito.when(
                shoppingCartService.addShoppingCart(mockCourse)).thenReturn(mockShoppingCart);

        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/carts")
                .accept(MediaType.APPLICATION_JSON).content(exampleShoppingCartJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void getShoppingCarts() {

    }

    @Test
    public void addProduct() {

    }

    @Test
    public void getProducts() {

    }

    @Test
    public void deleteProducts() {

    }

}
