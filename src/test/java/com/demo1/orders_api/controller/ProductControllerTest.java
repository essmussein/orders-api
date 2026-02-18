package com.demo1.orders_api.controller;

import com.demo1.orders_api.domain.Product;
import com.demo1.orders_api.exception.NotFoundException;
import com.demo1.orders_api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void shouldListProducts() throws Exception {
        Product p = new Product();
        p.setId(1L);
        p.setName("Keyboard");
        p.setDescription("Mechanical keyboard");
        p.setPrice(new BigDecimal("99.90"));
        p.setStock(10);

        Mockito.when(productService.list(Mockito.any()))
                .thenReturn(new PageImpl<>(List.of(p), PageRequest.of(0, 20), 1));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].name").value("Keyboard"));
    }

    @Test
    void shouldReturn404WhenProductNotFound() throws Exception {
        Mockito.when(productService.get(99999L))
                .thenThrow(new NotFoundException("Product not found: 99999"));

        mockMvc.perform(get("/api/products/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }

    @Test
    void shouldCreateProduct() throws Exception {
        Product created = new Product();
        created.setId(1L);
        created.setName("Keyboard");
        created.setDescription("Mechanical keyboard");
        created.setPrice(new BigDecimal("99.90"));
        created.setStock(10);

        Mockito.when(productService.create(Mockito.any(Product.class)))
                .thenReturn(created);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "Keyboard",
                                  "description": "Mechanical keyboard",
                                  "price": 99.90,
                                  "stock": 10
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Keyboard"));
    }

    @Test
    void shouldReturn400WhenValidationFails() throws Exception {
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "",
                                  "price": -1,
                                  "stock": -2
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.fieldErrors.name").exists());
    }
}
