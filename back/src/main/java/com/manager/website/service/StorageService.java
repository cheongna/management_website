package com.manager.website.service;

import com.manager.website.db.StorageDatabase;
import com.manager.website.dto.StorageDto;
import com.manager.website.entity.StorageEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageDatabase storageDatabase;

    public StorageDto generate(StorageDto dto) {
        StorageEntity entity = StorageEntity.convertToEntity(dto);
        entity = storageDatabase.save(entity);
        if (entity.getId() == null) {
            throw new CustomException("창고 생성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return StorageDto.convertToDto(entity);
        }
    }

    public List<StorageDto> findAll() {
        return storageDatabase.findAll()
                .stream().map(StorageDto::convertToDto).collect(Collectors.toList());
    }

    public StorageDto findById(long id) {
        StorageEntity entity = storageDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 창고가 없습니다.", HttpStatus.NOT_FOUND));
        return StorageDto.convertToDto(entity);
    }
}
