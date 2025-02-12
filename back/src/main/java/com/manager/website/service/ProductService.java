package com.manager.website.service;

import com.manager.website.db.ProductDatabase;
import com.manager.website.dto.ProductDto;
import com.manager.website.entity.ProductEntity;
import com.manager.website.handler.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDatabase productDatabase;

    public ProductDto generate(ProductDto dto) {
        ProductEntity entity = ProductEntity.convertToEntity(dto);
        entity = productDatabase.save(entity);
        if (entity.getId() == null) {
            throw new CustomException("상품 생성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ProductDto.convertToDto(entity);
        }
    }

    public List<ProductDto> findAll() {
        return productDatabase.findAll().stream().map(ProductDto::convertToDto).collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        ProductEntity entity = productDatabase.findById(id)
                .orElseThrow(() -> new CustomException("존재하는 품목이 없습니다.", HttpStatus.NOT_FOUND));
        return ProductDto.convertToDto(entity);
    }

    public void deleteById(Long id) {
        productDatabase.deleteById(id);
    }

}
