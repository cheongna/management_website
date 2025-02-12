package com.manager.website.controller;

import com.manager.website.dto.ProductDto;
import com.manager.website.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> list = productService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") Long id) {
        ProductDto result = productService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/generate")
    public ResponseEntity<ProductDto> generate(@RequestBody ProductDto dto) {
        ProductDto result = productService.generate(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
