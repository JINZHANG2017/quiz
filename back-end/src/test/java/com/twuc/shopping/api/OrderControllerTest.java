package com.twuc.shopping.api;

import com.twuc.shopping.dto.OrderItemDto;
import com.twuc.shopping.entity.OrderItemEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderItemRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldGetRsEventList() throws Exception {

        ProductEntity p1=ProductEntity.builder()
                .img("sdfsf")
                .name("product1")
                .unitPrice(10.0)
                .unit("mm")
                .build();
        productRepository.save(p1);
        ProductEntity p2=ProductEntity.builder()
                .img("sdfsf")
                .name("product2")
                .unitPrice(20.0)
                .unit("zz")
                .build();
        productRepository.save(p2);
        OrderItemEntity o1=OrderItemEntity.builder()
                .num(2)
                .productEntity(p1)
                .build();
        orderItemRepository.save(o1);
        OrderItemEntity o2=OrderItemEntity.builder()
                .num(3)
                .productEntity(p2)
                .build();
        orderItemRepository.save(o2);
        mockMvc
                .perform(get("/orderitem/list"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].productDtoList", hasSize(2)))
//                .andExpect(jsonPath("$[0].keyword", is("无分类")))
//                .andExpect(jsonPath("$[0]", not(hasKey("user"))))
                .andExpect(status().isOk());
    }
}