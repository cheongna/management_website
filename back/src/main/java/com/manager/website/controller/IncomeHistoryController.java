package com.manager.website.controller;

import com.manager.website.dto.IncomeHistoryDto;
import com.manager.website.service.IncomeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history/income")
public class IncomeHistoryController {
    private final IncomeHistoryService incomeHistoryService;

    @PostMapping("/generate")
    public ResponseEntity<IncomeHistoryDto> generate(@RequestBody IncomeHistoryDto dto) {
        IncomeHistoryDto result = incomeHistoryService.generate(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<IncomeHistoryDto>> findAll() {
        List<IncomeHistoryDto> result = incomeHistoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeHistoryDto> findById(@PathVariable("id") long id) {
        IncomeHistoryDto result = incomeHistoryService.findById(id);
        return ResponseEntity.ok(result);
    }
}
