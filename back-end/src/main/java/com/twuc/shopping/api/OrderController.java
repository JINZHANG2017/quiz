package com.twuc.shopping.api;

import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/list")
    public ResponseEntity<List<OrderDto>> getOrderDtoList(){
        List<OrderDto> list=new ArrayList<>();
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        orderEntityList.forEach(orderEntity -> list.add(orderEntity.toDto()));
        return ResponseEntity.ok(list);
    }
}
