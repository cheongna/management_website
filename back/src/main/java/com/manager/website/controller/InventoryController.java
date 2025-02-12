package com.manager.website.controller;

import com.manager.website.dto.InventoryDto;
import com.manager.website.entity.InventoryId;
import com.manager.website.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/update")
    public ResponseEntity<InventoryDto> update(@RequestBody InventoryDto dto) {
        InventoryDto result = inventoryService.update(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<InventoryDto>> findAll() {
        List<InventoryDto> result = inventoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{product_id}/{storage_id}")
    public ResponseEntity<InventoryDto> findById(@PathVariable("product_id") long product_id, @PathVariable("storage_id") long storage_id) {
        InventoryDto result = inventoryService.findById(new InventoryId(product_id, storage_id));
        return ResponseEntity.ok(result);
    }
}
