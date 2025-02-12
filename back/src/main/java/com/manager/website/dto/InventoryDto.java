package com.manager.website.dto;

import com.manager.website.entity.InventoryEntity;
import com.manager.website.entity.InventoryId;
import com.manager.website.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private Long product_id;
    private Long storage_id;
    private long amount;

    public static InventoryDto convertToDto(InventoryEntity entity) {
        return new InventoryDto(
                entity.getProduct().getId(),
                entity.getStorage().getId(),
                entity.getAmount()
        );
    }
}
