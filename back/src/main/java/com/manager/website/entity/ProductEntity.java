package com.manager.website.entity;

import com.manager.website.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String sub_category;

    @Column(nullable = false)
    private String name;

    private float price = 0f;

    public static ProductEntity convertToEntity(ProductDto dto) {
        return ProductEntity.builder()
                .category(dto.getCategory())
                .sub_category(dto.getSub_category())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
