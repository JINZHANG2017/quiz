package com.twuc.shopping.api;

import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.entity.OrderItemEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderItemRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping("/product/list")
    public ResponseEntity<List<ProductDto>> getOrderDtoList(){
        List<ProductDto> list=new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        productEntities.forEach(productEntity -> list.add(productEntity.toDto()));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/product/addToOrder/{id}")
    public ResponseEntity addToOrder(@PathVariable Integer id){
        List<OrderItemEntity> list = orderItemRepository.findAllByProductEntityIdEquals(id);
        ProductEntity productEntity=productRepository.findById(id).get();
        if(list.size()>0){
            OrderItemEntity orderItemEntity = list.get(0);
            orderItemEntity.setNum(orderItemEntity.getNum()+1);
            orderItemRepository.save(orderItemEntity);
        }else{
            OrderItemEntity orderItemEntity=OrderItemEntity.builder()
                    .productEntity(productEntity)
                    .num(1)
                    .build();
            orderItemRepository.save(orderItemEntity);
        }
        return ResponseEntity.ok().build();
    }
}
