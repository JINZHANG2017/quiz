package com.twuc.shopping.api;

import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.entity.OrderItemEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderItemRepository;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.util.JsonUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Test
    public void shouldGetProductList() throws Exception {
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

    @Test
    public void shouldAddNewProductToOrder() throws Exception {
        ProductEntity p=ProductEntity.builder()
                .img("sdfsf")
                .name("sdfsxcxc")
                .unit("mm")
                .build();
        productRepository.save(p);
        mockMvc
                .perform(get("/product/addToOrder/{id}",p.getId()))
                .andExpect(status().isOk());
        List<OrderItemEntity> orderItemEntityList = orderItemRepository.findAll();
        assertEquals(1,orderItemEntityList.size());
        assertEquals(1,orderItemEntityList.get(0).getNum());
    }

    @Test
    public void shouldAddOldProductToOrder() throws Exception {
        ProductEntity p=ProductEntity.builder()
                .img("sdfsf")
                .name("sdfsxcxc")
                .unit("mm")
                .build();
        productRepository.save(p);
        OrderItemEntity orderItemEntity=OrderItemEntity.builder()
                .productEntity(p)
                .num(1)
                .build();
        orderItemRepository.save(orderItemEntity);
        mockMvc
                .perform(get("/product/addToOrder/{id}",p.getId()))
                .andExpect(status().isOk());
        List<OrderItemEntity> orderItemEntityList = orderItemRepository.findAll();
        assertEquals(1,orderItemEntityList.size());
        assertEquals(2,orderItemEntityList.get(0).getNum());
    }
}