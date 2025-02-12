package com.manager.website.controller;

import com.manager.website.dto.CompanyDto;
import com.manager.website.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/generate")
    public ResponseEntity<CompanyDto> generate(@RequestBody CompanyDto dto) {
        CompanyDto result = companyService.generate(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<CompanyDto>> findAll() {
        List<CompanyDto> result = companyService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable("id") long id) {
        CompanyDto result = companyService.findById(id);
        return ResponseEntity.ok(result);
    }
}
