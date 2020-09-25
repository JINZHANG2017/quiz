package com.twuc.shopping.repository;

import com.twuc.shopping.entity.OrderItemEntity;
import com.twuc.shopping.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Integer> {
    List<OrderItemEntity> findAll();
}
