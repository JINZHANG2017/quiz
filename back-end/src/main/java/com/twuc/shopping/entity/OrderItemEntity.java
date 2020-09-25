package com.twuc.shopping.entity;

import com.twuc.shopping.dto.OrderItemDto;
import com.twuc.shopping.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "porder_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private int num;
    @OneToOne
    private ProductEntity productEntity;
//    @ManyToOne
//    @JoinColumn(name = "porder_id")
//    private OrderEntity orderEntity;
    public OrderItemDto toDto(){
        return OrderItemDto.builder()
                .num(num)
                .productDto(productEntity.toDto())
                .build();
    }
}
