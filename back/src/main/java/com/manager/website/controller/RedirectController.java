package com.manager.website.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/loginSuccess";
        }
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String successPage() {
        return "loginsuccess";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
