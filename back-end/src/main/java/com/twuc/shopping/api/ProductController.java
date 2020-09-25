package com.twuc.shopping.api;

import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product/list")
    public ResponseEntity<List<ProductDto>> getOrderDtoList(){
        List<ProductDto> list=new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        productEntities.forEach(productEntity -> list.add(productEntity.toDto()));
        return ResponseEntity.ok(list);
    }
}
