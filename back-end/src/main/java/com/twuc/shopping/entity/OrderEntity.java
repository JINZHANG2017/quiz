package com.twuc.shopping.entity;

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
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Double unitPrice;
    private String amount;
    private String unit;

    @OneToMany
    private List<ProductEntity> productEntityList;
}
