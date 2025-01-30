package com.manager.website.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PracticeController {

    @GetMapping("/practice")
    @ResponseBody
    public String pratice() {
        return "이재민입니다";
    }
}
