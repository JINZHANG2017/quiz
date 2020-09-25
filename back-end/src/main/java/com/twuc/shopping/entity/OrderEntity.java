package com.twuc.shopping.entity;

import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double unitPrice;
    private Integer amount;
    private String unit;

//    @ManyToMany
//    private List<ProductEntity> productEntityList;

    public OrderDto toDto(){
        List<ProductDto> list=new ArrayList<>();
//        productEntityList.forEach(productEntity -> list.add(productEntity.toDto()));
        return OrderDto.builder()
                .amount(amount)
                .name(name)
                .unit(unit)
                .unitPrice(unitPrice)
//                .productDtoList(list)
                .build();
    }
}
