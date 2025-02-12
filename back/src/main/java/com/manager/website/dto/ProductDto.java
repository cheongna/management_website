package com.manager.website.dto;

import com.manager.website.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String category;
    private String sub_category;
    private String name;
    private float price;

    public static ProductDto convertToDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getCategory(),
                entity.getSub_category(),
                entity.getName(),
                entity.getPrice()
        );
    }
}
