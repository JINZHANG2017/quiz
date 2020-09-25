package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDto {
    private String name;
    private Double unitPrice;
    private Integer amount;
    private String unit;
//    private List<ProductDto> productDtoList;
}
