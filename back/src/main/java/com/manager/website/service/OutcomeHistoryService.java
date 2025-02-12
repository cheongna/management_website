package com.manager.website.service;

import com.manager.website.db.OutcomeHistoryDatabase;
import com.manager.website.dto.OutcomeHistoryDto;
import com.manager.website.entity.OutcomeHistoryEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OutcomeHistoryService {
    private final OutcomeHistoryDatabase outcomeHistoryDatabase;
    private final CompanyService companyService;
    private final UserService userService;
    private final ProductService productService;

    public OutcomeHistoryDto generate(OutcomeHistoryDto dto) {
        OutcomeHistoryEntity entity = OutcomeHistoryEntity.convertToEntity(dto, companyService, userService, productService);
        entity = outcomeHistoryDatabase.save(entity);
        if (entity.getId() == null) {
            throw new CustomException("출고 기록 생성에 실패했습니다.", HttpStatus.NOT_FOUND);
        } else {
            return OutcomeHistoryDto.convertToDto(entity);
        }
    }

    public List<OutcomeHistoryDto> findAll() {
        return outcomeHistoryDatabase.findAll().stream()
                .map(OutcomeHistoryDto::convertToDto).collect(Collectors.toList());
    }

    public OutcomeHistoryDto findById(long id) {
        OutcomeHistoryEntity entity = outcomeHistoryDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 출고기록이 없습니다.", HttpStatus.NOT_FOUND));
        return OutcomeHistoryDto.convertToDto(entity);
    }
}
