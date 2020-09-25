package com.twuc.shopping.api;

import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldGetRsEventList() throws Exception {
        ProductEntity p=ProductEntity.builder()
                .img("sdfsf")
                .name("sdfsxcxc")
                .unit("mm")
                .build();
        productRepository.save(p);
        mockMvc
                .perform(get("/product/list"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());
    }
}