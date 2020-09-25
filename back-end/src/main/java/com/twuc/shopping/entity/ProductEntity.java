package com.twuc.shopping.entity;

import com.twuc.shopping.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double unitPrice;
    private String unit;
    private String img;

    public ProductDto toDto(){
        return ProductDto.builder()
                .img(img)
                .name(name)
                .unit(unit)
                .unitPrice(unitPrice)
                .build();
    }
}
