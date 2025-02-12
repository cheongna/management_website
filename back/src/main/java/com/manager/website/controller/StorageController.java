package com.manager.website.controller;

import com.manager.website.dto.StorageDto;
import com.manager.website.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @PostMapping("/generate")
    public ResponseEntity<StorageDto> generate(@RequestBody StorageDto dto) {
        StorageDto result = storageService.generate(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<StorageDto>> findAll() {
        List<StorageDto> result = storageService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageDto> findById(@PathVariable("id") long id) {
        StorageDto result = storageService.findById(id);
        return ResponseEntity.ok(result);
    }
}
