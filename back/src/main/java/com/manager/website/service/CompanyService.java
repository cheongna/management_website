package com.manager.website.service;

import com.manager.website.db.CompanyDatabase;
import com.manager.website.dto.CompanyDto;
import com.manager.website.entity.CompanyEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyDatabase companyDatabase;

    public CompanyDto generate(CompanyDto dto) {
        CompanyEntity entity = CompanyEntity.convertToEntity(dto);
        entity = companyDatabase.save(entity);
        if (entity.getId() == null) {
            throw new CustomException("회사 데이터 생성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return CompanyDto.convertToDto(entity);
        }
    }

    public List<CompanyDto> findAll() {
        return companyDatabase.findAll().stream()
                .map(CompanyDto::convertToDto).collect(Collectors.toList());
    }

    public CompanyDto findById(long id) {
        CompanyEntity entity = companyDatabase.findById(id)
                .orElseThrow(() -> new CustomException("해당 id에 존재하는 회사명이 없습니다.", HttpStatus.NOT_FOUND));
        return CompanyDto.convertToDto(entity);
    }
}
