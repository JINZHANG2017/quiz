package com.twuc.shopping.entity;

//import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
//    @ManyToMany
//    private List<OrderEntity> orderEntityList;

    public ProductDto toDto(){
        return ProductDto.builder()
                .img(img)
                .name(name)
                .unit(unit)
                .unitPrice(unitPrice)
                .build();
    }
}
