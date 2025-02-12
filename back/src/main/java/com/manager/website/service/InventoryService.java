package com.manager.website.service;

import com.manager.website.db.InventoryDatabase;
import com.manager.website.db.ProductDatabase;
import com.manager.website.db.StorageDatabase;
import com.manager.website.dto.InventoryDto;
import com.manager.website.entity.InventoryEntity;
import com.manager.website.entity.InventoryId;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryDatabase inventoryDatabase;
    private final ProductDatabase productDatabase;
    private final StorageDatabase storageDatabase;

    public InventoryDto update(InventoryDto dto) {
        //인벤토리가 존재하지 않을 시 생성
        InventoryEntity entity = inventoryDatabase.findById(new InventoryId(dto.getProduct_id(), dto.getStorage_id()))
                .orElseGet(() -> InventoryEntity.convertToEntity(dto, productDatabase, storageDatabase));
        //존재할때
        if (entity.getId() != null) {
            long amount = entity.getAmount();
            amount += dto.getAmount();
            entity.setAmount(amount);
            entity = inventoryDatabase.save(entity);
            return InventoryDto.convertToDto(entity);
        } else {
            entity.setId(new InventoryId(entity.getProduct().getId(), entity.getStorage().getId()));
            entity = inventoryDatabase.save(entity);
            return InventoryDto.convertToDto(entity);
        }
    }

    public List<InventoryDto> findAll() {
        return inventoryDatabase.findAll()
                .stream().map(InventoryDto::convertToDto).collect(Collectors.toList());
    }

    public InventoryDto findById(InventoryId id) {
        InventoryEntity entity = inventoryDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 인벤토리가 없습니다.", HttpStatus.NOT_FOUND));
        return InventoryDto.convertToDto(entity);
    }
}
