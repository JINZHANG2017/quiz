package com.twuc.shopping.api;

import com.twuc.shopping.dto.OrderItemDto;
import com.twuc.shopping.entity.OrderItemEntity;
import com.twuc.shopping.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderItemController {
    @Autowired
    OrderItemRepository orderitemRepository;

    @GetMapping("/orderitem/list")
    public ResponseEntity<List<OrderItemDto>> getOrderDtoList(){
        List<OrderItemDto> list=new ArrayList<>();
        List<OrderItemEntity> orderEntityList = orderitemRepository.findAll();
        orderEntityList.forEach(orderEntity -> list.add(orderEntity.toDto()));
        return ResponseEntity.ok(list);
    }
}
