package com.manager.website.controller;

import com.manager.website.dto.OutcomeHistoryDto;
import com.manager.website.service.OutcomeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history/outcome")
public class OutcomeHistoryController {
    private final OutcomeHistoryService outcomeHistoryService;

    @PostMapping("/generate")
    public ResponseEntity<OutcomeHistoryDto> generate(OutcomeHistoryDto dto) {
        OutcomeHistoryDto result = outcomeHistoryService.generate(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<OutcomeHistoryDto>> findAll() {
        List<OutcomeHistoryDto> result = outcomeHistoryService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutcomeHistoryDto> findById(@PathVariable("id") long id) {
        OutcomeHistoryDto result = outcomeHistoryService.findById(id);
        return ResponseEntity.ok(result);
    }
}
