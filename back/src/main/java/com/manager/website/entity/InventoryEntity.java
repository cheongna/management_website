package com.manager.website.entity;

import com.manager.website.db.ProductDatabase;
import com.manager.website.db.StorageDatabase;
import com.manager.website.dto.InventoryDto;
import com.manager.website.handler.exception.CustomException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
public class InventoryEntity {

    @EmbeddedId
    private InventoryId id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("storage_id")
    @JoinColumn(name = "storage_id")
    private StorageEntity storage;

    private long amount;

    public static InventoryEntity convertToEntity(InventoryDto dto, ProductDatabase prod_db, StorageDatabase stor_db) {
        return new InventoryEntity(
                null,
                prod_db.findById(dto.getProduct_id()).orElseThrow(() -> new CustomException("해당 id에 존재하는 상품이 없습니다.", HttpStatus.NOT_FOUND)),
                stor_db.findById(dto.getStorage_id()).orElseThrow(() -> new CustomException("해당 id에 존재하는 창고가 없습니다.", HttpStatus.NOT_FOUND)),
                dto.getAmount()
        );
    }
}
