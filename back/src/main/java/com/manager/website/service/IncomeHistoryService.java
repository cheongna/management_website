package com.manager.website.service;

import com.manager.website.db.IncomeHistoryDatabase;
import com.manager.website.dto.IncomeHistoryDto;
import com.manager.website.entity.IncomeHistoryEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeHistoryService {
    private final IncomeHistoryDatabase incomeHistoryDatabase;
    private final ProductService productService;
    private final UserService userService;

    public IncomeHistoryDto generate(IncomeHistoryDto dto) {
        IncomeHistoryEntity entity = IncomeHistoryEntity.convertToEntity(dto, productService, userService);
        entity = incomeHistoryDatabase.save(entity);
        if (entity.getId() == null) {
            throw new CustomException("입고기록 생성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return IncomeHistoryDto.convertToDto(entity);
        }
    }

    public List<IncomeHistoryDto> findAll() {
        return incomeHistoryDatabase.findAll().stream()
                .map(IncomeHistoryDto::convertToDto).collect(Collectors.toList());
    }

    public IncomeHistoryDto findById(long id) {
        IncomeHistoryEntity entity = incomeHistoryDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 입고 기록이 없습니다.", HttpStatus.NOT_FOUND));
        return IncomeHistoryDto.convertToDto(entity);
    }
}
