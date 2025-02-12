package com.manager.website.dto;

import com.manager.website.entity.StorageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StorageDto {
    private Long id;
    private String name;
    private long total_amount;

    public static StorageDto convertToDto(StorageEntity entity) {
        return new StorageDto(
                entity.getId(),
                entity.getName(),
                entity.getTotal_amount()
        );
    }
}
